package net.skhu.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserRegistrationModel {
	
	@NotEmpty(message="학번을 입력하세요.")
	@Size(min=3, max=12)
	String userid;
	
	@NotEmpty(message="비밀번호를 입력하세요.")
	@Size(min=6, max=12, message="6자리 이상 12 자리 이하여야 합니다.")
	String passwd1;
	
	@NotEmpty(message="비밀번호를 한번 더 입력하세요.")
	String passwd2;
	
	@NotEmpty(message="이름을 입력하세요.")
	@Size(min=2, max=30)
	String name;
	
	@NotEmpty(message="이메일 주소를 입력하세요.")
	@Email(message="이메일 주소가 올바르지 않습니다.")
	String email;
	
	Integer departmentId;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPasswd1() {
		return passwd1;
	}

	public void setPasswd1(String passwd1) {
		this.passwd1 = passwd1;
	}

	public String getPasswd2() {
		return passwd2;
	}

	public void setPasswd2(String passwd2) {
		this.passwd2 = passwd2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	
	
	
}
