package net.skhu.mapper;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.Student;

@Mapper
public interface StudentMapper {
	Student findStudent(int id);
	void updateStudent(int id, String password,String  department,String  name,String  gender,String  grade,String  phone,String  email);

	void insertStudent(int id, String password,String  department,String  name,String  gender,String  grade,String  phone,String  email);
}
