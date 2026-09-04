package com.atguigu.gulimall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 棣栭〉杞?挱骞垮憡
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 16:33:53
 */
@Data
@TableName("sms_home_adv")
public class HomeAdvEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 鍚嶅瓧
	 */
	private String name;
	/**
	 * 鍥剧墖鍦板潃
	 */
	private String pic;
	/**
	 * 寮??鏃堕棿
	 */
	private Date startTime;
	/**
	 * 缁撴潫鏃堕棿
	 */
	private Date endTime;
	/**
	 * 鐘舵?
	 */
	private Integer status;
	/**
	 * 鐐瑰嚮鏁
	 */
	private Integer clickCount;
	/**
	 * 骞垮憡璇︽儏杩炴帴鍦板潃
	 */
	private String url;
	/**
	 * 澶囨敞
	 */
	private String note;
	/**
	 * 鎺掑簭
	 */
	private Integer sort;
	/**
	 * 鍙戝竷鑰
	 */
	private Long publisherId;
	/**
	 * 瀹℃牳鑰
	 */
	private Long authId;

}
