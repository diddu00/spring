package kr.or.ddit.ioc.javaconfig;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import kr.or.ddit.ioc.dao.IocDaoInf;
import kr.or.ddit.ioc.service.IocAnnotationService;
import kr.or.ddit.ioc.service.IocServiceInf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={JavaAnnotationConfig.class})
public class JavaAnnotationConfigTest {
	
	
	//iocDao, iocAnnotationService 주입
	@Resource(name="iocDao")
	private IocDaoInf iocDao;
	
	@Resource(name="iocAnnotationService")
	private IocServiceInf iocService;
	
	
	@Test
	public void javaAnnotationConfigTest() {
		/***Given***/
		

		/***When***/
		
		/***Then***/
		assertEquals("say ho~", iocDao.hello());
		assertEquals("say ho~", iocService.hello());
		assertEquals(iocDao, iocService.getIocDao());
		
	}

}
