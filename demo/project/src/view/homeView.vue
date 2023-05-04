<template>

    <div style="width:100%;height: 100vh;">
        <el-container>
  <el-header style="height: 8vh;"><h1>后台管理系统</h1></el-header>
  <el-container style="height: 60vh;position: relative;">
    <el-aside style="height: 100%;width:12%;display: inline-block;">
        <el-row class="tac">
  <el-col :span="24">
    <el-menu
        router
      default-active="userList"
      class="el-menu-vertical-demo"
      @open="handleOpen"
      @close="handleClose">
      <el-menu-item index="/userList">
        <i class="el-icon-s-custom"></i>
        <span slot="title">用户管理</span>
      </el-menu-item>
      <el-menu-item index="2">
        <i class="el-icon-menu"></i>
        <span slot="title">导航二</span>
      </el-menu-item>
      <el-menu-item index="3" disabled>
        <i class="el-icon-document"></i>
        <span slot="title">导航三</span>
      </el-menu-item>
      <el-menu-item index="4">
        <i class="el-icon-setting"></i>
        <span slot="title">导航四</span>
      </el-menu-item>
    </el-menu>
  </el-col>
</el-row>
    
    
    </el-aside>
    <el-main style="background-color: white;height: 100%;width:88%;display: inline-block;position: absolute;top: 0;right: 0;">
    <!-- main -->
        <router-view></router-view>

    </el-main>
  </el-container>
</el-container>
    </div>

</template>

<style>

    *{
        margin: 0;
        padding: 0;
    }

  .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 8h;
  }
  
  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 200px;
  }
  
  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
  }
  
  body > .el-container {
    margin-bottom: 40px;
  }
  
  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }
  
  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }
</style>