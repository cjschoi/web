<template>
  <div id="trading">
      <!-- 차트 -->
      <div id="chart">
        차트
      </div>
      <br/>
      <!-- 호가창 -->
      <div id="order-book">
        호가창
      </div>
      <br>
      <!-- 매수매도주문 order -->
      <div id="order-input">
        매수매도주문
      </div>
      <br>
      <!-- 체결정보 -->
      <div id="che-status">
        체결정보
      </div>
      <br>
      <!-- 주문정보 -->
      <div id="corder-input">
        주문정보
      </div>
      <br>
      <!-- 코인시세 -->
      <div id="global-currency">
        코인시세
      </div>
  </div>
</template>

<script>
  import { mapActions, mapGetters } from 'vuex'
  export default {
    mounted () {
      this.getAllProducts()
    },
    computed: {
      ...mapGetters([
        'allProducts'
      ]),
      product () {
        let id = parseInt(this.$route.params.id)
        return this.allProducts.find((p) => p.id === id) || {}
      }
    },
    methods: {
      ...mapActions([
        'getAllProducts',
        'addToCart'
      ])
    }
  }
</script>

<style>
.product-item {
  margin: 10px 10px;
  width: 500px;
  height: 400px;
  border-bottom: 1px solid #aaa;
}

.back-link {
  font-size: 20px;
}

.product-title {
  padding-top: 120px;
  text-align: center;
  margin: 0 auto;
  font-size: 26px;
}

.product-details {
  margin-top: 120px;
}

.inventory {
  float: left;
  font-size: 20px;
  margin-top: 15px;
}
.add-button {
  float: right;
  width: 140px;
  height: 50px;
}
</style>
