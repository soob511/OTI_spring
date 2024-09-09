package com.mycompany.springframework;

import javax.transaction.Transactional;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringJUnitWebConfig(locations= {
		"classpath:spring/root/*.xml",
		"classpath:spring/dispatcher/*.xml"
		
})

@Transactional
public abstract class WebAppTest {

	
}
