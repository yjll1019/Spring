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
		//�Ű����� : ������ �����̳ʰ� �α׾ƿ��� ��û�� �������� ���ε� ���� ��ü�� ã�Ƽ� �Ѱ��ش�.
		System.out.println("�α׾ƿ� ó��");
		
		//1.�������� ����� ���� ��ü�� ���� �����Ѵ�.
		session.invalidate();

		return "login.jsp";
	}
}
