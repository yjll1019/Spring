package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.impl.BoardService;

//BoardService ������Ʈ�� ����ϴ� Ŭ���̾�Ʈ ���α׷� 
public class BoardServiceClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1. Spring �����̳ʸ� �����Ѵ�.
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. Spring �����̳ʷκ��� BoardServiceImpl ��ü lookup.
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		//3. �� ��� ��� �׽�Ʈ
		BoardVO vo = new BoardVO();
	//	vo.setSeq(101);
	//	vo.setTitle("�ӽ� ����");
	//	vo.setWriter("ȫ�浿");
	//	vo.setContent("�ӽ� ����.....");
	//	boardService.insertBoard(vo);
	//	boardService.insertBoard(vo);

		//4. �� ��� �˻� ���
		List<BoardVO> boardList = boardService.getBoardList(vo);
		System.out.println("boardList�� ����"+boardList.size());
		for(BoardVO board : boardList) {
			System.out.println("------> "+board.toString());
		}
		//5. �����̳� ����
		container.close();
	}

}
