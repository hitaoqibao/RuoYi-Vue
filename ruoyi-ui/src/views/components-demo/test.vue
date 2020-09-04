<template>
  <div class="app-container">
    <el-divider content-position="left">
      基于
      <a
        class="link-type"
        href="https://element.faas.ele.me/#/zh-CN/component/carousel"
        >el-carousel</a
      >
      轮播图
    </el-divider>
    <el-carousel :interval="4000" type="card" height="300px">
      <el-carousel-item
        v-for="item in bigScreen.images"
        :key="item.name"
        :name="item.name"
      >
        <img style="width:100%;height:100%;" :src="item.url" />
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>
export default {
  data() {
    return {
      bigScreen: {
        images: [
          {
            name: "image1",
            url: require("@/assets/image/carousel-image/image1.jpg")
          },
          {
            name: "image2",
            url: require("@/assets/image/carousel-image/image2.jpg")
          },
          {
            name: "image3",
            url: require("@/assets/image/carousel-image/image3.jpg")
          },
          {
            name: "image4",
            url: require("@/assets/image/carousel-image/image4.jpg")
          },
          {
            name: "image5",
            url: require("@/assets/image/carousel-image/image5.jpg")
          },
          {
            name: "image6",
            url: require("@/assets/image/carousel-image/image6.jpg")
          }
        ]
      }
    };
  }
};
</script>

<style scoped></style>
