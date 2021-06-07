package com.autotest.data.mode;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Transient;

import com.autotest.data.mode.custom.CaseList;
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
 * @since 2020-11-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName(autoResultMap = true)
@ApiModel
public class TestScheduled extends Model {

    private static final long serialVersionUID = 1L;
    public static final String TYPE_SAMPLER="samplerIds";
    public static final String TYPE_SCENARIO="scenarioIds";
    @TableId(value="JOB_ID",type = IdType.UUID)
    private String id;

    @TableField("JOB_NAME")
    private String jobName;

    /**
     * {
     * 	"samplerIds":1,2,
     * 	"scenarioIds":1,2
     * }
     * 用例集合
     */
    @ApiModelProperty(value = "{\"samplerIds\":[1,2],\"scenarioIds\":[1,2]}")
    @TableField(value="TC_CASEIDS", typeHandler =  FastjsonTypeHandler.class)
    private Map<String,List<Integer>> tcCaseids;
    
     
    
    @TableField("JOB_STATUS")
    private String jobStatus;

    @TableField("SER_VERSION")
    private String serVersion;

    /**
     * 定时任务表达式
     */
    @TableField("EXPRESSION")
    private String expression;
    /**
     * 并发数
     */
    @TableField("NUM_OF_CONCURRENT")
    private Integer numOfConcurrent=1;

    /**
     * 失败重试次数
     */
    @TableField("RETRY")
    private Integer retry;

    @TableField("START_TIME")
    private String startTime;

    @TableField("END_TIME")
    private String endTime;

    /**
     * 0-邮箱,1-钉钉群,3-微信群
     */
    @TableField("NOTIFY_TYPE")
    private String notifyType;

    @TableField(value ="CREATE_TIME",fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    /**
     * 是否立即启动
     */
    @TableField(exist = false)
    private Boolean isStartNow=false;
    
	  /**
	  * 接口host
	  */
    @TableField(exist = false)
	 private String testIp;
	
	 /**
	  * 接口PORT
	  */
    @TableField(exist = false)
	 private String testPort;
    /**
	  * historyId
	  */
   @TableField(exist = false)
	 private String historyId;   
}
