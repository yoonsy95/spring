package lab.spring.user.service;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import lab.spring.user.User;
import lab.spring.user.dao.UserDAO;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO dao;	 

	public UserServiceImpl() {} 

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}

	public boolean login(String uid, String pwd) {
        boolean success = false;
		if (dao.login(uid, pwd)) {
			success = true;
			System.out.println("login.success");
		} else {
			System.out.println("login.fail");
		}
		return success;
	}

	public List<User> findUserList() {
		return dao.findUserList();
	}

	public int addUser(User user) {
		return dao.addUser(user);
	}

	public int updateUser(User user) {		 
		return dao.updateUser(user);
	}

	public int removeUser(String uid) {
		return dao.removeUser(uid);
	}

	public User findUser(String uid) {
		return dao.findUser(uid);
	}

}
