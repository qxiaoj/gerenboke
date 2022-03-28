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

    <el-upload
  class="avatar-uploader"
  action="http://localhost:8080/file/imgUpload"
  :show-file-list="false"
  :on-success="handleAvatarSuccess"
  :before-upload="beforeAvatarUpload">
  <img v-if="imageUrl" :src="imageUrl" class="avatar">
  <i v-else class="el-icon-plus avatar-uploader-icon"></i>
</el-upload>
    <el-footer style="height: 50px;">
      <a href="#">Copyright @ 2021-2022 qxiaoj Designed by QJ</a>
    </el-footer>
  </div>
</template>

<script>
export default {
  name: "Footer",
  data() {
    return {
         imageUrl: ''
    }
  },
    methods: {
      handleAvatarSuccess(res, file) {
        this.imageUrl = URL.createObjectURL(file.raw);
      },
      beforeAvatarUpload(file) {
        const isJPG = file.type === 'image/jpeg';
        const isLt2M = file.size / 1024 / 1024 < 2;

        if (!isJPG) {
          this.$message.error('上传头像图片只能是 JPG 格式!');
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 2MB!');
        }
        return isJPG && isLt2M;
      }
    }
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


.avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>