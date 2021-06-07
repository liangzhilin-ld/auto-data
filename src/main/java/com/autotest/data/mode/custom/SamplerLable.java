package com.autotest.data.mode.custom;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Getter;
import lombok.Setter;

/**
 * 对象传给sampler lable属性，供SampleResult结果使用
 * @author Techstar
 *
 */
@Getter
@Setter
public class SamplerLable {
	/**
	 * 用例或场景ID
	 */
	@JSONField(ordinal = 1)
	private String CaseId;
	/**
	 * 模块ID
	 */
	@JSONField(ordinal = 2)
	private String suiteId;
	/**
	 * 用例或场景名称
	 */
	@JSONField(ordinal = 3)
	private String caseName;
	/**
	 * 用例或场景是否为公共登陆请求
	 */
	@JSONField(ordinal = 4)
	private Boolean isLogin=false;
}
