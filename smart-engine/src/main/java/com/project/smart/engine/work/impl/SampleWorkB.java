package com.project.smart.engine.work.impl;

import com.project.smart.engine.work.SmartWork;
import com.project.smart.engine.work.WorkResult;
import com.project.smart.engine.work.base.WorkBaseB;
import com.project.smart.engine.work.result.impl.ResultStatus;
import com.project.smart.engine.work.result.impl.SmartWorkResult;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SampleWorkB extends WorkBaseB implements SmartWork {

	private String workId = "sampleWorkB";

	@Override
	public WorkResult execute() {
		WorkResult wr = new SmartWorkResult();
		wr.setResultStatus(ResultStatus.OK);
		wr.setWorkResult("I am Sample Work B");
		System.out.println(wr.getWorkResult());
		return wr;
	}

}
