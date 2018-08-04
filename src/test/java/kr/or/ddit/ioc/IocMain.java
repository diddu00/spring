package kr.or.ddit.ioc;

import static org.junit.Assert.*;
import kr.or.ddit.ioc.dao.IocDao;
import kr.or.ddit.ioc.dao.IocDaoInf;
import kr.or.ddit.ioc.service.IocService;
import kr.or.ddit.ioc.service.IocServiceInf;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocMain {
	ApplicationContext context;
	@Before
	public void setup(){
		context = new ClassPathXmlApplicationContext("classpath:kr/or/ddit/ioc/application-ioc.xml");
	}
	
	
	@Test
	public void test() {
		//iocDao를 주입받은 iocService객체 생성
		// --> iocDao가 생성필요, iocService 생성, 주입 
		IocDaoInf iocDao = new IocDao();
		IocServiceInf iocService = new IocService(iocDao);
		
		String msg = iocService.hello();
		
		assertEquals("say ho~", msg);
		
	
	}
	
	@Test
	public void springIocTest(){
		/***Given***/
		//spring container를 생성(ApplicationContext <= spring container// ClassPathXmlApplicationContext <= 구현체)
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:kr/or/ddit/ioc/application-ioc.xml"); //xml 파일이기때문에 파일경로로 seperator를 쳐준다. 슬러시
		
		/***When***/
		//spring container로 부터 spring bean을 요청
		IocServiceInf iocService = (IocServiceInf)context.getBean("iocService"); //spring bean을 정의할때 입력한 id입력
		
		//spring bean 사용 
		String msg = iocService.hello();

		/***Then***/
		assertEquals("say ho~", msg);

	}
	
	//setter를 통한 스프링 bean 인젝션 테스트
	@Test
	public void setterDLTest(){
		/***Given***/
		//스프링 컨테이너를 생성
		
		
		/***When***/
		//setter를 사용하여 생성한 스프링 bean을 DL
		IocServiceInf iocSetterService = (IocServiceInf)context.getBean("iocSetterService"); //spring bean

		/***Then***/
		//DL를 통해 얻은 스프링 bean의 hello 메소드 호출 결과 비교
		assertEquals("say ho~", iocSetterService.hello());
	}
	
	//spring bean singleton scope test
	@Test
	public void singletonTest(){
		//디자인 패턴의 싱글톤 : jvm안에서 해당 클래스의 객체를 하나만 생성 
		/***Given***/
		//스프링 컨테이너 생성 --> setup에서 이미 생성됨
		

		/***When***/
		//spring bean iocDao, iocDao2 --> IocDao의 객체   
		IocDaoInf iocDao = (IocDaoInf) context.getBean("iocDao");
		IocDaoInf iocDao2 = (IocDaoInf) context.getBean("iocDao");
		
		/***Then***/
		assertEquals(iocDao, iocDao2);

	}
	
	//spring bean prototype scope Test
	@Test
	public void prototypeTest(){
		/***Given***/
		//스프링 컨테이너 생성

		/***When***/
		//prototype scope 를 갖는 bean을 서로다른 객체로 받느다.
		//(id = iocPrototypeDao)
		//IocDaoInf iocdao1 = //dl(iocprototypeDao)
		//IocDaoInf iocdao1 = //dl(iocprototypeDao)
		IocDaoInf iocdao1 = (IocDaoInf) context.getBean("iocPrototypeDao");
		IocDaoInf iocdao2 = (IocDaoInf) context.getBean("iocPrototypeDao");
		
		
		
		/***Then***/
		//iocDao1, iocDao2다르면 정상(프로토 타입 경우 dl을 할때마다 새로운 객체를 리턴하기 때문이다.)
		assertNotEquals(iocdao1, iocdao2);
		
	}
	
	// singleton scope 스프링 빈(iocSingletonService)에
	// prototype scope 스프링 빈(iocPrototype)을 주입하면
	// 주입받은 빈의 상태는????????????? 
	
	// -> singleton 스프링 빈에 prototype 스프링 빈을 주입할 경우
	//    prototype 정의에 따라 getter를 통해 리턴되는 빈이 매번 달라지는지 확인
	@Test
	public void singletonDIprototypeTest(){
		/***Given***/
		//스프링 컨테이너 생성

		/***When***/
		//IocService iocService = IocSingletonService(singletone scope) DL
		//IocDaoInf iocDao1 = iocService.getIocDao() // prototype scope
		//IocDaoInf iocDao2 = iocService.getIocDao() // prototype scope
		IocServiceInf iocService = (IocServiceInf) context.getBean("iocSingletonService");
		IocDaoInf iocDao1 = iocService.getIocDao();
		IocDaoInf iocDao2 =	iocService.getIocDao();
		//같다
		//내생각 -> 어차피 하나의 객체 iocService를 생성하면 singletion객체이기에 따로 더 prototype형이 생기지가 않는다 ??
		/***Then***/
		assertEquals(iocDao1, iocDao2);
	}
	

}
