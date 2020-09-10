<template>
  <div class="app-container">
    <el-divider content-position="left">
      基于
      <a class="link-type" href="https://github.com/FranckFreiburger/vue-pdf">vue-pdf</a>展示和打印
    </el-divider>
    <el-row :gutter="15">
      <el-col :span="7">
        <el-card>
          <span slot="header">部分操作</span>
          <el-form label-width="70px">
            <el-form-item label="文件名">
              <el-select v-model="value" placeholder="请选择文件名" @change="changeValue()" size="small">
                <el-option v-for="i in lists" :key="i.value" :label="i.value" :value="i.value"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="预览效果">
              <el-switch v-model="show"></el-switch>
            </el-form-item>
            <el-form-item label="预览方向">
              <el-button
                type="info"
                icon="el-icon-refresh-right"
                size="small"
                @click="rotate += 90"
                circle
              ></el-button>
              <el-button
                type="info"
                icon="el-icon-refresh-left"
                size="small"
                @click="rotate -= 90"
                circle
              ></el-button>
            </el-form-item>
            <el-form-item>
              <el-button
                type="primary"
                @click="$refs.pdf.print()"
                size="small"
                icon="el-icon-edit"
              >打印</el-button>
            </el-form-item>
          </el-form>
        </el-card>
      </el-col>
      <el-col :span="17">
        <el-card>
          <span slot="header">实时预览</span>
          <div>
            <div style="text-align:center;margin-bottom:5px">
              <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page.sync="page"
                layout="total,prev, pager, next, jumper"
                :page-size="1"
                :total="numPages"
                background
              ></el-pagination>
            </div>
            <div
              v-if="loadedRatio > 0 && loadedRatio < 1"
              style="background-color: green; color: white; text-align: center"
              :style="{ width: loadedRatio * 100 + '%' }"
            >{{ Math.floor(loadedRatio * 100) }}%</div>
            <pdf
              v-if="show"
              ref="pdf"
              style="border: 1px solid red"
              :src="src"
              :page="page"
              :rotate="rotate"
              @password="password"
              @progress="loadedRatio = $event"
              @error="error"
              @num-pages="numPages = $event"
              @link-clicked="page = $event"
            ></pdf>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>
<script>
import pdf from "vue-pdf";
//pdf预览
export default {
  components: {
    pdf: pdf,
  },
  data() {
    return {
      lists: [
        {
          value: "三体",
        },
        {
          value: "阿里巴巴Java开发",
        },
      ],
      value: "三体",
      show: true,
      src: "",
      loadedRatio: 0,
      //当前页
      page: 1,
      //总页数
      numPages: 0,
      //旋转角度
      rotate: 0,
    };
  },
  created() {
    this.getSrc();
  },
  methods: {
    //从后端获取资源
    getSrc() {
      this.src =
        process.env.VUE_APP_BASE_API + "/pdf/openpdf?value=" + this.value;
    },
    //改变资源
    changeValue() {
      this.getSrc();
    },
    password: function (updatePassword, reason) {
      updatePassword(prompt('password is "test"'));
    },
    error: function (err) {
      console.log(err);
    },
    // 当前页
    handleCurrentChange(val) {
      this.currentPage = val;
    },
  },
};
</script>

<style scoped></style>
