package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 成绩对象 stu_transcript
 * 
 * @author SZF
 * @date 2024-12-04
 */
public class StuTranscript extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 成绩ID */
    private Long id;

    /** 课程ID */
    @Excel(name = "课程ID")
    private Long courseId;

    /** 学生ID */
    @Excel(name = "学生ID")
    private Long studentId;

    /** 分数 */
    @Excel(name = "分数")
    private Long score;

    /** 是否及格 0 及格，1不及格 */
    @Excel(name = "是否及格 0 及格，1不及格")
    private Long isPass;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String courseName;

    /** 学生名称 */
    @Excel(name = "学生名称")
    private String studentName;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private Long isDel;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
    }
    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }
    public void setScore(Long score) 
    {
        this.score = score;
    }

    public Long getScore() 
    {
        return score;
    }
    public void setIsPass(Long isPass) 
    {
        this.isPass = isPass;
    }

    public Long getIsPass() 
    {
        return isPass;
    }
    public void setCourseName(String courseName) 
    {
        this.courseName = courseName;
    }

    public String getCourseName() 
    {
        return courseName;
    }
    public void setStudentName(String studentName) 
    {
        this.studentName = studentName;
    }

    public String getStudentName() 
    {
        return studentName;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setIsDel(Long isDel) 
    {
        this.isDel = isDel;
    }

    public Long getIsDel() 
    {
        return isDel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("courseId", getCourseId())
            .append("studentId", getStudentId())
            .append("score", getScore())
            .append("isPass", getIsPass())
            .append("courseName", getCourseName())
            .append("studentName", getStudentName())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isDel", getIsDel())
            .toString();
    }
}
