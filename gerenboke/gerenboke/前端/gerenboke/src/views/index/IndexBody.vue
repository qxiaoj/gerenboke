<template>
  <div>
    <el-row>
      <el-col :span="2">
        <div class="grid-content bg-purple-light"></div>
      </el-col>
      <el-col :span="12" style="border: 1px solid red">
        <div class="grid-content bg-purple">
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span style="float: left">博客发</span>
              <h1 style="float: right">共XX篇</h1>
            </div>
            <!-- 主模块显示 -->
            <el-card class="box-card">
              <div v-for="o in 4" :key="o" class="text item">{{'列表内容 ' + o }}</div>
            </el-card>
            <el-card class="box-card">
              <div v-for="o in 4" :key="o" class="text item">{{'列表内容 ' + o }}</div>
            </el-card>
            <el-card class="box-card">
              <div v-for="o in 4" :key="o" class="text item">{{'列表内容 ' + o }}</div>
            </el-card>
            <el-card class="box-card">
              <div v-for="o in 4" :key="o" class="text item">{{'列表内容 ' + o }}</div>
            </el-card>
          </el-card>
        </div>
      </el-col>
      <el-col :span="2">
        <div class="grid-content bg-purple-light"></div>
      </el-col>
      <el-col :span="6" style="border: 1px solid red">
        <div class="grid-content bg-purple">
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span style="float: left">分类</span>
              <a href="#" style="float: right">more</a>
            </div>
            <div v-for="o in 4" :key="o" class="text item">{{'列表内容 ' + o }}</div>
          </el-card>

          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span style="float: left">分类</span>
              <a href="#" style="float: right">more</a>
            </div>
            <div v-for="o in 4" :key="o" class="text item">{{'列表内容 ' + o }}</div>
          </el-card>
        </div>
      </el-col>
      <el-col :span="2">
        <div class="grid-content bg-purple-light"></div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "IndexBody",

  data() {
    return {};
  },

  mounted() {},

  methods: {}
};
</script>

<style lang="scss" scoped>
.el-row {
  margin-top: 20px;
  margin-bottom: 20px;
  &:last-child {
    margin-bottom: 0;
  }
}
.el-col {
  border-radius: 4px;
}
.grid-content {
  border-radius: 4px;
  min-height: 500px;
}
.bg-purple-light {
  background: #e5e9f2;
}

.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both;
}

// .box-card {
//   width: 480px;
// }
</style>