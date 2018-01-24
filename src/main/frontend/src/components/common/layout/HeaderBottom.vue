<template>
  <div class="menu-links">
    <router-link to="/">Home</router-link>
    <router-link to="/cart">Cart ({{ cartCount }})</router-link>
    <router-link to="/trading">트레이딩</router-link>
    <router-link to="/statement">입출금</router-link>
    <router-link to="/investment">투자내역</router-link>
    <router-link to="/cscenter">고객센터</router-link>
    <router-link to="/mypage">마이페이지</router-link>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  computed: {
    // mix the getters into the computed object
    ...mapGetters([
      'cartCount'

    ])
  }
}
</script>

<style>
.menu-links a {
  display: inline-block;
  text-decoration: none;
  color: #555;
  margin-right: 30px;
}
</style>
