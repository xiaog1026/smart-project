package com.project.smart.engine.work.base;

import java.math.BigDecimal;
import java.util.Map;

import lombok.Data;

@Data
public abstract class WorkBaseB {

	private Long quantity;

	private BigDecimal price;

	private Map<String, Object> allValuesMap;

	public WorkBaseB() {
		this.allValuesMap.put("quantity", quantity);
		this.allValuesMap.put("price", price);

	}

}
