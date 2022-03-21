<template>
  <div class="nav">
    <el-menu
      :default-active="activeIndex"
      class="el-menu-demo"
      mode="horizontal"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
    >
      <h1 style="display: inline-block" class="logo-h1">
        <a href="#"
          ><img
            src="@/assets/logo.png"
            alt="logo 个人博客"
            title="logo 个人博客"
            class="logo-img"
        /></a>
      </h1>

      <el-menu-item index="1">首页</el-menu-item>
      <el-menu-item index="2">分类</el-menu-item>
      <el-menu-item index="3">标签</el-menu-item>
      <el-menu-item index="4">归档</el-menu-item>
      <el-menu-item index="5">照片</el-menu-item>

      <el-menu-item class="searchInfo">
        <el-input placeholder="请输入内容" v-model="search">
          <el-button slot="append" icon="el-icon-search"></el-button>
        </el-input>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: "NavMenu",
  data() {
    return {
      activeIndex: "1",
      activeIndex2: "1",
      search: "",
    };
  },
  methods: {},
};
</script>

<style scoped>
.logo-h1 {
  float: left;
}

.logo-img {
  width: 50px;
  margin: 10px 50px 0 50px;
}

.searchInfo {
  left: 400px;
}
</style>