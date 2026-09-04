package com.atguigu.gulimall.product.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * className: Catalog2Vo
 * description:
 * date: 2024/4/19-17:39
 * <p>
 * project: gulimall
 * package: com.atguigu.gulimall.product.vo
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Catalog2Vo {

    /**
     * 1级父分类 Id
     */
    private String catalog1Id;

    /**
     * 3级子分类
     */
    private List<Catalog3Vo> catalog3List;

    /**
     * 当前节点 id
     */
    private String id;

    /**
     * 当前节点名称
     */
    private String name;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Catalog3Vo {
        /**
         * 2级父分类 Id
         */
        private String catalog2Id;

        /**
         * 当前节点 id
         */
        private String id;

        /**
         * 当前节点名称
         */
        private String name;
    }

}
