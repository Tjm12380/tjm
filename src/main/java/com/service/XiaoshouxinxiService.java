package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XiaoshouxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XiaoshouxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XiaoshouxinxiView;


/**
 * 销售信息
 *
 * @author 
 * @email 
 * @date 2022-03-15 21:22:20
 */
public interface XiaoshouxinxiService extends IService<XiaoshouxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiaoshouxinxiVO> selectListVO(Wrapper<XiaoshouxinxiEntity> wrapper);
   	
   	XiaoshouxinxiVO selectVO(@Param("ew") Wrapper<XiaoshouxinxiEntity> wrapper);
   	
   	List<XiaoshouxinxiView> selectListView(Wrapper<XiaoshouxinxiEntity> wrapper);
   	
   	XiaoshouxinxiView selectView(@Param("ew") Wrapper<XiaoshouxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiaoshouxinxiEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<XiaoshouxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<XiaoshouxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<XiaoshouxinxiEntity> wrapper);
}

