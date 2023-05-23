<template>
  <el-container>
    <el-aside style="width: 200px;margin-top: 20px">
      <switch></switch>
      <SideMenu @indexSelect="listByCategory" ref="sideMenu"></SideMenu>
    </el-aside>
    <el-main>
      <Context class="posts-area" ref="ContextArea"></Context>
    </el-main>
  </el-container>
</template>

<script>
import SideMenu from './SideMenu'
import Context from './Context'

export default {
  name: 'AppLibrary',
  components: {Context, SideMenu},
  methods: {
    listByCategory () {
      var _this = this
      var pid = this.$refs.sideMenu.pid
      var url = '/api' + '/findPosts?pid='+pid 
      this.$axios.get(url).then(resp => {
        if (resp.data.code === 200) {
          _this.$refs.ContextArea.posts = resp.data
        }
      })
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
