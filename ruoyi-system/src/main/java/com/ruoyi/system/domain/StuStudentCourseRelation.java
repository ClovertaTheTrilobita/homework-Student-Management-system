package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 选修（student_course_relation）课对象 stu_student_course_relation
 * 
 * @author SZF
 * @date 2024-12-04
 */
public class StuStudentCourseRelation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 选课ID */
    private Long id;

    /** 课程ID */
    @Excel(name = "课程ID")
    private Long courseId;

    /** 学生ID */
    @Excel(name = "学生ID")
    private Long studentId;

    /** 周几上课 */
    @Excel(name = "周几上课")
    private Long week;

    /** 第几节 */
    @Excel(name = "第几节")
    private Long timetableType;

    /** 授课地点 */
    @Excel(name = "授课地点")
    private String address;

    /** 教师ID(用户ID) */
    @Excel(name = "教师ID(用户ID)")
    private Long teacherId;

    /** 状态ID */
    @Excel(name = "状态ID")
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
    public void setWeek(Long week) 
    {
        this.week = week;
    }

    public Long getWeek() 
    {
        return week;
    }
    public void setTimetableType(Long timetableType) 
    {
        this.timetableType = timetableType;
    }

    public Long getTimetableType() 
    {
        return timetableType;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setTeacherId(Long teacherId) 
    {
        this.teacherId = teacherId;
    }

    public Long getTeacherId() 
    {
        return teacherId;
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
            .append("week", getWeek())
            .append("timetableType", getTimetableType())
            .append("address", getAddress())
            .append("teacherId", getTeacherId())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isDel", getIsDel())
            .toString();
    }
}
