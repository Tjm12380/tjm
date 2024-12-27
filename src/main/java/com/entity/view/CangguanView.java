package com.entity.view;

import com.entity.CangguanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 仓管
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-03-15 21:22:20
 */
@TableName("cangguan")
public class CangguanView  extends CangguanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CangguanView(){
	}
 
 	public CangguanView(CangguanEntity cangguanEntity){
 	try {
			BeanUtils.copyProperties(this, cangguanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
