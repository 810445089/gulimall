package com.atguigu.gulimall.product.feign.fallback;

import com.atguigu.common.exception.BizCodeEnum;
import com.atguigu.common.utils.R;
import com.atguigu.gulimall.product.feign.SecKillFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SecKillFeignServiceFallBack implements SecKillFeignService {

    @Override
    public R getSkuSecKillInfo(Long skuId) {
        log.info("熔断方法调用...getSkuSecKillInfo");
        return R.error(BizCodeEnum.TOO_MANY_REQUEST.getCode(),BizCodeEnum.TOO_MANY_REQUEST.getMessage());
    }
}
