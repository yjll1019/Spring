package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.Student;

@Mapper
public interface StudentMapper {
	   public Student findOne(int id);
	   public Student findByStudentNumber(String studentNumber);
	   public List<Student> findAllWithDepartment();
	   public List<Student> findByDepartmentId(int departmentId);
	   public List<Student> findAll();
	   public void insert(Student student);
	   public void update(Student student);
	   public void delete(int id);
	   
}
