package jp.co.project.smart.model;

public class RegisterWordDictionary {

	private Integer wordId;

	private String physicalName;
	
	private String logicName;
	
	private String wordType;
	
	private int wordLength;
	
	private int wordDecimal;
	
	private int arrayDimension;
	
	private String description;
	
	private boolean arrayFlg;

	public Integer getWordId() {
		return wordId;
	}
	public void setWordId(Integer wordId) {
		this.wordId = wordId;
	}

	public String getPhysicalName() {
		return physicalName;
	}

	public void setPhysicalName(String physicalName) {
		this.physicalName = physicalName;
	}

	public String getLogicName() {
		return logicName;
	}

	public void setLogicName(String logicName) {
		this.logicName = logicName;
	}

	public String getWordType() {
		return wordType;
	}

	public void setWordType(String wordType) {
		this.wordType = wordType;
	}

	public int getWordLength() {
		return wordLength;
	}

	public void setWordLength(int wordLength) {
		this.wordLength = wordLength;
	}

	public int getWordDecimal() {
		return wordDecimal;
	}

	public void setWordDecimal(int wordDecimal) {
		this.wordDecimal = wordDecimal;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isArrayFlg() {
		return arrayFlg;
	}

	public void setArrayFlg(boolean arrayFlg) {
		this.arrayFlg = arrayFlg;
	}

	public int getArrayDimension() {
		return arrayDimension;
	}

	public void setArrayDimension(int arrayDimension) {
		this.arrayDimension = arrayDimension;
	}
	
	
	
	
}
