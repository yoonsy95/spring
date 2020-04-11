package com.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.board.BoardService;
import com.board.BoardVO;

//TODO1. BoardServiceImpl Ŭ������ Bean���� ����ϴ� Annotation�� �����Ͻÿ�.
// UserServiceImpl�� Ŭ���̾�Ʈ���� "boardService" ��� �̸����� Lookup�� �� �־�� �Ѵ�.
@Component("boardService")
public class BoardServiceImpl implements BoardService {

	//TODO2. BoardDAO Ŭ������ ���� DI ���� Annotation�� �����Ͻÿ�.
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
