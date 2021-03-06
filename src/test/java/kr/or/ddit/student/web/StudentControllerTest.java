package kr.or.ddit.student.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.student.model.StudentVo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

/*
 * spring controller test 설정
 * 
 * 1. Spring을 junit에서 사용할 수 있도록 설정 : @RunWith(Springjunit4ClassRunner.class)
 * 2. Spring 설정 파일 설정 : @ContextConfiguration
 * 3. Spring container가 웹 어플리케이션 컨텍스트로 생성될 수 있도록 설정 : @WebAppConfiguration -> WebApplicationContext객체 생성가능
 * 
 * 4. 스프링 웹 환경과 동일하게 요청을 할 수 있도록 dispathcerServlet 역할을 하는 MockMvc 객체 생성
 * 		--> MockMvc를 생성하기 위해서는 WebApplicationContext 객체가 필요
 * 
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/servlet-context.xml",
								"classpath:kr/or/ddit/config/spring/root-context.xml"})
@WebAppConfiguration
public class StudentControllerTest {
	
	@Resource
	private WebApplicationContext context;
	
	//mockMvc
	private MockMvc mvc;
	
	@Before
	public void setup(){
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	
	@Test
	public void studentListTest() throws Exception {
		/***Given***/
		MvcResult result=mvc.perform(get("/student/list").param("page","1").param("pageSize","10")).andReturn();

		/***When***/

		/***Then***/
		//viewName(student/list)
		//속성들(studentList, totCnt, pageNavi)
		
		ModelAndView mav = result.getModelAndView();
		assertEquals("student/list", mav.getViewName());
		List<StudentVo> studentList=(List<StudentVo>) mav.getModel().get("studentList");
		
		assertEquals(10, studentList.size());
		assertTrue((Integer)mav.getModel().get("totCnt")>10);
		assertNotNull(mav.getModel().get("pageNavi"));
		
		
	
	
	}
	
	@Test
	public void studentDetailTest() throws Exception{
		/***Given***/
		MvcResult result = mvc.perform(get("/student/detail").param("id", "9")).andReturn();

		/***When***/
		ModelAndView mav = result.getModelAndView();
		StudentVo stdVo = (StudentVo) mav.getModel().get("studentVo");
		/***Then***/
		assertNotNull(mav);
		assertEquals("student/detail", mav.getViewName());
		assertEquals("차득림", stdVo.getName());

	}

}
