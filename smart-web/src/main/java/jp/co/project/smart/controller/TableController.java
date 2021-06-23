package jp.co.project.smart.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jp.co.project.smart.autogen.model.TableMaster;
import jp.co.project.smart.ermaster.model.ERMaster;
import jp.co.project.smart.model.ApiResponse;
import jp.co.project.smart.model.QueryParams;
import jp.co.project.smart.services.ERMasterService;
import jp.co.project.smart.services.TablesService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/table")
public class TableController {

	@Autowired
	private TablesService tablesService;
	
	@Autowired
	private ERMasterService eRMasterService;

	@GetMapping("/searchAllTables")
	public ApiResponse<?> searchAllTables() {
		return ApiResponse.ok(tablesService.searchAllTables());
	}
	
	@PostMapping("/upload")
	public ApiResponse<?> upload(MultipartFile file) {
		
		ERMaster eRMaster;
		try {
			eRMaster = eRMasterService.getERMaster(file.getInputStream());
			if (eRMaster != null) {
				eRMasterService.saveERMaster(eRMaster);
			}
		} catch (IOException e) {
		}
		return ApiResponse.ok(true);
	}

	@PostMapping("/searchTables")
	public ApiResponse<?> searchTables(@RequestBody QueryParams queryParams) {
		return ApiResponse.ok(tablesService.searchTables(queryParams));
	}
	
	@PostMapping("/registerTable")
	public ApiResponse<?> registerTable(@RequestBody TableMaster tableMaster) {
		return ApiResponse.ok(tablesService.registerTable(tableMaster));
	}
	
	@PostMapping("/searchTable")
	public ApiResponse<?> searchTable(@RequestBody int tableId) {
		return ApiResponse.ok(tablesService.searchTable(tableId));
	}
	
	@PostMapping("/modifyTable")
	public ApiResponse<?> modifyTable(@RequestBody TableMaster tableMaster) {
		return ApiResponse.ok(tablesService.modifyTable(tableMaster));
	}
}
