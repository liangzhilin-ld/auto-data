package com.autotest.data.mode.processors;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class JsonExtractor {

//    @TableField("NAME")
    private String name="JSON提取器";

//    @TableField("APPLY_TO")
    private String applyTo="Main_Sample_Only";
    /**
     * APPLY_TO选择变量时需要输入变量名称
     */
//    @TableField("APPLY_TO_VAR_TO_USE")
    private String applyToVarToUse="";
    /**
     * 变量名
     */
//    @TableField("VARIABLE_NAME")
    private String variableName;

    /**
     * json表达式
     */
//    @TableField("JSON_PATH")
    private String jsonPath;

    /**
     * 匹配序号
     */
//    @TableField("MATCH_NO")
    private String matchNo;

//    @TableField("SUFFIX_ALL")
    private boolean suffixAll=false;

//    @TableField("DEFAULT_VALUE")
    private String defaultValue;
    private String type="JSONExtractor";


  

}
