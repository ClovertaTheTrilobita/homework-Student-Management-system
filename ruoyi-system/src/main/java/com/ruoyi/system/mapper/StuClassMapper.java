package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.StuClass;

/**
 * 班级Mapper接口
 * 
 * @author SZF
 * @date 2024-12-04
 */
public interface StuClassMapper 
{
    /**
     * 查询班级
     * 
     * @param id 班级主键
     * @return 班级
     */
    public StuClass selectStuClassById(Long id);

    /**
     * 查询班级列表
     * 
     * @param stuClass 班级
     * @return 班级集合
     */
    public List<StuClass> selectStuClassList(StuClass stuClass);

    /**
     * 新增班级
     * 
     * @param stuClass 班级
     * @return 结果
     */
    public int insertStuClass(StuClass stuClass);

    /**
     * 修改班级
     * 
     * @param stuClass 班级
     * @return 结果
     */
    public int updateStuClass(StuClass stuClass);

    /**
     * 删除班级
     * 
     * @param id 班级主键
     * @return 结果
     */
    public int deleteStuClassById(Long id);

    /**
     * 批量删除班级
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStuClassByIds(Long[] ids);
}
