package kr.or.ddit.mvc.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ValidVoValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return ValidVo.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidVo vo = (ValidVo) target;
		
		// 검증 로직
		//userId는 null이거나 white space면 안된다.
		if(vo.getUserId()==null||vo.getUserId().equals("")){
			errors.rejectValue("userId", "notNull");
		}
		
		//name은 null이거나 white space면 안된다.
		if(vo.getName()==null||vo.getName().equals("")){
			errors.rejectValue("name", "notNull");
			
		}
		
		//password는 null이거나 white space이지않고 4자리 미만이면 안된다.
		if(vo.getPassword()==null||vo.getPassword().equals("")){
			errors.rejectValue("password", "notNull");
			
		}else if(vo.getPassword().length()<4){
			errors.rejectValue("password", "size");
		}
	}
	
	
}
