package com.mis.domain;

public class MemberVO {
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberPhon;
	private int memberAdmin;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhon() {
		return memberPhon;
	}

	public void setMemberPhon(String memberPhon) {
		this.memberPhon = memberPhon;
	}

	public int getMemberAdmin() {
		return memberAdmin;
	}

	public void setMemberAdmin(int memberAdmin) {
		this.memberAdmin = memberAdmin;
	}

	@Override
	public String toString() {
		return "MemberVO [memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName
				+ ", memberPhon=" + memberPhon + ", memberAdmin=" + memberAdmin + "]";
	}
}
