package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StuStudentCourseRelationMapper;
import com.ruoyi.system.domain.StuStudentCourseRelation;
import com.ruoyi.system.service.IStuStudentCourseRelationService;

/**
 * 选修（student_course_relation）课Service业务层处理
 * 
 * @author SZF
 * @date 2024-12-04
 */
@Service
public class StuStudentCourseRelationServiceImpl implements IStuStudentCourseRelationService 
{
    @Autowired
    private StuStudentCourseRelationMapper stuStudentCourseRelationMapper;

    /**
     * 查询选修（student_course_relation）课
     * 
     * @param id 选修（student_course_relation）课主键
     * @return 选修（student_course_relation）课
     */
    @Override
    public StuStudentCourseRelation selectStuStudentCourseRelationById(Long id)
    {
        return stuStudentCourseRelationMapper.selectStuStudentCourseRelationById(id);
    }

    /**
     * 查询选修（student_course_relation）课列表
     * 
     * @param stuStudentCourseRelation 选修（student_course_relation）课
     * @return 选修（student_course_relation）课
     */
    @Override
    public List<StuStudentCourseRelation> selectStuStudentCourseRelationList(StuStudentCourseRelation stuStudentCourseRelation)
    {
        return stuStudentCourseRelationMapper.selectStuStudentCourseRelationList(stuStudentCourseRelation);
    }

    /**
     * 新增选修（student_course_relation）课
     * 
     * @param stuStudentCourseRelation 选修（student_course_relation）课
     * @return 结果
     */
    @Override
    public int insertStuStudentCourseRelation(StuStudentCourseRelation stuStudentCourseRelation)
    {
        stuStudentCourseRelation.setCreateTime(DateUtils.getNowDate());
        return stuStudentCourseRelationMapper.insertStuStudentCourseRelation(stuStudentCourseRelation);
    }

    /**
     * 修改选修（student_course_relation）课
     * 
     * @param stuStudentCourseRelation 选修（student_course_relation）课
     * @return 结果
     */
    @Override
    public int updateStuStudentCourseRelation(StuStudentCourseRelation stuStudentCourseRelation)
    {
        stuStudentCourseRelation.setUpdateTime(DateUtils.getNowDate());
        return stuStudentCourseRelationMapper.updateStuStudentCourseRelation(stuStudentCourseRelation);
    }

    /**
     * 批量删除选修（student_course_relation）课
     * 
     * @param ids 需要删除的选修（student_course_relation）课主键
     * @return 结果
     */
    @Override
    public int deleteStuStudentCourseRelationByIds(Long[] ids)
    {
        return stuStudentCourseRelationMapper.deleteStuStudentCourseRelationByIds(ids);
    }

    /**
     * 删除选修（student_course_relation）课信息
     * 
     * @param id 选修（student_course_relation）课主键
     * @return 结果
     */
    @Override
    public int deleteStuStudentCourseRelationById(Long id)
    {
        return stuStudentCourseRelationMapper.deleteStuStudentCourseRelationById(id);
    }
}
