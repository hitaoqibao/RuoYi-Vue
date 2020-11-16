<template>
  <div id="app-container">
    <el-divider content-position="left">echarts图表随浏览器窗口变化</el-divider>
    <div id="echarts" :style="{ width: width, height: height }"></div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      myChart: "",
      height: "",
      width: ""
    };
  },
  created() {
    // 初始样式
    this.height = document.documentElement.clientHeight * 0.5 + "px";
    this.width = document.documentElement.clientWidth * 0.5 + "px";
  },
  mounted() {
    this.drawChart();
    // 随窗口变化
    window.onresize = () => {
      return (() => {
        this.height = document.documentElement.clientHeight * 0.5 + "px";
        this.width = document.documentElement.clientWidth * 0.5 + "px";
      })();
    };
    // 重绘echarts
    window.addEventListener("resize", () => {
      this.myChart.resize();
    });
  },

  methods: {
    drawChart() {
      // 指定图表的配置项和数据
      let option = {
        title: {
          text: "ECharts 入门示例"
        },
        tooltip: {},
        legend: {
          data: ["销量"]
        },
        xAxis: {
          data: ["衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子"]
        },
        yAxis: {},
        series: [
          {
            name: "销量",
            type: "bar",
            data: [5, 20, 36, 10, 10, 20]
          }
        ]
      };
      // 基于准备好的dom，初始化echarts实例
      this.myChart = this.$echarts.init(document.getElementById("echarts"));
      // 使用刚指定的配置项和数据显示图表。
      this.myChart.setOption(option);
    }
  }
};
</script>

<style scoped></style>
