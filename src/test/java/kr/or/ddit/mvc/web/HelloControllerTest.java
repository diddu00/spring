package kr.or.ddit.mvc.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/root-context.xml","classpath:kr/or/ddit/config/spring/servlet-context.xml"})
@WebAppConfiguration //applicationContext 객체를 WebApplicationContext로 사용하도록 설정
public class HelloControllerTest {
	
	Logger logger = LoggerFactory.getLogger(HelloControllerTest.class);
	
	//스프링의 모든 요청: dispatcherServlet이 처리
	//우선 컨테이너의 도움이 필요함 
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc; //dispatcher Servlet
	
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	

	//helloController spring 빈을 주입 받을 수 있다.
	@Resource(name="helloController")
	HelloController helloController;
	
	@Test
	public void helloControllerTest() {
		assertNotNull(helloController);
		
	}
	
	
	//hello jsp 요청 테스트 
	@Test
	public void helloControllerViewTest() throws Exception{
		//url로 요청(httpMethod : get/ post);
		MvcResult result = mockMvc.perform(get("/hello/view")).andReturn();
		ModelAndView mav = result.getModelAndView();
		String viewName=mav.getViewName();
		logger.debug("{}","viewName : "+viewName);
		assertEquals("hello",viewName);
		
		//model : msg
		Map<String, Object> model = mav.getModel();
		String msg = (String) model.get("msg");
		logger.debug("{}","msg : "+msg);
		assertEquals("say ho~", msg);
	}

}
