package com.user;

import com.user.UserService;
import com.user.UserVO;

// TODO1. UserServiceImpl 클래스를 Bean으로 등록하는 Annotation을 설정하시오.
// UserServiceImpl은 클라이언트에서 "userService" 라는 이름으로 Lookup할 수 있어야 한다.
public class UserServiceImpl implements UserService {
	
	// TODO2. UserDAO 클래스에 대한 DI 관련 Annotation을 설정하시오.
	private UserDAO userDAO;
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}
}
