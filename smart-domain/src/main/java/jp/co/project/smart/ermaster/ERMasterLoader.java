package jp.co.project.smart.ermaster;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.insightech.er.editor.model.ERDiagram;
import org.insightech.er.editor.model.diagram_contents.element.node.table.ERTable;
import org.insightech.er.editor.model.diagram_contents.element.node.table.column.Column;
import org.insightech.er.editor.model.diagram_contents.element.node.table.column.ColumnHolder;
import org.insightech.er.editor.model.diagram_contents.element.node.table.column.NormalColumn;
import org.insightech.er.editor.model.diagram_contents.not_element.dictionary.Word;
import org.insightech.er.editor.persistent.impl.XMLLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import jp.co.project.smart.autogen.model.ColumnMaster;
import jp.co.project.smart.autogen.model.TableMaster;
import jp.co.project.smart.autogen.model.WordDictionary;
import jp.co.project.smart.ermaster.model.ERMaster;

@Component
public class ERMasterLoader {
	
	public ERMaster load(InputStream in){
		
		ERMaster ermaster = new ERMaster();
		List<WordDictionary> wordMasterList = new ArrayList<WordDictionary>();
		List<ColumnMaster> columnMasterList = new ArrayList<ColumnMaster>();
		List<TableMaster> tableMasterList = new ArrayList<TableMaster>();
		
		try {
			XMLLoader xmlLoader = new XMLLoader();
			ERDiagram eRDiagram = xmlLoader.load(in);
		    List<ERTable> tableList = eRDiagram.getDiagramContents().getContents().getTableSet().getList();
		    // テーブル情報
		    for(ERTable table : tableList) {
		    	TableMaster tableMaster = new TableMaster();
		    	// テーブルID
		    	tableMaster.setTableId(getInteger(table.getId()));
		    	// 物理名
		        tableMaster.setPhysicalName(table.getPhysicalName());
		    	// 論理名
		        tableMaster.setLogicName(table.getLogicalName());
		    	// 主キー名
		        tableMaster.setPrimaryKeyName(table.getPrimaryKeyName());
		    	// オプション
		        tableMaster.setTableOption(table.getOption());
		    	// インデックス todo to jsonb
		        // tableMaster.setIndexes(table.getIndexes());
		        tableMaster.setIndexes(null);
		    	// 複合ユニックキーリスト todo to jsonb
		        // tableMaster.setComplexUniqueKeyList(table.getComplexUniqueKeyList());
		        tableMaster.setComplexUniqueKeyList(null);
		        tableMasterList.add(tableMaster);
		        
		        // コラムマスタ情報
		        List<Column> columns = table.getColumns();
		        for (Column column : columns) {

		        	if (column instanceof NormalColumn){
			        	ColumnMaster columnMaster = new ColumnMaster();
			        	NormalColumn normalColumn = (NormalColumn) column;
			        	// カラムID
			        	columnMaster.setColumnId(getInteger(normalColumn.getId()));
			        	// テーブルID
			        	columnMaster.setTableId(getInteger(table.getId()));
			        	// 単語ID
			        	columnMaster.setWordId(getInteger(normalColumn.getWordId()));
			        	// シーケンスNo
			        	columnMaster.setSeqNo(getInteger(normalColumn.getSeqNo()));
			        	// 説明
			        	columnMaster.setDescription(normalColumn.getDescription());
			        	// ユニックキー名前　 todo to jsonb
			        	// columnMaster.setUniqueKeyName(normalColumn.getUniqueKeyName());
			        	columnMaster.setUniqueKeyName(null);
			        	// 制約　 todo to jsonb
			        	// columnMaster.setColumnConstraint(normalColumn.getConstraint());
			        	columnMaster.setColumnConstraint(null);
			        	// 外部キーフラグ
						if (StringUtils.isEmpty(normalColumn.getForeignKeyPhysicalName())) {
							columnMaster.setForeignKeyFlg(false);
						} else {
							columnMaster.setForeignKeyFlg(true);
						}
			        	// NULL可否フラグ
			        	columnMaster.setNotNullFlg(normalColumn.isNotNull());
			        	// 主キーフラグ
			        	columnMaster.setPrimaryKeyFlg(normalColumn.isPrimaryKey());
			        	// ユニックキーフラグ
			        	columnMaster.setUniqueKeyFlg(normalColumn.isUniqueKey());

			        	columnMasterList.add(columnMaster);
		        	}
		        }
		        ermaster.setColumnMasterList(columnMasterList);
		       
		    }
		    ermaster.setTableMasterList(tableMasterList);
		    
		    // 単語辞書情報
		    Map<String, Word> wordMap = eRDiagram.getWordMap();
			for (Map.Entry<String, Word> word : wordMap.entrySet()) {
				WordDictionary wordMaster = new WordDictionary();
				// 単語ID
				wordMaster.setWordId(getInteger(word.getKey()));
				Word tempWrod = (Word)word.getValue();
				// 単語長さ
				wordMaster.setWordLength(getInteger(tempWrod.getLength()));
				// 単語小数桁
				wordMaster.setWordDecimal(getInteger(tempWrod.getDecimal()));
				// 配列フラグ
				wordMaster.setArrayFlg(getBoolean(tempWrod.getArray()));
				// 配列次元
				wordMaster.setArrayDimension(getInteger(tempWrod.getArray_dimension()));
				// 説明
				wordMaster.setDescription(tempWrod.getDescription());
				// 論理名
				wordMaster.setLogicName(tempWrod.getLogicalName());
				// 物理名
				wordMaster.setPhysicalName(tempWrod.getPhysicalName());
				// 単語型
				wordMaster.setWordType(tempWrod.getWordType());
				
				wordMasterList.add(wordMaster);
			}
			ermaster.setWordMasterList(wordMasterList);
		} catch (Exception e) {

		} 
		return ermaster;
	}
	
	private Integer getInteger(String param) {
		if (null == param || "null".equals(param) || ObjectUtils.isEmpty(param)) {
			return Integer.valueOf("0");
		} else {
			return Integer.valueOf(param);
		}
	}
	
	private Boolean getBoolean(String param) {
		if (null == param || "null".equals(param)  || ObjectUtils.isEmpty(param)) {
			return Boolean.valueOf("false");
		} else {
			return Boolean.valueOf(param);
		}
	}

	// テスト用
	public static void main(String[] args) {
		
		File file = new File("C:\\wgwork\\innox-wg\\20210112\\smart-project\\er-diagram\\ER\\SmartProjectER.erm");

		if (file.exists()) {
			FileInputStream in = null;

			try {
				in = new FileInputStream(file);
				org.insightech.er.editor.persistent.impl.XMLLoader xmlLoader = new org.insightech.er.editor.persistent.impl.XMLLoader();
				ERDiagram eRDiagram = xmlLoader.load(in);
				
			    List<ERTable> tableList = eRDiagram.getDiagramContents().getContents().getTableSet().getList();
			    
			    System.out.println("###############Table################## Start");
			    for(ERTable table : tableList) {
			        System.out.println("テーブルID : " + table.getId());
//			        System.out.println("物理名 : " + table.getPhysicalName());
//			        System.out.println("論理名 : " + table.getLogicalName());
//			        System.out.println("主キー名 : " + table.getPrimaryKeyName());
//			        System.out.println("オプション : " + table.getOption());
//			        System.out.println("インデックス : " + table.getIndexes());
//			        System.out.println("複合ユニックキーリスト : " + table.getComplexUniqueKeyList());
			        
			        List<Column> columns = table.getColumns();
//			        
			        for (Column column : columns) {
			        	
			        	if (column instanceof NormalColumn){
				        	System.out.println("Column id: " + ((NormalColumn) column).getId());
				        	System.out.println("word id: " + ((NormalColumn) column).getWordId());
			        	}
			        }
			        
			        ColumnHolder columnHolder = columns.get(0).getColumnHolder();
			    }
			    System.out.println("###############Table################## end");
			    
			    
			    System.out.println("###############Column################## Start");
			    Map<String, NormalColumn> columnMap = eRDiagram.getColumnMap();
				for (Map.Entry<String, NormalColumn> column : columnMap.entrySet()) {
					System.out.println("カラムID : " + column.getKey());
					System.out.println("Value = " + column.getValue().getPhysicalName());
//					column.getValue().getColumnHolder()
//					Word word = column.getValue().getWord();
//					System.out.println("wordId = " + word.getId());
				}
				System.out.println("###############Column################## end");
				
			    System.out.println("###############Word################## Start");
			    Map<String, Word> wordMap = eRDiagram.getWordMap();
				for (Map.Entry<String, Word> word : wordMap.entrySet()) {
//					System.out.println("単語ID : " + word.getKey());
//					System.out.println("物理名 :" + word.getValue().getPhysicalName());
//					System.out.println("論理名 :" + word.getValue().getLogicalName());
//					System.out.println("単語型 :" + word.getValue().getType());
//					System.out.println("説明  :" + word.getValue().getDescription());
				}
				System.out.println("###############Word################## end");

			} catch (Exception e) {

			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
					}
				}
			}
		}

	}

}
