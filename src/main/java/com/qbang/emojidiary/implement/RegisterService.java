package com.qbang.emojidiary.implement;

import javax.annotation.Resource;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.qbang.emojidiary.persistance.MemberDAO;

@Service("RegisterService")
public class RegisterService {
	@Resource(name="MemberDAO")
	private MemberDAO memberDAO;
	
	private BCryptPasswordEncoder passwordEcoder = new BCryptPasswordEncoder();
	
	public void registerUser(String userId, String userPw) {
		String encPw = passwordEcoder.encode(userPw);
		memberDAO.insertUser(userId, encPw);
	}
}
