package com.board;

import java.sql.*;
import java.util.ArrayList;
import com.board.BoardVO;
import com.common.JDBCUtil;

public class BoardDAO {
	// TODO1. BoardDAO Ŭ������ Bean���� ����ϴ� ������ Annotation�� �����Ͻÿ�.
	public class BoardDAO {
		// DB ���� ����
		private Connection conn = null;
		private PreparedStatement stmt = null;
		private ResultSet rs = null;
		// SQL ��ɾ��
		private final String BOARD_ADD = "insert into board(seq, title, writer, content)"
			+ " values((select nvl(max(seq), 0)+1 from board),?,?,?)";
			private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
			private final String BOARD_DELETE = "delete board where seq=?";
			private final String BOARD_LIST_TITLE = "select * from board where title like ? order by seq desc";
			private final String BOARD_LIST_CONTENT = "select * from board where content like ? order by seq desc";
			private final String BOARD_GET = "select * from board where seq=?";
			public void addBoard(BoardVO vo){
				// TODO2. ���� ��� JDBC ������ �����Ͻÿ�.
			}
			public void updateBoard(BoardVO vo){
				// TODO3. �� ���� JDBC ������ �����Ͻÿ�.
			}
			public void deleteBoard(BoardVO vo){
				// TODO4. �� ���� JDBC ������ �����Ͻÿ�.
			}
			public BoardVO getBoard(BoardVO vo){
				BoardVO board = null;
				// TODO5. �� �� �˻� JDBC ������ �����Ͻÿ�.
				return board;
			}
			public ArrayList<BoardVO> getBoardList(BoardVO vo){
				ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();
				// TODO6. �� ��� ��ȸ JDBC ������ �����Ͻÿ�.
				return boardList;
			}
		}
	}
}
