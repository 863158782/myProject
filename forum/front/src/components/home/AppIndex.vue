<template>
  <div style="margin-top: 40px">
      <div class="home">
        <div id="header-div">
          <div style="height: 150px;margin-top: 100px;"></div>
          <carousel></carousel>
          <quick-nav style="float: right;margin-top: -380px;margin-right: 480px;z-index: 5px;"></quick-nav>
        </div>
      </div>
  </div>
</template>

<script>
import Carousel from './Carousel'
import QuickNav from './QuickNav'
export default {
  name: 'AppIndex',
  components: {Carousel, QuickNav}
}
</script>

<style scoped>
  .home {
    width: 990px;
    margin-left: auto;
    margin-right: auto;
    margin-top: -20px;
  }

  #header-div {
    padding-bottom: 20px;
    padding-left: 5px;
    background-color: white;
  }

  #side-menu {
    position: fixed;
    margin-left: 50%;
    left: -680px;
    top: 100px;
  }
</style>
