<template>
  <div class="app-container">
    <el-divider content-position="left">手写签名，竖屏横屏不可兼得</el-divider>
    <div style="border: 1px solid #C0C0C0">
      <img :src="src" style="width: 100%;height: 500px;object-fit: contain" />
    </div>
    <el-button plain @click="signature">点击签名</el-button>
  </div>
</template>

<script>
export default {
  name: "autograph",
  data() {
    return {
      src: null
    };
  },
  methods: {
    signature() {
      this.$signature({
        image: this.src,
        onConfirm: img => (this.src = img)
      });
    }
  }
};
</script>
