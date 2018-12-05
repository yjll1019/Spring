package com.springbook.view.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController {
	@RequestMapping("/login.do") //클라이언트에서 login.do 요청이 있으면 이 메소드와 매핑.
	public String login(UserVO vo, UserDAO userDAO) {
		System.out.println("로그인 처리");
		
		if(userDAO.getUser(vo)!=null) return "getBoardList.do";
		else return "login.jsp"; //아이디 또는 비밀번호가 맞지 않아서 vo = null인 경우
	}
	
}
