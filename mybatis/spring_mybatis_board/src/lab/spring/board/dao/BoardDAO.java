package lab.spring.board.dao;

import java.util.List;

import lab.spring.board.Board;

public interface BoardDAO {
	public List<Board> getBoardList();
	public List<Board> getBoard(String writer);
	public int addBoard(Board board);
	public int updateBoard(Board board);
	public int dropBoard(int seq);
	
}
