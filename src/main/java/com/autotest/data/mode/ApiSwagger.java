package com.autotest.data.mode;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2021-03-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
//@Repository
public class ApiSwagger extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 接口编号
     */
    @TableId(value="ID",type = IdType.AUTO)
    private Integer id;

    /**
     * 项目ID
     */
    @TableField("PROJECT_ID")
    private Integer projectId;

    /**
     * SWAGGER地址title
     */
    @TableField("SWG_TITLE")
    private String swgTitle;
    /**
     * 服务名称
     */
    @TableField("SERVICE_NAME")
    private String serviceName;

    /**
     * 模块名
     */
    @TableField("MODULE_NAME")
    private String moduleName;
    /**
     * 模块名上次同步名称
     */
    @TableField("MODULE_NAME_OLD")
    private String moduleNameOld;
    
    /**
     * 模块描述
     */
    @TableField("MODULE_DESC")
    private String moduleDesc;

    /**
     * 接口描述
     */
    @TableField("API_DESC")
    private String apiDesc;

    /**
     * URI
     */
    @TableId("API_URI")
    private String apiUri;

    /**
     * 请求方法
     */
    @TableField("API_METHOD")
    private String apiMethod;

    /**
     * Parameter content type
     */
    @TableField("API_IN")
    private String apiIn;

    /**
     * 入参
     */
    @TableField("API_PARAMETERS")
    private String apiParameters;

    /**
     * 入参初始化示例
     */
    @TableField("API_EXAMPLE")
    private String apiExample;

    /**
     * 响应
     */
    @TableField("API_REPONSES")
    private String apiReponses;

    @TableField(value ="CREATE_TIME",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value ="UPDATE_TIME",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
