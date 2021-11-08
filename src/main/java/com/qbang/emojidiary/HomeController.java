package com.qbang.emojidiary;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qbang.emojidiary.implement.CalendarService;
import com.qbang.emojidiary.implement.LoginService;
import com.qbang.emojidiary.implement.RegisterService;
import com.qbang.emojidiary.implement.TransformService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource(name="CalendarService")
	private CalendarService calendarService;
	
	@Resource(name="LoginService")
	private LoginService loginService;
	
	@Resource(name="RegisterService")
	private RegisterService registerService;
	
	@Resource(name="TransformService")
	private TransformService transformService;
	
	// 로그인 페이지 요청 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale) {
		return "login";
	}
	
	// 로그인 정보가 맞는지 확인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, HttpServletRequest req, HttpServletResponse res) {
		
		try {
			req.setCharacterEncoding("UTF-8");
			res.setCharacterEncoding("UTF-8");
			String userId = req.getParameter("userId");
			String userPw = req.getParameter("userPw");
			
			// 로그인 성공
			if(loginService.checkUser(userId, userPw)) {
				HttpSession session = req.getSession();
				session.setAttribute("userId", userId);
				return "redirect:/calendar?value="+0;
			}
			// 로그인 실패 
			else {
				return "login";
			}
		}catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	// 회원가입 페이지 요청
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(HttpServletRequest req, HttpServletResponse res) {
		return "register";
	}
	
	// 회원가입 정보 등록
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerMember(HttpServletRequest req, HttpServletResponse res) {
		try {
			String userId = req.getParameter("userId");
			String userPw = req.getParameter("userPw");

			registerService.registerUser(userId, userPw);
			
			HttpSession session = req.getSession();
			session = req.getSession();
			session.setAttribute("userId", userId);
			
			return "redirect:/calendar?value="+0;
		}catch(Exception e) {
			e.printStackTrace();
			
			return "error";
		}
	}
	
	// 달력 정보와 함께 메인 페이지 요청
	@RequestMapping(value = "/calendar", method = RequestMethod.GET)
	public String calendar(Model model, HttpServletRequest req, HttpServletResponse res, @RequestParam int value) {
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userId");
		if(session.getAttribute("userId") == null) {
			return "login";
		}
		Map<Integer, Object> map = calendarService.getCalendarInfo(userId, value);

		model.addAttribute("map", map);
		model.addAttribute("userId", userId);
		model.addAttribute("month", calendarService.getMonth());
		model.addAttribute("year", calendarService.getYear());
		
		return "home";
	}
	
	// 메인에서 이모티콘 클릭했을 때
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, String> param) {
		HttpSession session = req.getSession();
		if(session.getAttribute("userId") == null) {
			return "login";
		}
		
		int feeling = 0;
		String feeling_src = null;
		String year, month, day = null;
		List<String> feeling_arr = null;
		
		//today.jsp에서 이모티콘 선택했을 때
		if(param.get("year") == null || param.get("month") == null || param.get("day") == null) {
			//날짜 초기화
			calendarService.initDate();
			
			year = calendarService.getYear();
			month = calendarService.getMonth();
			day = calendarService.getDay();
			
			feeling = Integer.parseInt(param.get("value"));
			feeling_src = transformService.numToString(feeling);
			
			model.addAttribute("feeling", feeling);
		}else {	// 달력에 있는 이모티콘을 클릭했을 때 
			year = param.get("year");
			month = param.get("month");
			day = param.get("day");
			
			feeling_arr = Arrays.asList(transformService.img); 
			
			// radio checked 해줄 이모티콘 찾기 
			if(param.get("value") != null && param.get("value").contains("/")) {
				feeling_src = param.get("value");
				feeling = transformService.srcToNum(param.get("value"));
				model.addAttribute("feeling", feeling);
			}else {	// 처음 이모티콘 입력할 때
				model.addAttribute("feeling", null);
			}
		}
		
		// 날짜와 등록된 메모 가져오기
		String detail = calendarService.getDetail(year+"-"+month+"-"+day, (String)session.getAttribute("userId"));
		
		model.addAttribute("detail", detail);
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("feeling_arr", feeling_arr);
		model.addAttribute("feeling_src", feeling_src);
		
		return "detail";
	}

	// detail.jsp에서 입력한 메모와 기분 이모티콘 등록
	@RequestMapping(value="/registerFeeling", method = RequestMethod.POST)
	public String registerFeeling(Model model, HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		if(session.getAttribute("userId") == null) {
			return "login";
		}
		
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "error";
		}
		
		String dateParam = req.getParameter("year")+"-"+req.getParameter("month")+"-"+req.getParameter("day");
		calendarService.addFeeling(dateParam,(String)session.getAttribute("userId"), req.getParameter("feeling"), req.getParameter("detail"));
		
		return "redirect:/calendar?value="+0;
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		session.removeAttribute("userId");
		
		return "login";
	}
}
