package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.StuStudent;

/**
 * 学生Mapper接口
 * 
 * @author SZF
 * @date 2024-12-04
 */
public interface StuStudentMapper 
{
    /**
     * 查询学生
     * 
     * @param id 学生主键
     * @return 学生
     */
    public StuStudent selectStuStudentById(Long id);

    /**
     * 查询学生列表
     * 
     * @param stuStudent 学生
     * @return 学生集合
     */
    public List<StuStudent> selectStuStudentList(StuStudent stuStudent);

    /**
     * 新增学生
     * 
     * @param stuStudent 学生
     * @return 结果
     */
    public int insertStuStudent(StuStudent stuStudent);

    /**
     * 修改学生
     * 
     * @param stuStudent 学生
     * @return 结果
     */
    public int updateStuStudent(StuStudent stuStudent);

    /**
     * 删除学生
     * 
     * @param id 学生主键
     * @return 结果
     */
    public int deleteStuStudentById(Long id);

    /**
     * 批量删除学生
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStuStudentByIds(Long[] ids);
}
