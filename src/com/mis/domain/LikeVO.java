package com.mis.domain;

public class LikeVO {
	private String likeDate;
	private int storeNo;
	private String memberId;
	private boolean islike;
	public String getLikeDate() {
		return likeDate;
	}
	public void setLikeDate(String likeDate) {
		this.likeDate = likeDate;
	}
	public int getStoreNo() {
		return storeNo;
	}
	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public boolean isIslike() {
		return islike;
	}
	public void setIslike(boolean islike) {
		this.islike = islike;
	}
	@Override
	public String toString() {
		return "LikeVO [likeDate=" + likeDate + ", storeNo=" + storeNo + ", memberId=" + memberId + ", islike=" + islike
				+ "]";
	}

	

}
