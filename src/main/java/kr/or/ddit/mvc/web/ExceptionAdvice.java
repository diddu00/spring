package kr.or.ddit.mvc.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionAdvice {
	
	
	@ExceptionHandler({ArithmeticException.class})
	public String handleException(Throwable e, HttpServletResponse response){
		
		return "error/arith";
	}
	
}
