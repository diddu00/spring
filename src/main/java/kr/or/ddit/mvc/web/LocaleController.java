package kr.or.ddit.mvc.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/locale")
@Controller
public class LocaleController {
	
	@ModelAttribute("localeMap")
	public Map<String, String> localeMap(){
		Map<String, String> localeMap = new HashMap<String, String>();
		localeMap.put("ko", "한국어");
		localeMap.put("jp", "일본어");
		localeMap.put("en", "Engilsh");
		
		return localeMap;
	}
	
	@RequestMapping("/view")
	public String view(Model model){
		
		return "locale/view";
	}
	
	/*
	 * 어떤 view resolver에서 처리될지를 결정 : 
	 * 			servlet-context.xml에 설정된 view resolver의 우선순위에 따라 결정
	 * 
	 * 현재 대덕인재개발월 207호 설정상황
	 * 
	 * beanNameViewResolver : priority 1
	 * tilesViewResolver 	: priority 2
	 * internalResourceViewResolver : priority 3
	 * 
	 * view이름으로 "locale/view" 를 controller에서 리턴한 경우
	 * 1. beanNameViewResolver에 의해 spring bean 중 이름이 "locale/view"를 갖는 view가 등록되어있는지 확인
	 * 	===> bean이 존재하지 않음 --> 다음 viewResolver로 이동
	 * ** "jsonView", "excelDownloadView", "fileDownloadView"
	 * 
	 * 2. tilesViewResolver를 통해 tiles-config.xml에 설정된 defination name 중
	 *    "locale/view"와 일치하는 defination이 존재하는 지 확인
	 *  ===> name이 일치하는 defination이 존재하지 않음 --> 다음 viewResolver로 이동
	 *  
	 * 3. internalResourceViewResolver
	 * 	  internalResourceViewResolver는 해당 리소스가 존재 하는 지 여부 확인하지 않고
	 * 	  prefix + viewName + surfix로 forward 처리함
	 *  ===> viewName에 해당하는 리소스가 없을 경우 404에러 
	 *  --> 이녀석이 마지막에 와야되는데 왜 그렇냐면 애는 확인안하고 무조건 내보내 있으면 뜨는거고 없으면 에러가 나오지
	 *  --> 1순위면 이자식이 다 에러뜨게 해서 뒤에잇는애들이 소용이 없어서 그래 ㅇㅋ? ㅇ
	 */

}
