package com.qbang.emojidiary;

import java.util.Calendar;

public class CalendarData {
	private Calendar cal;
	
	public CalendarData(){
		cal = Calendar.getInstance();
	}
	public String getMonth() {
		return String.valueOf(cal.get(Calendar.MONTH)+1);
	}
	public String getToday() {
		return cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"
				+cal.get(Calendar.DATE);
	}
	public String getYear() {
		return String.valueOf(cal.get(Calendar.YEAR));
	}
	public String getDay() {
		return String.valueOf(cal.get(Calendar.DATE));
	}
	
	public String getFirstDay() {
		return "01";
	}
	public String getLastDay() {
		return String.valueOf(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
	}
	public void setMonth(int value) {
		cal.add(Calendar.MONTH, value);
	}
}
