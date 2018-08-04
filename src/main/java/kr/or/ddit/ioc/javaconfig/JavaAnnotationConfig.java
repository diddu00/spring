package kr.or.ddit.ioc.javaconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@Configuration	
@ComponentScan(basePackages={"kr.or.ddit.ioc"}) //=>  @Component , @Controller, @Service, @Repository 에대해서 scan
public class JavaAnnotationConfig {

}
