package jp.co.project.smart.ermaster.model;

import java.util.List;

import jp.co.project.smart.autogen.model.ColumnMaster;
import jp.co.project.smart.autogen.model.TableMaster;
import jp.co.project.smart.autogen.model.WordDictionary;

public class ERMaster {
	List<WordDictionary> wordMasterList;
	List<ColumnMaster> columnMasterList;
	List<TableMaster> tableMasterList;

	public List<WordDictionary> getWordMasterList() {
		return wordMasterList;
	}

	public void setWordMasterList(List<WordDictionary> wordMasterList) {
		this.wordMasterList = wordMasterList;
	}

	public List<ColumnMaster> getColumnMasterList() {
		return columnMasterList;
	}

	public void setColumnMasterList(List<ColumnMaster> columnMasterList) {
		this.columnMasterList = columnMasterList;
	}

	public List<TableMaster> getTableMasterList() {
		return tableMasterList;
	}

	public void setTableMasterList(List<TableMaster> tableMasterList) {
		this.tableMasterList = tableMasterList;
	}

}
