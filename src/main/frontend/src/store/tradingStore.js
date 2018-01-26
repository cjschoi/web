//import shop from '@/api/shop'
import axios from 'axios'

const state = {
  marketHistory: []
}

//const BITTREX_MARKETHISTORY_API_URI = "https://bittrex.com/api/v1.1/public/getmarkethistory?market=BTC-DOGE";
const BITTREX_MARKETHISTORY_API_URI = "https://crix-api-endpoint.upbit.com/v1/crix/candles/lines?code=CRIX.UPBIT.KRW-XRP";
const UPDATE_INTERVAL = 3 * 1000;

const actions = {
  getMarketHistory: function({commit}) {
    axios.get(BITTREX_MARKETHISTORY_API_URI)
    .then((resp) => {
      console.log(resp.data.candles);
      state.marketHistory = resp.data.candles;
    })
    .catch((err) => {
      console.error(err);
    });
  },
  getCoinImage: function() {
  },
  getCoins: function() {
  }
}

const mutations = {
}

const getters = {
  marketHistory(state) {
    return state.marketHistory
  }
}

export default {
  state,
  actions,
  mutations,
  getters
}
