package net.skhu.dto;

import java.io.Serializable;
import java.util.Date;

//데이터를 객체에 담기 위해서 Serializable인터페이스 implements
public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//버전 번호 >> 객체의 멤버 변수 목록이 수정될 때마다 번호 1씩 증가.
	
	int id;
	String studentNumber;
	String name;
	int departmentId;
	int year;
	String departmentName;
	Date time;
	Department department;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
