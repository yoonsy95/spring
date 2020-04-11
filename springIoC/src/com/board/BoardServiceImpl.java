package com.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.board.BoardService;
import com.board.BoardVO;

//TODO1. BoardServiceImpl 클래스를 Bean으로 등록하는 Annotation을 설정하시오.
// UserServiceImpl은 클라이언트에서 "boardService" 라는 이름으로 Lookup할 수 있어야 한다.
@Component("boardService")
public class BoardServiceImpl implements BoardService {

	//TODO2. BoardDAO 클래스에 대한 DI 관련 Annotation을 설정하시오.
	@Autowired
	private BoardDAO boardDAO;
	
	public int addBoard(BoardVO vo) {
		return boardDAO.addBoard(vo);
	}
	
	public int updateBoard(BoardVO vo) {
		return boardDAO.updateBoard(vo);
	}
	
	public int deleteBoard(BoardVO vo) {
		return boardDAO.deleteBoard(vo);
	}
	
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}
	
	public BoardVO getBoardList(BoardVO vo) {
		vo.setSearchKeyword("%"+vo.getSearchKeyword()+"%");
		return boardDAO.getBoardList(vo);
	}
	
	public List<BoardVO> getBoard() {
		return boardDAO.getBoard();
	}
}
