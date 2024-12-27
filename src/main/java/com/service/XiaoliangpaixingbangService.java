package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XiaoliangpaixingbangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XiaoliangpaixingbangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XiaoliangpaixingbangView;


/**
 * 销量排行榜
 *
 * @author 
 * @email 
 * @date 2022-03-15 21:22:20
 */
public interface XiaoliangpaixingbangService extends IService<XiaoliangpaixingbangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiaoliangpaixingbangVO> selectListVO(Wrapper<XiaoliangpaixingbangEntity> wrapper);
   	
   	XiaoliangpaixingbangVO selectVO(@Param("ew") Wrapper<XiaoliangpaixingbangEntity> wrapper);
   	
   	List<XiaoliangpaixingbangView> selectListView(Wrapper<XiaoliangpaixingbangEntity> wrapper);
   	
   	XiaoliangpaixingbangView selectView(@Param("ew") Wrapper<XiaoliangpaixingbangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiaoliangpaixingbangEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<XiaoliangpaixingbangEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<XiaoliangpaixingbangEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<XiaoliangpaixingbangEntity> wrapper);
}

