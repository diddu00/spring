package kr.or.ddit.mvc.web;

import javax.servlet.http.HttpServletRequest;

import kr.or.ddit.student.model.StudentVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@RequestMapping("/login")
@Controller
public class LoginController {
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping("/loginView")
	public String login(){
		
		return "login/login";
	}
	
	//@RequestMapping("/loginProcess")
	public String loginProcess(HttpServletRequest request){
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		logger.debug("{}","id : "+id+" password : "+password);
		
		return "main";
	}
	
	//VO의 속성이름과 파라미터의 이름이 같을때 지가 알아서 들어간다. 개이득 
	//@RequestMapping("/loginProcess")
	public String loginProcess(StudentVo stdVo){
		
		logger.debug("{}","id : "+stdVo.getStd_id()+" password : "+stdVo.getPass());
		
		return "main";
	}
	
	@RequestMapping("/loginProcess")
	public ModelAndView loginProcess2(StudentVo stdVo){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		
		mav.addObject("from", "modelAndView");
		
		
		logger.debug("{}","return ModelAndView");
		logger.debug("{}","id : "+stdVo.getStd_id()+" password : "+stdVo.getPass());
		
		return mav;
	}

}
