package com.qbang.emojidiary.implement;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.qbang.emojidiary.domain.MemberVO;
import com.qbang.emojidiary.persistance.MemberDAO;

@Service("LoginService")
public class LoginService {
	
	@Resource(name="MemberDAO")
	private MemberDAO memberDAO;
	private BCryptPasswordEncoder passwordEcoder = new BCryptPasswordEncoder();
	
	public boolean checkUser(String userId, String userPw) {
		MemberVO memberVO = memberDAO.selectUser(userId);
		
		String id = memberVO.getUserId();
		String pw = memberVO.getUserPw();
		
		if(id.equals(userId) && passwordEcoder.matches(userPw, pw)) {
			return true;
		}else {
			return false;
		}
	}
}	
