package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.StuTranscript;

/**
 * 成绩Mapper接口
 * 
 * @author SZF
 * @date 2024-12-04
 */
public interface StuTranscriptMapper 
{
    /**
     * 查询成绩
     * 
     * @param id 成绩主键
     * @return 成绩
     */
    public StuTranscript selectStuTranscriptById(Long id);

    /**
     * 查询成绩列表
     * 
     * @param stuTranscript 成绩
     * @return 成绩集合
     */
    public List<StuTranscript> selectStuTranscriptList(StuTranscript stuTranscript);

    /**
     * 新增成绩
     * 
     * @param stuTranscript 成绩
     * @return 结果
     */
    public int insertStuTranscript(StuTranscript stuTranscript);

    /**
     * 修改成绩
     * 
     * @param stuTranscript 成绩
     * @return 结果
     */
    public int updateStuTranscript(StuTranscript stuTranscript);

    /**
     * 删除成绩
     * 
     * @param id 成绩主键
     * @return 结果
     */
    public int deleteStuTranscriptById(Long id);

    /**
     * 批量删除成绩
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStuTranscriptByIds(Long[] ids);
}
