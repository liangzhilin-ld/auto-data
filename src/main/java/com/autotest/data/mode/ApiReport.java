package com.autotest.data.mode;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;

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
 * @since 2020-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class ApiReport extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * reportID
     */
    @TableId(value="ID",type = IdType.UUID)
    private String id;
    
    @TableField("JOB_ID")
    private String jobId;
    
    @TableField("HISTORY_ID")
    private String historyId;
    
    @TableField("CASE_ID")
    private Integer caseId;

    @TableField("TC_SUITE")
    private String tcSuite;

    @TableField("TC_NAME")
    private String tcName;

    //失败-0,成功-1
    @TableField("TC_RESULT")
    private Boolean tcResult;

    @TableField("TC_DURATION")
    private String tcDuration;

    @TableField("TC_HEADER")
    private String tcHeader;

    @TableField("TC_LOG")
    private String tcLog;

    @TableField("TC_REQUEST")
    private String tcRequest;

    @TableField("TC_RESPONSE")
    private String tcResponse;

    @TableField("TC_ASSERT")
    private String tcAssert;

    /**
     * 用例执行次数
     */
    @TableField("TC_RUNS_NUM")
    private Integer tcRunsNum;

    @TableField(value ="CREATE_TIME",fill = FieldFill.INSERT)
    private LocalDateTime createTime;


}
