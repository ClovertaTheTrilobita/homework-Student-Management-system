package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.StuClass;
import com.ruoyi.system.mapper.StuClassMapper;
import io.netty.util.internal.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StuStudentMapper;
import com.ruoyi.system.domain.StuStudent;
import com.ruoyi.system.service.IStuStudentService;
import org.springframework.util.ObjectUtils;

/**
 * 学生Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-05
 */
@Service
public class StuStudentServiceImpl implements IStuStudentService 
{
    @Autowired
    private StuStudentMapper stuStudentMapper;
    @Autowired
    private StuClassMapper stuClassMapper;

    /**
     * 查询学生
     * 
     * @param id 学生主键
     * @return 学生
     */
    @Override
    public StuStudent selectStuStudentById(Long id)
    {
        return stuStudentMapper.selectStuStudentById(id);
    }

    /**
     * 查询学生列表
     * 
     * @param stuStudent 学生
     * @return 学生
     */
    @Override
    public List<StuStudent> selectStuStudentList(StuStudent stuStudent)
    {
        List<StuStudent> stulist = stuStudentMapper.selectStuStudentList(stuStudent);
        for (StuStudent student : stulist) {
            if (!ObjectUtils.isEmpty(student.getClassId())) {
                StuClass stuClass = stuClassMapper.selectStuClassById(student.getClassId());
                student.setClassName(stuClass.getName());
            }

        }
        return stulist;
    }

    /**
     * 新增学生
     * 
     * @param stuStudent 学生
     * @return 结果
     */
    @Override
    public int insertStuStudent(StuStudent stuStudent)
    {
        stuStudent.setCreateTime(DateUtils.getNowDate());
        return stuStudentMapper.insertStuStudent(stuStudent);
    }

    /**
     * 修改学生
     * 
     * @param stuStudent 学生
     * @return 结果
     */
    @Override
    public int updateStuStudent(StuStudent stuStudent)
    {
        stuStudent.setUpdateTime(DateUtils.getNowDate());
        return stuStudentMapper.updateStuStudent(stuStudent);
    }

    /**
     * 批量删除学生
     * 
     * @param ids 需要删除的学生主键
     * @return 结果
     */
    @Override
    public int deleteStuStudentByIds(Long[] ids)
    {
        return stuStudentMapper.deleteStuStudentByIds(ids);
    }

    /**
     * 删除学生信息
     * 
     * @param id 学生主键
     * @return 结果
     */
    @Override
    public int deleteStuStudentById(Long id)
    {
        return stuStudentMapper.deleteStuStudentById(id);
    }
}
