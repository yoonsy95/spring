package lab.spring.user.dao;
 
 


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import lab.spring.user.User;
import lab.spring.user.UserRowMapper;
 
@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    SqlSessionTemplate sqlSession;

	public UserDAOImpl() {	}

	public boolean login(String uid, String upwd) {
		boolean success = false;
//		Object vo = null;
//		Object args[] = new String[]{uid, upwd};
//		String sql = "select * from userinfo where userid=? and userpwd=?";
//		vo = sqlSession.query(sql, args ,new UserRowMapper());
//		if (vo!=null) success = true;
		
		return success;
	}

	public int addUser(final User user) {	
		int rows = 0;
//		final StringBuffer sql = new StringBuffer();
//		sql.append("insert into userinfo (uno, userid, username, userpwd, email, phone) ");
//		sql.append(" values((select nvl(max(uno), 0)+1 from userinfo),?,?,?,?,?)");	
//		rows = sqlSession.update(new PreparedStatementCreator() {			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con)
//					throws SQLException {
//				PreparedStatement pstat = con.prepareStatement(sql.toString());
//				pstat.setString(1, user.getUserid());
//				pstat.setString(2, user.getUsername());
//				pstat.setString(3, user.getUserpwd());
//				pstat.setString(4, user.getEmail());
//				pstat.setString(5, user.getPhone());				
//				return pstat;
//			}		 
//		});
		return rows;	
	} 

	public List<User> findUserList() {
		List<User> userList = null;		 
//		String sql = "select * from userinfo ";
//		userList = sqlSession.query(sql, new Object[0], new UserRowMapper());		 
//		return userList;
		userList =(List)sqlSession.selectList("lab.model.user.selectList");
		return userList;
	}
	

	public int updateUser(final User user) {
		int rows = 0;
//		final StringBuffer sql = new StringBuffer();
//		sql.append("update userinfo  set email=?, phone=?, address=? ");
//		sql.append(" where userid = ? ");
//		rows = sqlSession.update(new PreparedStatementCreator() {			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con)
//					throws SQLException {
//				PreparedStatement pstat = con.prepareStatement(sql.toString());
//				pstat.setString(4, user.getUserid());				 
//				pstat.setString(3, user.getAddress());
//				pstat.setString(1, user.getEmail());
//				pstat.setString(2, user.getPhone());				
//				return pstat;
//			}		 
//		});
		return rows;	
	}

	public int removeUser(final String userid) {
		int rows = 0;
//		final String sql = "delete userinfo where userid = ? ";
//		rows = sqlSession.update(new PreparedStatementCreator() {			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con)
//					throws SQLException {
//				PreparedStatement pstat = con.prepareStatement(sql);
//				pstat.setString(1, userid);				 				
//				return pstat;
//			}		 
//		});
		return rows;	
	}

	public User findUser(String userid) {
		Object vo = null;		 
//		String sql = "select * from userinfo where userid = ? ";
//		vo = sqlSession.queryForObject(sql, new Object[]{userid}, new UserRowMapper());		 
		return (User)vo;
	}

	 

}
