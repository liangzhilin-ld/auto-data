package com.autotest.data.mode;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2021-03-03
 */
@SuppressWarnings("rawtypes")
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
//@Repository
public class PublicVariable extends Model {

    private static final long serialVersionUID = 1L;

    @TableId(value="VAR_ID",type = IdType.AUTO)
    private Integer varId;

    @TableField("VAR_NAME")
    private String varName;

    @TableField("VAR_TYPE")
    private String varType;

    @TableField("VAR_KEY")
    private String varKey;

    @TableField("VAR_VALUE")
    private String varValue;


}
