package com.atguigu.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * spu鍥剧墖
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 10:47:12
 */
@Data
@TableName("pms_spu_images")
public class SpuImagesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * spu_id
	 */
	private Long spuId;
	/**
	 * 鍥剧墖鍚
	 */
	private String imgName;
	/**
	 * 鍥剧墖鍦板潃
	 */
	private String imgUrl;
	/**
	 * 椤哄簭
	 */
	private Integer imgSort;
	/**
	 * 鏄?惁榛樿?鍥
	 */
	private Integer defaultImg;

}
