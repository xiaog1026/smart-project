
package com.project.smart.engine.impl;

import com.project.smart.databus.DataBus;
import com.project.smart.engine.SmartWorkFlowEngine;
import com.project.smart.engine.flow.FlowDiagram;
import com.project.smart.engine.work.SmartWork;
import com.project.smart.engine.work.WorkResult;
import com.project.smart.engine.work.result.ResultMaker;

import lombok.Setter;

public class SmartWorkFlowEngineImpl implements SmartWorkFlowEngine {

	@Setter
	private DataBus dataBus;

	@Setter
	private ResultMaker resultMaker;

	@Override
	public WorkResult start(FlowDiagram flow) {

		SmartWork work = flow.getStartWork();
		String flowId = flow.getFlowId();

		while (null != work && !work.isEndWork()) {
			// 入力データを初期化
			this.dataBus.initInputWorkData(flowId, work);
			WorkResult result = work.execute();
			// 結果をアウトプット
			this.dataBus.outputWorkData(result);

			work = flow.getNextWork(work);
		}

//		return this.resultMaker.makeResult();
		return null;
	}

}
