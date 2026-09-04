package com.atguigu.gulimall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 浼樻儬鍒稿垎绫诲叧鑱
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 16:33:53
 */
@Data
@TableName("sms_coupon_spu_category_relation")
public class CouponSpuCategoryRelationEntity implements Serializable {
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
	 * 浜у搧鍒嗙被id
	 */
	private Long categoryId;
	/**
	 * 浜у搧鍒嗙被鍚嶇О
	 */
	private String categoryName;

}
