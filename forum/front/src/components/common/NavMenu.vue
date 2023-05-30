<template>
  <el-menu
    :default-active="'/index'"
    router
    mode="horizontal"
    background-color="white"
    text-color="#222"
    active-text-color="red"
    style="min-width: 1300px;position: fixed;top: 0;z-index: 20;">
    <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.location">
      {{ item.name }}
    </el-menu-item>
    <el-button @click="logout()" style="position: absolute; top: 10px;right: 100px;">注销</el-button>
    <span style="position: absolute;padding-top: 20px;right: 50%;font-size: 20px;font-weight: bold">Welcome to the forum</span>
    <img style="width: 40px;height:40px;border: 1px solid #ddd;position: absolute;right: 250px;top: 7px;
    border-radius: 50%;" v-if="this.$store.state.user.avatar" :src="this.$store.state.user.avatar" alt="" />
    <span style="font-size: 18px;color: skyblue;position: absolute;right: 200px;top: 15px;">{{ this.$store.state.user.username }}</span>
    <!-- <el-button @click="setNavlist()" style="position: absolute; top: 10px;right: 100px;">category</el-button> -->

  </el-menu>
</template>

<script>
import axios from "axios"
export default {
  name: 'NavMenu',
  data () {
    return {
      navList: [
   
      ]
    }
  },
  created(){
      this.setNavlist();

  },
  methods:{
    logout(){
      window.localStorage.removeItem('user')
      window.location.href='/login';
    },
    setNavlist(){
      var _this=this
      axios.get('/getCategory').then(res => {
        if(res.data.code==200){
          _this.navList=res.data.data
        }
      })
    }
  }
}


</script>

<style scoped>
a{
  text-decoration: none;
}

span {
  pointer-events: none;
}
</style>
