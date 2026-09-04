package com.atguigu.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 鍟嗗搧灞炴?
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 10:47:12
 */
@Data
@TableName("pms_attr")
public class AttrEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 灞炴?id
	 */
	@TableId
	private Long attrId;
	/**
	 * 灞炴?鍚
	 */
	private String attrName;
	/**
	 * 鏄?惁闇??妫?储[0-涓嶉渶瑕侊紝1-闇??]
	 */
	private Integer searchType;
	/**
	 * 鍊肩被鍨媅0-涓哄崟涓??锛?-鍙?互閫夋嫨澶氫釜鍊糫
	 */
	private Integer valueType;
	/**
	 * 灞炴?鍥炬爣
	 */
	private String icon;
	/**
	 * 鍙??鍊煎垪琛╗鐢ㄩ?鍙峰垎闅擼
	 */
	private String valueSelect;
	/**
	 * 灞炴?绫诲瀷[0-閿?敭灞炴?锛?-鍩烘湰灞炴?锛?-鏃㈡槸閿?敭灞炴?鍙堟槸鍩烘湰灞炴?]
	 */
	private Integer attrType;
	/**
	 * 鍚?敤鐘舵?[0 - 绂佺敤锛? - 鍚?敤]
	 */
	private Long enable;
	/**
	 * 鎵?睘鍒嗙被
	 */
    @TableField("catelog_id")
	private Long catalogId;
	/**
	 * 蹇??灞曠ず銆愭槸鍚﹀睍绀哄湪浠嬬粛涓婏紱0-鍚?1-鏄??锛屽湪sku涓?粛鐒跺彲浠ヨ皟鏁
	 */
	private Integer showDesc;

}
