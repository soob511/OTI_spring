package com.mycompany.springframework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class Ch01Controller {
	@RequestMapping("/ch01/login")
	public void login() {
		log.info("실행");
	}
	
	@RequestMapping("/ch01/join")
	public void join() {
		log.info("실행");
	}
}
