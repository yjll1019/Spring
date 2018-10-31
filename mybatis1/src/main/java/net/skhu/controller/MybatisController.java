package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.skhu.dto.Department;
import net.skhu.mapper.DepartmentMapper;
import net.skhu.mapper.StudentMapper;

@Controller
@RequestMapping("mybatis")
public class MybatisController {
	@Autowired DepartmentMapper departmentMapper;
	@Autowired StudentMapper studentMapper;
	
	@RequestMapping(value="cacheTest", method=RequestMethod.GET)
	public String cacheTest(Model model) {
		System.out.println("get");
		List<Department> departments = departmentMapper.findAll();
		model.addAttribute("departments",departments);
		model.addAttribute("department", departments.get(0));
		//findAll()메소드가 리턴한 List<student>객체의 subList(0,5) 호출 -> 결과 값들 중 선두 5개만 출력
		model.addAttribute("students", studentMapper.findAll().subList(0, 5));
		return "mybatis/cacheTest";
	}
	
	@RequestMapping(value="cacheTest", method=RequestMethod.POST)
	public String cacheTest(Model model, Department department) {
		System.out.println("post");
		departmentMapper.update(department);
		return "redirect:cacheTest";
	}
	
}
