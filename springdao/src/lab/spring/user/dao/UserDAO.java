package lab.spring.user.dao;

import java.util.List;

import lab.spring.user.User;

public interface UserDAO {
	public int addUser(User user);
	public int updateUser(User user);
	public int removeUser(String uid);
	public User findUser(String uid);
	public boolean login(String uid, String upwd);
	public List<User> findUserList();
	

}
