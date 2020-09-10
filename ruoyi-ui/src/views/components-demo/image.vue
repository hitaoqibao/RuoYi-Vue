<template>
  <div class="app-container">
    <image-effect
      :url="require('@/assets/image/carousel-image/image1.jpg')"
    ></image-effect>
  </div>
</template>

<script>
import ImageEffect from "@/components/ImageEffect";
export default {
  components: {
    ImageEffect
  },
  data() {
    return {};
  }
};
</script>

<style></style>
