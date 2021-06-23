package com.project.smart.engine.work.result.impl;

import com.project.smart.engine.work.WorkResult;

public class SmartWorkResult implements WorkResult {
	private ResultStatus status;
	private Throwable error;
	private Object result;

	public ResultStatus getStatus() {
		return status;
	}

	public Throwable getError() {
		return error;
	}

	@Override
	public String toString() {
		return "DefaultWorkReport {" + "status=" + status + ", context=" + ", error=" + (error == null ? "''" : error)
				+ '}';
	}

	@Override
	public void setWorkResult(Object result) {
		this.result = result;

	}

	@Override
	public void setResultStatus(ResultStatus status) {
		this.status = status;

	}

	@Override
	public Object getWorkResult() {

		return this.result;
	}

	@Override
	public ResultStatus getResultStatus() {
		
		return this.status;
	}

}
