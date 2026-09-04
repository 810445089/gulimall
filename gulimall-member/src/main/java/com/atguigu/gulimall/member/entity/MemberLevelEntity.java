package com.atguigu.gulimall.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 浼氬憳绛夌骇
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 16:51:52
 */
@Data
@TableName("ums_member_level")
public class MemberLevelEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 绛夌骇鍚嶇О
	 */
	private String name;
	/**
	 * 绛夌骇闇??鐨勬垚闀垮?
	 */
	private Integer growthPoint;
	/**
	 * 鏄?惁涓洪粯璁ょ瓑绾?0->涓嶆槸锛?->鏄痌
	 */
	private Integer defaultStatus;
	/**
	 * 鍏嶈繍璐规爣鍑
	 */
	private BigDecimal freeFreightPoint;
	/**
	 * 姣忔?璇勪环鑾峰彇鐨勬垚闀垮?
	 */
	private Integer commentGrowthPoint;
	/**
	 * 鏄?惁鏈夊厤閭?壒鏉
	 */
	private Integer priviledgeFreeFreight;
	/**
	 * 鏄?惁鏈変細鍛樹环鏍肩壒鏉
	 */
	private Integer priviledgeMemberPrice;
	/**
	 * 鏄?惁鏈夌敓鏃ョ壒鏉
	 */
	private Integer priviledgeBirthday;
	/**
	 * 澶囨敞
	 */
	private String note;

}
