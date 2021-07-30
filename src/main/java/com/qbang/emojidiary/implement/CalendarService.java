package com.qbang.emojidiary.implement;

import java.util.*;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qbang.emojidiary.CalendarData;
import com.qbang.emojidiary.domain.DateParam;
import com.qbang.emojidiary.domain.DateVO;
import com.qbang.emojidiary.domain.DetailParam;
import com.qbang.emojidiary.persistance.DateDAO;
import com.qbang.emojidiary.persistance.FeelingDAO;

@Service("CalendarService")
public class CalendarService {
	
	@Resource(name="DateDAO")
	private DateDAO dateDAO;
	
	@Resource(name="FeelingDAO")
	private FeelingDAO feelingDAO;
	
	@Resource(name="TransformService")
	private TransformService transformService;
	
	@Autowired 
	private CalendarData calendarData;
	
	// 달력 넘길 때
	public Map<Integer, Object> getCalendarInfo(String userId, int value){
		calendarData.setMonth(value);
		
		String year = calendarData.getYear();
		String month = calendarData.getMonth();
		System.out.println("Month -> "+month);
		String first_day = calendarData.getFirstDay();
		int last_day = Integer.parseInt(calendarData.getLastDay());
		
		DateParam param = new DateParam(userId, year+"-"+month+"-"+first_day,
				year+"-"+month+"-"+last_day);
	
		List<DateVO> list = dateDAO.selectCalendar(param);
		Map<Integer, Object> map = transformService.numToURL(list, last_day);

		// emoji�� ���� ���� �׳� ��¥�� ä���ֱ�
		for(int i=1; i<=last_day; i++) {
			if(!map.containsKey(i)) {
				map.put(i, String.valueOf(i));
			}
		}
		return map;
	}
	
	public void addFeeling(String date, String userId, String feeling, String detail) {
		feelingDAO.insertFeeling(date, Integer.parseInt(feeling), userId, detail);
	}
	
	public String getDetail(String date, String userId) {
		DetailParam param = new DetailParam(date, userId);
		String detail = feelingDAO.selectDetail(param);
		
		return detail;
	}
	
	public String getYear() {
		return calendarData.getYear();
	}
	
	public String getMonth() {
		return calendarData.getMonth();
	}
	
	public String getDay() {
		return calendarData.getDay();
	}
	
	public void initDate() {
		calendarData.initCalendar();
	}
}
