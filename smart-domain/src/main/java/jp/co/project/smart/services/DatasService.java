package jp.co.project.smart.services;

import java.util.List;

import jp.co.project.smart.autogen.model.WordDictionary;
import jp.co.project.smart.model.QueryParams;
import jp.co.project.smart.model.RegisterWordDictionary;

public interface DatasService {
	
	List<WordDictionary> searchDatas(QueryParams queryParams);
	
	//List<WordDictionary> searchDatasByCondition(String condition);
	
	
	int registerDatas(RegisterWordDictionary registerWordDictionary);

	WordDictionary selectWordBywordId(int queryWordId);

	int modifyDatas(RegisterWordDictionary modifyWordDictionary);

	int deleteData(int deleteWordId);

}
