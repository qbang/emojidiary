package com.qbang.emojidiary.domain;
// mybatisMapper���� �������� �Ķ���͸� �����ϱ� ���� ���
public class DateParam {
	private String user_id;
	private String start_day;
	private String last_day;
	
	public DateParam(String user_id, String start_day, String last_day) {
		this.user_id = user_id;
		this.start_day = start_day;
		this.last_day = last_day;
	}
	
}