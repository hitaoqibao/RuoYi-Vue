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
    <el-divider content-position="left">翻页特效</el-divider>
    <div id="box" @click="turningPage">
      <div class="page">
        <div class="front"></div>
        <div class="back"></div>
      </div>
      <div class="page2"></div>
    </div>
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
      bReady: true,
      iNow: 0,
      oBox: "",
      oPage: "",
      oPage2: "",
      oFront: "",
      oBack: "",
    };
  },
  methods: {
    turningPage() {
      /* 我们先获取一下需要用到的页面中的元素 */

      /* 定义一个变量this.iNow，这儿里是方便后续页面拉回与换图操作 */
      // this.iNow = 0;
      /* 这里定义一个变量，当页面点击后赋值成false,防止“麒麟臂”大神无限点击翻页。
				判断当运动完成后赋值为true */
      // this.bReady = true;
      /* 给box加一个点击事件，进行翻页 */
      // this.oBox.onclick = function(){
      /* 我们判断下，如果上次运动没结束就不能再开启新的运动，防止“撞车” */
      if (this.bReady == false) return;
      this.bReady = false;
      /* 这里我们将this.iNow的值进行++，我因为我们翻页了，所有图自然的就会加1 */
      this.iNow++;
      /* 设置翻页的运动时间运动形式等参数 */
      this.oPage.style.transition = "1s all ease";
      /* 翻页操作 */
      this.oPage.style.WebkitTransform = "perspective(800px) rotateY(-180deg)";
      /* 这里说明一下“webkitTransitionEnd”为运动完成之后可触发的事件 */
      this.oPage.addEventListener(
        "webkitTransitionEnd",
        () => {
          /* 这里当运动完成后我们进行拉回操作，将page的运动时间等设置为none，
					   // 并将翻页角度改为原来的0° */
          this.oPage.style.transition = "none";
          this.oPage.style.WebkitTransform = "perspective(800px) rotateY(0deg)";
          /* 下面我就行换图操作 */
          /* box的图为this.iNow%3,为啥模3呢，因为我们有三张图，如果你有八张图就模8 */
          this.oBox.style.background = `url(${this.url1}) no-repeat`;
          this.oFront.style.background = `url(${this.url2})right top no-repeat`;
          /* 这里因为back和page2组合成同一张图，且他们比box和fron组合成的图永远多1，所以这里就是(this.iNow+1)%3 */
          this.oBack.style.background = `url(${this.url3}) no-repeat`;
          this.oPage2.style.background = `url(${this.url4})right top no-repeat`;
          this.bReady = true;
          /* 这里我们所有的运动都完成后就将this.bReady赋值 为true*/
        },
        false
      );
      // };
    },
  },

  mounted() {
    this.oBox = document.getElementById("box");
    this.oPage = document.querySelector(".page");
    this.oPage2 = document.querySelector(".page2");
    this.oFront = document.querySelector(".front");
    this.oBack = document.querySelector(".back");
  },
};
</script>

<style scoped>
.el-row {
  margin-bottom: 20px;
}
#box {
  background: url("../../assets/image/carousel-image/image1.jpg") no-repeat;
  width: 700px;
  height: 400px;
  margin: 50px auto;
  position: relative;
}

#box .page {
  width: 50%;
  height: 100%;
  top: 0;
  right: 0;
  position: absolute;
  transform-style: preserve-3d;
  transform-origin: left center;
  z-index: 2;
  transform: perspective(800px) rotateY(0deg);
}

.page .front {
  background: url("../../assets/image/carousel-image/image1.jpg") right top
    no-repeat;
  width: 100%;
  height: 100%;
  left: 0;
  top: 0;
  position: absolute;
  backface-visibility: hidden;
  z-index: 2;
}

.page .back {
  background: url("../../assets/image/carousel-image/image2.jpg") left top
    no-repeat;
  position: absolute;
  width: 100%;
  height: 100%;
  left: 0;
  top: 0;
  transform: scale(-1, 1);
  z-index: 1;
}

#box .page2 {
  width: 50%;
  height: 100%;
  top: 0;
  right: 0;
  position: absolute;
  background: url("../../assets/image/carousel-image/image2.jpg") right top
    no-repeat;
  z-index: 1;
}
</style>
