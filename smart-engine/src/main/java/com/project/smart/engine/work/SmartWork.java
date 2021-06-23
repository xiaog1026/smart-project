package com.project.smart.engine.work;

import java.util.UUID;

public interface SmartWork {

	default String getName() {
		return UUID.randomUUID().toString();
	}

	default String getWorkId() {
		return UUID.randomUUID().toString();
	}

	default void setWorkId(String workId) {

	}

	default String getConditionCode() {
		return "";
	}

	default boolean isEndWork() {
		return false;
	}

	WorkResult execute();

}
