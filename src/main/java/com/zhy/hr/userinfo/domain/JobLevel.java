package com.zhy.hr.userinfo.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zhy.common.annotation.Excel;
import com.zhy.common.core.domain.BaseEntity;

/**
 * 职称对象 job_level
 *
 * @author zhy
 * @date 2022-01-27
 */
@Data
public class JobLevel extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 职称名称
     */
    @Excel(name = "职称名称")
    private String name;

    /**
     * 职称等级
     */
    @Excel(name = "职称等级")
    private String titleLevel;

    private String userCount;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /**
     * $column.columnComment
     */
    private Integer enabled;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTitleLevel(String titleLevel) {
        this.titleLevel = titleLevel;
    }

    public String getTitleLevel() {
        return titleLevel;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Integer getEnabled() {
        return enabled;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("titleLevel", getTitleLevel())
                .append("createDate", getCreateDate())
                .append("enabled", getEnabled())
                .toString();
    }
}
