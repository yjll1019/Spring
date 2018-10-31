package net.skhu.dto;

import java.io.Serializable;
import java.util.Date;

//캐시에 저장할 객체이기 때문에 Serializable인터페이스 implements
public class Department implements Serializable{
	private static final long serialVersionUID = 1L; //버전 번호 >> 객체의 멤버 변수 목록이 수정될 때마다 번호 1씩 증가.
	
	int id;
    String departmentName;
    Date time;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() { 
        return departmentName;
    }

    public void setDepartmentName(String departmentName) { //set + a >> a 가 db컬럼명과 일치해야 set기능이된다.
        this.departmentName = departmentName;
    }

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
    
    
}

