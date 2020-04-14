package lab.spring.user;

import java.sql.*;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAOImpl implements UserDAO{
   @Autowired
   private SqlSession  sqlSession;

	@Override
	public User login(String uid, String pwd) {
		User vo = null;
		HashMap<String , String> hashmap = new HashMap<String , String>();
		hashmap.put("uid", uid);
		hashmap.put("upwd", pwd);
		vo = sqlSession.selectOne("users.login", hashmap);
		return vo;
	}	
	@Override
	public int addUser(User user) {		 
		return sqlSession.insert("users.addUser", user);
	}

	@Override
	public int updateUser(User user) {		 
		return sqlSession.update("users.modifyUser", user);		  
	}

	@Override
	public List<User> findUser(String uid) {		
		return sqlSession.selectList("users.getUser", "%"+uid+"%");
	}

	@Override
	public List<User> findUserList() {
		return sqlSession.selectList("users.getUserList");		 
	}

	@Override
	public int removeUser(final String userid) {
		return   sqlSession.delete("users.dropUser", userid);		
	}	 
		 
	}






