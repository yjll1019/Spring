package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.impl.BoardService;

//BoardService 컴포넌트를 사용하는 클라이언트 프로그램 
public class BoardServiceClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. Spring 컨테이너로부터 BoardServiceImpl 객체 lookup.
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		//3. 글 등록 기능 테스트
		BoardVO vo = new BoardVO();
	//	vo.setSeq(101);
	//	vo.setTitle("임시 제목");
	//	vo.setWriter("홍길동");
	//	vo.setContent("임시 내용.....");
	//	boardService.insertBoard(vo);
	//	boardService.insertBoard(vo);

		//4. 글 목록 검색 기능
		List<BoardVO> boardList = boardService.getBoardList(vo);
		System.out.println("boardList의 길이"+boardList.size());
		for(BoardVO board : boardList) {
			System.out.println("------> "+board.toString());
		}
		//5. 컨테이너 종료
		container.close();
	}

}
