package com.project.smart.engine.work.base;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public abstract class WorkBaseC {

	private Map<String, Object> allValuesMap;

	private List<String> valueList;

	public WorkBaseC() {
		this.allValuesMap.put("valueList", valueList);

	}

}
