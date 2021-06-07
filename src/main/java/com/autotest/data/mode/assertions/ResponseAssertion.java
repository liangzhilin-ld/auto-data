package com.autotest.data.mode.assertions;

import java.util.List;



import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ResponseAssertion {
	  //@TableField("NAME")
	    private String name="响应断言";

	    //@TableField("CASE_ID")
//	    private Integer caseId;

	    /**
	     * 默认main
	     */
	    //@TableField("APPLY_TO")
	    private String applyTo="Main_Sample_Only";

	    /**
	     * 设置ApplyTo为Jmeter variable Name to Use时设置
	     */
	    //@TableField("VARIABLE_VALUE")
	    private String variableValue;
	    /**
	     * 校验范围，响应code或者返回接口内容
	     */
	    //@TableField("FIELD_TO_TEXT")
	    private String fieldToText="Text_Response";

	    /**
	     * contains,matches,substring,not,or
	     */
	    //@TableField("PATTERN_RULES")
	    private String patternRules="SUBSTRING";

	    /**
	     * 包含内容
	     */
//	    //@TableField(value="TEST_STRING",typeHandler = CustomTypeHandler.class)
	    //@TableField(value="TEST_STRING",typeHandler = FastjsonTypeHandler.class)
	    private List<String> testString;
	    /**
	     * 校验失败提示消息
	     */
	    //@TableField("CUSTOM_FAILURE_MSG")
	    private String customFailureMsg="";
	    private String type="ResponseAssertion";
}
