package com.board;

import java.util.ArrayList;
import com.board.BoardService;
import com.board.BoardVO;

//TODO1. BoardServiceImpl Ŭ������ Bean���� ����ϴ� Annotation�� �����Ͻÿ�.
// UserServiceImpl�� Ŭ���̾�Ʈ���� "boardService" ��� �̸����� Lookup�� �� �־�� �Ѵ�.
public class BoardServiceImpl implements BoardService {

	//TODO2. BoardDAO Ŭ������ ���� DI ���� Annotation�� �����Ͻÿ�.
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
