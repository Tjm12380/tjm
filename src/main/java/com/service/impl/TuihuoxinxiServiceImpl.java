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


import com.dao.TuihuoxinxiDao;
import com.entity.TuihuoxinxiEntity;
import com.service.TuihuoxinxiService;
import com.entity.vo.TuihuoxinxiVO;
import com.entity.view.TuihuoxinxiView;

@Service("tuihuoxinxiService")
public class TuihuoxinxiServiceImpl extends ServiceImpl<TuihuoxinxiDao, TuihuoxinxiEntity> implements TuihuoxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TuihuoxinxiEntity> page = this.selectPage(
                new Query<TuihuoxinxiEntity>(params).getPage(),
                new EntityWrapper<TuihuoxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TuihuoxinxiEntity> wrapper) {
		  Page<TuihuoxinxiView> page =new Query<TuihuoxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<TuihuoxinxiVO> selectListVO(Wrapper<TuihuoxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TuihuoxinxiVO selectVO(Wrapper<TuihuoxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TuihuoxinxiView> selectListView(Wrapper<TuihuoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TuihuoxinxiView selectView(Wrapper<TuihuoxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
