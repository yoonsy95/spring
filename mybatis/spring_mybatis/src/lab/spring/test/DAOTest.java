package lab.spring.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lab.spring.user.User;
import lab.spring.user.service.UserService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DAOTest {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"./lab/spring/user/user_dao.xml");
		UserService service = (UserService) context.getBean("userService");
		
//		service.login("admin", "a1234");
//		System.out.println();
		
//		Crud
//		User user = new User();
//		user.setUserid("admin");
//		user.setUsername("관리자");
//		user.setUserpwd("a1234");
//		user.setEmail("admin@korea.or.kr");
//		user.setPhone("02-129");
//		System.out.println("insert rows = >" + service.addUser(user));
//		System.out.println();

//		cRud // 한 줄에 하나씩
		List<User> lists = service.findUserList();
		Iterator<User> iter = lists.iterator();
		while (iter.hasNext()) {
			User u = iter.next();
			System.out.println(u);
		}
		
//		cRud // search
//		System.out.println(service.findUser("admin"));
		
//		crUd
//		User user = new User();
//		user.setUserid("admin");		
//		user.setEmail("admin@gmail.or.kr");
//		user.setPhone("02-129-1234");
//		System.out.println("update :admin =>"+service.updateUser(user));
//		System.out.println(service.findUser("admin"));

//		cruD
//		System.out.println("delete :hong123 =>"+service.removeUser("hong123"));
		
//		ArrayList<User> userlist = (ArrayList<User>) service.findUserList();
//		System.out.println(userlist);
	}

}








