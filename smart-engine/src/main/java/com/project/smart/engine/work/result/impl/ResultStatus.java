
package com.project.smart.engine.work.result.impl;

/**
 * @author dev
 *
 */
public enum ResultStatus {

	/** 業務正常 */
	OK("0", "正常"),
	/** 業務異常 */
	NG("1", "異常"),
	/** 例外発生 */
	EXCEPTION("2", "例外"),
	/** コード不正 */
	UNKNOWN_CODE("9", "コード不正 ");

	/** コード */
	private String code;

	/** コード値 */
	private String value;

	private ResultStatus(String code, String value) {
		this.code = code;
		this.value = value;
	}

	public static ResultStatus code(String code) {
		for (ResultStatus e : values()) {
			if (e.getCode().equals(code))
				return e;
		}
		return UNKNOWN_CODE;
	}

	public boolean isOk() {
		return isCode(OK);
	}

	public boolean isNg() {
		return isCode(NG);
	}

	public boolean isException() {
		return isCode(EXCEPTION);
	}

	public boolean isUnkonwnCode() {
		return isCode(UNKNOWN_CODE);
	}

	private boolean isCode(ResultStatus status) {
		return status.getCode().equals(this.getCode());
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
