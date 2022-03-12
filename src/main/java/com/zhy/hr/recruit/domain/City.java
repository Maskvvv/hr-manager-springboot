package com.zhy.hr.recruit.domain;

import com.zhy.common.annotation.Excel;
import com.zhy.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 城市对象 city
 *
 * @author zhouhongyin
 * @date 2022-03-12
 */
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

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
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

    public void setLocationType(Long locationType) {
        this.locationType = locationType;
    }

    public Long getLocationType() {
        return locationType;
    }

    public void setI18nName(String i18nName) {
        this.i18nName = i18nName;
    }

    public String getI18nName() {
        return i18nName;
    }

    public void setPyName(String pyName) {
        this.pyName = pyName;
    }

    public String getPyName() {
        return pyName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("code", getCode())
                .append("name", getName())
                .append("enName", getEnName())
                .append("locationType", getLocationType())
                .append("i18nName", getI18nName())
                .append("pyName", getPyName())
                .toString();
    }
}
