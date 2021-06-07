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
 * @since 2021-01-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class ApiReportHistoryList extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * historyID
     */
    @TableId(value="ID",type = IdType.UUID)
    private String id;

    @TableField("JOB_ID")
    private String jobId;

    @TableField("JOB_NAME")
    private String jobName;

    @TableField("SER_VERSION")
    private String serVersion;

    @TableField("TC_TOTAL")
    private String tcTotal;

    @TableField("TC_PASSED")
    private String tcPassed;

    @TableField("TC_FAILED")
    private String tcFailed;

    @TableField("START_TIME")
    private LocalDateTime startTime;

    @TableField("END_TIME")
    private LocalDateTime endTime;

    @TableField("NOTIFY_TYPE")
    private String notifyType;

    @TableField(value ="CREATE_TIME",fill = FieldFill.INSERT)
    private LocalDateTime createTime;


}
