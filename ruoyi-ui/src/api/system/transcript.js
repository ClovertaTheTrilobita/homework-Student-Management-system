import request from '@/utils/request'

// 查询成绩列表
export function listTranscript(query) {
  return request({
    url: '/system/transcript/list',
    method: 'get',
    params: query
  })
}

// 查询成绩详细
export function getTranscript(id) {
  return request({
    url: '/system/transcript/' + id,
    method: 'get'
  })
}

// 新增成绩
export function addTranscript(data) {
  return request({
    url: '/system/transcript',
    method: 'post',
    data: data
  })
}

// 修改成绩
export function updateTranscript(data) {
  return request({
    url: '/system/transcript',
    method: 'put',
    data: data
  })
}

// 删除成绩
export function delTranscript(id) {
  return request({
    url: '/system/transcript/' + id,
    method: 'delete'
  })
}
