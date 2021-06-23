package com.project.smart.engine.flow.impl;

import com.project.smart.engine.flow.FlowDispatcher;

public class SmartFlowUnit {

	private FlowDispatcher dispatcher;

	public SmartFlowUnit(FlowDispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}

	
	public String findNextWorkId() {
		
		return this.dispatcher.findNextWorkId();
	}
}
