package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.MySubject;

@Mapper
public interface MySubjectMapper {
	void insert(List<MySubject> mySubjects);
	List<MySubject> findAll(int userId);//학생이 수강한 전체 과목을 조회.
	List<MySubject> findByCode(int userId, String code);
	List<MySubject> findByName(int userId, String name);
}
