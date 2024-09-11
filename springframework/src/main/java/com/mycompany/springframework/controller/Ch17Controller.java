package com.mycompany.springframework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springframework.dto.Ch13Member;
import com.mycompany.springframework.security.Ch17UserDetails;
import com.mycompany.springframework.service.Ch13MemberService;
import com.mycompany.springframework.service.Ch13MemberService.JoinResult;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/ch17")
public class Ch17Controller {

	@RequestMapping("/loginForm")
	public String loginForm(Model model) {
		model.addAttribute("chNum", "ch17");
		return "ch17/loginForm";
	}

	@GetMapping("authorityCheck")
	public String authorityCheck(Model model) {
		model.addAttribute("chNum", "ch17");
		return "ch17/authorityCheck";
	}

	@GetMapping("userInfo")
	public String userInfo(Model model, Authentication authentication) {
		model.addAttribute("chNum", "ch17");

		// 사용자의 아이디만 얻고 싶을때
		// 방법1
		String mid = authentication.getName();

		// 방법2
		/*
		 * Ch17UserDetails userDetails = (Ch17UserDetails)
		 * authentication.getPrincipal(); String mid = userDetails.getUsername();
		 */
		model.addAttribute("mid", mid);

		// 사용자의 모든 정보를 얻고싶을때
		Ch17UserDetails userDetails = (Ch17UserDetails) authentication.getPrincipal();
		Ch13Member member = userDetails.getMember();
		model.addAttribute("member", member);

		return "ch17/userInfo";
	}

	@Secured({"ROLE_ADMIN"})
	@GetMapping("/admin/page")
	public String adminPage(Model model) {
		log.info("실행");
		return "redirect:/ch17/authorityCheck";
	}

	@Secured({"ROLE_MANAGER"})
	@GetMapping("/manager/page")
	public String managerPage(Model model) {
		log.info("실행");
		return "redirect:/ch17/authorityCheck";
	}

	@Secured({"ROLE_USER"})
	@GetMapping("/user/page")
	public String user(Model model) {
		log.info("실행");
		return "redirect:/ch17/authorityCheck";
	}

	@GetMapping
	public String error403(Model model) {
		log.info("실행");
		return "ch17/error403";
	}
	
	@GetMapping("/joinForm")
	   public String joinForm(Model model) {
		   model.addAttribute("chNum","ch17");
		   return "ch17/joinForm";
	   }
	   
	@Autowired
	private Ch13MemberService memberService;
	
	   @PostMapping("/join")
	   public String join(Ch13Member member,Model model) {
		   //계정활성화
		   member.setMenabled(true);
		   
		   //비밀번호 암호화
		   	PasswordEncoder passwordEncoder = 
		   			PasswordEncoderFactories.createDelegatingPasswordEncoder();
		   	member.setMpassword(passwordEncoder.encode(member.getMpassword()));//encode(암호와하는 코드 ) match(암호화된 코드를 비교해서 맞으면 true 아니면  false)(스프링시큐리티에선 사용할 필요 없음)
		   	
		   log.info(member.toString());
		   
		   
		   
		   
		   log.info(member.toString());
		   JoinResult joinResult = memberService.join(member);
		   if(joinResult==joinResult.FAIL_DUPLICATED_MID) {
			   String errorMessage = "아이디가 존재합니다.";
			   model.addAttribute("errorMessage",errorMessage);
			   return "ch17/joinForm";
		   }else {
			   return "redirect:/ch17/loginForm";	   		   
		   }
		   
	   }
}
