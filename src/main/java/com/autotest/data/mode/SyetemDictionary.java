package com.autotest.data.mode;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author liangzhilin
 * @since 2020-11-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SyetemDictionary extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 功能ID
     */
    @TableField("FUNCTIONAL_ID")
    private Integer functionalId;

    /**
     * 状态ID
     */
    @TableField("STATUS_ID")
    private String statusId;

    /**
     * 状态名
     */
    @TableField("STATUS_NAME")
    private String statusName;

    /**
     * 功能类别描述
     */
    @TableField("DESCRIBLE")
    private String describle;

    /**
     * 排序
     */
    @TableField("ORDER_INDEX")
    private Integer orderIndex;

    /**
     * 删除状态0-删除 1未删除
     */
    @TableField("STATUS")
    private Integer status=1;
}
