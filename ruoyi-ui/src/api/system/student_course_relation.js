import request from '@/utils/request'

// 查询选修（student_course_relation）课列表
export function listStudent_course_relation(query) {
  return request({
    url: '/system/student_course_relation/list',
    method: 'get',
    params: query
  })
}

// 查询选修（student_course_relation）课详细
export function getStudent_course_relation(id) {
  return request({
    url: '/system/student_course_relation/' + id,
    method: 'get'
  })
}

// 新增选修（student_course_relation）课
export function addStudent_course_relation(data) {
  return request({
    url: '/system/student_course_relation',
    method: 'post',
    data: data
  })
}

// 修改选修（student_course_relation）课
export function updateStudent_course_relation(data) {
  return request({
    url: '/system/student_course_relation',
    method: 'put',
    data: data
  })
}

// 删除选修（student_course_relation）课
export function delStudent_course_relation(id) {
  return request({
    url: '/system/student_course_relation/' + id,
    method: 'delete'
  })
}
