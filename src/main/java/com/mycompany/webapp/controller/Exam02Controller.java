package com.mycompany.webapp.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam02")
public class Exam02Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam02Controller.class);

	@RequestMapping("/method1form")
	public String method1form() {
		logger.info("실행");
		//리턴값은 JSP 주소
		return "exam02/method1form";
	}

	@RequestMapping("/method1")
	public String method1(HttpServletRequest request, HttpServletResponse response) {
		logger.info("실행");
		// post man에서 http://localhost:8080/webapp/exam02/method1?name=홍길동 로 보냄
		String name = request.getParameter("name");
		logger.info(name);
		return "exam02/method1";
	}
	
	@RequestMapping("/method2")
	public String method2() {
		logger.info("실행");	
		//이건 view가 아니라 재접속 경로 즉 RuquestMapping의 주소
		return "redirect:/home";
	}
}
