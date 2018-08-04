package kr.or.ddit.ioc.annotation;

import org.springframework.stereotype.Component;


@Component("annotationBean")
public class AnnotationBean {
	private String name;

	public AnnotationBean() {
		this.name = "Conny";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
