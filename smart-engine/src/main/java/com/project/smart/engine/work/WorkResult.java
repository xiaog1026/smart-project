package com.project.smart.engine.work;

import com.project.smart.engine.work.result.impl.ResultStatus;

public interface WorkResult {

	void setWorkResult(Object result);

	Object getWorkResult();

	void setResultStatus(ResultStatus status);

	ResultStatus getResultStatus();

}
