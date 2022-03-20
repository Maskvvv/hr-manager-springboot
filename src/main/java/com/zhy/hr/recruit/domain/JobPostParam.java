package com.zhy.hr.recruit.domain;

import lombok.Data;

import java.util.List;

/**
 * @author zhouhongyin
 * @since 2022/3/12 23:07
 */
@Data
public class JobPostParam {
    private String keyword;
    private List<String> locationCodeList;
    private Integer offset;
    private List<String> jobCategoryIdList;
}
