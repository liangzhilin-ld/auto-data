package com.autotest.data.mode;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
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
 * @since 2020-11-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class TheadGroupConfig extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 性能测试计划中的ID，创建性能测试计划时生成
     */
    @TableField("JOB_ID")
    private String jobId;

    /**
     * 线程组ID
     */
    @TableField("ID")
    private Integer id;

    @TableField("NAME")
    private String name;

    @TableField("ON_SAMPLE_ERROR")
    private String onSampleError;

    @TableField("NUM_THREADS")
    private String numThreads;

    @TableField("RAMP_UP")
    private String rampUp;

    @TableField("LOOP_COUNT")
    private String loopCount;

    /**
     * 0-false,1-true Integer
     */
    @TableField("DELAY_THRED_CREATION")
    private boolean delayThredCreation;

    /**
     * 0-false,1-true Integer
     */
    @TableField("SCHEDULER")
    private boolean scheduler;

    @TableField("DURATION")
    private String duration;
    /**
     * 延迟时间
     */
    @TableField("DELAY")
    private String delay;
    /**
     * 线程组下用例ID集合
     */
    @TableField("SAMPLER")
    private String sampler;

    /**
     * 逻辑控制器按分类存储0-，1-；json结构，可能存在多个
     */
    @TableField("LOGIC_CONTROLLER")
    private String logicController;

    /**
     * 定时器:固定定时器，随机定时器
     */
    @TableField("TIMER")
    private String timer;


}
