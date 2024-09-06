package com.mycompany.springframework.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
@Order(2)
public class Ch14Aspect1Before {
	//퍼블릭이 붙어있고 리턴타입은 상관없고 before타입으로 시작할때 매개변수는 뭐든지와도 상관없음
	@Before("execution(public * com.mycompany.springframework.controller.Ch14Controller.before*(..))")
	public void method() {
		//공통코드(메소드 호출 전에 실행하는 코드)
		log.info("메소드 호출 전에 실행");
	}

}
