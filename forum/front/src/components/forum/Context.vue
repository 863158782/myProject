<template>
  <div>
    <el-row style="height: 840px;">
      <search-bar @onSearch="searchResult" ref="searchBar"></search-bar>
      <el-tooltip effect="dark" placement="right"
                  v-for="item in posts.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                  :key="item.id">
        <!-- <p slot="content" style="font-size: 14px;margin-bottom: 6px;">{{item.title}}</p> -->
        <!-- <p slot="content" style="font-size: 13px;margin-bottom: 6px">
          <span>{{item.author}}</span> /
          <span>{{item.date}}</span> /
          <span>{{item.press}}</span>
        </p> -->
        <el-card style="width: 255px;margin-bottom: 20px;height: 240px;float: left;margin-right: 15px" class="book"
                 bodyStyle="padding:10px" shadow="hover">
          <div class="cover" @click="findPost(item)">
            <router-link style="position: absolute;z-index: 12" :to='{path:"/searchPost",query:{id:item.id,title:item.title,context:item.context,date:item.date,author:item.author,visited:item.visited,username:item.username}}'>
              <img :src="item.cover" alt="封面">
            </router-link>
              
           
          </div>
          <div class="info" style="position: relative;">
            <div class="title">
              <a style="font-size: 20px;color: black;" href="">{{item.title}}</a>
            </div>
            <span class="el-tag el-tag--success el-tag--mini el-tag--light" style="position: absolute;right: 5px;top: -180px;z-index: 20;">阅读量：{{ item.visited }}</span>
            <i style="width:30px;position: absolute;right: 20px;" class="el-icon-edit" @click="editPost(item)"></i>
            <i class="el-icon-delete" @click="deletePost(item.id)"></i>
          </div>
          <div style="font-size: 15px;" class="author">作者：{{item.username}}</div>
          
        </el-card>
      </el-tooltip>
      <edit-form @onSubmit="loadPosts()" ref="edit"></edit-form>
    </el-row>
    <el-row>
      <el-pagination
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-size="pagesize"
        :total="posts.length">
      </el-pagination>
    </el-row>
  </div>
</template>

<script>
import EditForm from './EditForm'
import SearchBar from './SearchBar'
import axios from 'axios'

export default {
  name: 'Context',
  components: {EditForm, SearchBar},
  data () {
    return {
      posts: [],
      currentPage: 1,
      pagesize: 17
    }
  },
  created(){
    this.loadPosts()
  },
  methods: {
    loadPosts () {
      var _this = this
      axios.get('/getPosts').then(resp => {
        if (resp.data.code === 200) {
          _this.posts = resp.data.data
        }
      })
    },
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage
      console.log(this.currentPage)
    },
    searchResult () {
      var _this = this
      this.$axios
        .get('/search?keywords=' + this.$refs.searchBar.keywords, {
        }).then(resp => {
          if (resp && resp.status === 200) {
            _this.books = resp.data
          }
        })
    },
    deletePost (id) {
      this.$confirm('此操作将永久删除该贴, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        axios
          .post('/delPost', {id: id}).then(resp => {
            if (resp && resp.status === 200) {
              this.loadPosts()
            }
          })
      }
      ).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    editPost (item) {
      this.$refs.edit.dialogFormVisible = true
      this.$refs.edit.form = {
        id:item.id,
        cover: item.cover,
        title: item.title,
        author: item.author,
        date: item.date,
        description: item.description,
        context: item.context,
        pid:item.pid
      }
    },
    findPost(item){
      
    }
  }
}
</script>
<style scoped>

.cover {
  width: 115px;
  height: 172px;
  margin-bottom: 7px;
  overflow: hidden;
  cursor: pointer;
}

img {
  width: 115px;
  height: 172px;
  /*margin: 0 auto;*/
}

.title {
  font-size: 14px;
  text-align: left;
}

.author {
  color: #333;
  width: 102px;
  font-size: 13px;
  margin-bottom: 6px;
  text-align: left;
}

.abstract {
  display: block;
  line-height: 17px;
}

.el-icon-delete {
  cursor: pointer;
  float: right;
}

.switch {
  display: flex;
  position: absolute;
  left: 780px;
  top: 25px;
}

a {
  text-decoration: none;
}

a:link, a:visited, a:focus {
  color: #3377aa;
}

</style>
