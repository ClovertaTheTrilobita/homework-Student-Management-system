package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StuCourseMapper;
import com.ruoyi.system.domain.StuCourse;
import com.ruoyi.system.service.IStuCourseService;

/**
 * 课程Service业务层处理
 * 
 * @author SZF
 * @date 2024-12-04
 */
@Service
public class StuCourseServiceImpl implements IStuCourseService 
{
    @Autowired
    private StuCourseMapper stuCourseMapper;

    /**
     * 查询课程
     * 
     * @param id 课程主键
     * @return 课程
     */
    @Override
    public StuCourse selectStuCourseById(Long id)
    {
        return stuCourseMapper.selectStuCourseById(id);
    }

    /**
     * 查询课程列表
     * 
     * @param stuCourse 课程
     * @return 课程
     */
    @Override
    public List<StuCourse> selectStuCourseList(StuCourse stuCourse)
    {
        return stuCourseMapper.selectStuCourseList(stuCourse);
    }

    /**
     * 新增课程
     * 
     * @param stuCourse 课程
     * @return 结果
     */
    @Override
    public int insertStuCourse(StuCourse stuCourse)
    {
        stuCourse.setCreateTime(DateUtils.getNowDate());
        return stuCourseMapper.insertStuCourse(stuCourse);
    }

    /**
     * 修改课程
     * 
     * @param stuCourse 课程
     * @return 结果
     */
    @Override
    public int updateStuCourse(StuCourse stuCourse)
    {
        stuCourse.setUpdateTime(DateUtils.getNowDate());
        return stuCourseMapper.updateStuCourse(stuCourse);
    }

    /**
     * 批量删除课程
     * 
     * @param ids 需要删除的课程主键
     * @return 结果
     */
    @Override
    public int deleteStuCourseByIds(Long[] ids)
    {
        return stuCourseMapper.deleteStuCourseByIds(ids);
    }

    /**
     * 删除课程信息
     * 
     * @param id 课程主键
     * @return 结果
     */
    @Override
    public int deleteStuCourseById(Long id)
    {
        return stuCourseMapper.deleteStuCourseById(id);
    }
}
