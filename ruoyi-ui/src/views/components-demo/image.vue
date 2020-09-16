<template>
  <div class="app-container">
    <image-effect :url="require('@/assets/image/carousel-image/image1.jpg')"></image-effect>
    <el-divider content-position="left">
      基于
      <a class="link-type" href="https://element.faas.ele.me/#/zh-CN/component/image">el-image</a>
      图片查看
    </el-divider>
    <el-row :gutter="20">
      <el-col :span="8">
        <el-card :body-style="{ padding: '0px' }">
          <el-image :src="url1" :preview-src-list="list1"></el-image>
        </el-card>
      </el-col>
      <el-col :span="8">
        <el-card :body-style="{ padding: '0px' }">
          <el-image :src="url2" :preview-src-list="list2"></el-image>
        </el-card>
      </el-col>
      <el-col :span="8">
        <el-card :body-style="{ padding: '0px' }">
          <el-image :src="url3" :preview-src-list="list3"></el-image>
        </el-card>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="8">
        <el-card :body-style="{ padding: '0px' }">
          <el-image :src="url4" :preview-src-list="list4"></el-image>
        </el-card>
      </el-col>
      <el-col :span="8">
        <el-card :body-style="{ padding: '0px' }">
          <el-image :src="url5" :preview-src-list="list5"></el-image>
        </el-card>
      </el-col>
      <el-col :span="8">
        <el-card :body-style="{ padding: '0px' }">
          <el-image :src="url6" :preview-src-list="list6"></el-image>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import ImageEffect from "@/components/ImageEffect";
export default {
  components: {
    ImageEffect,
  },
  data() {
    return {
      url1: require("@/assets/image/carousel-image/image1.jpg"),
      url2: require("@/assets/image/carousel-image/image2.jpg"),
      url3: require("@/assets/image/carousel-image/image3.jpg"),
      url4: require("@/assets/image/carousel-image/image4.jpg"),
      url5: require("@/assets/image/carousel-image/image5.jpg"),
      url6: require("@/assets/image/carousel-image/image6.jpg"),
      list1: [require("@/assets/image/carousel-image/image1.jpg")],
      list2: [require("@/assets/image/carousel-image/image2.jpg")],
      list3: [require("@/assets/image/carousel-image/image3.jpg")],
      list4: [require("@/assets/image/carousel-image/image4.jpg")],
      list5: [require("@/assets/image/carousel-image/image5.jpg")],
      list6: [require("@/assets/image/carousel-image/image6.jpg")],
    };
  },
};
</script>

<style scoped>
.el-row {
  margin-bottom: 20px;
}
</style>
