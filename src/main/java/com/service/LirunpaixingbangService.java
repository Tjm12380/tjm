package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LirunpaixingbangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LirunpaixingbangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LirunpaixingbangView;


/**
 * 利润排行榜
 *
 * @author 
 * @email 
 * @date 2022-03-15 21:22:20
 */
public interface LirunpaixingbangService extends IService<LirunpaixingbangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LirunpaixingbangVO> selectListVO(Wrapper<LirunpaixingbangEntity> wrapper);
   	
   	LirunpaixingbangVO selectVO(@Param("ew") Wrapper<LirunpaixingbangEntity> wrapper);
   	
   	List<LirunpaixingbangView> selectListView(Wrapper<LirunpaixingbangEntity> wrapper);
   	
   	LirunpaixingbangView selectView(@Param("ew") Wrapper<LirunpaixingbangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LirunpaixingbangEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<LirunpaixingbangEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<LirunpaixingbangEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<LirunpaixingbangEntity> wrapper);
}

