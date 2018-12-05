package com.springbook.biz.board.impl;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardVO;


//BoardServiceŬ������ ������ Ŭ����.

@Service("boardService")//�ǹ� : ����Ͻ� ������ ó���ϴ� Service Ŭ���� >> ������ �����̳ʰ� ��ü�� ������ �� �ֵ��� >> @Component ���
public class BoardServiceImpl implements BoardService{
	
	@Autowired //�� Ÿ���� ��ü�� �޸𸮿� �����ϴ��� Ȯ�� �Ŀ� ������ �� ��ü ����.(������ ����)
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
