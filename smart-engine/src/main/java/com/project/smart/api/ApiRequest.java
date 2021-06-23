package com.project.smart.api;

import org.springframework.web.util.pattern.PathPattern.PathMatchInfo;

import com.project.smart.api.dispatcher.ApiDefine;

import lombok.Data;

@Data
public class ApiRequest {

	PathMatchInfo pathMatchInfo;

	ApiDefine apiDefine;

}
