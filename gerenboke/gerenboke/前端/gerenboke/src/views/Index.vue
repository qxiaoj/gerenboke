<template>
  <div>
    <NavMenu />
    <Footer />
  </div>
</template>

<script>
import NavMenu from "@/components/NavMenu.vue";
import Footer from "@/components/Footer.vue";

export default {
  name: "Index",
  components: {
    NavMenu,
    Footer
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