package com.dao;

import com.entity.KetirenwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KetirenwuView;

/**
 * 课题任务 Dao 接口
 *
 * @author 
 */
public interface KetirenwuDao extends BaseMapper<KetirenwuEntity> {

   List<KetirenwuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
