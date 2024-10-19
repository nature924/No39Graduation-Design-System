package com.dao;

import com.entity.XuantishenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XuantishenqingView;

/**
 * 选题申请 Dao 接口
 *
 * @author 
 */
public interface XuantishenqingDao extends BaseMapper<XuantishenqingEntity> {

   List<XuantishenqingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
