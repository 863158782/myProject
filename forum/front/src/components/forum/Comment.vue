<template>
    <div class="msg-all-contain">
      <div class="msg-board">
        <div class="msg-board-contain">
          <div class="msg-head" >
            <!-- <img v-if="userAvatar" :src="userAvatar" alt="" /> -->
            <img :src="myAvatar" alt="" />
            <button id="e" @click="change" style="width: 20px;height:20px;border-style: none;background-color: white;position: absolute;left: 20px;top: 80px;;font-size: 20px;">🙂</button>
            <VEmojiPicker style="position: absolute;z-index: 10;top: 120px;" v-show="showDialog" @select="selectEmoji"/>

            <textarea
            style="border-radius: 3%;border: skyblue solid 1px;"
              type="textarea"
              :class="inputStatusClass"
              placeholder="请输入内容..."
              ref="input"
              v-model="newComment"
              cols="60"
              rows="5"
            >
            </textarea>
            <button style="text-align: center;width: 80px;height: 80px;font-size: 20px;color: skyblue;" @click="submit">发表</button>
          </div>
          <div class="msg-content">
            <comments-child
              :comments="comments"
              :count="layerCount"
              :pid="id"
            ></comments-child>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import {VEmojiPicker} from 'v-emoji-picker'
  import CommentsChild from '../forum/CommentChild.vue';
  import dayjs from "dayjs";
  export default {
    name: "commentsMessage",
    props:{
        id:{
            type:Number
        },
        author:{
            type:String
        }
    },
    data() {
      return {
        // 评论列表
        comments: [],
        // 新评论
        newComment: "",
        // 用户头像
        userAvatar: "",
        // 非空判断
        hasNoConent: false,
        // 输入栏状态
        inputStatusClass: "",
        // 计数
        layerCount: 0,
        myAvatar:'',
        showDialog:false
      };
    },
    created() {
        this.myAvatar=this.$store.state.user.avatar
        console.log(this.$store.state.user.avatar)
       var  _this=this
        this.$axios.get('/getComments/'+this.id).then(
            res =>{
                if(res.data.code==200){
                    _this.comments=res.data.data
                    // console.log(_this.comments)
                }
                    
            }
        )

            
        

    },
    mounted() {
      this.initData();
    },
    components: {
      "comments-child": CommentsChild,
      VEmojiPicker
    },
    methods: {
      // 提交
      submit() {
        var self = this;
        // 提交信息非空验证
        if (!self.newComment || self.newComment === "") {
          self.hasNoConent = true;
          self.inputStatusClass = "no-content-warn";
          this.$message({
            showClose:true,
            type:'warning',
            message:'评论不能为空！'
          })
          return;
        }
        self.inputStatusClass = "";
  
        // 生成comment对象
        var comment = {
          // 父评论Id
          parentId: 0,
          // 评论内容
          text: self.newComment,
          // 发送者id
          senderName: self.$store.state.user.username,
          // 接收者id
          receiverName: this.author,
          // 发送时间
          postDate: dayjs().format("YYYY-MM-DD HH:mm"),
          // 发送者头像
          senderAvatar: self.myAvatar,
          likeNum: 0,
          postId:self.id
        };
        

        this.$axios.post('/addComment',comment).then(res =>{
            if(res.data.code==200){
                //追入评论
                self.comments.push(comment);
                // 清空评论内容
                self.newComment = "";
                self.$message({
                    type:'success',
                    message:'评论成功！'
                })
            }
        })
        
      },
      selectEmoji(emoji){
      this.newComment=this.newComment+emoji.data;
      this.change();
     },
     change(){
      this.showDialog=!this.showDialog
     }
    },
  };
  </script>
  
  <!-- Add "scoped" attribute to limit CSS to this component only -->
  <style scoped>
  /* 评论头像 */
  .msg-head img {
    width: 55px;
    height: 55px;
    border-radius: 50%;
    position: absolute;
    top: 22px;
    left: 13px;
  }
  .msg-all-contain {
    width: 100%;
    height: 100%;
    /* overflow-y: auto; */
  }
  
  .msg-board-contain {
    letter-spacing: 1px;
    padding: 0 10px;
  }
  
  /* 信息栏标题 */
  .msg-board-title {
    width: auto;
    text-align: center;
    font-size: 28px;
    font-weight: 300;
    margin: 0 0 1.8rem 0;
    min-height: 20px;
    color: #000 !important;
    font-family: "Lato", Verdana, sans-serif !important;
  }
  .msg-head {
    background-color: rgb(248, 248, 248);
    position: relative;
    height: 130px;
    border-radius: 5px;
  }
  
  /* 评论输入 */
  .msg-head textarea {
    position: absolute;
    top: 13px;
    left: 85px;
    max-height: 60px;
    border-radius: 5px;
    outline: none;
    width: calc(100% - 300px);
    font-size: 16px;
    padding: 20px;
    border: 2px solid #f8f8f8;
    resize: none;
  }
  /* 发布评论按钮 */
  .msg-head button {
    position: absolute;
    top: 13px;
    right: 35px;
    width: 100px;
    height: 100px;
    border: 0;
    border-radius: 5px;
    font-size: 18px;
    font-weight: 500;
    color: #fff !important;
    background-color: #00a1d6;
    transition: 0.1s;
    cursor: pointer;
    letter-spacing: 2px;
  }
  /* 鼠标经过字体加粗 */
  .msg-head button:hover {
    /*font-weight: 600;*/
  }
  
  .msg-content {
    overflow-y: auto;
  }
  
  /* 评论内容区域 */
  .msg-content .child-comment {
    display: flex;
    position: relative;
    padding: 18px 10px 18px 10px;
  }
  
  @media (max-width: 900px) {
    .msg-head img {
      width: 40px;
      height: 40px;
      border-radius: 50%;
      position: absolute;
      top: 22px;
      left: 13px;
    }
    .msg-head textarea {
      position: absolute;
      top: 13px;
      left: 70px;
      height: 55px;
      border-radius: 5px;
      outline: none;
      width: calc(100% - 200px);
      font-size: 15px;
      padding: 10px;
      border: 2px solid #f8f8f8;
      resize: none;
    }
    .msg-head button {
      position: absolute;
      top: 13px;
      right: 16px;
      width: 80px;
      height: 77px;
      border: 0;
      border-radius: 5px;
      font-size: 14px;
      font-weight: 500;
      color: #fff !important;
      background-color: #00a1d6;
      transition: 0.1s;
      cursor: pointer;
      letter-spacing: 2px;
    }
  }
  </style>
  
  
  