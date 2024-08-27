package com.mycompany.springframework.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.springframework.dto.Ch02LoginResult;
import com.mycompany.springframework.interceptor.LoginCheck;

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
	
//	@RequestMapping("/postMethod")//default 값
//	public String postMethod() {
//		log.info("실행");
//		return "ch02/postMethod";
//	}
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
		return "redirect:/";
	}
	
	@GetMapping("/getLocationHref")
	public String getLocationHref(String bno,String bkind) {
		log.info("실행");
		log.info("bno: "+bno);
		log.info("bkind: "+ bkind);
		return "ch02/getMethod";
	}
	
	@GetMapping("/getAjax")
	public String getAjax(String bno,String bkind) {
		log.info("실행");
		log.info("bno: "+bno);
		log.info("bkind: "+ bkind);
		return "ch02/getMethod";
	}
	
	@GetMapping("/getAjax1")
	public String getAjax1(String bno,String bkind) {
		log.info("실행");
		log.info("bno: "+bno);
		log.info("bkind: "+ bkind);
		return "ch02/AjaxFragmentHtml";
	}
	
	@GetMapping("/getAjax2")
	public String getAjax2() {
		log.info("실행");
		return "ch02/AjaxJSON";
	}
	
	@GetMapping("/postMethod")//a태그
	public String postMethod() {
		log.info("실행");
		return "ch02/postMethod";
	}
	
	@PostMapping("/postFormTag")
	public String postFormTag(String bno, String bkind) {
		log.info("실행");
		log.info("bno: "+bno);
		log.info("bkind: "+ bkind);
		return "redirect:/"; //home으로 돌아감
	}
	
	@PostMapping("/postAjax1")
	public String postAjax1(String bno,String bkind) {
		log.info("실행");
		log.info("bno: "+bno);
		log.info("bkind: "+ bkind);
		return "ch02/AjaxFragmentHtml";
	}
	
	@PostMapping("/postAjax2")
	public String postAjax2(String bno,String bkind) {
		log.info("실행");
		log.info("bno: "+bno);
		log.info("bkind: "+ bkind);
		return "ch02/AjaxJSON";
	}
	
	@GetMapping("/returnModelAndView")
	public ModelAndView returnModelAndView() {
		log.info("실행");
		ModelAndView mav = new ModelAndView();
		mav.addObject("bno",15);//jsp에서 사용할 데이터
		mav.addObject("bkind","notice");
		mav.addObject("mid","user1");
		mav.addObject("memail","user1@mycompany.com");
		mav.setViewName("/ch02/returnModelAndView");
		return mav;
	}
	
	@GetMapping("/returnVoid")
	public void returnVoid(HttpServletResponse response) throws IOException {
		log.info("실행");
		//{ } : 객체 JSONObject jsonObject = new JSONObject();
		//[ ] : 배열  JSONArray jsonArray = new JSONArray();
		//{"result" : "success", "mid" : "user1" }
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "success");
		jsonObject.put("mid", "user1");
		String json = jsonObject.toString();
		
		//응답 생성(헤더(contentType)+ 본문(데이터))
		response.setContentType("application/json; Charset=UTF-8");
		PrintWriter pw = response.getWriter();//응답 본문을 작성할수 있는 printwriter객체
		pw.println(json);
		pw.flush();//버퍼비우기
		pw.close();
		}
	
		@GetMapping(value="/returnObject", produces="application/json;charset=UTF-8")//객체가 json으로 생성됨
		@ResponseBody//본문에 리턴한 객체가 들어감
		public Ch02LoginResult returnObject() {//내부적으로  json객체를  만들어서 응답
			log.info("실행");
			
			Ch02LoginResult obj = new Ch02LoginResult();
			obj.setResult("success");
			obj.setMid("user1");
			
			return obj;
		}
		
		@LoginCheck
		@GetMapping("/mypage")
		public String mypage() {
			log.info("실행");
			return "ch02/mypage";
		}
		
		@GetMapping("/loginForm")
		public String loginForm() {
			log.info("실행");
			return"ch02/loginForm";
		}
		
		@PostMapping("/login")
		public String login(String mid, String mpassword, HttpSession session) {
			log.info("실행");
			log.info("mid: "+ mid);
			log.info("mpassword: "+ mpassword);
			//세션에 로그인 정보 저장
			session.setAttribute("login", mid);
			return "redirect:/";
		}
		
		@GetMapping("/logout")
		public String logout(HttpSession session) {
			log.info("실행");
			//세션에 로그인 정보 삭제
			session.removeAttribute("login");
			return "redirect:/ch02/loginForm";
		}
		
		
}
