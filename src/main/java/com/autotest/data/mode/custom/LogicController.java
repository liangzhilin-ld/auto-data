package com.autotest.data.mode.custom;


import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author liangzhilin
 * @since 2021-01-27
 */
@Getter
@Setter
public class LogicController {

  
    private String type="LogicController";
    private String name="逻辑控制器";
    /**
     * 场景ID
     */
//   @TableField("SCENARIO_ID")
    private Integer scenarioId;

    /**
     * IF控制器
     */
//    @TableField("IF_CONTROLLER")
    private String ifController;

    /**
     * 事务控制器
     */
//    @TableField("TRANSACTION_CONTROLLER")
    private String transactionController;


}
