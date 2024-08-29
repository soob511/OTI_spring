package com.mycompany.springframework.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springframework.dto.Ch06Cart;
import com.mycompany.springframework.dto.Ch06Item;
import com.mycompany.springframework.dto.Ch06Member;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/ch07")
public class Ch07Controller {
	
	@GetMapping("/objectScope")
	public String objectScope(HttpServletRequest request,HttpSession session, Model model) {
		//Request 사용 범위
		request.setAttribute("key1", "value1");
		model.addAttribute("key2","value2");
	
		//Session 사용범위
		session.setAttribute("key3", "value3");
		
		//Application 사용범위(모든 브라우저에서 사용할 수 있는 범위)
		ServletContext application = request.getServletContext();
		application.setAttribute("key4", "value4");
		
		return "ch07/objectScope";
	}
	
	@GetMapping("/objectScope2")
	public String objectScope2(HttpServletRequest request,HttpSession session, Model model) {

		
		return "ch07/objectScope";
	}

}
