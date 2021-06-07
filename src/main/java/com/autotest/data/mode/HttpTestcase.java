package com.autotest.data.mode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.autotest.data.mode.assertions.AssertEntity;
import com.autotest.data.mode.assertions.JsonAssertion;
import com.autotest.data.mode.assertions.ResponseAssertion;
import com.autotest.data.mode.confelement.*;
import com.autotest.data.mode.custom.BeanShell;
import com.autotest.data.mode.processors.JdbcProcessor;
import com.autotest.data.mode.processors.JsonExtractor;
import com.autotest.data.mode.processors.PostProcessors;
import com.autotest.data.mode.processors.PreProcessors;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用例实体类
 * </p>
 *
 * @author liangzhilin
 * @since 2021-01-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName(autoResultMap = true)
public class HttpTestcase extends Model {

    private static final long serialVersionUID = 1L;

    @TableId(value = "CASE_ID", type = IdType.AUTO)
    private Integer caseId;

    @TableField("PROJECT_ID")
    private Integer projectId;

    @TableField("SUITE_ID")
    private Integer suiteId;

    @TableField("SUITE_NAME")
    private String suiteName;

    @TableField("API_PROTOCOL")
    private String apiProtocol="http";

    @TableField("API_NAME")
    private String apiName;

    @TableField("API_URI")
    private String apiUri;

    @TableField("API_METHOD")
    private String apiMethod;

    /**
     * Parameter content type
     */
    @TableField("API_IN")
    private String apiIn;

    @TableField("PARAMETERS")
    private String parameters;
    
    
    
    /**
     * 请求头[]
     */
    @TableField(value="HEADERS", typeHandler =  FastjsonTypeHandler.class)
    private List<ApiHeader> headers;

    /**
     * 用例变量定义user_defined_variable[]
     */
    @TableField(value="ARGUMENTS", typeHandler =  FastjsonTypeHandler.class)
    private List<UserDefinedVariable> arguments;

    /**
     * 前置,后置,断言
     */
    @TableField(value="HASHTREE", typeHandler =  FastjsonTypeHandler.class)
    private ArrayList<JSONObject> hashtree;

    /**
     * 附件路径
     */
    @TableField("ATTACHMENT")
    private String attachment;

    /**
     * 标记
     */
    @TableField("TAG")
    private String tag;

    /**
     * 标记
     */
    @TableField("PRIORITY")
    private String priority;
    
    @TableField(value ="CREATE_TIME",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value ="UPDATE_TIME",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private String type="HTTPSampler";
    
	/**
	 * 前置
	 * @return
	 */
//    @JsonIgnore
//	public List<Integer> getPreCases() {			
//		return this.getPreProcessors().getPreCaseIds();		
//	}
    @JsonIgnore
	public List<BeanShell> getPreBeanshell() {		
		return this.getPreProcessors().getBeanShellPreProcessor();		
	}
    @JsonIgnore
	public List<JdbcProcessor> getPreJdbc(){
		return this.getPreProcessors().getJdbcPreProcessor();
	}
    @JsonIgnore
	public List<Integer> getIdOfPreMock() {
		return this.getPreProcessors().getPreMockIds();
	}
	/**
	 * 后置
	 * @return
	 */
    @JsonIgnore
	public List<BeanShell> getPostBeanshell(){
		return this.getPostProcessors().getBeanShellPostProcessor();
	}
    @JsonIgnore
	public List<JdbcProcessor> getPostJdbc() {
		return this.getPostProcessors().getJdbcPostProcessor();
	}
	@JsonIgnore
	public List<JsonExtractor> getPostJson() {
		return this.getPostProcessors().getJsonExtractor();
	}
	
	/**
	 * 校验
	 * @return
	 */
	@JsonIgnore
	public List<BeanShell> getAssertBeanshell() {
		return this.getAssertions().getBeanShellAssertion();
	}
	@JsonIgnore
	public List<JsonAssertion> getAssertJson() {
		return this.getAssertions().getJsonAssertion();
	}
	@JsonIgnore
	public List<ResponseAssertion> getResponse() {
		return this.getAssertions().getResponseAssertion();
	}
	
	
	private PreProcessors getPreProcessors() {
		PreProcessors pre=new PreProcessors();
		for(JSONObject item:this.hashtree){
			if(item.getString("type").equals(pre.getType())) {
				pre=JSON.parseObject(item.toString(), PreProcessors.class);
				break;
			}
        }
		return pre;
	}
	private PostProcessors getPostProcessors() {
		PostProcessors post=new PostProcessors();
		for(JSONObject item:this.hashtree){
			if(item.getString("type").equals(post.getType())) {
				post=JSON.parseObject(item.toString(), PostProcessors.class);
				break;
			}
        }
		return post;
	}
	private AssertEntity getAssertions() {
		AssertEntity ae=new AssertEntity();
		for(JSONObject item:this.hashtree){
			if(item.getString("type").equals(ae.getType())) {
				ae=JSON.parseObject(item.toString(), AssertEntity.class);
				break;
			}
        }
		return ae;
	}
//    /**
//     * 前置处理，无则不传该参数
//     */
//    @TableField(exist = false)
//    private PreProcessors preProcessor;
//    /**
//     * 断言，无则不传该参数
//     */
//    @TableField(exist = false)
//    private Assertions assertions;
//    
//    /**
//     * 配置元件详细，header、用户自定义变量，无则不传该参数
//     */
//    @TableField(exist = false)  
//    private ConfigElement confElements;
//    
//	/**
//     * 后置处理，无则不传该参数
//     */
//    @TableField(exist = false)
//    private PostProcessors postProcessor;

}
