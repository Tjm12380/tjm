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


import com.dao.CangguanDao;
import com.entity.CangguanEntity;
import com.service.CangguanService;
import com.entity.vo.CangguanVO;
import com.entity.view.CangguanView;

@Service("cangguanService")
public class CangguanServiceImpl extends ServiceImpl<CangguanDao, CangguanEntity> implements CangguanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CangguanEntity> page = this.selectPage(
                new Query<CangguanEntity>(params).getPage(),
                new EntityWrapper<CangguanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CangguanEntity> wrapper) {
		  Page<CangguanView> page =new Query<CangguanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<CangguanVO> selectListVO(Wrapper<CangguanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CangguanVO selectVO(Wrapper<CangguanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CangguanView> selectListView(Wrapper<CangguanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CangguanView selectView(Wrapper<CangguanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
