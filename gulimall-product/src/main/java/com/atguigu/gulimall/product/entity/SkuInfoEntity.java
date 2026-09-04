package com.atguigu.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * sku淇℃伅
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 10:47:12
 */
@Data
@TableName("pms_sku_info")
public class SkuInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * skuId
	 */
	@TableId
	private Long skuId;
	/**
	 * spuId
	 */
	private Long spuId;
	/**
	 * sku鍚嶇О
	 */
	private String skuName;
	/**
	 * sku浠嬬粛鎻忚堪
	 */
	private String skuDesc;
	/**
	 * 鎵?睘鍒嗙被id
	 */
	private Long catalogId;
	/**
	 * 鍝佺墝id
	 */
	private Long brandId;
	/**
	 * 榛樿?鍥剧墖
	 */
	private String skuDefaultImg;
	/**
	 * 鏍囬?
	 */
	private String skuTitle;
	/**
	 * 鍓?爣棰
	 */
	private String skuSubtitle;
	/**
	 * 浠锋牸
	 */
	private BigDecimal price;
	/**
	 * 閿?噺
	 */
	private Long saleCount;

}
