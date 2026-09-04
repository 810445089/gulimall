package com.atguigu.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * spu灞炴?鍊
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 10:47:12
 */
@Data
@TableName("pms_product_attr_value")
public class ProductAttrValueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 鍟嗗搧id
	 */
	private Long spuId;
	/**
	 * 灞炴?id
	 */
	private Long attrId;
	/**
	 * 灞炴?鍚
	 */
	private String attrName;
	/**
	 * 灞炴?鍊
	 */
	private String attrValue;
	/**
	 * 椤哄簭
	 */
	private Integer attrSort;
	/**
	 * 蹇??灞曠ず銆愭槸鍚﹀睍绀哄湪浠嬬粛涓婏紱0-鍚?1-鏄??
	 */
	private Integer quickShow;

}
