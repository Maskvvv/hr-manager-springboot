package com.zhy.common.enums;

/**
 * 业务操作类型
 *
 * @Author: zhouhongyin
 * @date: 2021/10/25
 */
public enum BusinessType {
    /**
     * 日活 Day Active User
     */
    DAU,

    /**
     * 其它
     */
    OTHER,

    /**
     * 新增
     */
    INSERT,

    /**
     * 修改
     */
    UPDATE,

    /**
     * 删除
     */
    DELETE,

    /**
     * 授权
     */
    GRANT,

    /**
     * 导出
     */
    EXPORT,

    /**
     * 导入
     */
    IMPORT,

    /**
     * 强退
     */
    FORCE,

    /**
     * 生成代码
     */
    GENCODE,

    /**
     * 清空数据
     */
    CLEAN,
}
