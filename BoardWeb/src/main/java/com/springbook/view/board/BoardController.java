package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	
	//글 등록
	@RequestMapping(value="/insertBoard.do") // /insertBoard.do라는 요청이 있을 때 이 메소드를 매핑하겠다.
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) { 
		//매개변수 : 스프링 컨테이너가 Command객체를 생성해서 넘겨주고, 이 때 사용자가 입력한 값을 객체에 세팅까지해서 넘겨준다.

		System.out.println("글 등록 처리");

		boardDAO.insertBoard(vo);
		
		return "getBoardList.do"; //글 등록 후 리스트를 보여줘야하기 때문에 
	}
	
	//글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO){
		System.out.println("글 수정 처리");
		
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}

	//글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO){
		
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	//글 상세 조회
	@RequestMapping("/getBoard.do") //클라이언트에서 getBoard.do 요청이 오면 이 메소드와 매핑.
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글 상세 조회 처리");
		
		mav.addObject("board", boardDAO.getBoard(vo));
		mav.setViewName("getBoard");
		return mav;
	}
	
	//글 목록 검색
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		
		System.out.println("글 목록 검색 처리");

		mav.addObject("boardList",boardDAO.getBoardList(vo)); //Model정보 저장
		mav.setViewName("getBoardList");//View 정보 저장
		return mav;
	}

	
}
