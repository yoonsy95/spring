package lab.spring.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lab.spring.board.Board;
import lab.spring.board.service.BoardService;

public class BoardTest {
	public static void main(String args[]) {
		String[] configs = new String[] {"board_orm.xml"};
		
		ApplicationContext context = new ClassPathXmlApplicationContext(configs);
		
		BoardService service = context.getBean("boardService", BoardService.class);
		
//		cRud
		List<Board> lists = service.getBoardList();
		for(Board vo : lists) {
			System.out.println(vo);
		}
		System.out.println();
		
//		Crud
		Board board = new Board();
//		board.setWriter("ysy123");
//		board.setTitle("oh");
//		board.setContent("content");
//		System.out.println("insert rows: " + service.addBoard(board));
		
//		crUd
//		board.setTitle("testTitle");
//		board.setContent("아아아아아");
		board.setBbsId(5);
//		System.out.println("update rows: " + service.updateBoard(board));
		
//		cruD
		System.out.println("drop rows: " + service.dropBoard(board.getBbsId()));
		
		
//		cRud  // 결과 확인
		System.out.println();
		List<Board> lists2 = service.getBoardList();
		for(Board vo : lists2) {
			System.out.println(vo);
		}
	}
}
