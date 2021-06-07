package com.autotest.data.mode;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;
import java.util.List;

import com.autotest.data.mode.custom.SamplerReport;
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
@TableName(autoResultMap = true)
public class ScenarioReport extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 单个场景执行结果ID
     */
    @TableId(value = "ID", type = IdType.UUID)
    private String id;

    /**
     * 批次号
     */
    @TableField("HISTORY_ID")
    private String historyId;

    /**
     * 任务ID
     */
    @TableField("JOB_ID")
    private String jobId;

    /**
     * 项目ID
     */
    @TableField("PROJECT_ID")
    private Integer projectId;

    /**
     * 模块名称
     */
    @TableField("TC_SUITE")
    private String tcSuite;

    /**
     * 场景ID /用例ID
     */
    @TableField("TC_ID")
    private String tcId;

    /**
     * 用例名称
     */
    @TableField("TC_NAME")
    private String tcName;

    /**
     * 执行结果状态
     */
    @TableField("TC_RESULT")
    private Boolean tcResult;

    /**
     * 执行次数
     */
    @TableField("TC_RUNS_NUM")
    private Integer tcRunsNum=0;

    /**
     * 持续时间
     */
    @TableField("TC_DURATION")
    private String tcDuration;

    /**
     * 场景/sampler
     */
    @TableField("TC_TYPE")
    private String tcType="Sampler";
    /**
     * 控制台日志
     */
    @TableField(exist = false)
    private String console;
    
    /**
     * 存放场景中所有sampler全部响应内容
     */
    @TableField(value="HASHTREE", typeHandler =  FastjsonTypeHandler.class)
    private List<SamplerReport> hashtree;

    /**
     * 创建时间
     */
    @TableField(value ="CREATE_TIME",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value ="UPDATE_TIME",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
