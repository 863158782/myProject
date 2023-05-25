<template>
    <body id="poster">
    <el-form class="login-container" label-position="left"
             label-width="0px">
      <h3 class="login_title">系统注册</h3>
      <el-form-item>
        <el-input type="text" v-model="Form.username"
                  auto-complete="off" placeholder="账号"></el-input>
      </el-form-item>
      <el-form-item>
        <el-input type="password" v-model="Form.password"
                  auto-complete="off" placeholder="密码"></el-input>
      </el-form-item>
      <el-form-item>
        <el-input type="password" v-model="Form.testifyPassword"
                  auto-complete="off" placeholder="确认密码密码"></el-input>
      </el-form-item>
      <el-form-item style="width: 100%">
        <el-button type="primary" style="width: 100%;background: #505458;border: none" v-on:click="register">注册</el-button>
      </el-form-item>
    </el-form>
  
    <el-alert
    style="width: 300px;height: 30px;position: absolute;left: 40%;top: 5%;"
    center
      v-show="error"
      title="用户名或密码错误"
      type="error">
    </el-alert>
    </body>
  </template>
  
  <script>
  
  export default {
    name: 'Register',
    data () {
      return {
        Form: {
          username: '',
          password: '',
          testifyPassword:''
        },
        responseResult: [],
        error:false
      }
    },
    methods: {
        register () {
        var _this = this
        // console.log(this.$store.state)
        if(this.Form.password != this.Form.testifyPassword){
            alert("两次密码不一致");
            return ;
        }
        this.$axios
          .post('/register', {
            username: this.Form.username,
            password: this.Form.password
          })
          .then(successResponse => {
            if (successResponse.data.code === 200) {
              _this.$store.commit('login', _this.Form)
              var path = this.$route.query.redirect
              this.$router.replace({path: path === '/' || path === undefined ? '/index' : path})
              
            }
            else if(successResponse.data.code==400){
                _this.error=true
            }
          })
          .catch(failResponse => {
            alert("用户名已存在！");
          })
      }
    }
  }
  </script>
  
  <style>
  #poster {
    background:url("../assets/eva.jpg") no-repeat;
    background-position: center;
    height: 100%;
    width: 100%;
    background-size: cover;
    position: fixed;
  }
  body{
    margin: 0px;
  }
  .login-container {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 90px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }
  .login_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }
  </style>
  