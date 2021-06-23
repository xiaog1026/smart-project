package com.project.smart.engine.work.impl;

import com.project.smart.engine.work.SmartWork;
import com.project.smart.engine.work.WorkBase;
import com.project.smart.engine.work.WorkJunction;

public class SampleWorkJunction extends WorkBase implements WorkJunction {

	private String nextWorkId;

	@Override
	public String getNextWorkId() {

		return this.nextWorkId;
	}

	public void setNextWorkId(SmartWork smartWork) {
		this.nextWorkId = smartWork.getWorkId();
	}

	public void setNextWorkId(String nextWorkId) {
		this.nextWorkId = nextWorkId;
	}

}
