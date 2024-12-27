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


import com.dao.XiaoshouxinxiDao;
import com.entity.XiaoshouxinxiEntity;
import com.service.XiaoshouxinxiService;
import com.entity.vo.XiaoshouxinxiVO;
import com.entity.view.XiaoshouxinxiView;

@Service("xiaoshouxinxiService")
public class XiaoshouxinxiServiceImpl extends ServiceImpl<XiaoshouxinxiDao, XiaoshouxinxiEntity> implements XiaoshouxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiaoshouxinxiEntity> page = this.selectPage(
                new Query<XiaoshouxinxiEntity>(params).getPage(),
                new EntityWrapper<XiaoshouxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiaoshouxinxiEntity> wrapper) {
		  Page<XiaoshouxinxiView> page =new Query<XiaoshouxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XiaoshouxinxiVO> selectListVO(Wrapper<XiaoshouxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XiaoshouxinxiVO selectVO(Wrapper<XiaoshouxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XiaoshouxinxiView> selectListView(Wrapper<XiaoshouxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiaoshouxinxiView selectView(Wrapper<XiaoshouxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<XiaoshouxinxiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<XiaoshouxinxiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<XiaoshouxinxiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }

}
