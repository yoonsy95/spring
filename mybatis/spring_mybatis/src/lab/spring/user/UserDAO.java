package lab.spring.user;

import java.util.List;

public interface UserDAO {
	public int addUser(User user);
	   public User login(String uid, String pwd);
	   public int updateUser(User user);
	   public List<User> findUser(String uid);
	   public List<User> findUserList();
	   public int removeUser(String userid);
}
