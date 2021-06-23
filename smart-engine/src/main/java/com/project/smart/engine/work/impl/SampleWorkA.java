package com.project.smart.engine.work.impl;

import com.project.smart.engine.work.SmartWork;
import com.project.smart.engine.work.WorkResult;
import com.project.smart.engine.work.base.WorkBaseA;
import com.project.smart.engine.work.result.impl.ResultStatus;
import com.project.smart.engine.work.result.impl.SmartWorkResult;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SampleWorkA extends WorkBaseA implements SmartWork {

	private String workId = "sampleWorkA";

	@Override
	public WorkResult execute() {
		WorkResult wr = new SmartWorkResult();
		wr.setResultStatus(ResultStatus.OK);
		wr.setWorkResult("I am Sample Work A");
		System.out.println(wr.getWorkResult());
		return wr;
	}

}
