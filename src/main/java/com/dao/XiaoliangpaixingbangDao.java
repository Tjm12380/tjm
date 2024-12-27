package com.dao;

import com.entity.XiaoliangpaixingbangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XiaoliangpaixingbangVO;
import com.entity.view.XiaoliangpaixingbangView;


/**
 * 销量排行榜
 * 
 * @author 
 * @email 
 * @date 2024-11-15 21:22:20
 */
public interface XiaoliangpaixingbangDao extends BaseMapper<XiaoliangpaixingbangEntity> {
	
	List<XiaoliangpaixingbangVO> selectListVO(@Param("ew") Wrapper<XiaoliangpaixingbangEntity> wrapper);
	
	XiaoliangpaixingbangVO selectVO(@Param("ew") Wrapper<XiaoliangpaixingbangEntity> wrapper);
	
	List<XiaoliangpaixingbangView> selectListView(@Param("ew") Wrapper<XiaoliangpaixingbangEntity> wrapper);

	List<XiaoliangpaixingbangView> selectListView(Pagination page,@Param("ew") Wrapper<XiaoliangpaixingbangEntity> wrapper);
	
	XiaoliangpaixingbangView selectView(@Param("ew") Wrapper<XiaoliangpaixingbangEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XiaoliangpaixingbangEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XiaoliangpaixingbangEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XiaoliangpaixingbangEntity> wrapper);
}
