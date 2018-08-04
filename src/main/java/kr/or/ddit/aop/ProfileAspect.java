package kr.or.ddit.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//메소드 실행 전 후 시간을 측정할 aspect
//메소드 실행 로그
public class ProfileAspect {
	private Logger logger = LoggerFactory.getLogger(ProfileAspect.class);
	
	//메소드 실행 전 로그 작성
	public void beforeMethod(JoinPoint point){
		String className = point.getTarget().getClass().getSimpleName();
		String methodName = point.getSignature().getName();
		logger.debug("className : {}, methodName : {}",className,methodName);
	}
	
}
