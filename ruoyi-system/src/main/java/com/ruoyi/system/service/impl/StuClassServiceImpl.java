package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StuClassMapper;
import com.ruoyi.system.domain.StuClass;
import com.ruoyi.system.service.IStuClassService;

/**
 * 班级Service业务层处理
 * 
 * @author SZF
 * @date 2024-12-05
 */
@Service
public class StuClassServiceImpl implements IStuClassService 
{
    @Autowired
    private StuClassMapper stuClassMapper;

    /**
     * 查询班级
     * 
     * @param id 班级主键
     * @return 班级
     */
    @Override
    public StuClass selectStuClassById(Long id)
    {
        return stuClassMapper.selectStuClassById(id);
    }

    /**
     * 查询班级列表
     * 
     * @param stuClass 班级
     * @return 班级
     */
    @Override
    public List<StuClass> selectStuClassList(StuClass stuClass)
    {
        return stuClassMapper.selectStuClassList(stuClass);
    }

    /**
     * 新增班级
     * 
     * @param stuClass 班级
     * @return 结果
     */
    @Override
    public int insertStuClass(StuClass stuClass)
    {
        stuClass.setCreateTime(DateUtils.getNowDate());
        return stuClassMapper.insertStuClass(stuClass);
    }

    /**
     * 修改班级
     * 
     * @param stuClass 班级
     * @return 结果
     */
    @Override
    public int updateStuClass(StuClass stuClass)
    {
        stuClass.setUpdateTime(DateUtils.getNowDate());
        return stuClassMapper.updateStuClass(stuClass);
    }

    /**
     * 批量删除班级
     * 
     * @param ids 需要删除的班级主键
     * @return 结果
     */
    @Override
    public int deleteStuClassByIds(Long[] ids)
    {
        return stuClassMapper.deleteStuClassByIds(ids);
    }

    /**
     * 删除班级信息
     * 
     * @param id 班级主键
     * @return 结果
     */
    @Override
    public int deleteStuClassById(Long id)
    {
        return stuClassMapper.deleteStuClassById(id);
    }
}
