package com.project.smart.engine.work.base;

import java.util.Map;

import lombok.Data;

@Data
public abstract class WorkBaseA {

	private Integer age;
	private String name;
	private Long salary;

	private Map<String, Object> allValuesMap;

	public WorkBaseA() {
		this.allValuesMap.put("age", age);
		this.allValuesMap.put("name", name);
		this.allValuesMap.put("salary", salary);

	}

}
