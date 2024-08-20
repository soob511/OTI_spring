package com.mycompany.springframework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	@RequestMapping("")
	public void index() {
		log.info("실행");
	}
	
	@RequestMapping("/board")
	public void board() {
		log.info("실행");
	}
}
