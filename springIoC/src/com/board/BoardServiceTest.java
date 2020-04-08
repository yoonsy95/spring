package com.board;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
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
//		@Autowired => �ش��Ѵ� �̸� �ϳ��ۿ� ���µ� �� ã�Ƽ� ���� �Է� 
//		private BoardService boardService;
		BoardService boardService;
		ApplicationContext ctx = new ClassPathXmlApplicationContext("./resource/application*.xml");
		boardService = (BoardService)ctx.getBean("boardService");
		
//		@Test
//		public void testAddBoard() {
			BoardVO searchVO = new BoardVO();
			searchVO.setSearchCondition("TITLE");
			searchVO.setSearchKeyword("");
			
			
//			ArrayList<BoardVO> boardList = boardService.getBoardList(searchVO);
//			int beforeCnt = boardList.size();
			
			BoardVO vo = new BoardVO();
//			Crud
//			vo.setTitle("JDBC");
//			vo.setWriter("ä����");
//			vo.setContent("content");
//			boardService.addBoard(vo);
			
//			crUd
//			vo.setTitle("JDBC ����");
//			vo.setContent("JDBC ����");
//			vo.setSeq(2);
//			boardService.updateBoard(vo);
			
//			cruD
			vo.setSeq(2);
			boardService.deleteBoard(vo);
			
			ArrayList<BoardVO> boardlist = boardService.getBoard();
			System.out.println(boardlist);
			

//		}
	}
}
