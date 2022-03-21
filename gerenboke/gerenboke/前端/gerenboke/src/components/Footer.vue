<template>
  <div class="footer">
    <el-footer style="height: 160px;">
      <ul>
        <li>32432</li>
        <li>dsaf</li>
        <li>
            <h4>联系我</h4>
        </li>
        <li>11</li>
      </ul>
    </el-footer>
    <el-footer style="height: 50px;">
      <a href="#">Copyright @ 2021-2022 qxiaoj Designed by QJ</a>
    </el-footer>
  </div>
</template>

<script>
export default {
  name: "Footer"
};
</script>

<style scoped>
.el-footer:first-child {
  background-color: #545c64;
  color: #333;
  height: 160px;
  text-align: center;
  line-height: 160px;
}

.el-footer:nth-child(2) {
  background-color: #545c64;
  color: #333;
  height: 50px;
  text-align: center;
  line-height: 50px;
}

a {
    text-decoration: none;
    color: #ccc;
}

a:hover {
    color: #fff;
}

ul {
  position: absolute;
  width: 100%;
  border-bottom: 1px solid #ccc;
}

ul li {
  width: 20%;
  margin: 0 2%;
  list-style: none;
  position: relative;
  float: left;
  color: #fff;
  border-right: 1px solid #ccc;
  text-align: center;
}

ul li:last-child {
  border-right: none;
}
</style>