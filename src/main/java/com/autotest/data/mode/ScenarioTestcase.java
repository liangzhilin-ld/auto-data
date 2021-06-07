package com.autotest.data.mode;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.autotest.data.mode.confelement.UserDefinedVariable;
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
 * @since 2021-01-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName(autoResultMap = true)

public class ScenarioTestcase extends Model {

    private static final long serialVersionUID = 1L;
    public static final String LOGIN_SIGN="ScenarioLogin";
    public static final String TYPE_HTTP_SAMPLER="HTTPSampler";
    public static final String TYPE_LOGIN_CONTROLLER="LoginController";
    public static final String TYPE_SCENARIO="Scenario";
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 场景名称
     */
    @TableField("PROJECT_ID")
    private Integer projectId;
    
    
    /**
     * 场景名称
     */
    @TableField("SCENARIO_NAME")
    private String scenarioName;

    /**
     * 分类模块
     */
    @TableField("SUITE_ID")
    private Integer suiteId;

    /**
     * 优先级
     */
    @TableField("PRIORITY")
    private String priority;

    /**
     * 负责人
     */
    @TableField("DIRECTOR")
    private String director;

    /**
     * 描述
     */
    @TableField("COMMENTS")
    private String comments;

    /**
     * 存放关联的sampler、场景、控制器，Json数据
     */
    @TableField(value="HASHTREE", typeHandler =  FastjsonTypeHandler.class)
    private ArrayList<JSONObject> hashtree;
    
    @TableField(value="ARGUMENTS", typeHandler =  FastjsonTypeHandler.class)
    private List<UserDefinedVariable> arguments;
    
    @TableField("STATUS")
    private String status;    
    /**
     * 可标记[登陆]场景，后续所有请求的前置登陆条件
     */
    @TableField("TAG")
    private String tag;
    
    /**
     * scenario
     */
    @TableField("TYPE")
    private String type="Scenario";
    
    @TableField(value ="CREATE_TIME",fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(value ="UPDATE_TIME",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    
//    public Integer getCaseId(JSONObject obj) {
//    	if(obj.getString("type").equals("HTTPSampler")) {
//    		return  obj.getInteger("id");
//    	}
//    	return null;
//    }
    
}
