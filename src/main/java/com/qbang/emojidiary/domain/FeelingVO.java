package com.qbang.emojidiary.domain;

public class FeelingVO {
	private int id;
	private String regdate;
	private int emoji;
	private String userId;
	private String detail;
	
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getEmoji() {
		return emoji;
	}
	public void setEmoji(int emoji) {
		this.emoji = emoji;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}
