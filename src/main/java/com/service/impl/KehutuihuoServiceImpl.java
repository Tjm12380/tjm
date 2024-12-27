package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.KehutuihuoDao;
import com.entity.KehutuihuoEntity;
import com.service.KehutuihuoService;
import com.entity.vo.KehutuihuoVO;
import com.entity.view.KehutuihuoView;

@Service("kehutuihuoService")
public class KehutuihuoServiceImpl extends ServiceImpl<KehutuihuoDao, KehutuihuoEntity> implements KehutuihuoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KehutuihuoEntity> page = this.selectPage(
                new Query<KehutuihuoEntity>(params).getPage(),
                new EntityWrapper<KehutuihuoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KehutuihuoEntity> wrapper) {
		  Page<KehutuihuoView> page =new Query<KehutuihuoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KehutuihuoVO> selectListVO(Wrapper<KehutuihuoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KehutuihuoVO selectVO(Wrapper<KehutuihuoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KehutuihuoView> selectListView(Wrapper<KehutuihuoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KehutuihuoView selectView(Wrapper<KehutuihuoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
