package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KehutuihuoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KehutuihuoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KehutuihuoView;


/**
 * 客户退货
 *
 * @author 
 * @email 
 * @date 2022-03-15 21:22:20
 */
public interface KehutuihuoService extends IService<KehutuihuoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KehutuihuoVO> selectListVO(Wrapper<KehutuihuoEntity> wrapper);
   	
   	KehutuihuoVO selectVO(@Param("ew") Wrapper<KehutuihuoEntity> wrapper);
   	
   	List<KehutuihuoView> selectListView(Wrapper<KehutuihuoEntity> wrapper);
   	
   	KehutuihuoView selectView(@Param("ew") Wrapper<KehutuihuoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KehutuihuoEntity> wrapper);
   	

}

