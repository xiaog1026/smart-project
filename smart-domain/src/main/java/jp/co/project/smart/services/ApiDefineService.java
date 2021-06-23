package jp.co.project.smart.services;

import java.util.List;
import jp.co.project.smart.autogen.model.ApiDefine;


public interface ApiDefineService {

	ApiDefine getApiDefineByApiId(String apiId);
	
	List<ApiDefine> getAllApiDefineList();
	
	boolean saveApiDefine(ApiDefine apiDefine);
	
	boolean updateApiDefine(ApiDefine apiDefine);

}
