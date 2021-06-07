package com.autotest.data.mode.custom;

import java.util.List;
import lombok.Data;

@Data
public class CaseList {
	List<Integer> samplerIds;
	List<Integer> scenarioIds;
}
