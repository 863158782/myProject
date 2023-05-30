<template>
  <div style="margin-bottom: 30px;display: flex;justify-content: center;align-items: center">
    <el-input
      @keyup.enter.native="searchClick"
      placeholder="通过贴标题或作者搜索..."
      prefix-icon="el-icon-search"
      size="small"
      style="width: 400px;margin-right: 10px"
      v-model="keywords">
    </el-input>
    <el-button size="small" type="primary" icon="el-icon-search" @click="searchClick">搜索</el-button>
  </div>
</template>

<script>
export default {
  name: 'SearchBar',
  props:{

        pageSon:{
          type:Object
        }
      },
  data () {
    return {
      keywords: '',
      
    }
  },
  methods: {
    searchClick () {
      var _this = this
      this.$axios.get('/page?current='+this.pageSon.currentPage+"&size="+this.pageSon.pagesize+"&pid=0&name="+this.keywords).then(resp => {
        if (resp.data.code === 200) {
          _this.$message({
            type:'success',
            message:"共计"+resp.data.data.total+"条"
          })
          _this.$emit('searchResult',resp.data.data.records,resp.data.data.total,_this.keywords)
        }
      })
      
    }
  }
}
</script>

<style scoped>

</style>
