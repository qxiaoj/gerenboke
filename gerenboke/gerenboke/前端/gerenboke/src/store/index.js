import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

/**
 * 存储token，我们用的是localStorage，存储用户信息，我们用的是sessionStorage。毕竟用户信息我们不需要长久保存，保存了token信息，我们随时都可以初始化用户信息。
 */
export default new Vuex.Store({
  state: {
    token: '',  // 我们这里token使用本地存储
    userInfo: JSON.parse(sessionStorage.getItem("userInfo")) // 获取的用户数据，使用sessionStorage来，时间较短，如果过期了，就重新登录获取一下
  },
  getters: {
    getUser: state => {
      return state.userInfo
    }
  },
  mutations: {
    // 设置token值
    SET_TOKEN: (state, token) => {
      state.token = token
      localStorage.setItem("token", token)
    },
    // 设置用户信息值
    SET_USERINFO: (state, userInfo) => {
      state.userInfo = userInfo
      sessionStorage.setItem("userInfo", JSON.stringify(userInfo))
    },
    // 移除信息
    REMOVE_INFO: (state) => {
      localStorage.setItem("token", '')
      sessionStorage.setItem("userInfo", JSON.stringify(''))
      state.userInfo = {}
    }
  },
  actions: {
  },
  modules: {
  }
})
