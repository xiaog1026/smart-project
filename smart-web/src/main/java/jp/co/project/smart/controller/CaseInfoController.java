package jp.co.project.smart.controller;

import jp.co.project.smart.mapper.CaseInfoMapper;
import jp.co.project.smart.model.ApiResponse;
import jp.co.project.smart.model.CaseDto;
import jp.co.project.smart.model.SearchCaseDto;
import jp.co.project.smart.model.SearchResultDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.csvreader.CsvWriter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/case")
public class CaseInfoController {

	@Autowired
	private CaseInfoMapper caseService;
	
	@PostMapping
	@Transactional(rollbackFor = Exception.class)
	public ApiResponse<Integer> addCaseInfo(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "file1", required = false) MultipartFile file1,
			@RequestParam(value = "file2", required = false) MultipartFile file2,
			@RequestParam("caseInfo") String caseInfo) {
		CaseDto caseDto = null;
		
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			caseDto = objectMapper.readValue(caseInfo, CaseDto.class);
			if (file1 != null) {
				Map<String, String> file1Map = uploadFile(request, file1);
				caseDto.setFile1Name(file1Map.get("fileName"));
				caseDto.setFile1Url(file1Map.get("fileUrl"));
			}

			if (file2 != null) {
				Map<String, String> file2Map = uploadFile(request, file2);
				caseDto.setFile2Name(file2Map.get("fileName"));
				caseDto.setFile2Url(file2Map.get("fileUrl"));
			}

			// TODO 
			caseDto.setShopCode("0021");
			caseDto.setShopName("大森支店");
			caseDto.setChargeName("田中");
			caseDto.setDebateKbn("1");
			caseDto.setFinishKbn("0");
			
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック e.printStackTrace();
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "Case saved successfully.", caseService.save(caseDto));
	}

	/**
	 * 住宅情報リストを取得する
	 * 
	 * @return 情報リスト
	 */
	@GetMapping("/caseSearch/{conditions}")
	public ApiResponse<List<SearchResultDto>> searchCaseByCondition(@PathVariable String conditions) {
		SearchCaseDto searchCase = null;

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			searchCase = objectMapper.readValue(conditions, SearchCaseDto.class);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		List<SearchResultDto> searchResults = caseService.searchCaseByCondition(searchCase);
		// return null;
		return new ApiResponse<>(HttpStatus.OK.value(), "Case list fetched successfully.", searchResults);
	}

	/**
	 * 案件情報を削除する
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/deleteCase/{id}")
	public ApiResponse<Void> deleteCase(@PathVariable int id) {
		CaseDto caseInfo = caseService.getCaseById(id);
		caseService.delete(id);

		if (caseInfo.getFile1Url() != null) {
			deleteFile(caseInfo.getFile1Url());
		}
		if (caseInfo.getFile2Url() != null) {
			deleteFile(caseInfo.getFile2Url());
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "Case deleted successfully.", null);
	}

	/**
	 * 案件情報を取得する
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/getCaseById/{id}")
	public ApiResponse<CaseDto> getCaseById(@PathVariable int id) {

		CaseDto caseInfo = new CaseDto();
		caseInfo = caseService.getCaseById(id);
		
		return new ApiResponse<>(HttpStatus.OK.value(), "Case fetched successfully.", caseInfo);

	}

	/**
	 * 案件情報を更新する
	 * 
	 * @param request
	 * @param response
	 * @param file1
	 * @param file2
	 * @param caseInfo
	 * @return
	 */
	@PostMapping("/updateCaseInfo")
	public ApiResponse<Integer> updateCaseInfo(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "file1", required = false) MultipartFile file1,
			@RequestParam(value = "file2", required = false) MultipartFile file2,
			@RequestParam("caseInfo") String caseInfo) {
		
		CaseDto caseDto = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			caseDto = objectMapper.readValue(caseInfo, CaseDto.class);

			if (caseDto.getFile1Url() != null && file1 != null) {
				deleteFile(caseDto.getFile1Url());
			}

			if (caseDto.getFile2Url() != null && file2 != null) {
				deleteFile(caseDto.getFile2Url());
			}

			if (file1 != null) {
				Map<String, String> file1Map = uploadFile(request, file1);
				caseDto.setFile1Name(file1Map.get("fileName"));
				caseDto.setFile1Url(file1Map.get("fileUrl"));
			}

			if (file2 != null) {
				Map<String, String> file2Map = uploadFile(request, file2);
				caseDto.setFile2Name(file2Map.get("fileName"));
				caseDto.setFile2Url(file2Map.get("fileUrl"));
			}
			caseDto.setShopCode("0021");
			caseDto.setShopName("大森支店");

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック e.printStackTrace();
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "Case saved successfully.", caseService.update(caseDto));
	}

	/**
	 * ファイルアップロード実装
	 * 
	 * @param request
	 * @param file
	 * @throws IOException
	 */
	private Map<String, String> uploadFile(HttpServletRequest request, MultipartFile file) throws IOException {
		String realName = file.getOriginalFilename();
		String fileName = null;
		String fileUrl = "";
		Map<String, String> resultMap = new HashMap<String, String>();
		try {
			if (realName != null && realName != "") {
				Date now = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
				String path = request.getSession().getServletContext().getRealPath("upload/imgs");
				String fileIndex = realName.substring(realName.lastIndexOf("."), realName.length());
				fileName = sdf.format(now) + fileIndex;

				StringBuffer filePath = new StringBuffer().append(path).append(File.separator);
				File uploadDir = new File(filePath.toString(), sdf.format(now));
				int prefix = 0;
				while (uploadDir.exists()) {
					prefix++;
					uploadDir = new File(filePath.toString() + sdf.format(now) + "-" + String.valueOf(prefix));
				}
				uploadDir.mkdirs();

				File targetFile = new File(uploadDir.getPath() + "/", fileName);

				byte[] bytes;
				System.out.println("upload mkdirs OK !!!!");
				bytes = file.getBytes();
				BufferedOutputStream uploadFileStream;

				uploadFileStream = new BufferedOutputStream(new FileOutputStream(targetFile));
				// TODO
				System.out.println(targetFile);
				fileUrl = uploadDir.getPath() + "\\" + fileName;
				resultMap.put("fileUrl", fileUrl);
				resultMap.put("fileName", realName);
				uploadFileStream.write(bytes);
				uploadFileStream.flush();
				uploadFileStream.close();
			}
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return resultMap;

	}

	/**
	 * PDF表示
	 * 
	 * @param request
	 * @param response
	 * @param fileName
	 * @throws Exception
	 */
	@GetMapping("/getPdfInfo/{fileName}")
	public void getPdfInfo(HttpServletRequest request, HttpServletResponse response, @PathVariable String fileName)
			throws Exception {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/pdf");
		String ctxPath = request.getSession().getServletContext().getRealPath("");
		String downLoadPath = ctxPath + "/upload/imgs/" + fileName + "/" + fileName + ".pdf";

		FileInputStream in = new FileInputStream(new File(downLoadPath));
		OutputStream out = response.getOutputStream();
		byte[] b = new byte[512];
		while ((in.read(b)) != -1) {
			out.write(b);
		}
		out.flush();
		in.close();
		out.close();
	}

	@GetMapping(value = "/downloadFiles/{id}", produces = "text/csv; charset=utf-8")
	@ResponseStatus(HttpStatus.OK)
	public Resource getFileFromFileSystem(HttpServletRequest request, @PathVariable int id,
			HttpServletResponse response) {
		Resource resource = null;
		try {
			File file = new File(request.getSession().getServletContext().getRealPath("") + "/upload/", "download.csv");
			CsvWriter csvWriter = new CsvWriter(file.getCanonicalPath(), ',', Charset.forName("UTF-8"));

			CaseDto caseInfo = new CaseDto();
			caseInfo = caseService.getCaseById(id);

			csvWriter.writeRecord(new String[] { "ID", String.valueOf(caseInfo.getId()) });
			csvWriter.writeRecord(new String[] { "案件番号", caseInfo.getCaseNum() });
			csvWriter.writeRecord(new String[] { "当初受託日", formartDateToString(caseInfo.getStartDate())});
			csvWriter.writeRecord(new String[] { "業務区分", caseInfo.getTaskKbn() });
			csvWriter.writeRecord(new String[] { "氏名", caseInfo.getName() });
			csvWriter.writeRecord(new String[] { "フリガナ", caseInfo.getFurigana() });
			csvWriter.writeRecord(new String[] { "お客さま番号ー名義", caseInfo.getCustomNum() });
			csvWriter.writeRecord(new String[] { "CIF番号", caseInfo.getCifNum() });
			csvWriter.close();

			response.setContentType("text/csv; charset=utf-8");
			response.setHeader("Content-Disposition", "attachment; filename=" + String.valueOf(caseInfo.getCaseNum()));
			response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
			response.setHeader("filename", String.valueOf(caseInfo.getCaseNum()));
			response.setHeader("Access-Control-Expose-Headers", "filename");

			resource = new FileSystemResource(file);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return resource;

	}

	/**
	 * ファイル削除
	 *
	 * @param fileName ファイル名
	 */
	private boolean deleteFile(String fileName) {
		File file = new File(fileName);
		File fileDir = new File(fileName.substring(0, fileName.lastIndexOf(File.separator)));
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				fileDir.delete();
				System.out.println("delete" + fileName + "success");
				return true;
			} else {
				System.out.println("delete" + fileName + "fail");
				return false;
			}
		} else {
			System.out.println("no file" + fileName);
			return false;
		}
	}


	/**
	 * Dateフォーマット
	 * 
	 * @param date
	 * @return
	 */
	private String formartDateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String dateString = "";
		if (date!=null) {
			dateString = sdf.format(date);
		}
		return dateString;
	}
}
