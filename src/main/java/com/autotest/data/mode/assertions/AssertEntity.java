package com.autotest.data.mode.assertions;

import java.util.List;

import com.autotest.data.mode.custom.BeanShell;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;

import io.swagger.annotations.ApiModel;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

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
@ApiModel("断言")
public class AssertEntity{


	private String type="Assertions";
	private String name="校验";
    /**
     * 响应断言ResponseAssertion
     */

    private List<ResponseAssertion> responseAssertion;

    /**
     * beanshell断言
     */
    private List<BeanShell> beanShellAssertion;

    /**
     * json断言
     */
//    @TableField(value="JSON_ASSERTION", typeHandler =  FastjsonTypeHandler.class)
    private List<JsonAssertion> jsonAssertion;

    /**
     * js断言
     */

    private String jsr223Assertion;

    /**
     * xpath断言
     */

    private String xpathAssertion;

    /**
     * SCHEMA断言
     */

    private String schema;

   


}
