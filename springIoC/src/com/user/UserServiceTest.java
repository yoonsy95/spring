package com.user;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"file:./resource/application*.xml"})
public class UserServiceTest {
	
	public static void main(String args[]) {
		
		UserService userService;
		ApplicationContext ctx = new ClassPathXmlApplicationContext("./resource/application*.xml");
		userService=(UserService)ctx.getBean("userService");
		
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test123");
		
		UserVO user = userService.getUser(vo);
//		assertNotNull(user);
//		assertEquals("包府磊", user.getName());
		System.out.println(user);
		System.out.println("包府磊:" + user.getName());
	}
}