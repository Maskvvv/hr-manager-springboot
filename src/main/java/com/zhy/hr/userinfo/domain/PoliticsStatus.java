package com.zhy.hr.userinfo.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zhy.common.annotation.Excel;
import com.zhy.common.core.domain.BaseEntity;

/**
 * 政治面貌对象 politics_status
 *
 * @author zhy
 * @date 2022-01-27
 */
@Data
public class PoliticsStatus extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long politicsId;

    /**
     * 政治面貌
     */
    @Excel(name = "政治面貌")
    private String politicsName;

    private String userCount;

    public void setPoliticsId(Long politicsId) {
        this.politicsId = politicsId;
    }

    public Long getPoliticsId() {
        return politicsId;
    }

    public void setPoliticsName(String politicsName) {
        this.politicsName = politicsName;
    }

    public String getPoliticsName() {
        return politicsName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("politicsId", getPoliticsId())
                .append("politicsName", getPoliticsName())
                .toString();
    }
}
