package com.atguigu.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 鍟嗗搧璇勪环
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 10:47:12
 */
@Data
@TableName("pms_spu_comment")
public class SpuCommentEntity implements Serializable {
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
	 * spu_id
	 */
	private Long spuId;
	/**
	 * 鍟嗗搧鍚嶅瓧
	 */
	private String spuName;
	/**
	 * 浼氬憳鏄电О
	 */
	private String memberNickName;
	/**
	 * 鏄熺骇
	 */
	private Integer star;
	/**
	 * 浼氬憳ip
	 */
	private String memberIp;
	/**
	 * 鍒涘缓鏃堕棿
	 */
	private Date createTime;
	/**
	 * 鏄剧ず鐘舵?[0-涓嶆樉绀猴紝1-鏄剧ず]
	 */
	private Integer showStatus;
	/**
	 * 璐?拱鏃跺睘鎬х粍鍚
	 */
	private String spuAttributes;
	/**
	 * 鐐硅禐鏁
	 */
	private Integer likesCount;
	/**
	 * 鍥炲?鏁
	 */
	private Integer replyCount;
	/**
	 * 璇勮?鍥剧墖/瑙嗛?[json鏁版嵁锛沎{type:鏂囦欢绫诲瀷,url:璧勬簮璺?緞}]]
	 */
	private String resources;
	/**
	 * 鍐呭?
	 */
	private String content;
	/**
	 * 鐢ㄦ埛澶村儚
	 */
	private String memberIcon;
	/**
	 * 璇勮?绫诲瀷[0 - 瀵瑰晢鍝佺殑鐩存帴璇勮?锛? - 瀵硅瘎璁虹殑鍥炲?]
	 */
	private Integer commentType;

}
