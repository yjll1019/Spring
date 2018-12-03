package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.skhu.dto.MySubject;
import net.skhu.dto.User;
import net.skhu.mapper.MySubjectMapper;
import net.skhu.mapper.UserMapper;
import net.skhu.service.ExcelService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired UserMapper userMapper;	
	@Autowired ExcelService excelService;
	@Autowired MySubjectMapper mySubjectMapper;	
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(Model model) {
		System.out.println("user get컨트롤러");
		return "join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(Model model, @RequestParam("id") String id, @RequestParam("password") String password, @RequestParam("name") String name) {
		User user = new User();
		System.out.println("user POST컨트롤러");

		User result = userMapper.findUser(Integer.parseInt(id));
		
		if(result==null) {//해당하는 아이디가 없을 때
			System.out.println("user아이디없음");

			user.setId(Integer.parseInt(id));
			user.setPassword(password);
			user.setName(name);
			userMapper.insertUser(user);
			model.addAttribute("result", 0);
		//	return "redirect:login";
		}else {
			model.addAttribute("result", -1);
		}
		return "join";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		System.out.println("login get컨트롤러");
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Model model, @RequestParam("id") String id, @RequestParam("password") String password) {
		System.out.println("login post컨트롤러");
		System.out.println("id"+" "+id);
		System.out.println("password"+" "+password);
		
		User result = userMapper.findUser(Integer.parseInt(id));
		
		if(result==null) {
			model.addAttribute("result", -1); //해당 아이디 없을 때
		}else {
			if(result.getPassword().equals(password)) {//로그인 성공
				model.addAttribute("result", 1);
			}else {
				model.addAttribute("result", -2);
			}
		}
		
		return "login";
	}
	
	@RequestMapping(value="/userList", method=RequestMethod.GET)
	public String userList(Model model) {
		System.out.println("userList get컨트롤러");
		
		List<User> userList = userMapper.findByAll();
		
		model.addAttribute("userList", userList);
		
		return "userList";
	}
	
	@RequestMapping(value="/userList", method=RequestMethod.POST)
	public String userList(Model model, @RequestParam("search") String search, @RequestParam("searchText") String searchText) {
		System.out.println("userList post컨트롤러");
		System.out.println("search"+search);
		System.out.println("searchText"+searchText);
		List<User> userList;
		if(search.equals("0")) {//id검색
			userList = userMapper.findById(Integer.parseInt(searchText));
		}else if(search.equals("1")){//name검색
			userList = userMapper.findByName(searchText);
		}else {
			userList = userMapper.findByAll();
		}
		model.addAttribute("userList", userList);

		return "userList";
	}
	
	@RequestMapping(value="/userEdit", method=RequestMethod.GET)
	public String userEdit(Model model, @RequestParam("id") String id) {
		System.out.println("userEdit get컨트롤러");
		System.out.println("id는"+id);
		User user = userMapper.findUser(Integer.parseInt(id));
		
		model.addAttribute("user", user);
		
		return "userEdit";
	}
	
	@RequestMapping(value="/userEdit", method=RequestMethod.POST)
	public String userEdit(Model model, @RequestParam("userid") String id, @RequestParam("name") String name) {
		System.out.println("userEdit post컨트롤러");
		
		System.out.println("아이디"+id);
		System.out.println("이름"+name);
		
		userMapper.updateUser(Integer.parseInt(id), name);
		
		return "redirect:userList";
	}
	
	// 수강한 목록 엑셀 업로드
	@RequestMapping(value="mySubject_upload", method=RequestMethod.POST)
	public String replace_upload(Model model, @RequestParam("file") MultipartFile file) throws Exception{
		System.out.println("mySubject_upload POST컨트롤러");
		int id = 201632009;
		if(!file.isEmpty()) {
			List<MySubject> mySubjects = excelService.getMySubjectList(file.getInputStream(), id);
		//	mySubjectMapper.deleteById(user.getId());
			mySubjectMapper.insert(mySubjects);
			return "redirect:subjectList";
		} else {
			return "redirect:fileUpload?r=-1";
		}
	}
	
	// 수강한 목록 엑셀 업로드
	@RequestMapping(value="fileUpload", method=RequestMethod.GET)
	public String replace_upload(Model model) {
		System.out.println("fileUpload get컨트롤러");
		
		return "fileUpload";
		
	}

	//수강과목 리스트
	@RequestMapping(value="subjectList", method=RequestMethod.GET)
	public String subjectList(Model model) {
		System.out.println("mySubjectlist get컨트롤러");
		int userId = 201632009;
		List<MySubject> mySubjectlist = mySubjectMapper.findAll(userId);
		model.addAttribute("mySubjectlist", mySubjectlist);
		return "subjectList";
		
	}

	//수강과목 리스트
	@RequestMapping(value="subjectList", method=RequestMethod.POST)
	public String subjectList(Model model, @RequestParam("search") String search, @RequestParam("searchText") String searchText) {
		System.out.println("subjectList post컨트롤러");
		System.out.println("search"+search);
		System.out.println("searchText"+searchText);
		
		int userId = 201632009;

		List<MySubject> mySubjectlist;
		if(search.equals("0")) {//과목코드 검색
			mySubjectlist = mySubjectMapper.findByCode(userId, searchText);
		}else if(search.equals("1")){//과목명 검색
			mySubjectlist = mySubjectMapper.findByName(userId, "%"+searchText+"%");
		}else {
			mySubjectlist = mySubjectMapper.findAll(userId);
		}
		model.addAttribute("mySubjectlist", mySubjectlist);
		return "subjectList";
	}
}
