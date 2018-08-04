package kr.or.ddit.ioc.annotation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanTest {
ApplicationContext context;
	
	@Before
	public void setup(){ //'classpath:' 안써도 굴러가는데? -> 걍써라 
		context = new ClassPathXmlApplicationContext("classpath:kr/or/ddit/ioc/application-annotation.xml");
	}
	
	@Test
	public void test() {
		/***Given***/
		

		/***When***/
		//annotationBean DL
		AnnotationBean temp = context.getBean("annotationBean",AnnotationBean.class);
		
		/***Then***/
		assertEquals("Conny", temp.getName());

	}

}
