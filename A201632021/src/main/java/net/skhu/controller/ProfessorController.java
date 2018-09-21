package net.skhu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.Department;
import net.skhu.dto.Professor;
import net.skhu.mapper.DepartmentMapper;
import net.skhu.mapper.ProfessorMapper;

@Controller
@RequestMapping("/c201632021")
public class ProfessorController {
	@Autowired DepartmentMapper departmentMapper;
	@Autowired ProfessorMapper professorMapper;
	
	@RequestMapping("list1")
	public String list1(Model model) {
		List<Professor> professors = professorMapper.findAll();
		model.addAttribute("professors",professors);
		return "c201632021/list1";
	}
	
	@RequestMapping("edit")
	public String edit(Model model, int id) {
		Professor professor = professorMapper.findOne(id);
		model.addAttribute("professor",professor);
		
		List<Department> departments = departmentMapper.findAll();
		model.addAttribute("departments",departments);
		return "c201632021/edit";
	}
	
	@RequestMapping("list2")
	public String list2(Model model, @RequestParam("departmentId") int id) {
		List<Professor> professors = professorMapper.findByDepartment(id);
		model.addAttribute("professors",professors);
		return "c201632021/list2";
	}
}
