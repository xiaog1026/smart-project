package jp.co.project.smart.controller;

import jp.co.project.smart.mapper.JyutakuMapper;
import jp.co.project.smart.model.ApiResponse;
import jp.co.project.smart.model.JyutakuDto;
import jp.co.project.smart.model.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/jyutaku")
public class JutakuInfoController {

	@Autowired
	private JyutakuMapper jyutakuService;

	@PostMapping
	public ApiResponse<Integer> uploadFile(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("imgFile") MultipartFile file, @RequestParam("addFileForm") String jyukaJson) {
		ObjectMapper objectMapper = new ObjectMapper();
		JyutakuDto jyutakuDto = null;
		try {
			jyutakuDto = objectMapper.readValue(jyukaJson, JyutakuDto.class);
			System.out.println(file);
			System.out.println(jyukaJson);
			if (file.isEmpty()) {
				// stop
			}
			String imgUrl =  uploadFile(request, file);
			System.out.println("====================");
			System.out.println(imgUrl);
			System.out.println("====================");
			jyutakuDto.setUrl(imgUrl);
			System.out.println(jyutakuDto.getUrl());
			//jyutakuDto.setId(1);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		// return null;
		 return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",jyutakuService.save(jyutakuDto));
	}
	
	/**
	 * 住宅情報リストを取得する
	 * @return 情報リスト
	 */
	@GetMapping
    public ApiResponse<List<JyutakuDto>> getJyutakuList(){
        return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.",jyutakuService.findAll());
    }
	
	
	/**
	 * 住宅情報を削除する
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable int id) {
		jyutakuService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "User deleted successfully.", null);
    }
	
	/**
	   * 住宅情報を取得する
	 * @param id
	 * @return
	 */
    @GetMapping("/{id}")
    public ApiResponse<JyutakuDto> getOne(@PathVariable int id){
    	JyutakuDto uto = jyutakuService.findById(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "User fetched successfully.",uto);
        
        
    }
	/**
	　 * ファイルアップロード実装
	 * @param request
	 * @param file
	 * @throws IOException
	 */
	private String uploadFile(HttpServletRequest request, MultipartFile file) throws IOException {
		String fileName = file.getOriginalFilename();
		String imgUrl = "";
		try {
			if (fileName != null && fileName != "") {
			// TODO
			//String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			//		+ request.getContextPath() + "/upload/imgs/";
				Date now = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
				String path = request.getSession().getServletContext().getRealPath("upload/imgs");
				String fileIndex = fileName.substring(fileName.lastIndexOf("."), fileName.length());
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
				imgUrl = uploadDir.getPath() + "\\" + fileName;
				uploadFileStream.write(bytes);
				uploadFileStream.flush();
				uploadFileStream.close();
			}
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return imgUrl;
		
	}

//	private File mkdirs(StringBuffer filePath) {
//		Date now = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
//		File uploadDir = new File(filePath.toString(), sdf.format(now));
//
//		int prefix = 0;
//		while (uploadDir.exists()) {
//			prefix++;
//			uploadDir = new File(filePath.toString() + sdf.format(now) + "-" + String.valueOf(prefix));
//		}
//		uploadDir.mkdirs();
//		return uploadDir;
//
//	}
}
