package lab.spring.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lab.spring.board.Board;

@Repository
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Board> getBoardList() {
		return sqlSession.selectList("boards.getBoardList");
	}

	@Override
	public List<Board> getBoard(String writer) {
		return sqlSession.selectList("boards.getBoard", "%"+writer+"%");
	}

	@Override
	public int addBoard(Board board) {
		return sqlSession.insert("boards.addBoard", board);
	}

	@Override
	public int updateBoard(Board board) {
		return sqlSession.update("boards.updateBoard", board);
	}

	@Override
	public int dropBoard(int seq) {
		return sqlSession.delete("boards.dropBoard", seq);
	}

}
