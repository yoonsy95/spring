package lab.spring.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service("userService") 
public class UserServiceImpl implements UserService {
    @Autowired
	private UserDAO dao;
	
	@Override
	public int addUser(User user) {		 
		return dao.addUser(user);
	}

	@Override
	public User login(String uid, String pwd) {		 
		return dao.login(uid, pwd);
	}

	@Override
	public int updateUser(User user) {	 
		return dao.updateUser(user);
	}

	@Override
	public List<User> findUser(String uid) {		 
		return dao.findUser(uid);
	}

	@Override
	public List<User> findUserList() {		 
		return dao.findUserList();
	}

	@Override
	public int removeUser(String userid) {		 
		return dao.removeUser(userid);
	}
 
	 
	
	

}








