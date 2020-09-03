<template>
  <div class="app-container">
    <search-form labelWidth="90px">
      <search-form-item label="输入框">
        <el-input v-model="input" style="width: 200px;" placeholder="请输入内容"></el-input>
      </search-form-item>
      <search-form-item label="基础单选">
        <el-select v-model="value" style="width: 200px;" placeholder="请选择">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          ></el-option>
        </el-select>
      </search-form-item>
      <search-form-item label="基础多选">
        <el-select v-model="value1" style="width: 200px;" multiple placeholder="请选择">
          <el-option
            v-for="item in options1"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          ></el-option>
        </el-select>
      </search-form-item>
      <search-form-item label="日期选择">
        <el-date-picker v-model="value2" type="date" style="width: 200px;" placeholder="选择日期"></el-date-picker>
      </search-form-item>
      <search-form-item label="测试">
        <el-input v-model="input" style="width: 200px;" placeholder="请输入内容"></el-input>
      </search-form-item>
      <search-form-item label="测试">
        <el-input v-model="input" style="width: 200px;" placeholder="请输入内容"></el-input>
      </search-form-item>
      <search-form-item label="测试">
        <el-input v-model="input" style="width: 200px;" placeholder="请输入内容"></el-input>
      </search-form-item>
    </search-form>
    <el-divider content-position="left">使用说明</el-divider>
    <div>
      <span>
        引入：
        <el-tag type="info">@/components/SearchForm</el-tag>
      </span>
      <span style="margin-left:20px">
        <el-tag type="info">@/components/SearchFormItem</el-tag>
      </span>
    </div>
    <div style="margin-top:20px">
      <el-table :data="info">
        <el-table-column label="参数" prop="parameter"></el-table-column>
        <el-table-column label="说明" prop="explain"></el-table-column>
        <el-table-column label="类型" prop="type"></el-table-column>
        <el-table-column label="默认" prop="default"></el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
import SearchForm from "@/components/SearchForm";
import SearchFormItem from "@/components/SearchForm/item";
export default {
  name: "FormControl",
  components: { SearchForm, SearchFormItem },
  data() {
    return {
      input: "",
      options: [
        {
          value: "选项1",
          label: "黄金糕",
        },
        {
          value: "选项2",
          label: "双皮奶",
        },
        {
          value: "选项3",
          label: "蚵仔煎",
        },
        {
          value: "选项4",
          label: "龙须面",
        },
        {
          value: "选项5",
          label: "北京烤鸭",
        },
      ],
      value: "",
      options1: [
        {
          value: "选项1",
          label: "黄金糕",
        },
        {
          value: "选项2",
          label: "双皮奶",
        },
        {
          value: "选项3",
          label: "蚵仔煎",
        },
        {
          value: "选项4",
          label: "龙须面",
        },
        {
          value: "选项5",
          label: "北京烤鸭",
        },
      ],
      value1: [],
      value2: "",
      info: [
        {
          parameter: "label-width",
          explain: "等同于el-form的label-width",
          type: "	string",
          default: "120px",
        },
        {
          parameter: "xs",
          explain: "父元素内宽<768px时，每行渲染多少空间",
          type: "number",
          default: "1",
        },
        {
          parameter: "sm",
          explain: ">=768px",
          type: "number",
          default: "2",
        },
        {
          parameter: "md",
          explain: ">=998px",
          type: "number",
          default: "3",
        },
        {
          parameter: "lg",
          explain: ">=1200px",
          type: "number",
          default: "4",
        },
      ],
    };
  },
};
</script>

<style></style>
