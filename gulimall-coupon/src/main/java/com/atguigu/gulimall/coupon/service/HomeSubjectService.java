package com.atguigu.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.coupon.entity.HomeSubjectEntity;

import java.util.Map;

/**
 * 棣栭〉涓撻?琛ㄣ?jd棣栭〉涓嬮潰寰堝?涓撻?锛屾瘡涓?笓棰橀摼鎺ユ柊鐨勯〉闈?紝灞曠ず涓撻?鍟嗗搧淇℃伅銆
 *
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 16:33:53
 */
public interface HomeSubjectService extends IService<HomeSubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

