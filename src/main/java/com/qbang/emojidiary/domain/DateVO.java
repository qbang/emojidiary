package com.qbang.emojidiary.domain;

import java.sql.Date;

public class DateVO {
	private int id;
	private Date regdate;
	private int emoji;
	private int userId;
	private String detail;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getEmoji() {
		return emoji;
	}
	public void setEmoji(int emoji) {
		this.emoji = emoji;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
}
