package com.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.user.UserService;
import com.user.UserVO;

// TODO1. UserServiceImpl Ŭ������ Bean���� ����ϴ� Annotation�� �����Ͻÿ�.
// UserServiceImpl�� Ŭ���̾�Ʈ���� "userService" ��� �̸����� Lookup�� �� �־�� �Ѵ�.
@Component("userService")
public class UserServiceImpl implements UserService {
	
	// TODO2. UserDAO Ŭ������ ���� DI ���� Annotation�� �����Ͻÿ�.
	@Autowired
	private UserDAO userDAO;
	
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}
}
