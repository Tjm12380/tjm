package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 客户退货
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-03-15 21:22:20
 */
@TableName("kehutuihuo")
public class KehutuihuoEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public KehutuihuoEntity() {
		
	}
	
	public KehutuihuoEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 商品名称
	 */
					
	private String shangpinmingcheng;
	
	/**
	 * 商品类型
	 */
					
	private String shangpinleixing;
	
	/**
	 * 规格
	 */
					
	private String guige;
	
	/**
	 * 数量
	 */
					
	private Integer shuliang;
	
	/**
	 * 退货时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date tuihuoshijian;
	
	/**
	 * 退货原因
	 */
					
	private String tuihuoyuanyin;
	
	/**
	 * 销售账号
	 */
					
	private String xiaoshouzhanghao;
	
	/**
	 * 销售姓名
	 */
					
	private String xiaoshouxingming;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 审核回复
	 */
					
	private String shhf;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：商品名称
	 */
	public void setShangpinmingcheng(String shangpinmingcheng) {
		this.shangpinmingcheng = shangpinmingcheng;
	}
	/**
	 * 获取：商品名称
	 */
	public String getShangpinmingcheng() {
		return shangpinmingcheng;
	}
	/**
	 * 设置：商品类型
	 */
	public void setShangpinleixing(String shangpinleixing) {
		this.shangpinleixing = shangpinleixing;
	}
	/**
	 * 获取：商品类型
	 */
	public String getShangpinleixing() {
		return shangpinleixing;
	}
	/**
	 * 设置：规格
	 */
	public void setGuige(String guige) {
		this.guige = guige;
	}
	/**
	 * 获取：规格
	 */
	public String getGuige() {
		return guige;
	}
	/**
	 * 设置：数量
	 */
	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}
	/**
	 * 获取：数量
	 */
	public Integer getShuliang() {
		return shuliang;
	}
	/**
	 * 设置：退货时间
	 */
	public void setTuihuoshijian(Date tuihuoshijian) {
		this.tuihuoshijian = tuihuoshijian;
	}
	/**
	 * 获取：退货时间
	 */
	public Date getTuihuoshijian() {
		return tuihuoshijian;
	}
	/**
	 * 设置：退货原因
	 */
	public void setTuihuoyuanyin(String tuihuoyuanyin) {
		this.tuihuoyuanyin = tuihuoyuanyin;
	}
	/**
	 * 获取：退货原因
	 */
	public String getTuihuoyuanyin() {
		return tuihuoyuanyin;
	}
	/**
	 * 设置：销售账号
	 */
	public void setXiaoshouzhanghao(String xiaoshouzhanghao) {
		this.xiaoshouzhanghao = xiaoshouzhanghao;
	}
	/**
	 * 获取：销售账号
	 */
	public String getXiaoshouzhanghao() {
		return xiaoshouzhanghao;
	}
	/**
	 * 设置：销售姓名
	 */
	public void setXiaoshouxingming(String xiaoshouxingming) {
		this.xiaoshouxingming = xiaoshouxingming;
	}
	/**
	 * 获取：销售姓名
	 */
	public String getXiaoshouxingming() {
		return xiaoshouxingming;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：审核回复
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}

}
