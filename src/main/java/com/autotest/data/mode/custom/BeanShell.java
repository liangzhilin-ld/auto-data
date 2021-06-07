package com.autotest.data.mode.custom;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 处理器类型:BeanShellPreProcessor,BeanShellPostProcessor,BeanShellAssertion
 */
public class BeanShell {

    //@TableField("NAME")
    private String name;

    //@TableField("CASE_ID")
//    private Integer caseId;

    //@TableField("RESET_INTERPRETER")
    private boolean resetInterpreter=false;

    //@TableField("PRAMETERS")
    private String prameters;

    /**
     * SCRIPT脚本路径
     */
    //@TableField("FILE_NAME")
    private String fileName;

    /**
     * 脚本内容
     */
    //@TableField("SCRIPT")
    private String script;

    /**
     * 处理器类型:2-前置pre,8-后置post,11-断言assert,6-mock类型
     * 处理器类型:BeanShellPreProcessor,BeanShellPostProcessor,BeanShellAssertion
     */
    private String type;
}
