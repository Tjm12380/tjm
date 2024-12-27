package com.dao;

import com.entity.LirunpaixingbangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LirunpaixingbangVO;
import com.entity.view.LirunpaixingbangView;


/**
 * 利润排行榜
 * 
 * @author 
 * @email 
 * @date 2024-11-15 21:22:20
 */
public interface LirunpaixingbangDao extends BaseMapper<LirunpaixingbangEntity> {
	
	List<LirunpaixingbangVO> selectListVO(@Param("ew") Wrapper<LirunpaixingbangEntity> wrapper);
	
	LirunpaixingbangVO selectVO(@Param("ew") Wrapper<LirunpaixingbangEntity> wrapper);
	
	List<LirunpaixingbangView> selectListView(@Param("ew") Wrapper<LirunpaixingbangEntity> wrapper);

	List<LirunpaixingbangView> selectListView(Pagination page,@Param("ew") Wrapper<LirunpaixingbangEntity> wrapper);
	
	LirunpaixingbangView selectView(@Param("ew") Wrapper<LirunpaixingbangEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<LirunpaixingbangEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<LirunpaixingbangEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<LirunpaixingbangEntity> wrapper);
}
