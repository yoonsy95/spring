package lab.spring.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lab.spring.user.User;
import lab.spring.user.UserService;

public class ORMTest {

	public static void main(String[] args) {
		String[] configs = new String[]{"user_orm.xml"};
		ApplicationContext context = 
				new ClassPathXmlApplicationContext(configs);
		UserService service = 
				context.getBean("userService", UserService.class);
		
//		cRud // 한 객체로 출력
//		System.out.println(service.findUserList());
		
//		cRud // 한 줄마다
		List<User> lists= service.findUserList();
		for(User vo : lists){
			System.out.println(vo);
		} 
		
//		cRud // 관리자정보 출력
//		System.out.println("login :" + service.login("admin", "a1234"));
		 
		
//		Crud
		User user1 = new User();
		user1.setUserid("hong123");
//		user1.setUsername("tj");
//		user1.setUserpwd("p1234");
//		user1.setEmail("akasha.park@gmail.com");
//		System.out.println("insert rows :"+ service.addUser(user1));
		
		
//		crUd
//		user1.setUsername("홍쓰");
//		user1.setUserpwd("hong1234");
//		user1.setEmail("hong@gmail.com");
//		System.out.println("update rows :"+ service.updateUser(user1));

//		lists= service.findUser(user1.getUserid());
//		for(User vo : lists){
//			System.out.println(vo);
//		} 
		
//		cruD
		System.out.println("drop user :"+ 
		              service.removeUser(user1.getUserid()));
		
		lists = service.findUserList();
		for(User vo : lists){
			System.out.println(vo);
		}
		
	}

}
