package lab.spring.user;

 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;
 

 
@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
	JdbcTemplate template;

	public UserDAOImpl() {
	}
	

	public boolean login(String uid, String upwd) {
		boolean success = false;
		Object vo = null;
		Object args[] = new String[]{uid, upwd};
		String sql = "select * from userinfo where userid=? and userpwd=?";
		vo = template.query(sql, args ,new UserRowMapper());
		if (vo!=null) success = true;
		return success;
	}

	public int addUser(final User user) {	
		int rows = 0;
		final StringBuffer sql = new StringBuffer();
		sql.append("insert into userinfo (userid, username, userpwd, email, phone) ");
		sql.append(" values (?,?,?,?,?)");
		rows = template.update(new PreparedStatementCreator() {			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement pstat = con.prepareStatement(sql.toString());
				pstat.setString(1, user.getUserid());
				pstat.setString(2, user.getUsername());
				pstat.setString(3, user.getUserpwd());
				pstat.setString(4, user.getEmail());
				pstat.setString(5, user.getPhone());				
				return pstat;
			}		 
		});
		return rows;	
	} 

	public List<User> findUserList() {
		List<User> userList = null;		 
		String sql = "select * from userinfo ";
		userList = template.query(sql, new Object[0], new UserRowMapper());		 
		return userList;
	}
	

	public int updateUser(final User user) {
		int rows = 0;
		final StringBuffer sql = new StringBuffer();
		sql.append("update userinfo  set email=?, phone=?, address=? ");
		sql.append(" where userid = ? ");
		rows = template.update(new PreparedStatementCreator() {			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement pstat = con.prepareStatement(sql.toString());
				pstat.setString(4, user.getUserid());				 
				pstat.setString(3, user.getAddress());
				pstat.setString(1, user.getEmail());
				pstat.setString(2, user.getPhone());				
				return pstat;
			}		 
		});
		return rows;	
	}

	public int removeUser(final String userid) {
		int rows = 0;
		final String sql = "delete userinfo where userid = ? ";
		rows = template.update(new PreparedStatementCreator() {			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement pstat = con.prepareStatement(sql);
				pstat.setString(1, userid);				 				
				return pstat;
			}		 
		});
		return rows;	
	}

	public User findUser(String userid) {
		Object vo = null;		 
		String sql = "select * from userinfo where userid = ? ";
		vo = template.queryForObject(sql, new Object[]{userid}, new UserRowMapper());		 
		return (User)vo;
	}

	 

}
