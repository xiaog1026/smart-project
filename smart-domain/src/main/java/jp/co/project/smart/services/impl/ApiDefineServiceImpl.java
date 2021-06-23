package jp.co.project.smart.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jp.co.project.smart.autogen.mapper.ApiDefineMapper;
import jp.co.project.smart.autogen.model.ApiDefine;
import jp.co.project.smart.services.ApiDefineService;


public class ApiDefineServiceImpl implements ApiDefineService{
	
	@Autowired
	private ApiDefineMapper apiDefineMapper;

	public ApiDefine getApiDefineByApiId(String apiId) {
		return apiDefineMapper.selectByPrimaryKey(apiId);
	}
	
	public List<ApiDefine> getAllApiDefineList(){
		List<ApiDefine> list = new ArrayList<>();
		apiDefineMapper.selectByExample(null).iterator().forEachRemaining(list::add);
		return list;
	}
	
	public boolean saveApiDefine(ApiDefine apiDefine) {
		 apiDefineMapper.insert(apiDefine);
		 return true;
	}
	
	public boolean updateApiDefine(ApiDefine apiDefine) {
		apiDefineMapper.updateByPrimaryKey(apiDefine);
		return true;
	}

}
