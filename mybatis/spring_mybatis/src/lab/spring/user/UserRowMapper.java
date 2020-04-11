package lab.spring.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper; 

public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int num) throws SQLException {
		User vo = new User();
		vo.setUserid(rs.getString("userid"));
		vo.setUno(rs.getInt("uno"));
		vo.setUsername(rs.getString("username"));
		vo.setUserpwd(rs.getString("userpwd"));
		vo.setPhone(rs.getString("phone"));
		vo.setAddress(rs.getString("address"));
		vo.setEmail(rs.getString("email"));
		return vo;
	}
     
}
