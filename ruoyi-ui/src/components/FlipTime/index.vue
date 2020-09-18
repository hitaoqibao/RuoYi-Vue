<template>
  <div class="clock-container">
    <flip-item v-show="show" :total="9" :current="timeArr[0]" />
    <flip-item v-show="show" :total="9" :current="timeArr[1]" />
    <flip-item v-show="show" :total="9" :current="timeArr[2]" />
    <flip-item v-show="show" :total="9" :current="timeArr[3]" />
    <div class="font" v-show="show">{{content[0]}}</div>
    <flip-item v-show="show" :total="1" :current="timeArr[4]" />
    <flip-item v-show="show" :total="9" :current="timeArr[5]" />
    <div class="font" v-show="show">{{content[1]}}</div>
    <flip-item v-show="show" :total="3" :current="timeArr[6]" />
    <flip-item v-show="show" :total="9" :current="timeArr[7]" />
    <div class="test" v-show="show">{{content[2]}}</div>

    <flip-item :total="2" :current="timeArr[8]" />
    <flip-item :total="9" :current="timeArr[9]" />
    <div class="colon"></div>
    <flip-item :total="5" :current="timeArr[10]" />
    <flip-item :total="9" :current="timeArr[11]" />
    <div class="colon"></div>
    <flip-item :total="5" :current="timeArr[12]" />
    <flip-item :total="9" :current="timeArr[13]" />
  </div>
</template>

<script>
import FlipItem from "./FlipItem";
import { getTimeArr } from "@/utils";
//翻页时间组件
export default {
  name: "FilpTime",
  components: {
    FlipItem,
  },
  props: {
    show: {
      type: Boolean,
      default: true,
    },
    content: {
      type: Array,
      default: () => ["年", "月", "日"],
    },
  },
  data() {
    return {
      timeArr: getTimeArr(),
    };
  },
  mounted() {
    this.startTimer();
  },
  beforeDestroy() {
    this.stopTimer();
  },
  methods: {
    startTimer() {
      this.stopTimer();
      this.timer = setTimeout(() => {
        this.timeArr = getTimeArr();
        this.startTimer();
      }, 1000);
    },
    stopTimer() {
      clearTimeout(this.timer);
    },
  },
};
</script>

<style lang='scss' scoped>
.clock-container {
  display: flex;
  align-items: center;
}
.colon {
  height: 25px;
  padding: 0 2px;
  display: flex;
  justify-content: space-around;
  flex-direction: column;
  &::after,
  &::before {
    content: "";
    display: block;
    width: 8px;
    height: 8px;
    background: rgba(0, 0, 0, 0.7);
    border-radius: 50%;
  }
}
.font {
  font-size: 40px;
}
.test {
  margin-right: 20px;
  font-size: 40px;
}
</style>