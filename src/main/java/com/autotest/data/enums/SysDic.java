package com.autotest.data.enums;

public enum SysDic {    
	scheduled_task_status(1), 
    DB_TYPE(2), 
    processor_type(3), 
    pre_processor(4),
	post_processor(5),
	assertion_type(6),
	Configuration_type(7),
	task_trigger_mode(8),
	Test_field(9),
	Matching_rules(10),
	Apply_To(11),
	Query_type(12);
	
    private Integer id;
    SysDic(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    
}
