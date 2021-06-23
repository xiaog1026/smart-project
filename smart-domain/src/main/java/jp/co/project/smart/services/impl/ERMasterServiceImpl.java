package jp.co.project.smart.services.impl;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.project.smart.autogen.mapper.ColumnMasterMapper;
import jp.co.project.smart.autogen.mapper.TableMasterMapper;
import jp.co.project.smart.autogen.mapper.WordDictionaryMapper;
import jp.co.project.smart.autogen.model.ColumnMaster;
import jp.co.project.smart.autogen.model.TableMaster;
import jp.co.project.smart.autogen.model.WordDictionary;
import jp.co.project.smart.ermaster.ERMasterLoader;
import jp.co.project.smart.ermaster.model.ERMaster;
import jp.co.project.smart.services.ERMasterService;

@Service
public class ERMasterServiceImpl implements ERMasterService {
	
	private WordDictionaryMapper wordDictionaryMapper;
	private TableMasterMapper tableMasterMapper;
	private ColumnMasterMapper columnMasterMapper;
	private ERMasterLoader eRMasterLoader;

	@Autowired
	public ERMasterServiceImpl(WordDictionaryMapper wordDictionaryMapper, TableMasterMapper tableMasterMapper, ColumnMasterMapper columnMasterMapper, ERMasterLoader eRMasterLoader) {
		this.wordDictionaryMapper = wordDictionaryMapper;
		this.tableMasterMapper = tableMasterMapper;
		this.columnMasterMapper = columnMasterMapper;
		this.eRMasterLoader = eRMasterLoader;
	}

	@Override
	public ERMaster getERMaster(InputStream in) {
		return eRMasterLoader.load(in);
	}
	
	@Override
	public boolean saveERMaster(ERMaster eRMaster) {
		
		List<WordDictionary> wordMasterList = eRMaster.getWordMasterList();
		List<TableMaster> tableMasterList = eRMaster.getTableMasterList();
		List<ColumnMaster> columnMasterList = eRMaster.getColumnMasterList();

		for(WordDictionary word : wordMasterList) {
			wordDictionaryMapper.deleteByPrimaryKey(word.getWordId());
			wordDictionaryMapper.insert(word);
		}
		
		for(TableMaster table : tableMasterList) {
			tableMasterMapper.deleteByPrimaryKey(table.getTableId());
			tableMasterMapper.insert(table);
		}
		
		for(ColumnMaster column : columnMasterList) {
			columnMasterMapper.deleteByPrimaryKey(column.getColumnId());
			columnMasterMapper.insert(column);
		}
		
		return true;
	}

}
