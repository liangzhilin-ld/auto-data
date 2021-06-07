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
@ApiModel("前置处理器")
public class PreProcessors{

	private String type="PreExtract";
	private String name="前置处理器";
//	private List<Integer> preCaseIds;
	private List<Integer> preMockIds;
    /**
     * beanshell前置处理器
     */
//    @TableField(value="BEAN_SHELL_PRE_PROCESSOR", typeHandler =  FastjsonTypeHandler.class)
    private List<BeanShell> beanShellPreProcessor;

    /**
     * jdbc前置处理器
     */
//    @TableField(value="JDBC_PRE_PROCESSOR", typeHandler =  FastjsonTypeHandler.class)
    private List<JdbcProcessor> jdbcPreProcessor;

    /**
     * js前置处理器
     */
//    @TableField("JSR223_PRE_PROCESSOR")
    private String jsr223PreProcessor;

    /**
     * mock sampler, 存mock id与名称Map<String,String>
     */
//    @TableField(value="DUMMY_SAMPLER", typeHandler =  FastjsonTypeHandler.class)
    private List<Mock> dummySampler;

    /**
     * 请求超时时间-毫秒
     */
//    @TableField("SAMPLE_TIMEOUT")
    private Integer sampleTimeout=0;
    
    class Mock {
    	String id;
    	String name;
    }

}
