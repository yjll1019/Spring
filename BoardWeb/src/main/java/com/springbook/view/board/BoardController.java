package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	
	//�� ���
	@RequestMapping(value="/insertBoard.do") // /insertBoard.do��� ��û�� ���� �� �� �޼ҵ带 �����ϰڴ�.
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) { 
		//�Ű����� : ������ �����̳ʰ� Command��ü�� �����ؼ� �Ѱ��ְ�, �� �� ����ڰ� �Է��� ���� ��ü�� ���ñ����ؼ� �Ѱ��ش�.

		System.out.println("�� ��� ó��");

		boardDAO.insertBoard(vo);
		
		return "getBoardList.do"; //�� ��� �� ����Ʈ�� ��������ϱ� ������ 
	}
	
	//�� ����
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO){
		System.out.println("�� ���� ó��");
		
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}

	//�� ����
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO){
		
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	//�� �� ��ȸ
	@RequestMapping("/getBoard.do") //Ŭ���̾�Ʈ���� getBoard.do ��û�� ���� �� �޼ҵ�� ����.
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("�� �� ��ȸ ó��");
		
		mav.addObject("board", boardDAO.getBoard(vo));
		mav.setViewName("getBoard");
		return mav;
	}
	
	//�� ��� �˻�
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		
		System.out.println("�� ��� �˻� ó��");

		mav.addObject("boardList",boardDAO.getBoardList(vo)); //Model���� ����
		mav.setViewName("getBoardList");//View ���� ����
		return mav;
	}

	
}
