package com.atguigu.gulimall.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 鏀?粯淇℃伅琛
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 17:02:42
 */
@Data
@TableName("oms_payment_info")
public class PaymentInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 璁㈠崟鍙凤紙瀵瑰?涓氬姟鍙凤級
	 */
	private String orderSn;
	/**
	 * 璁㈠崟id
	 */
	private Long orderId;
	/**
	 * 鏀?粯瀹濅氦鏄撴祦姘村彿
	 */
	private String alipayTradeNo;
	/**
	 * 鏀?粯鎬婚噾棰
	 */
	private BigDecimal totalAmount;
	/**
	 * 浜ゆ槗鍐呭?
	 */
	private String subject;
	/**
	 * 鏀?粯鐘舵?
	 */
	private String paymentStatus;
	/**
	 * 鍒涘缓鏃堕棿
	 */
	private Date createTime;
	/**
	 * 纭??鏃堕棿
	 */
	private Date confirmTime;
	/**
	 * 鍥炶皟鍐呭?
	 */
	private String callbackContent;
	/**
	 * 鍥炶皟鏃堕棿
	 */
	private Date callbackTime;

}
