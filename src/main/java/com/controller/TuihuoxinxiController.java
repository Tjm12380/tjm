package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.TuihuoxinxiEntity;
import com.entity.view.TuihuoxinxiView;

import com.service.TuihuoxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 退货信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-11-15 21:22:20
 */
@RestController
@RequestMapping("/tuihuoxinxi")
public class TuihuoxinxiController {
    @Autowired
    private TuihuoxinxiService tuihuoxinxiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TuihuoxinxiEntity tuihuoxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("cangguan")) {
			tuihuoxinxi.setCangguanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<TuihuoxinxiEntity> ew = new EntityWrapper<TuihuoxinxiEntity>();
		PageUtils page = tuihuoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tuihuoxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TuihuoxinxiEntity tuihuoxinxi, 
		HttpServletRequest request){
        EntityWrapper<TuihuoxinxiEntity> ew = new EntityWrapper<TuihuoxinxiEntity>();
		PageUtils page = tuihuoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tuihuoxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TuihuoxinxiEntity tuihuoxinxi){
       	EntityWrapper<TuihuoxinxiEntity> ew = new EntityWrapper<TuihuoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tuihuoxinxi, "tuihuoxinxi")); 
        return R.ok().put("data", tuihuoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TuihuoxinxiEntity tuihuoxinxi){
        EntityWrapper< TuihuoxinxiEntity> ew = new EntityWrapper< TuihuoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tuihuoxinxi, "tuihuoxinxi")); 
		TuihuoxinxiView tuihuoxinxiView =  tuihuoxinxiService.selectView(ew);
		return R.ok("查询退货信息成功").put("data", tuihuoxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TuihuoxinxiEntity tuihuoxinxi = tuihuoxinxiService.selectById(id);
        return R.ok().put("data", tuihuoxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TuihuoxinxiEntity tuihuoxinxi = tuihuoxinxiService.selectById(id);
        return R.ok().put("data", tuihuoxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TuihuoxinxiEntity tuihuoxinxi, HttpServletRequest request){
    	tuihuoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tuihuoxinxi);
        tuihuoxinxiService.insert(tuihuoxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TuihuoxinxiEntity tuihuoxinxi, HttpServletRequest request){
    	tuihuoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tuihuoxinxi);
        tuihuoxinxiService.insert(tuihuoxinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody TuihuoxinxiEntity tuihuoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tuihuoxinxi);
        tuihuoxinxiService.updateById(tuihuoxinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tuihuoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<TuihuoxinxiEntity> wrapper = new EntityWrapper<TuihuoxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("cangguan")) {
			wrapper.eq("cangguanzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = tuihuoxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
