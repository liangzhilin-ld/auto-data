package com.autotest.data.mode.assertions;



import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class JsonAssertion {
    //@TableField("NAME")
    private String name;

    //@TableField("CASE_ID")
//    private Integer caseId;

    //@TableField("JSON_PATH")
    private String jsonPath;

    //@TableField("ADD_ASSERT_VALUE")
    private boolean addAssertValue;

    //@TableField("EXPECTED_VALUE")
    private String expectedValue;

    //@TableField("EXPECTED_NULL")
    private boolean expectedNull;

    //@TableField("INVERT_ASSERT")
    private boolean invertAssert;
    private String type="JSONAssertion";
}
