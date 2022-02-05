package com.mis.domain;

public class StoreVO {

	private String storeNo;
	private String storeTitle;
	private String storeContent;
	private String storeLo;
	private String storeImg;
	private String storeDate;
	private String memberId;
	public String getStoreNo() {
		return storeNo;
	}
	public void setStoreNo(String storeNo) {
		this.storeNo = storeNo;
	}
	public String getStoreTitle() {
		return storeTitle;
	}
	public void setStoreTitle(String storeTitle) {
		this.storeTitle = storeTitle;
	}
	public String getStoreContent() {
		return storeContent;
	}
	public void setStoreContent(String storeContent) {
		this.storeContent = storeContent;
	}
	public String getStoreLo() {
		return storeLo;
	}
	public void setStoreLo(String storeLo) {
		this.storeLo = storeLo;
	}
	public String getStoreImg() {
		return storeImg;
	}
	public void setStoreImg(String storeImg) {
		this.storeImg = storeImg;
	}
	public String getStoreDate() {
		return storeDate;
	}
	public void setStoreDate(String storeDate) {
		this.storeDate = storeDate;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	@Override
	public String toString() {
		return "StoreVO [storeNo=" + storeNo + ", storeTitle=" + storeTitle + ", storeContent=" + storeContent
				+ ", storeLo=" + storeLo + ", storeImg=" + storeImg + ", storeDate=" + storeDate + ", memberId="
				+ memberId + "]";
	}
}
