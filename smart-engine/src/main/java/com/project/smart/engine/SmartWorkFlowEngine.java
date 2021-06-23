package com.project.smart.engine;

import com.project.smart.engine.flow.FlowDiagram;
import com.project.smart.engine.work.WorkResult;

public interface SmartWorkFlowEngine {
	WorkResult start(FlowDiagram workFlow);
}
