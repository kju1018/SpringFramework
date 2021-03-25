package com.mycompany.webapp.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.webapp.dto.User;

@Controller
@RequestMapping("/exam06")
public class Exam06Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Exam06Controller.class);
	
	@GetMapping("/content")
	public String content() {
		return "exam06/content";
	}
	
	@GetMapping("/createCookie")
	public String createCookie(HttpServletResponse response) {
		String uid = "spring";
		Cookie cookie = new Cookie("uid", uid);
//		cookie.setDomain("localhost");
		/*cookie.setDomain("192.168.3.115");*/
		//이 도메인으로 접속한 클라이언트만 쿠키를 받을 수 있다.
		
//		cookie.setPath("/");
//		cookie.setPath("/webapp/exam06");
		//여기에 있는 경로에서만 사용하고싶다
		//특정 경로에서만 사용 가능하게 하려면 설정
		
//		cookie.setHttpOnly(true);
		//이게 true이면 자바스크립트에서 값을 읽을 수 없다.
		
//		cookie.setMaxAge(10);
		//값을 안주면 메모리에만 저장
		//0이면 삭제
		//양수면 해당 초만큼만 저장
		
		response.addCookie(cookie);
		//응답 http 헤더에 쿠키를 담아서 브라우저로 보냄
		
		
		Cookie cookie2 = new Cookie("utel", "010-1234-1234");
		response.addCookie(cookie2);
		return "redirect:/exam06/content";
	}
	
	//1번 방법
	
	/*@GetMapping("/readCookie")
	public String readCookie(HttpServletRequest request) {
		Cookie[] cookieArr = request.getCookies();
		for(Cookie cookie : cookieArr) {
			logger.info(cookie.getName() + ": " + cookie.getValue());
			if(cookie.getName().equals("uid")) {
				logger.info(cookie.getValue()+ "활용하기");
			}
		}
		return "redirect:/exam06/content";
	}*/
	
	//2번 방법
	@GetMapping("/readCookie")
	public String readCookie(@CookieValue String uid) {
		//쿠키 아이디가 uid인것이 넘어오면 uid에 넣어라
		logger.info(uid+" 활용하기");
		return "redirect:/exam06/content";
	}
	
	@GetMapping("/deleteCookie")
	public String deleteCookie(HttpServletResponse response) {
		Cookie cookie = new Cookie("uid", "");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		return "redirect:/exam06/content";
	}
	
	@GetMapping("/sessionSaveObject")
	public String sessionSaveObject(HttpSession session) {
		User user = new User();
		user.setUid("spring");
		session.setAttribute("user", user);
		return "redirect:/exam06/content";
	}
	
	@GetMapping("/sessionReadObject")
	public String sessionReadObject(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user != null) {
			logger.info("저장된 uid: " + user.getUid());
		}
	
		return "redirect:/exam06/content";
	}
	
	@GetMapping("/sessionRemoveObject")
	public String sessionRemoveObject(HttpSession session) {
		//개별 객체를 삭제할 때
		session.removeAttribute("user");
		
		//세션에 저장된 모든 객체를 삭제할 경우 세션을 무효화 시킴
//		session.invalidate();
		return "redirect:/exam06/content";
	}
}
