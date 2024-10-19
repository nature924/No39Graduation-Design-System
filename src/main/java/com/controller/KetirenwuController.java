
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
 * 课题任务
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/ketirenwu")
public class KetirenwuController {
    private static final Logger logger = LoggerFactory.getLogger(KetirenwuController.class);

    @Autowired
    private KetirenwuService ketirenwuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private JiaoshiService jiaoshiService;
    @Autowired
    private XuantishenqingService xuantishenqingService;

    @Autowired
    private YonghuService yonghuService;


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
        PageUtils page = ketirenwuService.queryPage(params);

        //字典表数据转换
        List<KetirenwuView> list =(List<KetirenwuView>)page.getList();
        for(KetirenwuView c:list){
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
        KetirenwuEntity ketirenwu = ketirenwuService.selectById(id);
        if(ketirenwu !=null){
            //entity转view
            KetirenwuView view = new KetirenwuView();
            BeanUtils.copyProperties( ketirenwu , view );//把实体数据重构到view中

                //级联表
                JiaoshiEntity jiaoshi = jiaoshiService.selectById(ketirenwu.getJiaoshiId());
                if(jiaoshi != null){
                    BeanUtils.copyProperties( jiaoshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJiaoshiId(jiaoshi.getId());
                }
                //级联表
                XuantishenqingEntity xuantishenqing = xuantishenqingService.selectById(ketirenwu.getXuantishenqingId());
                if(xuantishenqing != null){
                    BeanUtils.copyProperties( xuantishenqing , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXuantishenqingId(xuantishenqing.getId());
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
    public R save(@RequestBody KetirenwuEntity ketirenwu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,ketirenwu:{}",this.getClass().getName(),ketirenwu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("教师".equals(role))
            ketirenwu.setJiaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<KetirenwuEntity> queryWrapper = new EntityWrapper<KetirenwuEntity>()
            .eq("jiaoshi_id", ketirenwu.getJiaoshiId())
            .eq("xuantishenqing_id", ketirenwu.getXuantishenqingId())
            .eq("ketirenwu_name", ketirenwu.getKetirenwuName())
            .eq("ketirenwu_types", ketirenwu.getKetirenwuTypes())
            .eq("ketirenwu_yesno_types", ketirenwu.getKetirenwuYesnoTypes())
            .eq("ketirenwu_yesno_text", ketirenwu.getKetirenwuYesnoText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KetirenwuEntity ketirenwuEntity = ketirenwuService.selectOne(queryWrapper);
        if(ketirenwuEntity==null){
            ketirenwu.setKetirenwuYesnoTypes(1);
            ketirenwu.setInsertTime(new Date());
            ketirenwu.setCreateTime(new Date());
            ketirenwuService.insert(ketirenwu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KetirenwuEntity ketirenwu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,ketirenwu:{}",this.getClass().getName(),ketirenwu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("教师".equals(role))
//            ketirenwu.setJiaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<KetirenwuEntity> queryWrapper = new EntityWrapper<KetirenwuEntity>()
            .notIn("id",ketirenwu.getId())
            .andNew()
            .eq("jiaoshi_id", ketirenwu.getJiaoshiId())
            .eq("xuantishenqing_id", ketirenwu.getXuantishenqingId())
            .eq("ketirenwu_name", ketirenwu.getKetirenwuName())
            .eq("ketirenwu_types", ketirenwu.getKetirenwuTypes())
            .eq("ketirenwu_yesno_types", ketirenwu.getKetirenwuYesnoTypes())
            .eq("ketirenwu_yesno_text", ketirenwu.getKetirenwuYesnoText())
            .eq("insert_time", ketirenwu.getInsertTime())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KetirenwuEntity ketirenwuEntity = ketirenwuService.selectOne(queryWrapper);
        if("".equals(ketirenwu.getKetirenwuFile()) || "null".equals(ketirenwu.getKetirenwuFile())){
                ketirenwu.setKetirenwuFile(null);
        }
        if("".equals(ketirenwu.getKetirenwuHuidaFile()) || "null".equals(ketirenwu.getKetirenwuHuidaFile())){
                ketirenwu.setKetirenwuHuidaFile(null);
        }
        if(ketirenwuEntity==null){
            KetirenwuEntity ketirenwuEntity1 = ketirenwuService.selectById(ketirenwu.getId());
            if(ketirenwuEntity1.getKetirenwuYesnoTypes() == 3){
                ketirenwu.setKetirenwuYesnoTypes(1);
            }
            ketirenwuService.updateById(ketirenwu);//根据id更新
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
        ketirenwuService.deleteBatchIds(Arrays.asList(ids));
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
            List<KetirenwuEntity> ketirenwuList = new ArrayList<>();//上传的东西
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
                            KetirenwuEntity ketirenwuEntity = new KetirenwuEntity();
//                            ketirenwuEntity.setJiaoshiId(Integer.valueOf(data.get(0)));   //教师 要改的
//                            ketirenwuEntity.setXuantishenqingId(Integer.valueOf(data.get(0)));   //选题申请 要改的
//                            ketirenwuEntity.setKetirenwuName(data.get(0));                    //课题任务 要改的
//                            ketirenwuEntity.setKetirenwuTypes(Integer.valueOf(data.get(0)));   //任务类型 要改的
//                            ketirenwuEntity.setKetirenwuFile(data.get(0));                    //参考文献 要改的
//                            ketirenwuEntity.setKetirenwuHuidaFile(data.get(0));                    //阶段文档 要改的
//                            ketirenwuEntity.setKetirenwuYesnoTypes(Integer.valueOf(data.get(0)));   //审核结果 要改的
//                            ketirenwuEntity.setKetirenwuYesnoText(data.get(0));                    //教师打分 要改的
//                            ketirenwuEntity.setInsertTime(date);//时间
//                            ketirenwuEntity.setCreateTime(date);//时间
                            ketirenwuList.add(ketirenwuEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        ketirenwuService.insertBatch(ketirenwuList);
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
