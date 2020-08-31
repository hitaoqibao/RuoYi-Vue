import Vue from 'vue'

import Cookies from 'js-cookie'

import 'normalize.css/normalize.css' // 一个可以定制的CSS文件，它让不同的浏览器在渲染网页元素的时候形式更统一

import Element from 'element-ui'
import './assets/styles/element-variables.scss'

import '@/assets/styles/index.scss' // 全局css
import '@/assets/styles/ruoyi.scss' // ruoyi css
import App from './App'
import store from './store'
import router from './router'
import permission from './directive/permission'

import './assets/icons' // 图标
import './permission' // 权限控制
import {
  getDicts
} from "@/api/system/dict/data";
import {
  getConfigKey
} from "@/api/system/config";
import {
  parseTime,
  resetForm,
  addDateRange,
  selectDictLabel,
  selectDictLabels,
  download,
  handleTree
} from "@/utils/ruoyi";
import Pagination from "@/components/Pagination";
//自定义表格工具扩展
import RightToolbar from "@/components/RightToolbar"
import vRegion from 'v-region' //行政区划选择器

Vue.use(vRegion)

// 全局方法挂载
Vue.prototype.getDicts = getDicts
Vue.prototype.getConfigKey = getConfigKey
Vue.prototype.parseTime = parseTime
Vue.prototype.resetForm = resetForm
Vue.prototype.addDateRange = addDateRange
Vue.prototype.selectDictLabel = selectDictLabel
Vue.prototype.selectDictLabels = selectDictLabels
Vue.prototype.download = download
Vue.prototype.handleTree = handleTree

Vue.prototype.msgSuccess = function (msg) {
  this.$message({
    showClose: true,
    message: msg,
    type: "success"
  });
}

Vue.prototype.msgError = function (msg) {
  this.$message({
    showClose: true,
    message: msg,
    type: "error"
  });
}

Vue.prototype.msgInfo = function (msg) {
  this.$message.info(msg);
}

// 全局组件挂载
Vue.component('Pagination', Pagination)
Vue.component('RightToolbar', RightToolbar)

Vue.use(permission)

Vue.use(Element, {
  size: Cookies.get('size') || 'medium' // set element-ui default size
})

Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})
