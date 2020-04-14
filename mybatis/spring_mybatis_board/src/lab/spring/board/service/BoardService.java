package lab.spring.board.service;

import java.util.List;

import lab.spring.board.Board;

public interface BoardService {	
	public List<Board> getBoardList();
	public List<Board> getBoard(String writer);
	public int addBoard(Board board);
	public int updateBoard(Board board);
	public int dropBoard(int seq);
}
