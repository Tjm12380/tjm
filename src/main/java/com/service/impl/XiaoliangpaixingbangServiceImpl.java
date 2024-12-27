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


import com.dao.XiaoliangpaixingbangDao;
import com.entity.XiaoliangpaixingbangEntity;
import com.service.XiaoliangpaixingbangService;
import com.entity.vo.XiaoliangpaixingbangVO;
import com.entity.view.XiaoliangpaixingbangView;

@Service("xiaoliangpaixingbangService")
public class XiaoliangpaixingbangServiceImpl extends ServiceImpl<XiaoliangpaixingbangDao, XiaoliangpaixingbangEntity> implements XiaoliangpaixingbangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiaoliangpaixingbangEntity> page = this.selectPage(
                new Query<XiaoliangpaixingbangEntity>(params).getPage(),
                new EntityWrapper<XiaoliangpaixingbangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiaoliangpaixingbangEntity> wrapper) {
		  Page<XiaoliangpaixingbangView> page =new Query<XiaoliangpaixingbangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XiaoliangpaixingbangVO> selectListVO(Wrapper<XiaoliangpaixingbangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XiaoliangpaixingbangVO selectVO(Wrapper<XiaoliangpaixingbangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XiaoliangpaixingbangView> selectListView(Wrapper<XiaoliangpaixingbangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiaoliangpaixingbangView selectView(Wrapper<XiaoliangpaixingbangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<XiaoliangpaixingbangEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<XiaoliangpaixingbangEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<XiaoliangpaixingbangEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }

}
