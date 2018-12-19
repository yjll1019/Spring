package net.skhu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.domain.Course;
import net.skhu.domain.Registration;
import net.skhu.domain.Student;
import net.skhu.repository.CourseRepository;
import net.skhu.repository.ProfessorRepository;
import net.skhu.repository.RegistrationRepository;
import net.skhu.repository.StudentRepository3;

@RestController	
@RequestMapping("api5")
public class API5Controller {
	
	@Autowired StudentRepository3 studentRepository;
	@Autowired RegistrationRepository registrationRepository;
	@Autowired CourseRepository courseRepository;
	@Autowired ProfessorRepository professorRepository;
	
	
	//어느 학생이 수강하는 강좌 목록을 조회하는 REST 액션 메소드 구현.
	@RequestMapping("student/{id}/courses")
	public List<Course> studentCourses(@PathVariable("id") int id){
		//학생 의 registrations->여기서 getcourse
		Student s = studentRepository.findById(id).get();
		List<Course> list = new ArrayList<Course>();
		
		for(Registration r : s.getRegistrations())
			list.add(r.getCourse());
		
		return list;
	}
	
	@RequestMapping("student/{id}/courses1")
	public List<Course> studentCourses1(@PathVariable("id") int id){
		//학생 의 registrations->여기서 getcourse
		List<Course> list = new ArrayList<Course>();
		
		for(Registration r : registrationRepository.findByStudentId(id))
			list.add(r.getCourse());
		
		return list;
	}
	
	@RequestMapping("student/{id}/courses2")
	public List<Course> studentCourses2(@PathVariable("id") int id){
		//학생 의 registrations->여기서 getcourse
		return courseRepository.findByStudentId(id);
	}

	//어느 교수가 강의하는 강좌 목록을 조회하는 메소드 구현
	@RequestMapping("professor/{id}/courses")
	public List<Course> professorCourses(@PathVariable("id") int id){
		return professorRepository.findById(id).get().getCourses();
	}
	
	@RequestMapping("professor/{id}/courses2")
	public List<Course> professorCourses2(@PathVariable("id") int id){
		return courseRepository.findByProfessorId(id);
	}
	
	@RequestMapping("professor/{id}/courses3")
	public List<Course> professorCourses3(@PathVariable("id") int id){
		return courseRepository.findByProfessorId2(id);
	}
}
