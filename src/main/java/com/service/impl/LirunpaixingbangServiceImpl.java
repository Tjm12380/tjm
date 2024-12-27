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


import com.dao.LirunpaixingbangDao;
import com.entity.LirunpaixingbangEntity;
import com.service.LirunpaixingbangService;
import com.entity.vo.LirunpaixingbangVO;
import com.entity.view.LirunpaixingbangView;

@Service("lirunpaixingbangService")
public class LirunpaixingbangServiceImpl extends ServiceImpl<LirunpaixingbangDao, LirunpaixingbangEntity> implements LirunpaixingbangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LirunpaixingbangEntity> page = this.selectPage(
                new Query<LirunpaixingbangEntity>(params).getPage(),
                new EntityWrapper<LirunpaixingbangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LirunpaixingbangEntity> wrapper) {
		  Page<LirunpaixingbangView> page =new Query<LirunpaixingbangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LirunpaixingbangVO> selectListVO(Wrapper<LirunpaixingbangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LirunpaixingbangVO selectVO(Wrapper<LirunpaixingbangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LirunpaixingbangView> selectListView(Wrapper<LirunpaixingbangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LirunpaixingbangView selectView(Wrapper<LirunpaixingbangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<LirunpaixingbangEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<LirunpaixingbangEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<LirunpaixingbangEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }

}
