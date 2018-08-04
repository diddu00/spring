package kr.or.ddit.mvc.web;

import javax.annotation.Resource;

import kr.or.ddit.ioc.service.IocServiceInf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/hello")
@Controller
public class HelloController {
	
	@Resource(name="iocAnnotationService")
	private IocServiceInf iocService;
	
	//return:view 이름
	//localhost:8180/hello/view 호출 시 나옴
	@RequestMapping("/view")
	public String hello(Model model){
		
		//BoardServiceInf boerService = new BoardService();
		//매번 이걸 재생성한다는 것은 쉣이다. 
		
		String msg = iocService.hello();
		// -> hello()와 리턴 값을 hello.jsp에서 출력 하고 싶다.
		//   -> 어떻게 해야 하는것인가?
		model.addAttribute("msg", msg);
		
		
		//default 기본적으로 forward이다.
		//redirect : hello
		return "hello";
		//prefix : /WEB-INF/views/
		//suffix : .jsp
		// -->/WEB-INF/views/hello.jsp
	}
	
	
}
