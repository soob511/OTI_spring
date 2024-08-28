package com.mycompany.springframework.controller;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/ch05")
public class Ch05Controller {
	
	@GetMapping("/header")
	public String header(@RequestHeader("User-Agent")String userAgent, Model model,HttpServletRequest request){ //헤더값을 바로 매개변수로 받을수 있음
		
		//헤더값 얻는방법1 (매개변수)
		//헤더값 얻는방법2
		userAgent = request.getHeader("User-Agent");
		log.info("userAgent: "+ userAgent);
		
		String browser = null;
		if(userAgent.contains("Edg")) {
			browser = "Edg";
		}else if(userAgent.contains("Chrome")){
			browser = "Chrome";
		}
		model.addAttribute("browser",browser);
		
		String clientIp = request.getRemoteAddr();
		model.addAttribute("clientIp",clientIp);
		log.info("clientIp:" + clientIp);
		return "ch05/header";
	}
	
	@GetMapping("/createCookie")
	public String createCookie(HttpServletResponse response) {
		//쿠키생성
		Cookie cookie1 = new Cookie("mid","user1");
		//cookie1.setMaxAge(60);//클라이언트 파일 시스템에 저장하는 기간 설정 ( 없으면 브라우저 메모리에 저장)
		//cookie1.setDomain("samsung.com");  *.samsung.com 도메인이 포함된 사이트에 쿠키를 다들고감
		//cookie1.setSecure(true); 브라우저에서 수정 x ( 자바스크립트로 브라우저로 쿠키값 수정 가능)
		//cookie1.setHttpOnly(true); http에서는 읽기만 가능하다 https에서는 수정 가능
 		Cookie cookie2 = new Cookie("memail","user1@mycompany.com");
		//쿠키를 응답헤더에 추가해서 브라우저로 보냄
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		return "redirect:/";
	}

	@GetMapping("/readCookie")
	public String readCookie(@CookieValue("mid")String mid, @CookieValue("memail")String memail,Model model) {
		log.info("mid:"+mid);
		log.info("memail:"+memail);
		model.addAttribute("mid",mid);
		model.addAttribute("memail",memail);
		return "ch05/readCookie";
	}
	
}
