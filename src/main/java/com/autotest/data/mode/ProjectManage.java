package com.autotest.data.mode;

import java.util.List;

import com.autotest.data.mode.confelement.ApiHeader;
import com.autotest.data.mode.confelement.UserDefinedVariable;
import com.autotest.data.mode.custom.SwaggerInfo;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * <p>
 * 
 * </p>
 *value = "project_manage",
 * @author liangzhilin
 * @since 2020-11-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName(autoResultMap = true)
public class ProjectManage extends Model {
    private static final long serialVersionUID = 1L;
    
    @TableId(value="PROJECT_ID",type = IdType.AUTO)
    private Integer projectId;

    @TableField("PROJECT_NAME")
    private String projectName;
//
//    /**
//     * 接口host
//     */
//    @TableField("TEST_IP")
//    private String testIp;
//
//    /**
//     * 接口PORT
//     */
//    @TableField("TEST_PORT")
//    private String testPort;

	
	@TableField(value="HEADERS", typeHandler =  FastjsonTypeHandler.class)
	private List<ApiHeader> headers;
	
	@TableField(value="ARGUMENTS", typeHandler =  FastjsonTypeHandler.class)
	private List<UserDefinedVariable> arguments;
    @TableField("PROJECT_DESC")
    private String projectDesc;
    
    @TableField(value="SWAGGER_URL", typeHandler =  FastjsonTypeHandler.class)
    private List<SwaggerInfo> swaggerUrl;

}
