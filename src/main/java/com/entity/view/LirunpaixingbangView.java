package com.entity.view;

import com.entity.LirunpaixingbangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 利润排行榜
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-03-15 21:22:20
 */
@TableName("lirunpaixingbang")
public class LirunpaixingbangView  extends LirunpaixingbangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LirunpaixingbangView(){
	}
 
 	public LirunpaixingbangView(LirunpaixingbangEntity lirunpaixingbangEntity){
 	try {
			BeanUtils.copyProperties(this, lirunpaixingbangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
