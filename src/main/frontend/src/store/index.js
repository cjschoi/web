import Vuex from 'vuex'
import Vue from 'vue'
import cartStore from './cartStore'
import productsStore from './productsStore'

// 코인스탁 메뉴
import tradingStore from './tradingStore'

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    cartStore,
    productsStore,
    tradingStore
  }
})
