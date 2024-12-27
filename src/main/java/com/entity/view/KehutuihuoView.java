package com.entity.view;

import com.entity.KehutuihuoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 客户退货
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-03-15 21:22:20
 */
@TableName("kehutuihuo")
public class KehutuihuoView  extends KehutuihuoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KehutuihuoView(){
	}
 
 	public KehutuihuoView(KehutuihuoEntity kehutuihuoEntity){
 	try {
			BeanUtils.copyProperties(this, kehutuihuoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
