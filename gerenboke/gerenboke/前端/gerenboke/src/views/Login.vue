<template>
  <div>
    <el-container>
      <el-header>
        <img
          src="https://www.markerhub.com/dist/images/logo/markerhub-logo.png"
          style="height: 60%; margin-top: 10px;"
        />
      </el-header>
      <el-main>
        <el-form
          :model="ruleForm"
          status-icon
          :rules="rules"
          ref="ruleForm"
          label-width="100px"
          class="demo-ruleForm"
          style="width: 500px;margin: 80px auto"
        >
          <el-form-item label="用户名" prop="username">
            <el-input type="text" maxlength="12" v-model="ruleForm.username"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input type="password" v-model="ruleForm.password" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
          </el-form-item>
        </el-form>
      </el-main>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "login",
  data() {
    var validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入密码"));
      } else {
        callback();
      }
    };
    return {
      ruleForm: {
        password: "123456",
        username: "admin"
      },
      rules: {
        password: [{ validator: validatePass, trigger: "blur" }],
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" },
          { min: 3, max: 12, message: "长度在 3 到 12 个字符", trigger: "blur" }
        ]
      }
    };
  },
  methods: {
    submitForm(formName) {
      const _this = this;
      this.$refs[formName].validate(valid => {
        if (valid) {
          // 提交逻辑
          axios
            .post("/user/login", this.ruleForm)
            .then(res => {
              const token = res.headers["authorization"];
              _this.$store.commit("SET_TOKEN", token);
              _this.$store.commit("SET_USERINFO", res.data.user);
              if (res.data.code == 200 && res.data.user != null) {
                _this.$router.push("/index");
                _this.$message.success(res.data.message);

                if (res.data.user.lastLoginTime != null) {
                  this.$notify({
                    title: "欢迎再次登录，上次登录：",
                    message: res.data.user.lastLoginTime,
                    duration: 5500
                  });
                } else {
                  this.$notify({
                    title: "欢迎用户" + res.data.user.username,
                    message: '首次登录',
                    duration: 5500
                  });
                }
              } else {
                _this.$message.error(res.data.message);
              }
            })
            .catch(err => {
              _this.$message.error(err.response.data.message);
            });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  },
  mounted() {
    this.$notify({
      title: "欢迎来到：",
      message: "QJのVblog",
      duration: 1500
    });
  }
};
</script>

<style scoped>

</style>