package com.atguigu.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * sku鍥剧墖
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 10:47:12
 */
@Data
@TableName("pms_sku_images")
public class SkuImagesEntity implements Serializable {
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
	 * 鍥剧墖鍦板潃
	 */
	private String imgUrl;
	/**
	 * 鎺掑簭
	 */
	private Integer imgSort;
	/**
	 * 榛樿?鍥綶0 - 涓嶆槸榛樿?鍥撅紝1 - 鏄?粯璁ゅ浘]
	 */
	private Integer defaultImg;

}
