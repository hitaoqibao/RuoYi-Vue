<template>
  <div class="test">
    <div style="position: absolute;top: '84px';right: 0;left: 0;bottom: 0;">
      <canvas
        :height="height"
        :width="width"
        id="canvas-fluid"
        style="display: block"
      />
    </div>
  </div>
</template>

<script>
import { debounce } from "@/utils";
//流体动画
export default {
  name: "fluid",

  data() {
    return {
      sign: true,
      width: 100,
      height: 100
    };
  },

  methods: {
    $_initResizeEvent() {
      this.resizeObserver = new ResizeObserver(() => this.$_resizeHandler());
      this.resizeObserver.observe(this.parentDom);
    },
    $_destroyResizeEvent() {
      if (this.resizeObserver) {
        this.resizeObserver.disconnect();
        this.resizeObserver = null;
      }
    },
    start() {
      import("@/plugins/webgl/fluid").then(_ =>
        _.default(this.$el.querySelector("#canvas-fluid"))
      );
    },
    close() {
      window.location.reload();
    }
  },

  mounted() {
    this.parentDom = document.querySelector(".test");
    this.width = this.parentDom.clientWidth;
    this.height = this.parentDom.clientHeight;
    this.$_resizeHandler = debounce(() => {
      this.width = this.parentDom.clientWidth;
      this.height = this.parentDom.clientHeight;
    });

    this.$_initResizeEvent();
    this.$nextTick(() => this.start());
  },

  beforeDestroy() {
    this.$_destroyResizeEvent();
    // this.close();
  }
};
</script>

<style scoped>
.test {
  min-height: calc(100vh - 84px);
  width: 100%;
  position: relative;
  overflow: hidden;
}
</style>
