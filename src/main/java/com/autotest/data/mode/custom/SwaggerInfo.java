package com.autotest.data.mode.custom;

//import lombok.Data;
//@Data
public class SwaggerInfo {
	private String url;	
	//api 手动增加前缀
	private String prefix="";
	private String serviceName;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
}
