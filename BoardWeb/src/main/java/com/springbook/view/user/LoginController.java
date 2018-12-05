package com.springbook.view.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController {
	@RequestMapping("/login.do") //Ŭ���̾�Ʈ���� login.do ��û�� ������ �� �޼ҵ�� ����.
	public String login(UserVO vo, UserDAO userDAO) {
		System.out.println("�α��� ó��");
		
		if(userDAO.getUser(vo)!=null) return "getBoardList.do";
		else return "login.jsp"; //���̵� �Ǵ� ��й�ȣ�� ���� �ʾƼ� vo = null�� ���
	}
	
}
