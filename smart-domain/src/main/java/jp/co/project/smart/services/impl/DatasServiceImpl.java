package jp.co.project.smart.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.project.smart.autogen.mapper.WordDictionaryMapper;
import jp.co.project.smart.autogen.model.WordDictionary;
import jp.co.project.smart.autogen.model.WordDictionaryExample;
import jp.co.project.smart.autogen.model.WordDictionaryExample.Criteria;
import jp.co.project.smart.model.QueryParams;
import jp.co.project.smart.model.RegisterWordDictionary;
import jp.co.project.smart.services.DatasService;
@Service
public class DatasServiceImpl implements DatasService{

	@Autowired
	private WordDictionaryMapper wordDictionaryMapper;


	public DatasServiceImpl(WordDictionaryMapper wordDictionaryMapper) {
		this.wordDictionaryMapper = wordDictionaryMapper;
	}

	@Override
	public List<WordDictionary> searchDatas(QueryParams queryParams) {
		WordDictionaryExample example = new WordDictionaryExample();
		Criteria criteria = example.createCriteria();
		if (!queryParams.getKeyWord().equals("")) {
			if (queryParams.getQueryOption().equals("option2")) {
				criteria.andPhysicalNameLike("%"+queryParams.getKeyWord()+"%");
			}else {
				criteria.andPhysicalNameLike(queryParams.getKeyWord()+"%");
			}
		}
		return this.wordDictionaryMapper.selectByExample(example);
	}

	@Override
	public int registerDatas(RegisterWordDictionary registerWordDictionary) {
		if(!(registerWordDictionary.getPhysicalName().equals("")&&registerWordDictionary.getWordType().equals(""))) {
			WordDictionary record = new WordDictionary();
			record.setArrayFlg(registerWordDictionary.isArrayFlg());
			record.setCreateTime(new Date());
			record.setDescription(registerWordDictionary.getDescription());
			record.setLogicName(registerWordDictionary.getLogicName());
			record.setPhysicalName(registerWordDictionary.getPhysicalName());
			record.setWordDecimal(registerWordDictionary.getWordDecimal());
			record.setWordLength(registerWordDictionary.getWordLength());
			record.setWordType(registerWordDictionary.getWordType());
			return this.wordDictionaryMapper.insertSelective(record);
		}else {
			return 0;
		}
	}

	public WordDictionary selectWordBywordId(int queryWordId){
		return this.wordDictionaryMapper.selectByPrimaryKey(queryWordId);
	}

	public int modifyDatas(RegisterWordDictionary modifyWordDictionary){
		if(!(modifyWordDictionary.getPhysicalName().equals("")&&modifyWordDictionary.getWordType().equals(""))) {
			WordDictionary record = new WordDictionary();
			record.setWordId(modifyWordDictionary.getWordId());
			record.setArrayFlg(modifyWordDictionary.isArrayFlg());
			record.setCreateTime(new Date());
			record.setDescription(modifyWordDictionary.getDescription());
			record.setLogicName(modifyWordDictionary.getLogicName());
			record.setPhysicalName(modifyWordDictionary.getPhysicalName());
			record.setWordDecimal(modifyWordDictionary.getWordDecimal());
			record.setWordLength(modifyWordDictionary.getWordLength());
			record.setWordType(modifyWordDictionary.getWordType());
			return this.wordDictionaryMapper.updateByPrimaryKey(record);
		}else {
			return 0;
		}
	}

	public int deleteData(int deleteWordId){
		return this.wordDictionaryMapper.deleteByPrimaryKey(deleteWordId);
	}


}
