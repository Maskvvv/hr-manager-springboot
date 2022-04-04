package com.zhy.hr.recruit.domain;

import com.zhy.common.annotation.Excel;
import com.zhy.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 城市对象 city
 *
 * @author zhouhongyin
 * @date 2022-03-12
 */
@Data
public class City extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private String code;

    /**
     * 名称
     */
    @Excel(name = "名称")
    private String name;

    /**
     * $column.columnComment
     */
    @Excel(name = "名称")
    private String enName;

    /**
     * 类型
     */
    @Excel(name = "类型")
    private Long locationType;

    /**
     * $column.columnComment
     */
    @Excel(name = "类型")
    private String i18nName;

    /**
     * 拼音
     */
    @Excel(name = "拼音")
    private String pyName;

    /**
     * 工作数量
     */
    private Integer jobCount;
}
