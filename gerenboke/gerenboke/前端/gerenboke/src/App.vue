<template>
  <div id="app">
    <NavMenu/>
    <Footer/>
  </div>
</template>

<script>
import NavMenu from '@/components/NavMenu.vue'
import Footer from '@/components/Footer.vue'

export default {
  name: 'app',
  components: {
    NavMenu,
    Footer
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
