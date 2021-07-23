package com.qbang.emojidiary.persistance;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.qbang.emojidiary.domain.MemberVO;

@Repository("MemberDAO")
public class MemberDAO{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate session;

	//select
	public MemberVO selectUser(String id) {
		MemberVO vo = session.selectOne("mogi.selectUser",id);
		return vo;
	}
	
	//insert
	public void insertUser(String id, String pw) {
		MemberVO vo = new MemberVO();
		vo.setUserId(id);
		vo.setUserPw(pw);
		session.insert("mogi.insertUser", vo);
		System.out.println("ȸ�� insert �Ϸ�");
	}
	
}
