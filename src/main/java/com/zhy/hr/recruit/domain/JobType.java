package com.zhy.hr.recruit.domain;

import com.zhy.common.annotation.Excel;
import com.zhy.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;


/**
 * 职位类型对象 job_type
 *
 * @author zhouhongyin
 * @date 2022-03-12
 */
@Data
public class JobType extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 类型名称
     */
    @Excel(name = "类型名称")
    private String name;

    /**
     * 英文名
     */
    @Excel(name = "英文名")
    private String enName;

    /**
     * $column.columnComment
     */
    @Excel(name = "英文名")
    private String i18nName;

    /**
     * 等级
     */
    @Excel(name = "等级")
    private Long depth;

    /**
     * 父节点
     */
    @Excel(name = "父节点")
    private String parent;

    private List<JobType> children;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getEnName() {
        return enName;
    }

    public void setI18nName(String i18nName) {
        this.i18nName = i18nName;
    }

    public String getI18nName() {
        return i18nName;
    }

    public void setDepth(Long depth) {
        this.depth = depth;
    }

    public Long getDepth() {
        return depth;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getParent() {
        return parent;
    }

}
