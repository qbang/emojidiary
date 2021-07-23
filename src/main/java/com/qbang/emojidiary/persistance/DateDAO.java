package com.qbang.emojidiary.persistance;

import java.util.List;
import javax.annotation.Resource;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.qbang.emojidiary.domain.DateParam;
import com.qbang.emojidiary.domain.DateVO;

@Repository("DateDAO")
public class DateDAO {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate session;
	
	public List<DateVO> selectCalendar(DateParam param) {
		List<DateVO> list = session.selectList("mogi.selectCalendar", param);
		return list;
	}
}
