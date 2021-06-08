package com.autotest.data.mode.custom;

import lombok.Data;
@Data
public class SwaggerInfo {
	private String url;	
	//api 手动增加前缀
	private String prefix="";
	private String serviceName;
}
