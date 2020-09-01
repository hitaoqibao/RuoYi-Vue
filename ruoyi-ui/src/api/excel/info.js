import request from '@/utils/request'

//获取信息表所有数据
export function allinfo() {
  return request({
    url: '/info/allinfo',
  })
}
