package com.zhy.hr.approval.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * 审批状态
 *
 * @author zhouhongyin
 * @since 2022/1/24 13:05
 */
@Getter
@AllArgsConstructor
public enum AprrovalState {

    failure("失败", "0"),
    successful("成功", "1"),
    underway("进行中", "2");

    private String title;
    private String value;


}
