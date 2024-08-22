package com.mycompany.springframework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/ch02")
@Slf4j
public class Ch02Controller {
	@RequestMapping("/getMethod")
	public String getMethod() {
		log.info("실행");
		return "ch02/getMethod";
	}
	
	@RequestMapping("/postMethod")//default 값
	public String postMethod() {
		log.info("실행");
		return "ch02/postMethod";
	}
//	@RequestMapping( value="/getAtag", method=RequestMethod.GET)
	//값을 여러개를 줘야하는 경우 default값은 반드시 value= 붙여야하고 다른 속성의 값은 그 속성 = 하고 값을 줘야함
	@GetMapping("/getAtag")
	public String getAtag(String bno,String bkind) {
		
		log.info("실행");
		log.info("bno: "+bno);
		log.info("kind: "+ bkind);
		return "ch02/getMethod";
	}
	
	@GetMapping("/getFormTag")
	public String getFormTag(String bno,String bkind) {
		log.info("실행");
		log.info("bno: "+bno);
		log.info("bkind: "+ bkind);
		return "ch02/getMethod";
	}
}
