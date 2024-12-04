package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.StuStudentCourseRelation;

/**
 * 选修（student_course_relation）课Mapper接口
 * 
 * @author SZF
 * @date 2024-12-04
 */
public interface StuStudentCourseRelationMapper 
{
    /**
     * 查询选修（student_course_relation）课
     * 
     * @param id 选修（student_course_relation）课主键
     * @return 选修（student_course_relation）课
     */
    public StuStudentCourseRelation selectStuStudentCourseRelationById(Long id);

    /**
     * 查询选修（student_course_relation）课列表
     * 
     * @param stuStudentCourseRelation 选修（student_course_relation）课
     * @return 选修（student_course_relation）课集合
     */
    public List<StuStudentCourseRelation> selectStuStudentCourseRelationList(StuStudentCourseRelation stuStudentCourseRelation);

    /**
     * 新增选修（student_course_relation）课
     * 
     * @param stuStudentCourseRelation 选修（student_course_relation）课
     * @return 结果
     */
    public int insertStuStudentCourseRelation(StuStudentCourseRelation stuStudentCourseRelation);

    /**
     * 修改选修（student_course_relation）课
     * 
     * @param stuStudentCourseRelation 选修（student_course_relation）课
     * @return 结果
     */
    public int updateStuStudentCourseRelation(StuStudentCourseRelation stuStudentCourseRelation);

    /**
     * 删除选修（student_course_relation）课
     * 
     * @param id 选修（student_course_relation）课主键
     * @return 结果
     */
    public int deleteStuStudentCourseRelationById(Long id);

    /**
     * 批量删除选修（student_course_relation）课
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStuStudentCourseRelationByIds(Long[] ids);
}
