package com.zhy.system.domain;

import lombok.Data;

/**
 * @author zhouhongyin
 * @since 2022/4/4 21:12
 */
@Data
public class DayActiveUser {
    private String id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户ID
     */
    private Long creatTime;
}
