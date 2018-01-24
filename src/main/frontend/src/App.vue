<template>
<div class="app">
  <div class="header">
    <header-top></header-top>
    <header-bottom></header-bottom>
  </div>
  <div class="page">
    <router-view></router-view>
    <div class="help-text">
      <p>Vue.js 2 Single Page App (SPA) Example with vuex and vue-router.</p>
      <a href="https://github.com/skyronic/vue-spa">View Source Code</a>
    </div>
  </div>
</div>
</template>

<script>
// 헤더 import
import HeaderTop from '@/components/common/layout/HeaderTop'
import HeaderBottom from '@/components/common/layout/HeaderBottom'
export default {
  components: {
    HeaderTop,
    HeaderBottom
  },
  name: 'app'
}
</script>

<style>
body {
  font-family: "HelveticaNeue", "Helvetica Neue", Helvetica, Arial, sans-serif;
  color: #333;
}
.app {
  display: flex;
  flex-direction: column;
  width: 100%;
}
.header {
  border-bottom: 1px solid #b3b3b3;
  width: 100%;
  padding: 30px 50px;
}
.page {
  width: 100%;
  padding: 30px 50px;
}
.help-text {
  margin-top: 20px;
  font-size: 12px;
}
</style>
