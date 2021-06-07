package com.autotest.data.mode;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.List;

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
 * @since 2020-11-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class TestSuites extends Model {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;
    @TableId("PROJECT_ID")
    private Integer projectId;
    @TableField("PARENT_ID")
    private Integer parentId;

    @TableField("`NAME`")
    private String name;

    /**
     * API/UI测试
     */
    @TableField("TYPE")
    private String type;

    @TableField("`DESC`")
    private String desc;

}
