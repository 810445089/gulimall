<template>
  <el-tree
    :data="menus"
    :props="defaultProps"
    node-key="catId"
    ref="menuTree"
    @node-click="nodeClick"
    :filter-node-method="filterNode"
    :highlight-current="true"
  >
  </el-tree>
</template>

<script>
export default {
  data() {
    return {
      filterText: "",
      menus: [],
      expandedKey: [],
      defaultProps: {
        children: "children",
        label: "name"
      }
    };
  },

  //计算属性 类似于data概念
  computed: {},
  //监控data中的数据变化
  watch: {
    filterText(val) {
      this.$refs.menuTree.filter(val);
    }
  },

  methods: {
    //树节点过滤
    filterNode(value, data) {
      if (!value) return true;
      return data.name.indexOf(value) !== -1;
    },

    // 获取数据列表
    getMenus() {
      this.dataListLoading = true;
      this.$http({
        url: this.$http.adornUrl("/product/category/list/tree"),
        method: "get"
      }).then(({ data }) => {
        this.menus = data.data;
      });
    },

    nodeClick(data, node, component) {
      // 向父组件发送事件
      this.$emit("tree-node-click", data, node, component);
    }
  },
  created() {
    this.getMenus();
  }
};
</script>
