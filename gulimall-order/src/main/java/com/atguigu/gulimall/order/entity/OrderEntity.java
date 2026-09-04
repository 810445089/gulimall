package com.atguigu.gulimall.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 璁㈠崟
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 17:02:42
 */
@Data
@TableName("oms_order")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * member_id
	 */
	private Long memberId;
	/**
	 * 璁㈠崟鍙
	 */
	private String orderSn;
	/**
	 * 浣跨敤鐨勪紭鎯犲埜
	 */
	private Long couponId;
	/**
	 * create_time
	 */
	private Date createTime;
	/**
	 * 鐢ㄦ埛鍚
	 */
	private String memberUsername;
	/**
	 * 璁㈠崟鎬婚?
	 */
	private BigDecimal totalAmount;
	/**
	 * 搴斾粯鎬婚?
	 */
	private BigDecimal payAmount;
	/**
	 * 杩愯垂閲戦?
	 */
	private BigDecimal freightAmount;
	/**
	 * 淇冮攢浼樺寲閲戦?锛堜績閿?环銆佹弧鍑忋?闃舵?浠凤級
	 */
	private BigDecimal promotionAmount;
	/**
	 * 绉?垎鎶垫墸閲戦?
	 */
	private BigDecimal integrationAmount;
	/**
	 * 浼樻儬鍒告姷鎵ｉ噾棰
	 */
	private BigDecimal couponAmount;
	/**
	 * 鍚庡彴璋冩暣璁㈠崟浣跨敤鐨勬姌鎵ｉ噾棰
	 */
	private BigDecimal discountAmount;
	/**
	 * 鏀?粯鏂瑰紡銆?->鏀?粯瀹濓紱2->寰?俊锛?->閾惰仈锛?4->璐у埌浠樻?锛涖?
	 */
	private Integer payType;
	/**
	 * 璁㈠崟鏉ユ簮[0->PC璁㈠崟锛?->app璁㈠崟]
	 */
	private Integer sourceType;
	/**
	 * 璁㈠崟鐘舵?銆?->寰呬粯娆撅紱1->寰呭彂璐э紱2->宸插彂璐э紱3->宸插畬鎴愶紱4->宸插叧闂?紱5->鏃犳晥璁㈠崟銆
	 */
	private Integer status;
	/**
	 * 鐗╂祦鍏?徃(閰嶉?鏂瑰紡)
	 */
	private String deliveryCompany;
	/**
	 * 鐗╂祦鍗曞彿
	 */
	private String deliverySn;
	/**
	 * 鑷?姩纭??鏃堕棿锛堝ぉ锛
	 */
	private Integer autoConfirmDay;
	/**
	 * 鍙?互鑾峰緱鐨勭Н鍒
	 */
	private Integer integration;
	/**
	 * 鍙?互鑾峰緱鐨勬垚闀垮?
	 */
	private Integer growth;
	/**
	 * 鍙戠エ绫诲瀷[0->涓嶅紑鍙戠エ锛?->鐢靛瓙鍙戠エ锛?->绾歌川鍙戠エ]
	 */
	private Integer billType;
	/**
	 * 鍙戠エ鎶?ご
	 */
	private String billHeader;
	/**
	 * 鍙戠エ鍐呭?
	 */
	private String billContent;
	/**
	 * 鏀剁エ浜虹數璇
	 */
	private String billReceiverPhone;
	/**
	 * 鏀剁エ浜洪偖绠
	 */
	private String billReceiverEmail;
	/**
	 * 鏀惰揣浜哄?鍚
	 */
	private String receiverName;
	/**
	 * 鏀惰揣浜虹數璇
	 */
	private String receiverPhone;
	/**
	 * 鏀惰揣浜洪偖缂
	 */
	private String receiverPostCode;
	/**
	 * 鐪佷唤/鐩磋緰甯
	 */
	private String receiverProvince;
	/**
	 * 鍩庡競
	 */
	private String receiverCity;
	/**
	 * 鍖
	 */
	private String receiverRegion;
	/**
	 * 璇︾粏鍦板潃
	 */
	private String receiverDetailAddress;
	/**
	 * 璁㈠崟澶囨敞
	 */
	private String note;
	/**
	 * 纭??鏀惰揣鐘舵?[0->鏈?‘璁わ紱1->宸茬‘璁?
	 */
	private Integer confirmStatus;
	/**
	 * 鍒犻櫎鐘舵?銆?->鏈?垹闄わ紱1->宸插垹闄ゃ?
	 */
	private Integer deleteStatus;
	/**
	 * 涓嬪崟鏃朵娇鐢ㄧ殑绉?垎
	 */
	private Integer useIntegration;
	/**
	 * 鏀?粯鏃堕棿
	 */
	private Date paymentTime;
	/**
	 * 鍙戣揣鏃堕棿
	 */
	private Date deliveryTime;
	/**
	 * 纭??鏀惰揣鏃堕棿
	 */
	private Date receiveTime;
	/**
	 * 璇勪环鏃堕棿
	 */
	private Date commentTime;
	/**
	 * 淇?敼鏃堕棿
	 */
	private Date modifyTime;

}
