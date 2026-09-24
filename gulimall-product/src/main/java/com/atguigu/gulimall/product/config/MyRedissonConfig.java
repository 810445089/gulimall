package com.atguigu.gulimall.product.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRedissonConfig {

    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.33.10:6379"); // 单节点模式
//        config.useSingleServer().setAddress("rediss://192.168.33.10:6379"); // 安全连接
//        config.useClusterServers().addNodeAddress("127.0.0.1:7001", "127.0.0.1:7002"); //集群模式

        return Redisson.create(config);
    }
}
