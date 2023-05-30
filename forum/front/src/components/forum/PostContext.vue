<template style="background-color:red;" >
    <div style="width: 100%;height: 100vh;">
        <el-button size="mini" style="position: fixed;top: 80px;left: 50px;" @click="go_context" round>返回</el-button>
        <div style="width: 60%;margin-left:20% ;">
            
            <div style="margin-top: 70px;text-align: center;">
                <h1 style="text-align: center;">{{ title }}</h1>
                <span>作者：<b>{{ author }}</b></span>
                &nbsp;&nbsp;<span>发布时间：<b>{{ date }}</b></span>
                &nbsp;&nbsp;<span>阅读量：<b>{{ visited }}</b></span>
            </div>
        <div style="padding: 15px;" v-highlight v-html="context"></div>
        <div style="background-color: #f0f9eb;text-align: center;font-size: 12px;">END</div>
            
    </div>
        
        <!-- 评论 -->
        <div style="width: 60%;margin-left: 20%;height: 80%;  ">
            <Comment :comments="comments" 
                :id="id"
                :author="author"
            ></Comment>
        </div>
    </div>
  </template>
  
  <script>
  import {marked} from "marked"
  import Comment from '../forum/Comment.vue'
  export default {
    name: 'PostContext',
    components:{Comment},
    data(){
        return{
            id:0,
            title:"",
            context:"",
            author:"",
            date:"",
            visited:0
            
        }
    },
    created(){
        this.id=this.$route.query.id
        this.title=this.$route.query.title
        this.author=this.$route.query.author
        this.date=this.$route.query.date
        this.visited=this.$route.query.visited
        this.author=this.$route.query.author
        var _this=this
        this.$axios.get("findPost/"+this.id).then(res =>{
            if(res.data.code===200){
                _this.context=marked.parse(res.data.data.context)
                _this.context=marked(this.context)
            }
        })
    },
    methods:{
        go_context(){
            this.$router.push("/posts");
        }
    }
  }
  </script>

<style>
    *{
        /* padding: 15px; */
        text-align: left;
    }
    pre{
        padding: 18px;
        background-color: #f6f8fa;
    }
</style>