package com.autotest.data.mode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.autotest.data.mode.assertions.AssertEntity;
import com.autotest.data.mode.assertions.JsonAssertion;
import com.autotest.data.mode.assertions.ResponseAssertion;
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
import java.util.Iterator;
import java.util.List;

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
 * @since 2021-01-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName(autoResultMap = true)
public class ApiMock extends Model {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 对应sampler的前置mock
     */
    @TableField("CASE_ID")
    private Integer caseId;

    /**
     * 请求uri
     */
    @TableField("URL")
    private String url;

    /**
     * 显示接口名称
     */
    @TableField("NAME")
    private String name;

    /**
     * 备注
     */
    @TableField("COMMENT")
    private String comment;

    /**
     * YES:前置beanshell,可用于设置动态值, NO:不设置前置beanshell
     */
//    @TableField("API_PRE")
//    private String apiPre;

    /**
     * 模拟请求内容
     */
    @TableField("REQUEST_DATA")
    private String requestData;

    /**
     * 模拟响应内容
     */
    @TableField("RESPONSE_DATA")
    private String responseData;

    /**
     * 后置处理:7-json,8-beanshell,9-jdbc
     */
//    @TableField("TC_POST")
//    private String tcPost;

    @TableField(value ="CREATE_TIME",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     *存放前置后置处理，参考http_testcase。
     *前置暂时只支持beanshell,后置:json,beanshell,jdbc
     */
    @TableField(value="HASHTREE", typeHandler =  FastjsonTypeHandler.class)
    private ArrayList<JSONObject> hashtree;
    @TableField(exist = false)
    private String type="Mock";
    
//    public List<BeanShell> getPreBeanshell() {
//    	JSONArray hashtree=this.getHashtree();
//    	List<BeanShell> preBeanshell=new ArrayList<BeanShell>();
//    	if(hashtree.size()>0) {
//    	       for (Iterator<Object> iterator = hashtree.iterator(); iterator.hasNext();) {
//    	            JSONObject obj = (JSONObject)iterator.next();
//    	            
//    	            if(obj.getString("type").equals("PreExtract")) {
//    	            	JSONArray preBeanshellArray=obj.getJSONArray("BeanShellPreProcessor");
//    	            	if(preBeanshellArray.size()>0&&preBeanshellArray!=null)
//    	            		preBeanshell=(List<BeanShell>)JSONArray.parseArray(preBeanshellArray.toString(), BeanShell.class);
//    	            	break;
//    	            }
//    	            
//    	        }
//    	}
//    	return preBeanshell;
//    }
//    public List<BeanShell> getPostBeanshell() {
//    	JSONArray hashtree=this.getHashtree();
//    	List<BeanShell> postBeanshell=new ArrayList<BeanShell>();
//    	if(hashtree.size()>0) {
//    	       for (Iterator<Object> iterator = hashtree.iterator(); iterator.hasNext();) {
//    	            JSONObject obj = (JSONObject)iterator.next();
//    	            if(obj.getString("type").equals("PostExtract")) {
//    	            	JSONArray postBeanshellArray=obj.getJSONArray("BeanShellPostProcessor");
//    	            	if(postBeanshellArray.size()>0&&postBeanshellArray!=null)
//    	            		postBeanshell=(List<BeanShell>)JSONArray.parseArray(postBeanshellArray.toString(), BeanShell.class);
//    	            	break;
//    	            }
//    	            
//    	        }
//    	}
//    	return postBeanshell;
//    }
//    public List<JsonExtractor> getPostJson() {
//    	JSONArray hashtree=this.getHashtree();
//    	List<JsonExtractor> postBeanshell=new ArrayList<JsonExtractor>();
//    	if(hashtree.size()>0) {
//    	       for (Iterator<Object> iterator = hashtree.iterator(); iterator.hasNext();) {
//    	            JSONObject obj = (JSONObject)iterator.next();
//    	            if(obj.getString("type").equals("PostExtract")) {
//    	            	JSONArray postBeanshellArray=obj.getJSONArray("JSONExtractor");
//    	            	if(postBeanshellArray.size()>0&&postBeanshellArray!=null)
//    	            		postBeanshell=(List<JsonExtractor>)JSONArray.parseArray(postBeanshellArray.toString(), JsonExtractor.class);
//    	            	break;
//    	            }
//    	            
//    	        }
//    	}
//    	return postBeanshell;
//    }
//    public List<JdbcProcessor> getPostJdbc() {
//    	JSONArray hashtree=this.getHashtree();
//    	List<JdbcProcessor> postBeanshell=new ArrayList<JdbcProcessor>();
//    	if(hashtree.size()>0) {
//    	       for (Iterator<Object> iterator = hashtree.iterator(); iterator.hasNext();) {
//    	            JSONObject obj = (JSONObject)iterator.next();
//    	            if(obj.getString("type").equals("PostExtract")) {
//    	            	JSONArray postBeanshellArray=obj.getJSONArray("JDBCPostProcessor");
//    	            	if(postBeanshellArray.size()>0&&postBeanshellArray!=null)
//    	            		postBeanshell=(List<JdbcProcessor>)JSONArray.parseArray(postBeanshellArray.toString(), JdbcProcessor.class);
//    	            	break;
//    	            }
//    	            
//    	        }
//    	}
//    	return postBeanshell;
//    }
//    
    
    
    
    @JsonIgnore
    //当使用fastJson时，使用 @JSONField(serialize = false)
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
    
    
}
