package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TuihuoxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TuihuoxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TuihuoxinxiView;


/**
 * 退货信息
 *
 * @author 
 * @email 
 * @date 2022-03-15 21:22:20
 */
public interface TuihuoxinxiService extends IService<TuihuoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TuihuoxinxiVO> selectListVO(Wrapper<TuihuoxinxiEntity> wrapper);
   	
   	TuihuoxinxiVO selectVO(@Param("ew") Wrapper<TuihuoxinxiEntity> wrapper);
   	
   	List<TuihuoxinxiView> selectListView(Wrapper<TuihuoxinxiEntity> wrapper);
   	
   	TuihuoxinxiView selectView(@Param("ew") Wrapper<TuihuoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TuihuoxinxiEntity> wrapper);
   	

}

