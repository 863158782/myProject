<template>
    
    <div class="quick-nav" style="width: 800px;position: absolute;right: -20px;top: 530px;z-index: 1;">
      <h1 style="position: absolute;right: 650px;top: 90px;">采用技术</h1>
      <img style="position: absolute;right:290px;" src="../../assets/img/icon/icon2.png"  alt="" class="monster">
      <img src="../../assets/img/icon/icon7.png" alt="" class="spark">
      <img src="../../assets/img/icon/logo.png" alt="" class="logo">
    </div>
</template>

<script>
export default {
  name: 'QuickNav'
}
</script>

<style scoped>
  .quick-nav {
    width: 303px;
    height: 318px;
    background-color: transparent;
  }

  .monster {
    width: 280px;
    height: 260px;
    /*position: absolute;*/
    /*top: 150px;*/
    /*left: 700px;*/
  }

  .readme {
    width: 300px;
    height: 285px;
    position: absolute;
    margin-left: 50%;
    top: 300px;
    left: 230px;
  }

  .spark {
    position: absolute;
    margin-left: 50%;
    top: 100px;
    left: 20px;
  }

  .logo {
    width: 280px;
    position: absolute;
    margin-left: 50%;
    top: 50px;
    left: 210px;
  }

</style>
