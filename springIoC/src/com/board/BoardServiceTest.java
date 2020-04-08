package com.board;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.board.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:./resource/application*.xml"})
public class BoardServiceTest {
	@Autowired
	private BoardService boardService;
	
	@Test
	public void testAddBoard() {
		BoardVO searchVO = new BoardVO();
		searchVO.setSearchCondition("TITLE");
		searchVO.setSearchKeyword("");
		
		ArrayList<BoardVO> boardList = boardService.getBoardList(searchVO);
		int beforeCnt = boardList.size();
		
		BoardVO vo = new BoardVO();
		vo.setTitle("JDBC 제목");
		vo.setWriter("채규태");
		vo.setContent("JDBC 내용");
		boardService.addBoard(vo);
		
		boardList = boardService.getBoardList(searchVO);
		int afterCnt = boardList.size();
		assertEquals(beforeCnt + 1, afterCnt);
	}
}
