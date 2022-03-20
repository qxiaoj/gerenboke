import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins/element.js'
import axios from '../node_modules/axios/dist/axios.js'

Vue.config.productionTip = false

// 设置全局的baseURL
axios.defaults.baseURL = 'http://127.0.0.1:8999/gerenboke/'
Vue.prototype.$http = axios

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
