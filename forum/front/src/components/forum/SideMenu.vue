<template>
  <el-menu
    class="categories"
    default-active="0"
    style="text-align: left;"
    active-text-color="blue"
    >
    <el-menu-item v-for="(item,index) in list" :key="index" :index="item.id" @click="handleSelect(item)">
      <i class="el-icon-menu"></i>
      <span slot="title">{{item.name}}</span>
    </el-menu-item>
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
    this.getMenu();
    // this.$parent.list=this.list;
  },
  methods: {
    handleSelect (item) {
      this.$emit('indexSelect',item.id)
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
