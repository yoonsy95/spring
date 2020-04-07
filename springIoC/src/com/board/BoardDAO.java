package com.board;

import java.sql.*;
import java.util.ArrayList;
import com.board.BoardVO;
import com.common.JDBCUtil;

public class BoardDAO {
	// TODO1. BoardDAO 클래스를 Bean으로 등록하는 적절한 Annotation을 설정하시오.
	public class BoardDAO {
		// DB 관련 변수
		private Connection conn = null;
		private PreparedStatement stmt = null;
		private ResultSet rs = null;
		// SQL 명령어들
		private final String BOARD_ADD = "insert into board(seq, title, writer, content)"
			+ " values((select nvl(max(seq), 0)+1 from board),?,?,?)";
			private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
			private final String BOARD_DELETE = "delete board where seq=?";
			private final String BOARD_LIST_TITLE = "select * from board where title like ? order by seq desc";
			private final String BOARD_LIST_CONTENT = "select * from board where content like ? order by seq desc";
			private final String BOARD_GET = "select * from board where seq=?";
			public void addBoard(BoardVO vo){
				// TODO2. 새글 등록 JDBC 로직을 구현하시오.
			}
			public void updateBoard(BoardVO vo){
				// TODO3. 글 수정 JDBC 로직을 구현하시오.
			}
			public void deleteBoard(BoardVO vo){
				// TODO4. 글 삭제 JDBC 로직을 구현하시오.
			}
			public BoardVO getBoard(BoardVO vo){
				BoardVO board = null;
				// TODO5. 글 상세 검색 JDBC 로직을 구현하시오.
				return board;
			}
			public ArrayList<BoardVO> getBoardList(BoardVO vo){
				ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();
				// TODO6. 글 목록 조회 JDBC 로직을 구현하시오.
				return boardList;
			}
		}
	}
}
