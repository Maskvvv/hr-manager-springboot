package com.zhy.hr.recruit.domain;

import lombok.Data;

/**
 * @author zhouhongyin
 * @since 2022/3/13 10:14
 */
@Data
public class RecruitType {
    private String id;
    private String en_name;
    private String name;
    private RecruitType children;
    private Integer active_status;
    private Integer depth;
    private String i18n_name;
    private RecruitType parent;
}
