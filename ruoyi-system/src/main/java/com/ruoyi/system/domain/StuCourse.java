package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 课程对象 stu_course
 * 
 * @author SZF
 * @date 2024-12-04
 */
public class StuCourse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 课程ID */
    private Long id;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String name;

    /** 课程描述 */
    @Excel(name = "课程描述")
    private String desc;

    /** 学分 */
    @Excel(name = "学分")
    private Long credit;

    /** 及格分数 */
    @Excel(name = "及格分数")
    private Long passScore;

    /** 课程类型 */
    @Excel(name = "课程类型")
    private Long type;

    /** 授课方式 */
    @Excel(name = "授课方式")
    private Long method;

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
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setDesc(String desc) 
    {
        this.desc = desc;
    }

    public String getDesc() 
    {
        return desc;
    }
    public void setCredit(Long credit) 
    {
        this.credit = credit;
    }

    public Long getCredit() 
    {
        return credit;
    }
    public void setPassScore(Long passScore) 
    {
        this.passScore = passScore;
    }

    public Long getPassScore() 
    {
        return passScore;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setMethod(Long method) 
    {
        this.method = method;
    }

    public Long getMethod() 
    {
        return method;
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
            .append("name", getName())
            .append("desc", getDesc())
            .append("remark", getRemark())
            .append("credit", getCredit())
            .append("passScore", getPassScore())
            .append("type", getType())
            .append("method", getMethod())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isDel", getIsDel())
            .toString();
    }
}
