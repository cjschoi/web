<template>
  <div id="trading">
      <button type="button" class="btn btn-primary" autocomplate="off" data-loading-text="jquery with bootstrap" @click="clickBtn">jQuery테스트</button>

      <!-- 차트 -->
      <div id="chart">
        <b>차트</b>
      </div>
      <br/>
      <!-- 호가창 -->
      <div id="order-book">
        <b호가창</b>
      </div>
      <br>
      <!-- 매수매도주문 order -->
      <div id="order-input">
        <b>매수매도주문</b>
      </div>
      <br>
      <!-- 체결정보 -->
      <div id="che-status">
        <b>체결정보</b>
        <table>
          <thead>
          <tr>
            <td>체결시간</td>
            <td>매수/매도</td>
            <td>체결가격</td>
            <td>체결량</td>
            <td>체결금액</td>
          </tr>
          </thead>
          <tbody>
          <tr v-for="marketData in marketHistory">
            <td>{{marketData.candleDateTime}}</td>
            <td>{{marketData.candleAccTradePrice}}</td>
            <td>{{marketData.candleAccTradeVolume}}</td>
            <td></td>
            <td></td>
          </tr>
          </tbody>
        </table>
      </div>
      <br>
      <!-- 주문정보 -->
      <div id="corder-input">
        <b>주문정보</b>
      </div>
      <br>
      <!-- 코인시세 -->
      <div id="global-currency">
        <b>코인시세</b>
      </div>
  </div>
</template>

<script>
  import { mapActions, mapGetters } from 'vuex'
  export default {
    created() {
      setInterval(() => {
        this.getMarketHistory();
      }, 3 * 1000);
    },
    computed: {
      ...mapGetters([
        'marketHistory'
      ])
    },
    methods: {
      ...mapActions([
        'getMarketHistory',
        'getCoinImage',
        'getCoins'
      ]),
      clickBtn (event) {
        $(event.target).button('loading')

        setTimeout(function() {
          $(event.target).button('reset')
        }, 1000);
      }
    }
  }

</script>

