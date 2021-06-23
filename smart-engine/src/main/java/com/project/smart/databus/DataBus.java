package com.project.smart.databus;

import com.project.smart.engine.work.SmartWork;
import com.project.smart.engine.work.WorkResult;

public interface DataBus {

	void initInputWorkData(String flowId,SmartWork work);

	void outputWorkData(WorkResult result);

}
