package kr.or.ddit.mvc.web;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("/json")
@Controller
public class JsonController {
	
	@ModelAttribute("rangers")
	public void rangers(Model model){
		List<String> list = new ArrayList<String>();
		list.add("brown");	
		list.add("sally");	
		list.add("cony");	
		
			
		model.addAttribute("rangers", list);
	}
	
	//rangers 리스트를 json응답으로 생성
	@RequestMapping("/data")
	public String data(){
		
		return "jsonView";
		//지금까지 jsp이름 리턴 (폴더를 포함한 경로와 jsp파일 이름)
		//현재까지 viewResolver 설정상황
		//1. 두개의 order 0 : beanNameViewResolver
		//        order 1 : internalResourceViewResorlver
	}
	
	//ragners 리스트를 json 응답으로 생성(@ResponseBody)
	@RequestMapping("/data/responseBody")
	@ResponseBody
	public List<String> dataResponseBody(Model model){
		List<String> rangers = (List<String>)model.asMap().get("rangers");
		return rangers;
	}
	
	//json 요청 테스트를 위한 view
	@RequestMapping("/requestView")
	public String requestView(){
		return"json/view";
	}
	
	//json 요청 처리
	@RequestMapping("requestBody")
	@ResponseBody
	public List<String> requestBody(@RequestBody List<String> rangers){
		for (int i = 0; i < rangers.size(); i++) {
			rangers.set(i, rangers.get(i)+UUID.randomUUID().toString()+"     ");
		}
		return rangers;
	}
	
	@RequestMapping("/excelData")
	public String exceData(){
		return "excelDownloadView";
	}
	
	@RequestMapping("/fileDown")
	public String fileDown(@RequestParam("fileName")String fileName, Model model){
		model.addAttribute("fileName",fileName);
		return "fileDownloadView";
	}
	
	
	
	
	
	
	
}
