package jp.co.project.smart.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.project.smart.autogen.mapper.CodeMasterMapper;
import jp.co.project.smart.autogen.model.CodeMaster;
import jp.co.project.smart.autogen.model.CodeMasterExample;
import jp.co.project.smart.autogen.model.CodeMasterExample.Criteria;
import jp.co.project.smart.model.CodeMasterVo;
import jp.co.project.smart.services.CodeService;

/**
 * CodeService
 * 
 * @author InnoX01
 *
 */
@Service
public class CodeServiceImpl implements CodeService {

	@Autowired
	private CodeMasterMapper codeMasterMapper;

	/**
	 * code登録
	 */
	@Override
	public int registerCode(CodeMasterVo codeMasterVo) {
		int i = 0;
		if (codeMasterVo != null) {
			CodeMaster codeMaster = new CodeMaster();
			codeMaster.setCodeId(codeMasterVo.getCodeId());
			codeMaster.setWordId(codeMasterVo.getWordId());
			codeMaster.setLogicCodeName(codeMasterVo.getValueLogicName());
			codeMaster.setPhysicalCodeName(codeMasterVo.getValuePhysicalName());
			i = codeMasterMapper.insert(codeMaster);
		} else {
			i = 0;
		}
		return i;
	}

	/**
	 * code一覧
	 */
	@Override
	public List<CodeMasterVo> selectCodeBywordId(int wordId) {
		List<CodeMasterVo> codeMasterVos = new ArrayList<>();
		CodeMasterExample codeMasterExample = new CodeMasterExample();
		Criteria criteria = codeMasterExample.createCriteria();
		criteria.andWordIdEqualTo(wordId);
		List<CodeMaster> codeMasters = codeMasterMapper.selectByExample(codeMasterExample);
		for (CodeMaster codeMaster : codeMasters) {
			CodeMasterVo codeMasterVo = new CodeMasterVo();
			codeMasterVo.setCodeId(codeMaster.getCodeId());
			codeMasterVo.setWordId(codeMaster.getWordId());
			codeMasterVo.setCodeNo(0);
			codeMasterVo.setValueLogicName(codeMaster.getLogicCodeName());
			codeMasterVo.setValuePhysicalName(codeMaster.getPhysicalCodeName());
			codeMasterVo.setDescription("TODO");
			codeMasterVos.add(codeMasterVo);
		}
		return codeMasterVos;
	}

	/**
	 * code改修
	 */
	@Override
	public CodeMasterVo selectCodeByCodeId(int codeId) {
		// TODO Auto-generated method stub
		CodeMaster codeMaster = codeMasterMapper.selectByPrimaryKey(codeId);
		CodeMasterVo codeMasterVo = new CodeMasterVo();
		codeMasterVo.setCodeId(codeMaster.getCodeId());
		codeMasterVo.setWordId(codeMaster.getWordId());
		codeMasterVo.setCodeNo(0);
		codeMasterVo.setValueLogicName(codeMaster.getLogicCodeName());
		codeMasterVo.setValuePhysicalName(codeMaster.getPhysicalCodeName());
		codeMasterVo.setDescription("TODO");
		return codeMasterVo;
	}

	/**
	 * 
	 */
	@Override
	public int modifyCode(CodeMasterVo codeMasterVo) {
		int i = 0;
		if (codeMasterMapper.selectByPrimaryKey(codeMasterVo.getCodeId()) != null) {
			CodeMaster codeMaster = new CodeMaster();
			codeMaster.setCodeId(codeMasterVo.getCodeId());
			codeMaster.setWordId(codeMasterVo.getWordId());
			codeMaster.setLogicCodeName(codeMasterVo.getValueLogicName());
			codeMaster.setPhysicalCodeName(codeMasterVo.getValuePhysicalName());
			codeMaster.setUpdateUser("sessionUser");
			codeMaster.setUpdateTime(new Date());
			codeMasterMapper.updateByPrimaryKey(codeMaster);
			i = 1;
		} else {
			i = 0;
		}
		return i;
	}

	@Override
	public int deleteCode(CodeMasterVo codeMasterVo) {
		int i = 0;
		if (codeMasterMapper.selectByPrimaryKey(codeMasterVo.getCodeId()) != null) {
			i = codeMasterMapper.deleteByPrimaryKey(codeMasterVo.getCodeId());
		} else {
			i = 0;
		}
		return i;
	}

}
