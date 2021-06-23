package jp.co.project.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.project.smart.model.ApiResponse;
import jp.co.project.smart.model.QueryParams;
import jp.co.project.smart.model.RegisterWordDictionary;
import jp.co.project.smart.services.DatasService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/data")
public class DataController {
	@Autowired
	private DatasService datasService;

	@PostMapping("/searchDatas")
	public ApiResponse<?> searchDatas(@RequestBody QueryParams queryParams) {
		return ApiResponse.ok(datasService.searchDatas(queryParams));
	}
	
	@PostMapping("/registerDatas")
	public ApiResponse<?> registerDatas(@RequestBody RegisterWordDictionary registerWordDictionary) {
		return ApiResponse.ok(datasService.registerDatas(registerWordDictionary));
	}

	@PostMapping("/selectWordBywordId")
	public ApiResponse<?> selectWordBywordId(@RequestBody int queryWordId) {
		return ApiResponse.ok(datasService.selectWordBywordId(queryWordId));
	}

	@PostMapping("/modifyDatas")
	public ApiResponse<?> modifyDatas(@RequestBody RegisterWordDictionary modifyWordDictionary) {
		return ApiResponse.ok(datasService.modifyDatas(modifyWordDictionary));
	}

	@PostMapping("/deleteData")
	public ApiResponse<?> deleteData(@RequestBody int deleteWordId) {
		return ApiResponse.ok(datasService.deleteData(deleteWordId));
	}

}
