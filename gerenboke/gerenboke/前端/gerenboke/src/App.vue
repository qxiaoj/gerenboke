<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
import NavMenu from '@/components/NavMenu.vue'
import Footer from '@/components/Footer.vue'
import IndexBody from "@/views/index/IndexBody.vue";

export default {
  name: 'app',
  components: {
    NavMenu,
    Footer,
    IndexBody,
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

* {
  padding: 0;
  margin: 0;
}
</style>
