package com.board;

import java.util.ArrayList;
import com.board.BoardVO;

public interface BoardService {
	public void addBoard(BoardVO vo);
	public void updateBoard(BoardVO vo);
	public void deleteBoard(BoardVO vo);
	public ArrayList<BoardVO> getBoard(BoardVO vo);
	public ArrayList<BoardVO> getBoardList(BoardVO vo);
	public ArrayList<BoardVO> getBoard();
}
