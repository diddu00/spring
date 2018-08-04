package kr.or.ddit.mvc.web;

import javax.validation.Valid;

import kr.or.ddit.mvc.model.ValidJsr303Vo;
import kr.or.ddit.mvc.model.ValidVo;
import kr.or.ddit.mvc.model.ValidVoValidator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/valid")
@Controller
public class ValidatorController {
	
	@RequestMapping("/view")
	public String view(){
		
		
		return "mvc/valid/view";
	}
	
	@RequestMapping("/submit")
	//bindResult 객체는 검증하기위한 vo객체의 바로 뒤에 선언되어야 한다. 꼭 !
	public String submit(ValidVo validVo,BindingResult errors, Model model){
		new ValidVoValidator().validate(validVo, errors);
		
		if(errors.hasErrors()){
			model.addAttribute("errorMsg","에러가 발생했습니다.");
		}
		
		model.addAttribute("validVo", validVo);
		
		return "mvc/valid/view";
	}
	
	@RequestMapping("/submit/valid")
	//bindResult 객체는 검증하기위한 vo객체의 바로 뒤에 선언되어야 한다. 꼭 !
	public String submitValid(@Valid ValidVo validVo,BindingResult errors, Model model){
		new ValidVoValidator().validate(validVo, errors);
		
		if(errors.hasErrors()){
			model.addAttribute("errorMsg","에러가 발생했습니다.");
		}
		
		model.addAttribute("validVo", validVo);
		
		return "mvc/valid/view";
	}
	
	@InitBinder
	public void initBinder (WebDataBinder binder){
		binder.setValidator(new ValidVoValidator());
	}
	
	
	
	@RequestMapping("/submit/jsr303")
	//bindResult 객체는 검증하기위한 vo객체의 바로 뒤에 선언되어야 한다. 꼭 !
	public String submitJsr303(ValidJsr303Vo validJsr303Vo,BindingResult errors, Model model){
		
		if(errors.hasErrors()){
			model.addAttribute("errorMsg","에러가 발생했습니다.");
		}
		
		model.addAttribute("validJsr303Vo", validJsr303Vo);
		
		return "mvc/valid/view";
	}
	
}
