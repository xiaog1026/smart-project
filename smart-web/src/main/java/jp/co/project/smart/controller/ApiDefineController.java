package jp.co.project.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jp.co.project.smart.autogen.model.ApiDefine;
import jp.co.project.smart.model.ApiResponse;
import jp.co.project.smart.services.ApiDefineService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/apiDefine")
public class ApiDefineController {

	@Autowired
	private ApiDefineService apiDefineService;

	@PostMapping("/getAllApiDefineList")
	public ApiResponse<?> getAllApiDefineList() {
		return ApiResponse.ok(apiDefineService.getAllApiDefineList());
	}
	
	@PostMapping("/getApiDefineByApiId")
	public ApiResponse<?> getApiDefineByApiId(@RequestBody String apiId) {
		return ApiResponse.ok(apiDefineService.getApiDefineByApiId(apiId));
	}
	
	@PostMapping("/saveApiDefine")
	public ApiResponse<?> saveApiDefine(@RequestBody ApiDefine apiDefine) {
		return ApiResponse.ok(apiDefineService.saveApiDefine(apiDefine));
	}
	
	@PostMapping("/updateApiDefine")
	public ApiResponse<?> modifyTable(@RequestBody ApiDefine apiDefine) {
		return ApiResponse.ok(apiDefineService.updateApiDefine(apiDefine));
	}

}
