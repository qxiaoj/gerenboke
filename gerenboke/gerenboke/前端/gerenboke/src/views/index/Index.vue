<template>
  <div>
    <NavMenu />
    <IndexBody/>
    <Footer />
  </div>
</template>

<script>
import NavMenu from "@/components/NavMenu.vue";
import IndexBody from "@/views/index/IndexBody.vue";
import Footer from "@/components/Footer.vue";

export default {
  name: "index",
  components: {
    NavMenu,
    Footer,
    IndexBody
  },
  data() {
    return {};
  },

  mounted() {},

  methods: {}
};
</script>

<style lang="scss" scoped>
</style>