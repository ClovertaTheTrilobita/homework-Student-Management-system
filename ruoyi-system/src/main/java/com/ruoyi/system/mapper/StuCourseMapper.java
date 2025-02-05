package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.StuCourse;

/**
 * 课程Mapper接口
 * 
 * @author SZF
 * @date 2024-12-04
 */
public interface StuCourseMapper 
{
    /**
     * 查询课程
     * 
     * @param id 课程主键
     * @return 课程
     */
    public StuCourse selectStuCourseById(Long id);

    /**
     * 查询课程列表
     * 
     * @param stuCourse 课程
     * @return 课程集合
     */
    public List<StuCourse> selectStuCourseList(StuCourse stuCourse);

    /**
     * 新增课程
     * 
     * @param stuCourse 课程
     * @return 结果
     */
    public int insertStuCourse(StuCourse stuCourse);

    /**
     * 修改课程
     * 
     * @param stuCourse 课程
     * @return 结果
     */
    public int updateStuCourse(StuCourse stuCourse);

    /**
     * 删除课程
     * 
     * @param id 课程主键
     * @return 结果
     */
    public int deleteStuCourseById(Long id);

    /**
     * 批量删除课程
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStuCourseByIds(Long[] ids);
}
