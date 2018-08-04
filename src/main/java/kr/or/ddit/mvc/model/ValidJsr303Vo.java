package kr.or.ddit.mvc.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;



public class ValidJsr303Vo {
	//userId, name, password
	@NotEmpty
	private String userId;
	
	@NotEmpty
	private String name;
	
	@Size(min=4)
	@NotEmpty
	private String password;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
