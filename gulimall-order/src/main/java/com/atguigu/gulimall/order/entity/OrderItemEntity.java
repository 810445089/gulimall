package com.atguigu.gulimall.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 璁㈠崟椤逛俊鎭
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 17:02:42
 */
@Data
@TableName("oms_order_item")
public class OrderItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * order_id
	 */
	private Long orderId;
	/**
	 * order_sn
	 */
	private String orderSn;
	/**
	 * spu_id
	 */
	private Long spuId;
	/**
	 * spu_name
	 */
	private String spuName;
	/**
	 * spu_pic
	 */
	private String spuPic;
	/**
	 * 鍝佺墝
	 */
	private String spuBrand;
	/**
	 * 鍟嗗搧鍒嗙被id
	 */
	private Long categoryId;
	/**
	 * 鍟嗗搧sku缂栧彿
	 */
	private Long skuId;
	/**
	 * 鍟嗗搧sku鍚嶅瓧
	 */
	private String skuName;
	/**
	 * 鍟嗗搧sku鍥剧墖
	 */
	private String skuPic;
	/**
	 * 鍟嗗搧sku浠锋牸
	 */
	private BigDecimal skuPrice;
	/**
	 * 鍟嗗搧璐?拱鐨勬暟閲
	 */
	private Integer skuQuantity;
	/**
	 * 鍟嗗搧閿?敭灞炴?缁勫悎锛圝SON锛
	 */
	private String skuAttrsVals;
	/**
	 * 鍟嗗搧淇冮攢鍒嗚В閲戦?
	 */
	private BigDecimal promotionAmount;
	/**
	 * 浼樻儬鍒镐紭鎯犲垎瑙ｉ噾棰
	 */
	private BigDecimal couponAmount;
	/**
	 * 绉?垎浼樻儬鍒嗚В閲戦?
	 */
	private BigDecimal integrationAmount;
	/**
	 * 璇ュ晢鍝佺粡杩囦紭鎯犲悗鐨勫垎瑙ｉ噾棰
	 */
	private BigDecimal realAmount;
	/**
	 * 璧犻?绉?垎
	 */
	private Integer giftIntegration;
	/**
	 * 璧犻?鎴愰暱鍊
	 */
	private Integer giftGrowth;

}
