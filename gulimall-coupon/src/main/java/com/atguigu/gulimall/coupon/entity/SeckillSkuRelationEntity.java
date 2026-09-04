package com.atguigu.gulimall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 绉掓潃娲诲姩鍟嗗搧鍏宠仈
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 16:33:53
 */
@Data
@TableName("sms_seckill_sku_relation")
public class SeckillSkuRelationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 娲诲姩id
	 */
	private Long promotionId;
	/**
	 * 娲诲姩鍦烘?id
	 */
	private Long promotionSessionId;
	/**
	 * 鍟嗗搧id
	 */
	private Long skuId;
	/**
	 * 绉掓潃浠锋牸
	 */
	private BigDecimal seckillPrice;
	/**
	 * 绉掓潃鎬婚噺
	 */
	private BigDecimal seckillCount;
	/**
	 * 姣忎汉闄愯喘鏁伴噺
	 */
	private BigDecimal seckillLimit;
	/**
	 * 鎺掑簭
	 */
	private Integer seckillSort;

}
