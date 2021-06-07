package com.autotest.data.mode.processors;

import java.util.List;
import com.autotest.data.mode.custom.BeanShell;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author liangzhilin
 * @since 2021-01-26
 */
@Getter
@Setter
@ApiModel("后置处理器")
public class PostProcessors{


    private String type="PostExtract";
	private String name="后置处理器";

    /**
     * json提取
     */
 
//    @TableField(value="JSON_EXTRACTOR", typeHandler =  FastjsonTypeHandler.class)
    private List<JsonExtractor> jsonExtractor;

    /**
     * 边界提取
     */
//    @TableField("BOUNDARY_EXTRACTOR")
    private String boundaryExtractor;

    /**
     * 正则提取
     */
//    @TableField("REGULAR_EXPRESSION_EXTRACTOR")
    private String regularExpressionExtractor;

    /**
     * css提取
     */
//    @TableField("CSS_SELECTOR_EXTRACTOR")
    private String cssSelectorExtractor;

    /**
     * beanshell提取
     */
//    @TableField(value="BEAN_SHELL_POST_PROCESSOR", typeHandler =  FastjsonTypeHandler.class)
    private List<BeanShell> beanShellPostProcessor;

    /**
     * JDBC提取
     */
//   @TableField(value="JDBC_POST_PROCESSOR", typeHandler =  FastjsonTypeHandler.class)
    private List<JdbcProcessor> jdbcPostProcessor;

    /**
     * js提取
     */
//    @TableField("JSR223_POST_PROCESSOR")
    private String jsr223PostProcessor;

//    @TableField("XPATH_EXTRACTOR")
    private String xpathExtractor;

//    @TableField("XPATH2_EXTRACTOR")
    private String xpath2Extractor;

}
