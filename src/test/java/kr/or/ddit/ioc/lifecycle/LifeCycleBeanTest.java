package kr.or.ddit.ioc.lifecycle;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleBeanTest {
	//spring container 생성(before)
	ApplicationContext context;
	Logger logger = LoggerFactory.getLogger(LifeCycleBeanTest.class);
	
	@Before
	public void setup(){
		context = new ClassPathXmlApplicationContext("classpath:kr/or/ddit/ioc/application-lifecycle.xml");
	}
	
	
	@Test
	public void LifeCycleBeanTest() {
		/***Given***/
		

		/***When***/
		LifeCycleBean lifeCycleBean = context.getBean("lifeCycleBean",LifeCycleBean.class);
		
		logger.debug("{}",lifeCycleBean);
		/***Then***/
		
	}
	

}
