package com.autotest.data.mode.custom;


import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author liangzhilin
 * @since 2020-12-01
 */
@Getter
@Setter
public class SamplerReport{
    private String jobId;
    private String caseId;
    private String tcSuite;
    private String tcName;
    private String tcDuration;
    private String tcHeader;
    private String tcLog;
    private String tcRequest;
    private String tcResponse;
    private List<String> tcAssert;
    private Boolean isSuccess;
}
