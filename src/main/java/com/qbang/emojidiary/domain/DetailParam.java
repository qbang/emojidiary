package com.qbang.emojidiary.domain;

public class DetailParam {
	private String user_id;
	private String date;
	
	public DetailParam(String date, String user_id) {
		this.user_id = user_id;
		this.date = date;
	}
}
