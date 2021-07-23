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
	
	// ������ �����ϸ� �ٷ� login�϶�� �Ѱ���
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale) {
		return "login";
	}
	
	// login â���� Ȯ�ι�ư ������ ��
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, HttpServletRequest req, HttpServletResponse res) {
		
		try {
			req.setCharacterEncoding("UTF-8");
			res.setCharacterEncoding("UTF-8");
			String userId = req.getParameter("userId");
			String userPw = req.getParameter("userPw");
			
			// �α��� ���� ȣ�� �� ���� ���� üũ
			if(loginService.checkUser(userId, userPw)) {
				HttpSession session = req.getSession();
				session.setAttribute("userId", userId);
				
				return "redirect:/calendar?value="+0;
			}
			// �����ϰų� �������� ��쿡�� ��� login �������� �ӹ�
			else {
				return "login";
			}
		}catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	// login���� ȸ������ ������ ��
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(HttpServletRequest req, HttpServletResponse res) {
		return "register";
	}
	
	// ȸ������ â���� Ȯ�ι�ư ������ ��
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
	
	// �α��� �������� ���� ȸ���������� �� �޷� ���� ��û
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
	
	// home.jsp���� Ŭ������ ��
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, String> param) {
		// session ��ȿ���� üũ
		HttpSession session = req.getSession();
		if(session.getAttribute("userId") == null) {
			return "login";
		}
		
		int feeling = 0;
		String feeling_src = null;
		String year, month, day = null;
		List<String> feeling_arr = null;
		
		// today.jsp���� ǥ�� �������� ��
		if(param.get("year") == null || param.get("month") == null || param.get("day") == null) {
			CalendarData cal2 = new CalendarData();
			
			year = cal2.getYear();
			month = cal2.getMonth();
			day = cal2.getDay();
			// feeling���� value �����ϰ� ��ȯ�������
			feeling = Integer.parseInt(param.get("value"));
			feeling_src = transformService.numToString(feeling);
			
			model.addAttribute("feeling", feeling);
		}else {	// �޷¿��� �����ϸ� feeling_arr ����
			year = param.get("year");
			month = param.get("month");
			day = param.get("day");
			
			feeling_arr = Arrays.asList(transformService.img); 
			
			// ǥ���� ���������� radio checked�� �־��� ���� ���� ����
			if(param.get("value") != null && param.get("value").contains("/")) {
				feeling_src = param.get("value");
				feeling = transformService.srcToNum(param.get("value"));
				model.addAttribute("feeling", feeling);
			}else {	// ��¥�� ���������� �� �� ����
				model.addAttribute("feeling", null);
			}
			
//			if(param.get("value") != null && param.get("value").contains("/")) {
//				feeling_src = param.get("value");
//				feeling = transformService.srcToNum(param.get("value"));
//				model.addAttribute("feeling", feeling);
//			}else { // �׳� ��¥ �������� ���� �̹����� ��θ� �迭�� �Ѱ���
//				feeling_arr = Arrays.asList(transformService.img); 
//				model.addAttribute("feeling", null);
//			}
		}
		
		// �ش� ��¥�� ����� ����� ����� ���� �� ������ detail ������. jsp���� null üũ
		String detail = calendarService.getDetail(year+"-"+month+"-"+day, (String)session.getAttribute("userId"));
		
		model.addAttribute("detail", detail);
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("feeling_arr", feeling_arr);
		model.addAttribute("feeling_src", feeling_src);
		
		return "detail";
	}

	// detail.jsp���� �Է¿Ϸ� ���� ��
	@RequestMapping(value="/registerFeeling", method = RequestMethod.POST)
	public String registerFeeling(Model model, HttpServletRequest req, HttpServletResponse res) {
		// session ��ȿ���� üũ
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
