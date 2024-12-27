package com.dao;

import com.entity.KehutuihuoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KehutuihuoVO;
import com.entity.view.KehutuihuoView;


/**
 * 客户退货
 * 
 * @author 
 * @email 
 * @date 2024-11-15 21:22:20
 */
public interface KehutuihuoDao extends BaseMapper<KehutuihuoEntity> {
	
	List<KehutuihuoVO> selectListVO(@Param("ew") Wrapper<KehutuihuoEntity> wrapper);
	
	KehutuihuoVO selectVO(@Param("ew") Wrapper<KehutuihuoEntity> wrapper);
	
	List<KehutuihuoView> selectListView(@Param("ew") Wrapper<KehutuihuoEntity> wrapper);

	List<KehutuihuoView> selectListView(Pagination page,@Param("ew") Wrapper<KehutuihuoEntity> wrapper);
	
	KehutuihuoView selectView(@Param("ew") Wrapper<KehutuihuoEntity> wrapper);
	

}
