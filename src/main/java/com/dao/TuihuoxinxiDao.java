package com.dao;

import com.entity.TuihuoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TuihuoxinxiVO;
import com.entity.view.TuihuoxinxiView;


/**
 * 退货信息
 * 
 * @author 
 * @email 
 * @date 2024-11-15 21:22:20
 */
public interface TuihuoxinxiDao extends BaseMapper<TuihuoxinxiEntity> {
	
	List<TuihuoxinxiVO> selectListVO(@Param("ew") Wrapper<TuihuoxinxiEntity> wrapper);
	
	TuihuoxinxiVO selectVO(@Param("ew") Wrapper<TuihuoxinxiEntity> wrapper);
	
	List<TuihuoxinxiView> selectListView(@Param("ew") Wrapper<TuihuoxinxiEntity> wrapper);

	List<TuihuoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<TuihuoxinxiEntity> wrapper);
	
	TuihuoxinxiView selectView(@Param("ew") Wrapper<TuihuoxinxiEntity> wrapper);
	

}
