<template>
    <div style="width: 80%;margin-left: 10%;margin-top: 50px;">
    <el-card class="el-card-d" shadow="always">
             <div class="infinite-list-wrapper" style="overflow:auto;">
                <el-timeline
                  infinite-scroll-disabled="disabled">
                <div v-if="allmessages.length>0"> 
                  <el-timeline-item v-for="(item,index) in allmessages"  :key="index"  placement="top" style="position: relative;">
                    <el-card class="el-card-m" style="height:120px;text-align: left;">
                      <h4 >{{item.username}}：</h4>
                      <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{item.text}}</p>
                      <span style="color: black;font-size: 8px;position: absolute;right: 5px;bottom: 5px;">{{ item.datetime }}</span>
                    </el-card>
                  </el-timeline-item>
                </div>
                <div v-else>
                   <el-timeline-item placement="top">
                    <el-card class="el-card-m" style="height:120px">
                      <h4>admin：</h4>
                      <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 说点什么吧😁</p>
                    </el-card>
                  </el-timeline-item>
                </div>
              </el-timeline> 
              </div>
              <div class="el-card-messages" style="position: relative;">
                <VEmojiPicker style="position: absolute;bottom: 200px;" v-show="showDialog" @select="selectEmoji"
                
                />
                <button id="e" @click="change" style="border-style: none;background-color: white;position: absolute;left: 0px;bottom: 160px;font-size: 20px;">🙂</button>
                 <el-input type="textarea" :rows="5" placeholder="输入留言" maxlength="200" v-model="message"></el-input>
                 <el-button type="info" round class="submit-message" @click="submitMessage">留言</el-button>
              </div>
            </el-card>

    </div>
</template>

<script>
import dayjs from "dayjs";
import {VEmojiPicker} from 'v-emoji-picker'
export default {
  name: 'MessageBoard',
  components:{VEmojiPicker},
  data() {
    return {
        message:'',
        showDialog:false,
        emoji:'',
        allmessages:[
          // {
          //   username:"lwz",
          //   text:'hello',
          //   datetime:'2022-5-5 22:22:22'
          // }
        ],
    };
  },
  created(){
    var _this=this
      this.$axios.get('/getAllBoard').then(res =>{
              if(res.data.code==200){
                _this.allmessages=res.data.data
              }
          })
  },
  methods: {
    submitMessage(){
          if(this.message=='' || this.message.replace(/(^\s*)|(\s*$)/g, "")==""){
              this.$message('写点啥都行😉');
              return;
          }
          var _this=this
          
          //  这里往下写调用后端的代码；
          var comment={
            username:_this.$store.state.user.username ,
            text:_this.message,
            datetime:dayjs().format('YYYY-MM-DD HH:mm')
          }
          this.$axios.post('/insertBoard',comment).then(res =>{
            if(res.data.code==200){

              this.allmessages.push(comment);
              this.message='';
                // 清空内容
                self.newComment = "";
                self.$message({
                    type:'success',
                    message:'留言成功！'
                })
            }
        })
     },
     selectEmoji(emoji){
      this.message=this.message+emoji.data;
      this.change();
     },
     change(){
      this.showDialog=!this.showDialog
     }

  }
}
</script>
<style>

.infinite-list-wrapper{
      width: 100%;
      height: 500px;
    }
    .submit-message{
        width: 100%; 
        background: rgb(235, 245, 247);
        color: cadetblue;
        letter-spacing:20px;
    }
 @media screen and (max-width: 3000px) and (min-width: 767px) {
    .el-card-d{
      float: left;
      margin-top: 20px;
      margin-left: 10%; 
      width: 80%;
      height: 90%;
    }

   }
  /*
  屏幕小于768px的
  */
  @media screen and (max-width:768px) and (min-width: 100px){  
     .el-card-d{

      width: 100%;
      height: 100%;
    }
  }
  #e{
    display: inline-block;
  }
  #e:hover{
    cursor: pointer;
  }
</style>