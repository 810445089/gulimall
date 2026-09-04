package com.atguigu.gulimall.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 璁㈠崟閫?揣鐢宠?
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 17:02:42
 */
@Data
@TableName("oms_order_return_apply")
public class OrderReturnApplyEntity implements Serializable {
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
	 * 閫?揣鍟嗗搧id
	 */
	private Long skuId;
	/**
	 * 璁㈠崟缂栧彿
	 */
	private String orderSn;
	/**
	 * 鐢宠?鏃堕棿
	 */
	private Date createTime;
	/**
	 * 浼氬憳鐢ㄦ埛鍚
	 */
	private String memberUsername;
	/**
	 * 閫??閲戦?
	 */
	private BigDecimal returnAmount;
	/**
	 * 閫?揣浜哄?鍚
	 */
	private String returnName;
	/**
	 * 閫?揣浜虹數璇
	 */
	private String returnPhone;
	/**
	 * 鐢宠?鐘舵?[0->寰呭?鐞嗭紱1->閫?揣涓?紱2->宸插畬鎴愶紱3->宸叉嫆缁漖
	 */
	private Integer status;
	/**
	 * 澶勭悊鏃堕棿
	 */
	private Date handleTime;
	/**
	 * 鍟嗗搧鍥剧墖
	 */
	private String skuImg;
	/**
	 * 鍟嗗搧鍚嶇О
	 */
	private String skuName;
	/**
	 * 鍟嗗搧鍝佺墝
	 */
	private String skuBrand;
	/**
	 * 鍟嗗搧閿?敭灞炴?(JSON)
	 */
	private String skuAttrsVals;
	/**
	 * 閫?揣鏁伴噺
	 */
	private Integer skuCount;
	/**
	 * 鍟嗗搧鍗曚环
	 */
	private BigDecimal skuPrice;
	/**
	 * 鍟嗗搧瀹為檯鏀?粯鍗曚环
	 */
	private BigDecimal skuRealPrice;
	/**
	 * 鍘熷洜
	 */
	private String reason;
	/**
	 * 鎻忚堪
	 */
	private String description杩;
	/**
	 * 鍑?瘉鍥剧墖锛屼互閫楀彿闅斿紑
	 */
	private String descPics;
	/**
	 * 澶勭悊澶囨敞
	 */
	private String handleNote;
	/**
	 * 澶勭悊浜哄憳
	 */
	private String handleMan;
	/**
	 * 鏀惰揣浜
	 */
	private String receiveMan;
	/**
	 * 鏀惰揣鏃堕棿
	 */
	private Date receiveTime;
	/**
	 * 鏀惰揣澶囨敞
	 */
	private String receiveNote;
	/**
	 * 鏀惰揣鐢佃瘽
	 */
	private String receivePhone;
	/**
	 * 鍏?徃鏀惰揣鍦板潃
	 */
	private String companyAddress;

}
