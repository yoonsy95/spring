package lab.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.spring.board.Board;
import lab.spring.board.dao.BoardDAO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO bDao;
	
	@Override
	public List<Board> getBoardList() {
		return bDao.getBoardList();
	}

	@Override
	public List<Board> getBoard(String writer) {
		return bDao.getBoard(writer);
	}

	@Override
	public int addBoard(Board board) {
		return bDao.addBoard(board);
	}

	@Override
	public int updateBoard(Board board) {
		return bDao.updateBoard(board);
	}

	@Override
	public int dropBoard(int seq) {
		return bDao.dropBoard(seq);
	}
	
}
