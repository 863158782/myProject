<template>
  <el-menu
    class="categories"
    default-active="0"
    style="text-align: left;"
    @select="handleSelect"
    active-text-color="red">
    <el-menu-item v-for="(item,index) in list" :key="index" :index="item.location">
      <i class="el-icon-menu"></i>
      <span slot="title">{{item.name}}</span>
    </el-menu-item>
    <!-- <el-menu-item index="0">
      <i class="el-icon-menu"></i>
      <span slot="title">全部</span>
    </el-menu-item>
    <el-menu-item index="1">
      <i class="el-icon-menu"></i>
      <span slot="title">文学</span>
    </el-menu-item>
    <el-menu-item index="2">
      <i class="el-icon-menu"></i>
      <span slot="title">流行</span>
    </el-menu-item>
    <el-menu-item index="3">
      <i class="el-icon-menu"></i>
      <span slot="title">文化</span>
    </el-menu-item>
    <el-menu-item index="4">
      <i class="el-icon-menu"></i>
      <span slot="title">生活</span>
    </el-menu-item>
    <el-menu-item index="5">
      <i class="el-icon-menu"></i>
      <span slot="title">经管</span>
    </el-menu-item>
    <el-menu-item index="6">
      <i class="el-icon-menu"></i>
      <span slot="title">科技</span>
    </el-menu-item> -->
  </el-menu>
</template>

<script>
import axios from 'axios'
export default {
  name: 'SideMenu',
  data () {
    return {
      cid: '',
      list:[]
    }
  },
  created(){
    this.getMenu()
  },
  methods: {
    handleSelect (key, keyPath) {
      this.cid = key
      this.$emit('indexSelect')
    },
    getMenu(){
      var _this=this
      axios.get('/Partition').then(res => {
          if(res.data.code==200){
              _this.list=res.data.data
          }
      })
    }
  }
}
</script>

<style scoped>
.categories {
  position: fixed;
  margin-left: 50%;
  left: -600px;
  top: 100px;
  width: 150px;
}
</style>
