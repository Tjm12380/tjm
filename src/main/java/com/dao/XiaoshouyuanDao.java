package com.dao;

import com.entity.XiaoshouyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XiaoshouyuanVO;
import com.entity.view.XiaoshouyuanView;


/**
 * 销售员
 * 
 * @author 
 * @email 
 * @date 2024-011-15 21:22:20
 */
public interface XiaoshouyuanDao extends BaseMapper<XiaoshouyuanEntity> {
	
	List<XiaoshouyuanVO> selectListVO(@Param("ew") Wrapper<XiaoshouyuanEntity> wrapper);
	
	XiaoshouyuanVO selectVO(@Param("ew") Wrapper<XiaoshouyuanEntity> wrapper);
	
	List<XiaoshouyuanView> selectListView(@Param("ew") Wrapper<XiaoshouyuanEntity> wrapper);

	List<XiaoshouyuanView> selectListView(Pagination page,@Param("ew") Wrapper<XiaoshouyuanEntity> wrapper);
	
	XiaoshouyuanView selectView(@Param("ew") Wrapper<XiaoshouyuanEntity> wrapper);
	

}
