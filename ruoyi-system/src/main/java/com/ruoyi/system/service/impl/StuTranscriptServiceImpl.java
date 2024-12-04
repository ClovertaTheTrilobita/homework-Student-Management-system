package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StuTranscriptMapper;
import com.ruoyi.system.domain.StuTranscript;
import com.ruoyi.system.service.IStuTranscriptService;

/**
 * 成绩Service业务层处理
 * 
 * @author SZF
 * @date 2024-12-04
 */
@Service
public class StuTranscriptServiceImpl implements IStuTranscriptService 
{
    @Autowired
    private StuTranscriptMapper stuTranscriptMapper;

    /**
     * 查询成绩
     * 
     * @param id 成绩主键
     * @return 成绩
     */
    @Override
    public StuTranscript selectStuTranscriptById(Long id)
    {
        return stuTranscriptMapper.selectStuTranscriptById(id);
    }

    /**
     * 查询成绩列表
     * 
     * @param stuTranscript 成绩
     * @return 成绩
     */
    @Override
    public List<StuTranscript> selectStuTranscriptList(StuTranscript stuTranscript)
    {
        return stuTranscriptMapper.selectStuTranscriptList(stuTranscript);
    }

    /**
     * 新增成绩
     * 
     * @param stuTranscript 成绩
     * @return 结果
     */
    @Override
    public int insertStuTranscript(StuTranscript stuTranscript)
    {
        stuTranscript.setCreateTime(DateUtils.getNowDate());
        return stuTranscriptMapper.insertStuTranscript(stuTranscript);
    }

    /**
     * 修改成绩
     * 
     * @param stuTranscript 成绩
     * @return 结果
     */
    @Override
    public int updateStuTranscript(StuTranscript stuTranscript)
    {
        stuTranscript.setUpdateTime(DateUtils.getNowDate());
        return stuTranscriptMapper.updateStuTranscript(stuTranscript);
    }

    /**
     * 批量删除成绩
     * 
     * @param ids 需要删除的成绩主键
     * @return 结果
     */
    @Override
    public int deleteStuTranscriptByIds(Long[] ids)
    {
        return stuTranscriptMapper.deleteStuTranscriptByIds(ids);
    }

    /**
     * 删除成绩信息
     * 
     * @param id 成绩主键
     * @return 结果
     */
    @Override
    public int deleteStuTranscriptById(Long id)
    {
        return stuTranscriptMapper.deleteStuTranscriptById(id);
    }
}
