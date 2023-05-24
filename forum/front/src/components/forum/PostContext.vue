<template>
    <div>
        <h1>{{ title }}</h1>
        <div>
            <span>作者：<b>{{ username }}</b></span>
            &nbsp;&nbsp;<span>发布时间：<b>{{ date }}</b></span>
            &nbsp;&nbsp;<span>阅读量：<b>{{ visited }}</b></span>
        </div>
        <div v-html="context"></div>
        <!-- <img :src=''  alt=""> -->
    </div>
  </template>
  
  <script>
  import {marked} from "marked"
  export default {
    name: 'PostContext',
    data(){
        return{
            id:0,
            title:"",
            context:"",
            author:"",
            date:"",
            username:"",
            visited:0
        }
    },
    created(){
        this.id=this.$route.query.id
        this.title=this.$route.query.title
        this.author=this.$route.query.author
        this.date=this.$route.query.date
        this.visited=this.$route.query.visited
        this.username=this.$route.query.username
        var _this=this
        this.$axios.get("findPost/"+this.id).then(res =>{
            if(res.data.code===200){
                _this.context=marked.parse(res.data.data.context)
            }
        })
    }
  }
  </script>