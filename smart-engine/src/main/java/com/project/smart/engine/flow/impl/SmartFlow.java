package com.project.smart.engine.flow.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.project.smart.engine.flow.FlowDiagram;
import com.project.smart.engine.work.SmartWork;
import com.project.smart.engine.work.WorkJunction;

import lombok.Getter;
import lombok.Setter;

public class SmartFlow implements FlowDiagram {

	private Map<String, SmartWork> allWorkMap = new TreeMap<>();
	private Map<String, WorkJunction> allWorkJunction = new HashMap<>();

	@Setter
	@Getter
	private String startWorkId;

	@Getter
	private String flowId;

	public SmartWork getStartWork() {
		return this.allWorkMap.get(startWorkId);
	}

	public SmartWork getNextWork(SmartWork work) {

		WorkJunction workJunction = allWorkJunction.get(work.getWorkId());
		if (null == workJunction) {
			return null;
		}

		return this.allWorkMap.get(workJunction.getNextWorkId());

	}

	public void putWork(SmartWork work) {

		this.allWorkMap.put(work.getWorkId(), work);
	}

	public void putWorkJunction(SmartWork smartWork, WorkJunction workJunction) {
		this.allWorkJunction.put(smartWork.getWorkId(), workJunction);
	}

}
