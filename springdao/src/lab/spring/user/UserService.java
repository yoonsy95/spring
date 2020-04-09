package lab.spring.user;
 
import java.util.List;

public interface UserService {
	public int addUser(User user);
	public int updateUser(User user);
	public int removeUser(String uid);
	public User findUser(String uid);
	public boolean login(String uid, String upwd);
	public List<User> findUserList();
	

}
