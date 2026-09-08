<!--
 * @Author: WangGuojian 1085844536@qq.com
 * @Date: 2024-02-03 22:21:08
 * @LastEditTime: 2024-03-24 01:02:35
 * @LastEditors: WangGuojian 1085844536@qq.com
 * @FilePath: \htmld:\Developer\WGJ\Java_WorkSpace\guli\gulimall\renren-fast-vue\src\views\main-sidebar-sub-menu.vue
 * @Description:
-->
<template>
  <el-submenu
    v-if="menu.list && menu.list.length >= 1"
    :index="menu.menuId + ''"
    :popper-class="'site-sidebar--' + sidebarLayoutSkin + '-popper'"
  >
    <template slot="title">
      <icon-svg :name="menu.icon || ''" class="site-sidebar__menu-icon">
      </icon-svg>
      <span>{{ menu.name }}</span>
    </template>
    <sub-menu
      v-for="item in menu.list"
      v-if="item.type !== 2"
      :key="item.menuId"
      :menu="item"
      :dynamicMenuRoutes="dynamicMenuRoutes"
    >
    </sub-menu>
  </el-submenu>
  <el-menu-item v-else :index="menu.menuId + ''" @click="gotoRouteHandle(menu)">
    <icon-svg :name="menu.icon || ''" class="site-sidebar__menu-icon">
    </icon-svg>
    <span>{{ menu.name }}</span>
  </el-menu-item>
</template>

<script>
import SubMenu from "./main-sidebar-sub-menu";
export default {
  name: "sub-menu",
  props: {
    menu: {
      type: Object,
      required: true
    },
    dynamicMenuRoutes: {
      type: Array,
      required: true
    }
  },
  components: {
    SubMenu
  },
  computed: {
    sidebarLayoutSkin: {
      get() {
        return this.$store.state.common.sidebarLayoutSkin;
      }
    }
  },
  methods: {
    // 通过menuId与动态(菜单)路由进行匹配跳转至指定路由
    gotoRouteHandle(menu) {
      var route = this.dynamicMenuRoutes.filter(
        item => item.meta.menuId === menu.menuId
      );
      if (route.length >= 1) {
        this.$router.push({ name: route[0].name });
      }
    }
  }
};
</script>
