package com.mycompany.springframework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
//	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
	public static void main(String[] args) {
//		LOGGER.error("메세지1");
//		LOGGER.warn("메세지2");
//		LOGGER.info("메세지3");
//		LOGGER.debug("메세지4");
		log.error("메세지1");
		log.warn("메시지2");
		log.info("메시지3");
		log.debug("메시지4");
	}
	

}
