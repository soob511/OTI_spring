package com.mycompany.springframework.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch17AuthenticationSuccessHandler 
//로그인 성공시 사용자가 요청한 페이지로 이동

extends SavedRequestAwareAuthenticationSuccessHandler{

//로그인 성공시 지정한 페이지로 이동
//extends SimpleUrlAuthenticationSuccessHandler{
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		log.info("실행");
		//extends SimpleUrlAuthenticationSuccessHandle사용할 경우
		//setDefaultTargetUrl("/"); //여기로 강제적으로 이동
		
		super.onAuthenticationSuccess(request, response, authentication);//부모가 갖고있는 메소드를 재호출해줘야함 
	}
	

}
