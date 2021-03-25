package com.mycompany.webapp.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.webapp.dto.User;
import com.mycompany.webapp.service.UsersService;

@Controller
@RequestMapping("/exam07")
public class Exam07Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Exam07Controller.class);
	
	@Autowired
	private UsersService usersService;
	
	@GetMapping("/joinForm")
	public String joinForm() {
		return "exam07/joinForm";
	}
	
	@PostMapping("/join")
	public String join(User user) {
		logger.info(user.getUid());
		logger.info(user.getUname());
		logger.info(user.getUpassword());
		
		//암호화
		//가장 많이 쓰는 방법
		BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
		
		//암호화된 비밀번호
		user.setUpassword(bpe.encode(user.getUpassword()));
		usersService.join(user);
		
		return "redirect:/exam07/loginForm";
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "exam07/loginForm";
	}
	
	@PostMapping("/login")
	public String login(User user, HttpSession session) {
		String result = usersService.login(user);
		if(result.equals("success")) {
			//세션에 남아있는 loginError를 제거
			session.removeAttribute("loginError");
			session.setAttribute("loginUid", user.getUid());
			return "redirect:/home";
		} else {
			session.setAttribute("loginError", result);
			return "redirect:/exam07/loginForm";
		}

	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
//		session.invalidate();
		session.removeAttribute("loginUid");
		return "redirect:/home";
	}
	
}
