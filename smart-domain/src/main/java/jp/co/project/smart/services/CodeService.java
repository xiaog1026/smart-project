package jp.co.project.smart.services;

import java.util.List;

import jp.co.project.smart.model.CodeMasterVo;

public interface CodeService {
    int registerCode(CodeMasterVo codeMasterVo);

	List<CodeMasterVo> selectCodeBywordId(int wordId);

	CodeMasterVo selectCodeByCodeId(int codeId);

	int modifyCode(CodeMasterVo codeMasterVo);
	
	int deleteCode(CodeMasterVo codeMasterVo);
}
