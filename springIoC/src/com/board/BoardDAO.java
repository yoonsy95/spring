package com.board;

import java.util.ArrayList;
import java.util.List;

import com.board.BoardVO;

public interface BoardDAO {
	public int addBoard(BoardVO vo);
	public int updateBoard(BoardVO vo);
	public int deleteBoard(BoardVO vo);
	public BoardVO getBoard(BoardVO vo);
	public BoardVO getBoardList(BoardVO vo);
	public List<BoardVO> getBoard();
}
