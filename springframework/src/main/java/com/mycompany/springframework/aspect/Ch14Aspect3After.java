package com.mycompany.springframework.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class Ch14Aspect3After {
	//퍼블릭이 붙어있고 리턴타입은 상관없고 before타입으로 시작할때 매개변수는 뭐든지와도 상관없음
	@After("execution(public * com.mycompany.springframework.controller.Ch14Controller.after*(..))")
	public void method() {
		//공통코드(메소드 호출 후에 실행하는 코드)
		log.info("메소드 호출 후에 실행");
	}

}
