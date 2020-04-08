package com.board;

import java.util.ArrayList;
import com.board.BoardService;
import com.board.BoardVO;

//TODO1. BoardServiceImpl 클래스를 Bean으로 등록하는 Annotation을 설정하시오.
// UserServiceImpl은 클라이언트에서 "boardService" 라는 이름으로 Lookup할 수 있어야 한다.
public class BoardServiceImpl implements BoardService {

	//TODO2. BoardDAO 클래스에 대한 DI 관련 Annotation을 설정하시오.
	private BoardDAO boardDAO;
	
	public void addBoard(BoardVO vo) {
		boardDAO.addBoard(vo);
	}
	
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}
	
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}
	
	public ArrayList<BoardVO> getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}
	
	public ArrayList<BoardVO> getBoardList(BoardVO vo) {
		vo.setSearchKeyword("%"+vo.getSearchKeyword()+"%");
		return boardDAO.getBoardList(vo);
	}
}
