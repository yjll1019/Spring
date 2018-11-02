package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Category;
import net.skhu.mapper.CategoryMapper;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired CategoryMapper categoryMapper;
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<Category> categoryList = categoryMapper.findAll();
		model.addAttribute("categoryList", categoryList);
		return "category/list";
	}
	
}
