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
     * i18nName
     */
    @Excel(name = "英文名")
    private String i18nName;

    /**
     * 等级
     */
    private Long depth;

    /**
     * 父节点
     */
    private String parent;

    private List<JobType> children;

    @Excel(name = "工作数量")
    private Integer jobCount;
}
