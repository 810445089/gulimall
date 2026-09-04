package com.atguigu.gulimall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 鍟嗗搧浼氬憳浠锋牸
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 16:33:53
 */
@Data
@TableName("sms_member_price")
public class MemberPriceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * sku_id
	 */
	private Long skuId;
	/**
	 * 浼氬憳绛夌骇id
	 */
	private Long memberLevelId;
	/**
	 * 浼氬憳绛夌骇鍚
	 */
	private String memberLevelName;
	/**
	 * 浼氬憳瀵瑰簲浠锋牸
	 */
	private BigDecimal memberPrice;
	/**
	 * 鍙?惁鍙犲姞鍏朵粬浼樻儬[0-涓嶅彲鍙犲姞浼樻儬锛?-鍙?彔鍔燷
	 */
	private Integer addOther;

}
