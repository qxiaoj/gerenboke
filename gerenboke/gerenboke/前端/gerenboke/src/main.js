import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins/element.js'
import './axios.js'

Vue.config.productionTip = false
Vue.prototype.$ajax = axios 
// 设置全局的baseURL
axios.defaults.baseURL = 'http://localhost:8080'
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
