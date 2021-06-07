package com.autotest.data.mode.confelement;

import java.util.List;


import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ConfElementEntity {
	private String type="ConfElements";
	private String name="配置元件";
	private List<ApiHeader> headers;
	private List<UserDefinedVariable> userDefinedVar;

}
