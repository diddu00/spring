package kr.or.ddit.ioc.placeholder;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class placeholderTest {
	ApplicationContext context;
	
	@Before
	public void setup(){ //'classpath:' 안써도 굴러가는데?
		context = new ClassPathXmlApplicationContext("classpath:kr/or/ddit/ioc/application-placeholder.xml");
	}
	
	@Test
	public void placeholderTest() {
		/***Given***/
		//스프링 컨테이너 생성

		/***When***/
		//jdbcInfo bean DL
		JdbcInfo jdbcInfo = context.getBean("jdbcInfo",JdbcInfo.class);
		
		/***Then***/
		assertEquals("jdbc:oracle:thin:@192.168.207.135:1521:xe", jdbcInfo.getUrl());
		assertEquals("oracle.jdbc.driver.OracleDriver", jdbcInfo.getDriver());
		assertEquals("pc11", jdbcInfo.getUsername());
		assertEquals("java", jdbcInfo.getPassword());

	}

}
