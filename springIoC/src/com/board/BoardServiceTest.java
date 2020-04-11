package com.board;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.board.BoardVO;
import com.user.UserService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"file:./resource/application*.xml"})
public class BoardServiceTest {
	
	public static void main(String args[]) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("./resource/application*.xml");
		BoardService boardService = (BoardService)ctx.getBean("boardService");
		
		
//		BoardVO searchVO = new BoardVO();
//		searchVO.setSearchCondition("TITLE");
//		searchVO.setSearchKeyword("");
		
		
//		ArrayList<BoardVO> boardList = boardService.getBoardList(searchVO);
//		int beforeCnt = boardList.size();
		
		BoardVO vo = new BoardVO();
		
//		Crud
//		vo.setTitle("JDBC");
//		vo.setWriter("채규태");
//		vo.setContent("content");
//		boardService.addBoard(vo);
		
//		crUd
//		vo.setTitle("JDBC 제목");
//		vo.setContent("JDBC 내용");
//		vo.setSeq(2);
//		boardService.updateBoard(vo);
		
//		cruD
		vo.setSeq(2);
		boardService.deleteBoard(vo);
		
//		cRud
		List<BoardVO> boards = boardService.getBoard();
		Iterator<BoardVO> iter = boards.iterator();
		while(iter.hasNext()) {
			BoardVO b = iter.next();
			System.out.println(b);
		}
	}
}
