package com.user;

import com.user.UserService;
import com.user.UserVO;

// TODO1. UserServiceImpl Ŭ������ Bean���� ����ϴ� Annotation�� �����Ͻÿ�.
// UserServiceImpl�� Ŭ���̾�Ʈ���� "userService" ��� �̸����� Lookup�� �� �־�� �Ѵ�.
public class UserServiceImpl implements UserService {
	
	// TODO2. UserDAO Ŭ������ ���� DI ���� Annotation�� �����Ͻÿ�.
	private UserDAO userDAO;
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}
}
