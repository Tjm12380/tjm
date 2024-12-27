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

import com.entity.XiaoliangpaixingbangEntity;
import com.entity.view.XiaoliangpaixingbangView;

import com.service.XiaoliangpaixingbangService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 销量排行榜
 * 后端接口
 * @author 
 * @email 
 * @date 2024-11-15 21:22:20
 */
@RestController/**用于与下面@Requestmapping一起处理http请求的控制器*/
@RequestMapping("/xiaoliangpaixingbang")/**（）里是基础路径*/
public class XiaoliangpaixingbangController {
    @Autowired/**自动注入依赖项*/
    private XiaoliangpaixingbangService xiaoliangpaixingbangService;/**p是访问修饰符，表示这个变量只能在其所在类内部访问，1是2的实例*/


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")/**用于映射http请求到控制器的处理方法上*/
    public R page(@RequestParam Map<String, Object> params,XiaoliangpaixingbangEntity xiaoliangpaixingbang,/**这是公共方法，返回r这个实体类，接受后面三个参数，1：包含请求参数的map，2：一个实体对象3：当前的http对象*/
		HttpServletRequest request){
        EntityWrapper<XiaoliangpaixingbangEntity> ew = new EntityWrapper<XiaoliangpaixingbangEntity>();/**创建一个用于条件查询的类*/
		PageUtils page = xiaoliangpaixingbangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaoliangpaixingbang), params), params));
/**调用service中的page来进行分页查询，sort是基于params中的排序参数，between是自定义工具方法用于构建like或equal查询条件*/
        return R.ok().put("data", page);/**使用R.ok()创建一个成功的响应对象，并将分页查询结果page放入响应的data字段中*/
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth/**自定义注解,用于标记不需要身份验证或授权的api方法*/
    @RequestMapping("/list")/**将/list映射到list上处理，即用/list时用list来处理请求*/
    public R list(@RequestParam Map<String, Object> params,XiaoliangpaixingbangEntity xiaoliangpaixingbang, 
		HttpServletRequest request){
        EntityWrapper<XiaoliangpaixingbangEntity> ew = new EntityWrapper<XiaoliangpaixingbangEntity>();
		PageUtils page = xiaoliangpaixingbangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaoliangpaixingbang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiaoliangpaixingbangEntity xiaoliangpaixingbang){/** list 返 回一个 R 类型的对象，这是一个自定义的响应实体类，用于构建JSON格式的响应，这是一个实体对象，用于绑定请求体中的JSON数据*/
   /**查询条件的类*/  EntityWrapper<XiaoliangpaixingbangEntity> ew = new EntityWrapper<XiaoliangpaixingbangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiaoliangpaixingbang, "xiaoliangpaixingbang")); /**alleq用于将实体对象的所有字段与传入的键值对进行匹配，生成查询条件，MPUtil.allEQMapPre是一个自定义的工具方法，用于生成所有字段的等值条件，其中 pre 参数 "xiaoliangpaixingbang" 可能是用于字段名前缀。*/
        return R.ok().put("data", xiaoliangpaixingbangService.selectListView(ew));/**调用selectListView方法执行查询操作，传入构建好的查询包装器 ew。使用R.ok创建成功的响应对象并将其放入data字段*/
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiaoliangpaixingbangEntity xiaoliangpaixingbang){
        EntityWrapper< XiaoliangpaixingbangEntity> ew = new EntityWrapper< XiaoliangpaixingbangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiaoliangpaixingbang, "xiaoliangpaixingbang")); 
		XiaoliangpaixingbangView xiaoliangpaixingbangView =  xiaoliangpaixingbangService.selectView(ew);/**调用 服务层的 selectView 方法执行查询操作，传入构建好的查询包装器 ew。
         XiaoliangpaixingbangView 是一个视图模型，用于展示查询结果。*/
		return R.ok("查询销量排行榜成功").put("data", xiaoliangpaixingbangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")/**将HTTP请求的URL路径模式 /info/{id} 映射到 info 方法。这里的 {id} 是一个路径变量，表示URL中的具体ID值将被作为参数传递给方法*/
    public R info(@PathVariable("id") Long id){/**info 返回一个 R 类型的对象，这是一个自定义的响应实体类，用于构建JSON格式的响应。
     方法接受一个参数 Long id，这是通过 @PathVariable 注解从URL路径中提取的ID值*/
        XiaoliangpaixingbangEntity xiaoliangpaixingbang = xiaoliangpaixingbangService.selectById(id);/**调用Service 服务层的 selectById 方法，传入ID值 id，以查询销量排行榜中对应ID的条目*/
        return R.ok().put("data", xiaoliangpaixingbang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiaoliangpaixingbangEntity xiaoliangpaixingbang = xiaoliangpaixingbangService.selectById(id);/**调用Service 服务层的 selectById 方法，传入ID值 id，以查询销量排行榜中对应ID的条目*/
        return R.ok().put("data", xiaoliangpaixingbang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")/**将/save 映射到 save 方法。这意味着当客户端请求这个路径时，会调用此方法来处理POST请求，通常用于创建新的资源*/
    public R save(@RequestBody XiaoliangpaixingbangEntity xiaoliangpaixingbang, HttpServletRequest request){/**xiaoliangpaixingbang：通过 @RequestBody 注解，Spring将HTTP请求的正文（JSON格式）绑定到这个实体对象上*/
    	xiaoliangpaixingbang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());/**这行代码为新创建的销量排行榜条目生成一个唯一的ID。它使用当前时间的毫秒数加上一个0到999之间的随机数*/
        xiaoliangpaixingbangService.insert(xiaoliangpaixingbang);/**调用Service 服务层的 insert 方法，将 xiaoliangpaixingbang 实体对象插入到数据库中*/
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")/**将/add 映射到 add 方法。这通常用于处理POST请求，用于添加新的数据条目*/
    public R add(@RequestBody XiaoliangpaixingbangEntity xiaoliangpaixingbang, HttpServletRequest request){
    	xiaoliangpaixingbang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());/**为新创建的销量排行榜条目生成一个唯一的ID。它使用当前时间的毫秒数加上一个0到999之间的随机数来确保ID的唯一性*/
        xiaoliangpaixingbangService.insert(xiaoliangpaixingbang);/**调用Service 服务层的 insert 方法，将 xiaoliangpaixingbang 实体对象插入到数据库中*/
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")/**update方法通过@RequestMapping("/update")注解映射到/update路径，用于处理PUT或PATCH HTTP请求，用于更新数据*/
    public R update(@RequestBody XiaoliangpaixingbangEntity xiaoliangpaixingbang, HttpServletRequest request){/**update方法通过@RequestMapping("/update")注解映射到/update路径，用于处理PUT或PATCH HTTP请求，用于更新数据*/
        //ValidatorUtils.validateEntity(xiaoliangpaixingbang);
        xiaoliangpaixingbangService.updateById(xiaoliangpaixingbang);//调用服务层的方法更新数据库中的记录
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")//注解映射到/delete路径，用于处理DELETE HTTP请求，用于删除数据
    public R delete(@RequestBody Long[] ids){//@RequestBody Long[] ids接收一个包含ID的数组，这些ID是要被删除的记录的标识符
        xiaoliangpaixingbangService.deleteBatchIds(Arrays.asList(ids));//用服务层的方法批量删除记录
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")//remindCount方法通过@RequestMapping("/remind/{columnName}/{type}")注解映射到/remind/{columnName}/{type}路径，用于处理特定条件的查询请求
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request,//注解从URL路径中提取columnName和type的值
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);//向参数Map中添加一个键值对，键是column，值是从URL路径中提取的
		map.put("type", type);//向参数Map中添加另一个键值对，键是type，值是方法参数中的type
		
		if(type.equals("2")) {//如果type等于字符串"2"，则执行以下操作
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//创建一个日期格式化对象，用于将日期转换为"yyyy-MM-dd"格式的字符串
			Calendar c = Calendar.getInstance();//获取当前日期和时间的Calendar实例。
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}//如果map中包含remindstart或remindend参数，将根据这些参数计算提醒的开始和结束日期，并使用Calendar实例对当前日期进行调整
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<XiaoliangpaixingbangEntity> wrapper = new EntityWrapper<XiaoliangpaixingbangEntity>();//创建一个新的查询包装器实例，用于构建查询条件
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}//如果map包含remindstart和/或remindend，使用.ge(columnName, map.get("remindstart"))和.le(columnName, map.get("remindend"))方法设置大于等于和小于等于的查询条件
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = xiaoliangpaixingbangService.selectCount(wrapper);//调用服务层的方法，使用构建的查询条件包装器来获取满足条件的记录数
		return R.ok().put("count", count);
	}
	





//当你在 @PathVariable 注解中使用 "yColumnName" 时，这里的 "yColumnName" 是 URL 模板中的一个占位符名称。这意味着在控制器方法中，
// 你可以通过 @PathVariable("yColumnName") 来获取 URL 中对应占位符的值，并将其作为参数传递给方法。
    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")//用于根据两个列的值进行统计
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {//@PathVariable注解从URL路径中提取xColumnName和yColumnName的值
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<XiaoliangpaixingbangEntity> ew = new EntityWrapper<XiaoliangpaixingbangEntity>();
        List<Map<String, Object>> result = xiaoliangpaixingbangService.selectValue(params, ew);//调用服务层的方法执行统计查询
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);//;返回一个包含统计结果的成功的响应。
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<XiaoliangpaixingbangEntity> ew = new EntityWrapper<XiaoliangpaixingbangEntity>();
        List<Map<String, Object>> result = xiaoliangpaixingbangService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")//用于按列名分组统计数据
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {//使用@PathVariable注解从URL路径中提取columnName的值
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<XiaoliangpaixingbangEntity> ew = new EntityWrapper<XiaoliangpaixingbangEntity>();
        List<Map<String, Object>> result = xiaoliangpaixingbangService.selectGroup(params, ew);//调用服务层的方法执行分组统计查询
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//对结果中的日期进行格式化
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);//返回一个包含分组统计结果的成功的响应
    }

}
