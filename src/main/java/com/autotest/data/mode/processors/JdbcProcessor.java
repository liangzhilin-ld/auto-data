package com.autotest.data.mode.processors;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
/**
 * 处理器类型：JDBCPreProcessor，JDBCPostProcessor
 */
public class JdbcProcessor {
	   //@TableField("NAME")
	    private String name;

	    //@TableField("CASE_ID")
//	    private Integer caseId;

	    /**
	     * 被定义的连接池名称JDBC Connection Configuration
	     */
	    //@TableField("VARIABLE_NAME_POOL")
	    private String variableNamePool;

	    /**
	     * Select,Update,Callable
	     */
	    //@TableField("QUERY_TYPE")
	    private String queryType;

	    /**
	     * sql语句
	     */
	    //@TableField("QUERY")
	    private String query;

	    /**
	     * sql query中占位符对应的参数值
	     */
	    //@TableField("PARAMETER_VALUES")
	    private String parameterValues;

	    /**
	     * sql query中占位符对应的参数值的类型
	     */
	    //@TableField("PARAMETER_TYPES")
	    private String parameterTypes;

	    /**
	     * 定义sql执行结果被引用的变量名称
	     */
	    //@TableField("VARIABLE_NAMES")
	    private String variableNames;

	    /**
	     * 存储所有数据的变量
	     */
	    //@TableField("RESULT_VALUE_NAME")
	    private String resultValueName;

	    /**
	     * 查询超时时间
	     */
	    //@TableField("QUERY_TIMEOUT")
	    private String queryTimeout;

	    /**
	     * Store as String
	     */
	    //@TableField("HANDLE_RESULTSET")
	    private String handleResultset;

	    /**
	     * 处理器类型：JDBCPreProcessor，JDBCPostProcessor
	     */
	    private String type="JDBCPostProcessor";
}
