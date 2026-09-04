package com.atguigu.gulimall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 浼樻儬鍒搁?鍙栧巻鍙茶?褰
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 16:33:53
 */
@Data
@TableName("sms_coupon_history")
public class CouponHistoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 浼樻儬鍒竔d
	 */
	private Long couponId;
	/**
	 * 浼氬憳id
	 */
	private Long memberId;
	/**
	 * 浼氬憳鍚嶅瓧
	 */
	private String memberNickName;
	/**
	 * 鑾峰彇鏂瑰紡[0->鍚庡彴璧犻?锛?->涓诲姩棰嗗彇]
	 */
	private Integer getType;
	/**
	 * 鍒涘缓鏃堕棿
	 */
	private Date createTime;
	/**
	 * 浣跨敤鐘舵?[0->鏈?娇鐢?紱1->宸蹭娇鐢?紱2->宸茶繃鏈焆
	 */
	private Integer useType;
	/**
	 * 浣跨敤鏃堕棿
	 */
	private Date useTime;
	/**
	 * 璁㈠崟id
	 */
	private Long orderId;
	/**
	 * 璁㈠崟鍙
	 */
	private Long orderSn;

}
