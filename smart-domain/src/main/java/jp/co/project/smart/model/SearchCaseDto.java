package jp.co.project.smart.model;

import java.util.Date;

public class SearchCaseDto {
	private String businessType;
	private String chargeName;
	private String cifNum;
	private String debateKbn;
	private String finishKbn;
	private Date fixDateFrom;
	private Date fixDateTo;
	private String shopCode;
	private String shopName;
	private String willName;
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	public String getChargeName() {
		return chargeName;
	}
	public void setChargeName(String chargeName) {
		this.chargeName = chargeName;
	}
	public String getCifNum() {
		return cifNum;
	}
	public void setCifNum(String cifNum) {
		this.cifNum = cifNum;
	}
	public String getDebateKbn() {
		return debateKbn;
	}
	public void setDebateKbn(String debateKbn) {
		this.debateKbn = debateKbn;
	}
	public String getFinishKbn() {
		return finishKbn;
	}
	public void setFinishKbn(String finishKbn) {
		this.finishKbn = finishKbn;
	}
	public Date getFixDateFrom() {
		return fixDateFrom;
	}
	public void setFixDateFrom(Date fixDateFrom) {
		this.fixDateFrom = fixDateFrom;
	}
	public Date getFixDateTo() {
		return fixDateTo;
	}
	public void setFixDateTo(Date fixDateTo) {
		this.fixDateTo = fixDateTo;
	}
	public String getShopCode() {
		return shopCode;
	}
	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getWillName() {
		return willName;
	}
	public void setWillName(String willName) {
		this.willName = willName;
	}

}
