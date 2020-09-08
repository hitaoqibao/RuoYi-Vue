import request from '@/utils/request'

//获取信息表所有数据
export function allinfo() {
  return request({
    url: '/info/allinfo',
    method: 'get'
  })
}

//导出excel表格
export function exportExcel(filename) {
  return request({
    url: '/info/export',
    method: 'get',
    params: {
      filename
    }
  })
}

// 下载导入模板
export function importTemplate() {
  return request({
    url: '/info/importTemplate',
    method: 'get'
  })
}
