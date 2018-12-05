package com.springbook.biz.board.impl;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardVO;


//BoardService클래스를 구현한 클래스.

@Service("boardService")//의미 : 비즈니스 로직을 처리하는 Service 클래스 >> 스프링 컨테이너가 객체를 생성할 수 있도록 >> @Component 상속
public class BoardServiceImpl implements BoardService{
	
	@Autowired //이 타입의 객체가 메모리에 존재하는지 확인 후에 변수에 그 객체 주입.(의존성 주입)
	private BoardDAOSpring boardDAO;
	
	public void insertBoard(BoardVO vo) {

		boardDAO.insertBoard(vo);
	}

	public void updateBoard(BoardVO vo) {

		boardDAO.updateBoard(vo);
	}

	public void deleteBoard(BoardVO vo) {

		boardDAO.deleteBoard(vo);
	}

	public BoardVO getBoard(BoardVO vo) {

		return boardDAO.getBoard(vo);
	}

	public List<BoardVO> getBoardList(BoardVO vo) {

		return boardDAO.getBoardList(vo);
	}
}
