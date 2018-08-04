package kr.or.ddit.ioc.javaconfig;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import kr.or.ddit.ioc.dao.IocDaoInf;
import kr.or.ddit.ioc.service.IocServiceInf;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={JavaConfig.class})
public class JavaConfigTest {
	
	//iocDao, iocService (지금 빈이 설정된 2개)
	@Resource(name="iocDao")		// 빈 주입중.. 바로 사용가능
	private IocDaoInf iocDao;
	
	@Resource(name="iocService")
	private IocServiceInf iocService;
	
	
	@Test
	public void javaConfigTest() {
		/***Given***/
		

		/***When***/
		//iocDao, iocService가 정상적으로 주입 되었는지 확인 
		//기존 : spring container 에서 DL
		//지금 : @Resource(name="스프링 빈")을 통해 주입
		
		/***Then***/
		//iocDao.hello() => "say ho~"
		//iocService.hello() => "say ho~"
		//iocDao, iocService.getIocDao()
		assertEquals("say ho~", iocDao.hello());
		assertEquals("say ho~", iocService.hello());
		assertEquals(iocDao, iocService.getIocDao());
	}

}
