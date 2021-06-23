package com.project.smart.engine.flow;

import com.project.smart.engine.work.SmartWork;

public interface FlowDiagram {
	String getFlowId();

	SmartWork getStartWork();

	SmartWork getNextWork(SmartWork work);

}
