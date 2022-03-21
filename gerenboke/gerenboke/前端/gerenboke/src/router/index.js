import Vue from 'vue'
import VueRouter from 'vue-router'
import helloWorld from '@/components/HelloWorld.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'helloWorld',
    component: helloWorld
  }
]

const router = new VueRouter({
  routes
})

export default router
