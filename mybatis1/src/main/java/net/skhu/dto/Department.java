package net.skhu.dto;

public class Department {
	int id;
    String departmentName;

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
}
