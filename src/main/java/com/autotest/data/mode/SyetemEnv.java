package com.autotest.data.mode;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
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
 * @since 2020-10-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SyetemEnv extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 环境编号
     */
    @TableId("ID")
    private Integer id;

    /**
     * 环境名称
     */
    @TableField("`NAME`")
    private String name;

    @TableField("IP")
    private String ip;

    @TableField("`PORT`")
    private String port;

    /**
     * 超时设置
     */
    @TableField("TIME_OUT")
    private Integer timeOut;

    /**
     * 说明
     */
    @TableField("`DESC`")
    private String desc;

    /**
     * 操作
     */
    @TableField("OPERATION")
    private String operation;

    @TableField(value ="CREATE_TIME",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "UPDATE_TIME", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
