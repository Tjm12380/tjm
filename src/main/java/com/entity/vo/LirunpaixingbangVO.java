package com.entity.vo;

import com.entity.LirunpaixingbangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 利润排行榜
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-03-15 21:22:20
 */
public class LirunpaixingbangVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 商品类型
	 */
	
	private String shangpinleixing;
		
	/**
	 * 规格
	 */
	
	private String guige;
		
	/**
	 * 利润
	 */
	
	private Float lirun;
		
	/**
	 * 排行
	 */
	
	private String paixing;
		
	/**
	 * 统计月份
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date tongjiyuefen;
				
	
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
	 * 设置：利润
	 */
	 
	public void setLirun(Float lirun) {
		this.lirun = lirun;
	}
	
	/**
	 * 获取：利润
	 */
	public Float getLirun() {
		return lirun;
	}
				
	
	/**
	 * 设置：排行
	 */
	 
	public void setPaixing(String paixing) {
		this.paixing = paixing;
	}
	
	/**
	 * 获取：排行
	 */
	public String getPaixing() {
		return paixing;
	}
				
	
	/**
	 * 设置：统计月份
	 */
	 
	public void setTongjiyuefen(Date tongjiyuefen) {
		this.tongjiyuefen = tongjiyuefen;
	}
	
	/**
	 * 获取：统计月份
	 */
	public Date getTongjiyuefen() {
		return tongjiyuefen;
	}
			
}
