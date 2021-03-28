package com.mycompany.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam02")
public class Exam02Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam02Controller.class);

	@RequestMapping("/method1")
	public String method1(HttpServletRequest request, HttpServletResponse response) {
		logger.info("실행 여기임");
		// post man에서 http://localhost:8080/webapp/exam02/method1?name=홍길동 로 보냄
		String name = request.getParameter("name");
		logger.info(name);
		request.setAttribute("username", name);
		return "exam02/method1";
	}
	
	@RequestMapping("/method1form")
	public String method1form() {
		logger.info("실행");
		//리턴값은 JSP 주소
		return "exam02/method1form";
	}

	@RequestMapping("/method2")
	public String method2() {
		logger.info("실행");	
		//이건 view가 아니라 재접속 경로 즉 RuquestMapping의 주소
		return "redirect:/home";
	}
	//--------------원래 코드-------------------------------------------------
//	@GetMapping(value="/method3") value가 생략된것
//	@GetMapping("/method3")
	@RequestMapping(value = "/method3", method = RequestMethod.GET)
	public String method3(Model model) {
		logger.info("실행");
		//request.setAttribute("method", "GET");
		model.addAttribute("method", "GET");
		return "exam02/method";
	}
	
//	@PostMapping("/method3")
	@RequestMapping(value = "/method3", method = RequestMethod.POST)
	public String method4(Model model) {
		logger.info("실행");
		model.addAttribute("method", "POST");
		return "exam02/method";
	}
	
//	@PutMapping("/method3")
//	public String method7(Model model) {
//		logger.info("실행");
//		model.addAttribute("method", "PUT");
//		return "exam02/method";
//	}
//	
//	@DeleteMapping("/method3")
//	public String method8(Model model) {
//		logger.info("실행");
//		model.addAttribute("method", "DELETE");
//		return "exam02/method";
//	}
//	
	
	//-------------------ajax 코드-----------------------------
	@GetMapping(value = "/ajaxmethod3", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String method5(Model model) {
		logger.info("실행");
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("method", "GET");
		String json = jsonobject.toString();
		return json;
	}
	
	@PostMapping(value = "/ajaxmethod3", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String method6(Model model) {
		logger.info("실행");
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("method", "POST");
		String json = jsonobject.toString();
		return json;
	}

	
	@PutMapping(value = "/ajaxmethod3", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String method7(Model model) {
		logger.info("실행");
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("method", "PUT");
		String json = jsonobject.toString();
		return json;
	}
	
	@DeleteMapping(value = "/ajaxmethod3", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String method8(Model model) {
		logger.info("실행");
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("method", "DELETE");
		String json = jsonobject.toString();
		return json;
	}
}
