package com.board;

import java.sql.*;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.board.BoardVO;
import com.common.JDBCUtil;

// TODO1. BoardDAO Ŭ������ Bean���� ����ϴ� ������ Annotation�� �����Ͻÿ�.
@Component("board")
public class BoardDAO {
	// DB ���� ����
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	// SQL ��ɾ��
	private final String BOARD_ADD = "insert into board(seq, title, writer, content)"
		+ " values((select nvl(max(seq), 0)+1 from board),?,?,?)";
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete board where seq=?";
	private final String BOARD_LIST_TITLE = "select * from board where title like ? order by seq desc";
	private final String BOARD_LIST_CONTENT = "select * from board where content like ? order by seq desc";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String board_list="select * from board order by seq desc";
	
	public void addBoard(BoardVO vo){
		// TODO2. ���� ��� JDBC ������ �����Ͻÿ�.
		try {
			conn=JDBCUtil.getConnection();
			pstmt=conn.prepareStatement(BOARD_ADD);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	public void updateBoard(BoardVO vo){
		// TODO3. �� ���� JDBC ������ �����Ͻÿ�.
		try {
			conn=JDBCUtil.getConnection();
			pstmt=conn.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getSeq());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	public void deleteBoard(BoardVO vo){
		// TODO4. �� ���� JDBC ������ �����Ͻÿ�.
		try {
			conn=JDBCUtil.getConnection();
			pstmt=conn.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1, vo.getSeq());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	public ArrayList<BoardVO> getBoard(BoardVO vo){
		ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();
		// BoardVO board = null;
		
		// TODO5. �� �� �˻� JDBC ������ �����Ͻÿ�.
		try {
			conn=JDBCUtil.getConnection();
			pstmt=conn.prepareStatement(BOARD_LIST_TITLE);
			pstmt.setString(1, rs.getString("title"));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardVO bVo=new BoardVO();
				bVo.setSeq(rs.getInt("seq"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setWriter(rs.getString("writer"));
				boardList.add(bVo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
				
		return boardList;
	}
	public ArrayList<BoardVO> getBoardList(BoardVO vo){
		ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();
		
		// TODO6. �� ��� ��ȸ JDBC ������ �����Ͻÿ�.
		try {
			conn=JDBCUtil.getConnection();
			pstmt=conn.prepareStatement(BOARD_GET);
			pstmt.setInt(1, vo.getSeq());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardVO bVo=new BoardVO();
				bVo.setSeq(rs.getInt("seq"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setWriter(rs.getString("writer"));
				boardList.add(bVo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		
		return boardList;
	}
	
	public ArrayList<BoardVO> getBoard() {
		ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();
		
		try {
			conn=JDBCUtil.getConnection();
			pstmt=conn.prepareStatement(board_list);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardVO bVo=new BoardVO();
				bVo.setSeq(rs.getInt("seq"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setWriter(rs.getString("writer"));
				boardList.add(bVo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		
		return boardList;
	}
}

