import Vue from 'vue'
import Router from 'vue-router'
import CartPage from '@/pages/CartPage'
import HomePage from '@/pages/HomePage'
import ProductPage from '@/pages/ProductPage'

// 코인스탁 페이지 import
import TradingPage from '@/pages/TradingPage'
import StatementPage from '@/pages/StatementPage'
import InvestmentPage from '@/pages/InvestmentPage'
import CscenterPage from '@/pages/CscenterPage'
import Mypage from '@/pages/Mypage'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomePage
    },
    {
      path: '/cart',
      name: 'cart',
      component: CartPage
    },
    {
      path: '/product/:id',
      name: 'product',
      component: ProductPage
    },
    { // 트레이딩
      path: '/trading',
      name: 'trading',
      component: TradingPage
    },
    { // 입출금
      path: '/statement',
      name: 'statement',
      component: StatementPage
    },
    { // 투자내역
      path: '/investment',
      name: 'investment',
      component: InvestmentPage
    },
    { // 고객센터
      path: '/cscenter',
      name: 'cscenter',
      component: CscenterPage
    },
    { // 마이페이지
      path: '/mypage',
      name: 'mypage',
      component: Mypage
    }
  ]
})
