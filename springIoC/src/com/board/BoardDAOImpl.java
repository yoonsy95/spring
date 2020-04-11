package com.board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.board.BoardVO;
import com.common.JDBCUtil;

//@Component("board")
@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired
	JdbcTemplate template;
	
	// DB 관련 변수
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	// SQL 명령어들
	private final String BOARD_ADD = "insert into board(seq, title, writer, content)"
		+ " values((select nvl(max(seq), 0)+1 from board),?,?,?)";
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete board where seq=?";
	private final String BOARD_LIST_TITLE = "select * from board where title like ? order by seq desc";
	private final String BOARD_LIST_CONTENT = "select * from board where content like ? order by seq desc";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String board_list="select * from board order by seq desc";
	
	public int addBoard(BoardVO vo){
		int rows=0;
		rows = template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(BOARD_ADD);
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getWriter());
				pstmt.setString(3, vo.getContent());
				return pstmt;
			}
		});
		return rows;
	}
	
//	게시판 crUd
	public int updateBoard(BoardVO vo) {
		int rows = 0;
		rows = template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(BOARD_UPDATE);
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getContent());
				pstmt.setInt(3, vo.getSeq());
				return pstmt;
			}
		});
		return rows;
	}

//	게시판 cruD
	public int deleteBoard(BoardVO vo) {
		int rows = 0;
		rows = template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(BOARD_DELETE);
				pstmt.setInt(1, vo.getSeq());
				return pstmt;
			}
		});
		return rows;
	}
	
	
//	제목 검색
	public BoardVO getBoard(BoardVO vo) {
		BoardVO boardList = null;
		boardList = template.queryForObject(BOARD_LIST_TITLE, new Object[]{vo}, new BoardRowMapper());
		return (BoardVO) boardList;
	}
	
//	게시판 상세보기
	public BoardVO getBoardList(BoardVO vo) {
		BoardVO boardList = null;
		boardList = template.queryForObject(BOARD_GET, new Object[]{vo}, new BoardRowMapper());
		return (BoardVO) boardList;
	}
	
//	게시판 전체목록 조회
	public List<BoardVO> getBoard() {
		List<BoardVO> boardList = null;
		boardList = template.query(board_list, new Object[0], new BoardRowMapper());
		return boardList;
	}
}

