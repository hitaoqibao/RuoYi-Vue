<template>
  <div class="app-container">
    <div class="real-container">
      <div>
        <FilenameOption v-model="filename" />
        <el-button
          :loading="downloadLoading"
          style="margin:0 0 20px 20px;"
          type="primary"
          icon="el-icon-download"
          @click="handleDownload"
          size="medium"
          >后端导出 Excel</el-button
        >
      </div>

      <el-table :data="list" border fit highlight-current-row>
        <el-table-column align="center" label="序号" width="95">
          <template slot-scope="scope">{{ scope.row.id }}</template>
        </el-table-column>
        <el-table-column label="作品">
          <template slot-scope="scope">{{ scope.row.title }}</template>
        </el-table-column>
        <el-table-column label="作者" width="110" align="center">
          <template slot-scope="scope">
            <el-tag>{{ scope.row.author }}</el-tag>
          </template>
        </el-table-column>
        <el-table-column label="阅读数" width="115" align="center">
          <template slot-scope="scope">{{ scope.row.readings }}</template>
        </el-table-column>
        <el-table-column align="center" label="时间" width="220">
          <template slot-scope="scope">
            <i class="el-icon-time" />
            <span>{{ scope.row.date }}</span>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
import { parseTime } from "@/utils/ruoyi";
import FilenameOption from "./components/FilenameOption";
import { allinfo, exportExcel } from "@/api/excel/info";
//后端导出excel
export default {
  name: "EndExportExcel",
  components: { FilenameOption },
  data() {
    return {
      list: null,
      downloadLoading: false,
      filename: "" //文件名
    };
  },
  created() {
    this.getlist();
  },
  methods: {
    //获取表格数据
    getlist() {
      this.listloading = true;
      allinfo()
        .then(response => {
          this.list = response.data.list;
          this.listloading = false;
        })
        .catch(error => {
          console.log(error);
        });
    },
    //导出Excel
    handleDownload() {
      this.downloadLoading = true;
      exportExcel(this.filename)
        .then(response => {
          this.download(response.msg);
          this.downloadLoading = false;
        })
        .catch(error => {
          console.log(error);
        });
    },
    //时间格式化
    formatJson(filterVal, jsonData) {
      return jsonData.map(v =>
        filterVal.map(j => {
          if (j === "date") {
            return parseTime(v[j]);
          } else {
            return v[j];
          }
        })
      );
    }
  }
};
</script>

<style>
.radio-label {
  font-size: 14px;
  color: #606266;
  line-height: 40px;
  padding: 0 12px 0 30px;
}
</style>
