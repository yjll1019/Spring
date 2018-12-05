package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {
	@RequestMapping("/logout.do")
	public String logout (HttpSession session) { 
		//매개변수 : 스프링 컨테이너가 로그아웃을 요청한 브라우저와 매핑된 세션 객체를 찾아서 넘겨준다.
		System.out.println("로그아웃 처리");
		
		//1.브라우저와 연결된 세션 객체를 강제 종료한다.
		session.invalidate();

		return "login.jsp";
	}
}
