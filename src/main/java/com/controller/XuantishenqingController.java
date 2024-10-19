
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 选题申请
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xuantishenqing")
public class XuantishenqingController {
    private static final Logger logger = LoggerFactory.getLogger(XuantishenqingController.class);

    @Autowired
    private XuantishenqingService xuantishenqingService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private KetiService ketiService;
    @Autowired
    private YonghuService yonghuService;

    @Autowired
    private JiaoshiService jiaoshiService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("教师".equals(role))
            params.put("jiaoshiId",request.getSession().getAttribute("userId"));
        else if("学生".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = xuantishenqingService.queryPage(params);

        //字典表数据转换
        List<XuantishenqingView> list =(List<XuantishenqingView>)page.getList();
        for(XuantishenqingView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XuantishenqingEntity xuantishenqing = xuantishenqingService.selectById(id);
        if(xuantishenqing !=null){
            //entity转view
            XuantishenqingView view = new XuantishenqingView();
            BeanUtils.copyProperties( xuantishenqing , view );//把实体数据重构到view中

                //级联表
                KetiEntity keti = ketiService.selectById(xuantishenqing.getKetiId());
                if(keti != null){
                    BeanUtils.copyProperties( keti , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setKetiId(keti.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(xuantishenqing.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XuantishenqingEntity xuantishenqing, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xuantishenqing:{}",this.getClass().getName(),xuantishenqing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            xuantishenqing.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<XuantishenqingEntity> queryWrapper = new EntityWrapper<XuantishenqingEntity>()
            .eq("yonghu_id", xuantishenqing.getYonghuId())
            .in("xuantishenqing_yesno_types", new Integer[]{1,2})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuantishenqingEntity xuantishenqingEntity = xuantishenqingService.selectOne(queryWrapper);
        if(xuantishenqingEntity==null){
            xuantishenqing.setXuantishenqingYesnoTypes(1);
            xuantishenqing.setCreateTime(new Date());
            xuantishenqingService.insert(xuantishenqing);
            return R.ok();
        }else {
            return R.error(511,"每个学生只能选择一个课题");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XuantishenqingEntity xuantishenqing, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xuantishenqing:{}",this.getClass().getName(),xuantishenqing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            xuantishenqing.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<XuantishenqingEntity> queryWrapper = new EntityWrapper<XuantishenqingEntity>()
            .notIn("id",xuantishenqing.getId())
            .andNew()
            .eq("xuantishenqing_uuid_number", xuantishenqing.getXuantishenqingUuidNumber())
            .eq("yonghu_id", xuantishenqing.getYonghuId())
            .eq("keti_id", xuantishenqing.getKetiId())
            .eq("xuantishenqing_yesno_types", xuantishenqing.getXuantishenqingYesnoTypes())
            .eq("xuantishenqing_yesno_text", xuantishenqing.getXuantishenqingYesnoText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuantishenqingEntity xuantishenqingEntity = xuantishenqingService.selectOne(queryWrapper);
        if(xuantishenqingEntity==null){
            KetiEntity ketiEntity = new KetiEntity();
            ketiEntity.setId(xuantishenqing.getKetiId());
            if(xuantishenqing.getXuantishenqingYesnoTypes() == 2){
                ketiEntity.setKetiYesnoTypes(5);
            }else if(xuantishenqing.getXuantishenqingYesnoTypes() == 3){
                ketiEntity.setKetiYesnoTypes(2);
            }
            ketiService.updateById(ketiEntity);
            xuantishenqingService.updateById(xuantishenqing);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        xuantishenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<XuantishenqingEntity> xuantishenqingList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            XuantishenqingEntity xuantishenqingEntity = new XuantishenqingEntity();
//                            xuantishenqingEntity.setXuantishenqingUuidNumber(data.get(0));                    //课题编号 要改的
//                            xuantishenqingEntity.setYonghuId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            xuantishenqingEntity.setKetiId(Integer.valueOf(data.get(0)));   //课题 要改的
//                            xuantishenqingEntity.setXuantishenqingYesnoTypes(Integer.valueOf(data.get(0)));   //申请状态 要改的
//                            xuantishenqingEntity.setXuantishenqingYesnoText(data.get(0));                    //申请结果 要改的
//                            xuantishenqingEntity.setCreateTime(date);//时间
                            xuantishenqingList.add(xuantishenqingEntity);


                            //把要查询是否重复的字段放入map中
                                //课题编号
                                if(seachFields.containsKey("xuantishenqingUuidNumber")){
                                    List<String> xuantishenqingUuidNumber = seachFields.get("xuantishenqingUuidNumber");
                                    xuantishenqingUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xuantishenqingUuidNumber = new ArrayList<>();
                                    xuantishenqingUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xuantishenqingUuidNumber",xuantishenqingUuidNumber);
                                }
                        }

                        //查询是否重复
                         //课题编号
                        List<XuantishenqingEntity> xuantishenqingEntities_xuantishenqingUuidNumber = xuantishenqingService.selectList(new EntityWrapper<XuantishenqingEntity>().in("xuantishenqing_uuid_number", seachFields.get("xuantishenqingUuidNumber")));
                        if(xuantishenqingEntities_xuantishenqingUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XuantishenqingEntity s:xuantishenqingEntities_xuantishenqingUuidNumber){
                                repeatFields.add(s.getXuantishenqingUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [课题编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xuantishenqingService.insertBatch(xuantishenqingList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
