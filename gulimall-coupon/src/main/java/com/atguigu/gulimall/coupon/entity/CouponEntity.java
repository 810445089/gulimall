package com.atguigu.gulimall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 浼樻儬鍒镐俊鎭
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 16:33:53
 */
@Data
@TableName("sms_coupon")
public class CouponEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 浼樻儬鍗风被鍨媅0->鍏ㄥ満璧犲埜锛?->浼氬憳璧犲埜锛?->璐?墿璧犲埜锛?->娉ㄥ唽璧犲埜]
	 */
	private Integer couponType;
	/**
	 * 浼樻儬鍒稿浘鐗
	 */
	private String couponImg;
	/**
	 * 浼樻儬鍗峰悕瀛
	 */
	private String couponName;
	/**
	 * 鏁伴噺
	 */
	private Integer num;
	/**
	 * 閲戦?
	 */
	private BigDecimal amount;
	/**
	 * 姣忎汉闄愰?寮犳暟
	 */
	private Integer perLimit;
	/**
	 * 浣跨敤闂ㄦ?
	 */
	private BigDecimal minPoint;
	/**
	 * 寮??鏃堕棿
	 */
	private Date startTime;
	/**
	 * 缁撴潫鏃堕棿
	 */
	private Date endTime;
	/**
	 * 浣跨敤绫诲瀷[0->鍏ㄥ満閫氱敤锛?->鎸囧畾鍒嗙被锛?->鎸囧畾鍟嗗搧]
	 */
	private Integer useType;
	/**
	 * 澶囨敞
	 */
	private String note;
	/**
	 * 鍙戣?鏁伴噺
	 */
	private Integer publishCount;
	/**
	 * 宸蹭娇鐢ㄦ暟閲
	 */
	private Integer useCount;
	/**
	 * 棰嗗彇鏁伴噺
	 */
	private Integer receiveCount;
	/**
	 * 鍙?互棰嗗彇鐨勫紑濮嬫棩鏈
	 */
	private Date enableStartTime;
	/**
	 * 鍙?互棰嗗彇鐨勭粨鏉熸棩鏈
	 */
	private Date enableEndTime;
	/**
	 * 浼樻儬鐮
	 */
	private String code;
	/**
	 * 鍙?互棰嗗彇鐨勪細鍛樼瓑绾?0->涓嶉檺绛夌骇锛屽叾浠?瀵瑰簲绛夌骇]
	 */
	private Integer memberLevel;
	/**
	 * 鍙戝竷鐘舵?[0-鏈?彂甯冿紝1-宸插彂甯僝
	 */
	private Integer publish;

}
