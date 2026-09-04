package com.atguigu.gulimall.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 閲囪喘淇℃伅
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 17:21:10
 */
@Data
@TableName("wms_purchase")
public class PurchaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 閲囪喘鍗昳d
	 */
	@TableId
	private Long id;
	/**
	 * 閲囪喘浜篿d
	 */
	private Long assigneeId;
	/**
	 * 閲囪喘浜哄悕
	 */
	private String assigneeName;
	/**
	 * 鑱旂郴鏂瑰紡
	 */
	private String phone;
	/**
	 * 浼樺厛绾
	 */
	private Integer priority;
	/**
	 * 鐘舵?
	 */
	private Integer status;
	/**
	 * 浠撳簱id
	 */
	private Long wareId;
	/**
	 * 鎬婚噾棰
	 */
	private BigDecimal amount;
	/**
	 * 鍒涘缓鏃ユ湡
	 */
	private Date createTime;
	/**
	 * 鏇存柊鏃ユ湡
	 */
	private Date updateTime;

}
