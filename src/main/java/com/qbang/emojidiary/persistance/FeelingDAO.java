package com.qbang.emojidiary.persistance;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.qbang.emojidiary.domain.DetailParam;
import com.qbang.emojidiary.domain.FeelingVO;

@Repository("FeelingDAO")
public class FeelingDAO {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate session;
	
	public void insertFeeling(String regdate, int emoji, String userId, String detail) {
		FeelingVO vo = new FeelingVO();
		vo.setEmoji(emoji);
		vo.setRegdate(regdate);
		vo.setUserId(userId);
		vo.setDetail(detail);
		
		session.insert("mogi.insertFeeling", vo);
	}
	
	public String selectDetail(DetailParam param) {
		String detail = session.selectOne("mogi.selectDetail", param);
		return detail;
	}
	
}
