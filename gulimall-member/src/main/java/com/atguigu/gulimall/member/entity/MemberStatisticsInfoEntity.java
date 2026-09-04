package com.atguigu.gulimall.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 浼氬憳缁熻?淇℃伅
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 16:51:52
 */
@Data
@TableName("ums_member_statistics_info")
public class MemberStatisticsInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 浼氬憳id
	 */
	private Long memberId;
	/**
	 * 绱??娑堣垂閲戦?
	 */
	private BigDecimal consumeAmount;
	/**
	 * 绱??浼樻儬閲戦?
	 */
	private BigDecimal couponAmount;
	/**
	 * 璁㈠崟鏁伴噺
	 */
	private Integer orderCount;
	/**
	 * 浼樻儬鍒告暟閲
	 */
	private Integer couponCount;
	/**
	 * 璇勪环鏁
	 */
	private Integer commentCount;
	/**
	 * 閫?揣鏁伴噺
	 */
	private Integer returnOrderCount;
	/**
	 * 鐧诲綍娆℃暟
	 */
	private Integer loginCount;
	/**
	 * 鍏虫敞鏁伴噺
	 */
	private Integer attendCount;
	/**
	 * 绮変笣鏁伴噺
	 */
	private Integer fansCount;
	/**
	 * 鏀惰棌鐨勫晢鍝佹暟閲
	 */
	private Integer collectProductCount;
	/**
	 * 鏀惰棌鐨勪笓棰樻椿鍔ㄦ暟閲
	 */
	private Integer collectSubjectCount;
	/**
	 * 鏀惰棌鐨勮瘎璁烘暟閲
	 */
	private Integer collectCommentCount;
	/**
	 * 閭??鐨勬湅鍙嬫暟閲
	 */
	private Integer inviteFriendCount;

}
