<template>
  <el-container>
    <el-aside style="width: 200px;margin-top: 20px">
      <switch></switch>
      <SideMenu style="margin-top: 40px;" @indexSelect="listByCategory" ref="sideMenu"></SideMenu>
    </el-aside>
    <el-main>
      <Context style="margin-top: 50px;" :pid="pid"  class="posts-area" ref="ContextArea"></Context>
    </el-main>
  </el-container>
</template>

<script>
import SideMenu from './SideMenu'
import Context from './Context'

export default {
  name: 'Posts',
  components: {Context, SideMenu},
  data(){
    return{
      pid:0,
    }
  },
  methods: {
    listByCategory (pid) {
      // console.log(location)
      this.pid=pid
    }
  }
}
</script>

<style scoped>
.posts-area {
  width: 990px;
  margin-left: auto;
  margin-right: auto;
}
</style>
