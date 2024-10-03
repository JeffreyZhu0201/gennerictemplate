<template>
  <div class="login-container">
    <div style="display: flex">
      <el-form>
        <el-form-item class="form-box" style="padding-top: 40px;border-radius: 10px">
          <el-form-item>
            <el-input style="margin-bottom: 15px;" size="large" prefix-icon="el-icon-s-custom"
                      placeholder="请输入用户名" v-model="form.userName"></el-input>
          </el-form-item>
          <el-form-item>
            <el-input style="margin-bottom: 15px" size="large" show-password prefix-icon="el-icon-key"
                      placeholder="请输入密码" v-model="form.password"></el-input>
          </el-form-item>
          <el-form-item>
            <el-select style="width: 100%;margin-bottom: 15px" size="large" placeholder="请选择角色"
                       v-model="form.role">
              <el-option value="1" label="管理员"></el-option>
              <el-option value="2" label="用户"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-button style="width: 100%;height: 50px;background-color: #17bb94;border-color: #17bb94;color:white"
                       size="large" @click="login">登录
            </el-button>
          </el-form-item>
        </el-form-item>
        <el-form-item
            style="background-color: #ffffff; border-radius: 10px; display: flex; justify-content: center;align-items: center">
          <el-form-item class="regBox">
            <a href="javascript:void(0)" @click="navRegister" style="text-indent: 12px;">注册</a><span
              class="el-icon-right"></span>
          </el-form-item>

        </el-form-item>

      </el-form>
    </div>
  </div>
</template>


<script>

import request from "@/utils/request";

export default {
  name: "Login",
  data() {
    return {
      form: {}
    }
  },
  // 页面加载的时候，做一些事情，在created里面
  created() {
  },
  // 定义一些页面上控件出发的事件调用的方法
  methods: {
    // 登录按钮点击事件入口
    login() {
      // 页面表单数据的输入校验
      if (!this.form.userName) {
        this.$notify.error("请输入用户名");
        return;
      }
      if (!this.form.password) {
        this.$notify.error("请输入密码");
        return;
      }
      if (!this.form.role) {
        this.$notify.error("请选择角色");
        return;
      }
      // 如果角色标识为2，调用后用户登录的接口
      request.post('/account/login', this.form).then(res => {
        if (res.code === '200') {
          let user = res.data.user;
          let token = res.data.token;
          localStorage.setItem("token",token);
          localStorage.setItem("user",JSON.stringify(user))
          this.$notify.success("登录成功！");
          this.$router.push("/manager/home")
        } else {
          this.$notify.error(res.msg);
        }
      });
    },
    navRegister() {
      this.$router.push("/register")
    }
  }
}
</script>
<style scoped>
.login-container {
  height: 100vh;
  overflow: hidden;
  background-image: url("@/assets/logo.png");
  background-size: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
}

.form-box {
  width: 300px;
  padding: 20px 40px;
  border-radius: 2px;
  background-color: #ffffff;
  opacity: 1;
}

/deep/ .el-form-item {
  margin-bottom: 5px;
}

/deep/ .el-input__inner {
  border-color: #ccc !important;
  border-radius: 2px;
  background-color: #ffffff !important;
  color: #333;
}

/deep/ .el-input__icon {
  color: #666;
}

a {
  text-decoration: none;
  color: #17bb94;
  font-weight: bold;
}

.regBox {
  color: #17bb94;
  font-size: 28px;
  margin-bottom: 10px;
  margin-top: 10px;
  text-align: right;
}
</style>