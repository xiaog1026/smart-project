package jp.co.project.smart.controller;

import jp.co.project.smart.model.ApiResponse;
import jp.co.project.smart.model.CodeMasterVo;
import jp.co.project.smart.services.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/code")
public class CodeController {
    @Autowired
    private CodeService codeService;

    @PostMapping("/registerCode")
    public ApiResponse<?> registerCode (@RequestBody CodeMasterVo codeMasterVo){
        return ApiResponse.ok(codeService.registerCode(codeMasterVo));
    }
    
    @PostMapping("/selectCodeBywordId")
    public ApiResponse<?> selectCodeBywordId (@RequestBody int wordId){
        return ApiResponse.ok(codeService.selectCodeBywordId(wordId));
    }
    
    @PostMapping("/selectCodeByCodeId")
    public ApiResponse<?> selectCodeByCodeId (@RequestBody int codeId){
        return ApiResponse.ok(codeService.selectCodeByCodeId(codeId));
    }
    
    @PostMapping("/modifyCode")
    public ApiResponse<?> modifyCode (@RequestBody CodeMasterVo codeMasterVo){
        return ApiResponse.ok(codeService.modifyCode(codeMasterVo));
    }
    
    @PostMapping("/deleteCode")
    public ApiResponse<?> deleteCode (@RequestBody CodeMasterVo codeMasterVo){
        return ApiResponse.ok(codeService.deleteCode(codeMasterVo));
    }
}
