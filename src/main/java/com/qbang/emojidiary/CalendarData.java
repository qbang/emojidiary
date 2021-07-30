package com.qbang.emojidiary;

import java.util.Calendar;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class CalendarData {
	private Calendar cal = Calendar.getInstance();
	public String getToday() {
		return cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"
				+cal.get(Calendar.DATE);
	}
	public String getFirstDay() {
		return "01";
	}
	public String getLastDay() {
		return String.valueOf(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
	}
	public String getYear() {
		return String.valueOf(cal.get(Calendar.YEAR));
	}
	public String getMonth() {
		return String.valueOf(cal.get(Calendar.MONTH)+1);
	}
	public String getDay() {
		return String.valueOf(cal.get(Calendar.DATE));
	}
	public void setYear(int value) {
		cal.add(Calendar.YEAR, value);
	}
	public void setMonth(int value) {
		cal.add(Calendar.MONTH, value);
	}
	public void setDay(int value) {
		cal.add(Calendar.DATE, value);
	}
	public void	initCalendar() {
		cal = Calendar.getInstance();
	}
}
