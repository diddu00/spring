package kr.or.ddit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.student.model.StudentVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ProfileInterceptor extends HandlerInterceptorAdapter{

	Logger logger = LoggerFactory.getLogger(ProfileInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		request.setAttribute("startTime", System.currentTimeMillis());
		
		HttpSession session = request.getSession();
		//로그인을 정상적으로 하고, 일정시간동안 서비스를 사용중이라면
		//로그인시 저장된 session 정보가 존재해야함
		StudentVo std = (StudentVo)session.getAttribute("studentVO");
		if(std==null){
			response.sendRedirect("/login/loginView");
			return false;
		}
		
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
			
		long startTime=(long)request.getAttribute("startTime");
		long endTime = System.currentTimeMillis();
		
		logger.debug(request.getRequestURI()+" profiling : {} ", endTime - startTime);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		long startTime = (long)request.getAttribute("startTime");
		long endTime = System.currentTimeMillis();
		
		logger.debug(request.getRequestURI()+" afterCompletion profiling : {}", endTime-startTime);
		
	}
	
}
