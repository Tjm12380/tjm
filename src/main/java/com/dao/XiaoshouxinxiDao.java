package com.dao;

import com.entity.XiaoshouxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XiaoshouxinxiVO;
import com.entity.view.XiaoshouxinxiView;


/**
 * 销售信息
 * 
 * @author 
 * @email 
 * @date 2024-11-15 21:22:20
 */
public interface XiaoshouxinxiDao extends BaseMapper<XiaoshouxinxiEntity> {
	
	List<XiaoshouxinxiVO> selectListVO(@Param("ew") Wrapper<XiaoshouxinxiEntity> wrapper);
	
	XiaoshouxinxiVO selectVO(@Param("ew") Wrapper<XiaoshouxinxiEntity> wrapper);
	
	List<XiaoshouxinxiView> selectListView(@Param("ew") Wrapper<XiaoshouxinxiEntity> wrapper);

	List<XiaoshouxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<XiaoshouxinxiEntity> wrapper);
	
	XiaoshouxinxiView selectView(@Param("ew") Wrapper<XiaoshouxinxiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XiaoshouxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XiaoshouxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XiaoshouxinxiEntity> wrapper);
}
