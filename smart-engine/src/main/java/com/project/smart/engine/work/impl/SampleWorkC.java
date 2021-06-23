package com.project.smart.engine.work.impl;

import com.project.smart.engine.work.SmartWork;
import com.project.smart.engine.work.WorkResult;
import com.project.smart.engine.work.base.WorkBaseC;
import com.project.smart.engine.work.result.impl.ResultStatus;
import com.project.smart.engine.work.result.impl.SmartWorkResult;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SampleWorkC extends WorkBaseC implements SmartWork {

	private String workId = "sampleWorkC";

	@Override
	public WorkResult execute() {
		WorkResult wr = new SmartWorkResult();
		wr.setResultStatus(ResultStatus.OK);
		wr.setWorkResult("I am Sample Work C");
		System.out.println(wr.getWorkResult());
		return wr;
	}

}
