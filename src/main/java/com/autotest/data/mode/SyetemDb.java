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
public class SyetemDb extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 连接id
     */
    @TableId("CNN_ID")
    private Integer cnnId;

    /**
     * 连接名称
     */
    @TableField("CNN_NAME")
    private String cnnName;

    /**
     * 类型
     */
    @TableField("DB_TYPE")
    private String dbType;

    /**
     * 数据库名称
     */
    @TableField("DB_NAME")
    private String dbName;

    /**
     * host
     */
    @TableField("CNN_HOST")
    private String cnnHost;

    /**
     * 端口  
     */
    @TableField("CNN_PORT")
    private Integer cnnPort;
    /**
     * DRIVER CLASS路径
     */
    @TableField("DRIVER_CLASS")
    private String driverClass;
    
    /**
     * 数据库登陆用户
     */
    @TableField("USERNAME")
    private String username;
    /**
     * 数据库登陆密码
     */
    @TableField("PASSWORD")
    private String password;
    /**
     * 备注
     */
    @TableField("REMARKS")
    private String remarks;

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
