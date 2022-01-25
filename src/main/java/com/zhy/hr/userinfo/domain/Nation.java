package com.zhy.hr.userinfo.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zhy.common.annotation.Excel;
import com.zhy.common.core.domain.BaseEntity;

/**
 * 民族对象 nation
 *
 * @author zhy
 * @date 2022-01-25
 */
@Data
public class Nation extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long nationId;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String nationName;

    private String userCount;

    public void setNationId(Long nationId) {
        this.nationId = nationId;
    }

    public Long getNationId() {
        return nationId;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }

    public String getNationName() {
        return nationName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("nationId", getNationId())
                .append("nationName", getNationName())
                .toString();
    }
}
