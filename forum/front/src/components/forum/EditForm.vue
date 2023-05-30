<template>
  <div>
    <i class="el-icon-circle-plus-outline"  @click="dialogFormVisible = true"></i>
    <el-dialog
    show-close
      title="添加/修改"
      :visible.sync="dialogFormVisible"
      @close="clear"
      fullscreen
      >
      <el-form v-model="form" style="text-align: left" ref="dataForm">
        <el-form-item label="标题" :label-width="formLabelWidth" prop="title">
          <el-input v-model="form.title" autocomplete="off" placeholder=""></el-input>
        </el-form-item>
        <el-form-item label="作者" :label-width="formLabelWidth" prop="author">
          <el-input readonly v-model="form.author" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="发布日期" :label-width="formLabelWidth" prop="date">
          <div class="block">
    <span class="demonstration"></span>
    <el-date-picker
      readonly
      value-format="yyyy-MM-dd HH:MM:SS"
      v-model="date"
      type="date"
      placeholder="选择日期">
    </el-date-picker>
  </div>
        </el-form-item>
        <el-form-item label="描述" :label-width="formLabelWidth" prop="description">
          <el-input v-model="form.description" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="封面" :label-width="formLabelWidth" prop="cover">
          <el-input v-model="form.cover" autocomplete="off" placeholder="图片 URL"></el-input>
        </el-form-item>
        <el-form-item label="内容"  :label-width="formLabelWidth" prop="context">
          <!-- <el-input type="textarea" v-model="form.context" :rows="10" autocomplete="off"></el-input> -->
          <mavon-editor
          :toolbars="toolbars"        
@imgAdd="handleEditorImgAdd"   
@imgDel="handleEditorImgDel"   
          v-model="form.context"
          ref=md
          />
        </el-form-item>
        <el-form-item label="板块" :label-width="formLabelWidth" prop="pid">
          <el-select v-model:value="form.pid" placeholder="请选择分类">
            <el-option label="python" value="1"></el-option>
            <el-option label="php" value="2"></el-option>
            <el-option label="vue" value="3"></el-option>
            <el-option label="java" value="4"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="onSubmit">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import 'github-markdown-css/github-markdown.css'
export default {
  name: 'EditForm',
  data () {
    return {
      dialogFormVisible: false,
      form: {
        id:"",
        title: '',
        author: '',
        date: '',
        description: '',
        cover: '',
        context: '',
        pid:"",
        visited:0
      },
      list:[],
      formLabelWidth: '120px',
      toolbars: {
    bold: true, // 粗体
    italic: true, // 斜体
    header: true, // 标题
    underline: true, // 下划线
    strikethrough: true, // 中划线
    mark: true, // 标记
    superscript: true, // 上角标
    subscript: true, // 下角标
    quote: true, // 引用
    ol: true, // 有序列表
    ul: true, // 无序列表
    link: true, // 链接
    imagelink: true, // 图片链接
    code: false, // code
    table: true, // 表格
    fullscreen: true, // 全屏编辑
    readmodel: true, // 沉浸式阅读
    htmlcode: true, // 展示html源码
    help: true, // 帮助
    /* 1.3.5 */
    undo: true, // 上一步
    redo: true, // 下一步
    trash: true, // 清空
    save: true, // 保存（触发events中的save事件）
    /* 1.4.2 */
    navigation: true, // 导航目录
    /* 2.1.8 */
    alignleft: true, // 左对齐
    aligncenter: true, // 居中
    alignright: true, // 右对齐
    /* 2.2.1 */
    subfield: true, // 单双栏模式
    preview: true, // 预览
  }
    }
  },
  created(){
    this.date=new Date();
    this.form.author=JSON.parse(window.localStorage.getItem('user' || '[]')).username
  },
  methods: {
    getMenu(){
      var _this=this
      axios.get('/Partition').then(res => {
          if(res.data.code==200){
              _this.list=res.data.data
              console.log(list);
          }
      })
    },
    clear () {
      this.form = {
        id: '',
        title: '',
        date: '',
        description: '',
        cover: '',
        context: '',
        pid: ''
      }
    },
    getDate(){
      var date = new Date();
      var sign2 = ":";
      var year = date.getFullYear() // 年
      var month = date.getMonth() + 1; // 月
      var day = date.getDate(); // 日
      var hour = date.getHours(); // 时
      var minutes = date.getMinutes(); // 分
      var seconds = date.getSeconds() //秒
      var weekArr = ['星期一', '星期二', '星期三', '星期四', '星期五', '星期六', '星期天'];
      var week = weekArr[date.getDay()];
      // 给一位数的数据前面加 “0”
      if (month >= 1 && month <= 9) {
        month = "0" + month;
      }
      if (day >= 0 && day <= 9) {
        day = "0" + day;
      }
      if (hour >= 0 && hour <= 9) {
        hour = "0" + hour;
      }
      if (minutes >= 0 && minutes <= 9) {
        minutes = "0" + minutes;
      }
      if (seconds >= 0 && seconds <= 9) {
        seconds = "0" + seconds;
      }
      return year + "-" + month + "-" + day + " " + hour + sign2 + minutes + sign2 + seconds;
    },
    onSubmit () {
      var _this=this
      this.$axios
        .post('/Posts', {
          id:this.form.id,
          cover: this.form.cover,
          title: this.form.title,
          author: this.form.author,
          date: this.getDate(),
          description: this.form.description,
          context: this.form.context,
          pid: this.form.pid
        }).then(resp => {
          if (resp.data.code === 200) {
            _this.dialogFormVisible = false
            _this.$router.go(0)
          }
        })
    },
    //上传图片接口pos 表示第几个图片 
  handleEditorImgAdd(pos , $file){
    var formdata = new FormData();
    formdata.append('file' , $file);
     this.$axios
    .post("http://localhost:8443/api/tengxun", formdata)
    .then(res => {
      if(res.data.code===200)
        var url = res.data.data;
       this.$refs.md.$img2Url(pos, url);  //这里就是引用ref = md 然后调用$img2Url方法即可替换地址
    });
  },
  handleEditorImgDel(){
    console.log('handleEditorImgDel');    //删除操作
  }

  }
}
</script>

<style scoped>
.el-icon-circle-plus-outline {
  margin: 50px 0 0 20px;
  font-size: 100px;
  float: left;
  cursor: pointer;
}
textarea{
  height: 300px;
}
</style>
