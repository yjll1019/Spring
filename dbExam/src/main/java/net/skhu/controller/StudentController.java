package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.skhu.dto.MySubject;
import net.skhu.dto.Student;
import net.skhu.dto.User;
import net.skhu.mapper.MySubjectMapper;
import net.skhu.mapper.StudentMapper;
import net.skhu.service.ExcelService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired StudentMapper studentMapper;	
	@Autowired ExcelService excelService;
	@Autowired MySubjectMapper mySubjectMapper;	
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(Model model) {
		System.out.println("user get컨트롤러");
		return "join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(Model model, @RequestParam("userId") String userId, @RequestParam("password") String password,@RequestParam("department") String department, @RequestParam("name") String name , 
			@RequestParam("gender") String gender, @RequestParam("grade") String grade,
			 @RequestParam("phone") String phone,@RequestParam("email") String email) {
		Student student = new Student();
		
		System.out.println("join POST컨트롤러");

		Student result = studentMapper.findStudent(Integer.parseInt(userId));
		
		if(result==null) {//해당하는 아이디가 없을 때
			System.out.println("user아이디없음");

			student.setUserId(Integer.parseInt(userId));
			student.setDepartment(department);
			student.setName(name);
			student.setGender(gender);
			student.setGrade(grade);
			student.setPhone(phone);
			student.setEmail(email);
			student.setPassword(password);
			
			
			studentMapper.insertStudent(Integer.parseInt(userId), password, department, name, gender, grade, phone, email);
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
	public String login(Model model, @RequestParam("id") String id,  @RequestParam("password") String password) {
		System.out.println("login post컨트롤러");
		System.out.println("id"+" "+id);
		System.out.println("password"+" "+password);
		
		Student result = studentMapper.findStudent(Integer.parseInt(id));
		
		if(result==null) {
			model.addAttribute("result", -1); //해당 아이디 없을 때
		}else {
			if(result.getPassword().equals(password)) {//로그인 성공
				model.addAttribute("result", 1);
				model.addAttribute("id", id);
			}else {
				model.addAttribute("result", -2);
			}
		}
		
		return "login";
	}
	
	@RequestMapping(value="/userEdit", method=RequestMethod.GET)
	public String userEdit(Model model, @RequestParam("id") String id) {
		System.out.println("userEdit get컨트롤러");
		System.out.println("id는"+id);
		Student student = studentMapper.findStudent(Integer.parseInt(id));
		
		model.addAttribute("student", student);
		model.addAttribute("user", id);
		return "userEdit";
	}
	
	@RequestMapping(value="/userEdit", method=RequestMethod.POST)
	public String userEdit(Model model, @RequestParam("userId") String userId, @RequestParam("password") String password,@RequestParam("department") String department, @RequestParam("name") String name , 
			@RequestParam("gender") String gender, @RequestParam("grade") String grade,
			 @RequestParam("phone") String phone,@RequestParam("email") String email) {
		System.out.println("userEdit post컨트롤러");
		
		System.out.println("아이디"+userId);
		System.out.println("이름"+name);
		
		studentMapper.updateStudent(Integer.parseInt(userId), password, department, name, gender, grade, phone, email);
		
		return "redirect:userEdit?id="+userId;
	}
	
	// 수강한 목록 엑셀 업로드
		@RequestMapping(value="fileUpload", method=RequestMethod.GET)
		public String replace_upload(Model model, @RequestParam("id") String id) {
			System.out.println("fileUpload get컨트롤러");
			model.addAttribute("id", id);
			return "fileUpload";
			
		}
		
		// 수강한 목록 엑셀 업로드
		@RequestMapping(value="mySubject_upload", method=RequestMethod.POST)
		public String replace_upload(Model model,  RedirectAttributes redirectAttributes, @RequestParam("id") String id, @RequestParam("file") MultipartFile file) throws Exception{
			System.out.println("mySubject_upload POST컨트롤러");
			
			if(!file.isEmpty()) {
				List<MySubject> mySubjects = excelService.getMySubjectList(file.getInputStream(), Integer.parseInt(id));
			//	mySubjectMapper.deleteById(user.getId());
				mySubjectMapper.insert(mySubjects);
				redirectAttributes.addAttribute("userid", id);
			//	model.addAttribute("id",id);
				return "redirect:subjectList";
			} else {
				return "redirect:fileUpload?r=-1";
			}
		}

		//수강과목 리스트
		@RequestMapping(value="subjectList", method=RequestMethod.GET)
		public String subjectList(Model model, @RequestParam("userid") String id) {
			System.out.println("mySubjectlist get컨트롤러");
			//int userId = 201632009;
			List<MySubject> mySubjectlist = mySubjectMapper.findAll(Integer.parseInt(id));
			model.addAttribute("mySubjectlist", mySubjectlist);
			model.addAttribute("id", id);
			return "subjectList";
			
		}

		//수강과목 리스트
		@RequestMapping(value="subjectList", method=RequestMethod.POST)
		public String subjectList(Model model,  @RequestParam("id") String id,@RequestParam("searchText") String searchText) {
			System.out.println("subjectList post컨트롤러");
		
			System.out.println("searchText"+searchText);
			
			List<MySubject> mySubjectlist;
			if(searchText==null) {//과목코드 검색
				mySubjectlist = mySubjectMapper.findAll(Integer.parseInt(id));
			}else{//과목명 검색
				mySubjectlist = mySubjectMapper.findByName(Integer.parseInt(id), "%"+searchText+"%");
			}
			model.addAttribute("mySubjectlist", mySubjectlist);
			model.addAttribute("userid", id);
			return "subjectList";
		}
}
