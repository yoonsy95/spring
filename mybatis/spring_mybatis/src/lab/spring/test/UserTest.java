package lab.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import lab.spring.user.User;
import lab.spring.user.dao.UserDAO;

//@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {
 
    @Autowired
    private UserDAO user;
    
    @Test
    public void userTest() {
//    	User uVo = new User();
//    	uVo.setUserid("test");
//    	uVo.setUserpwd("test");
//    	uVo.setUsername("Å×½ºÆ®");
//    	uVo.setPhone("01045674567");
//    	uVo.setEmail("test@test.test");
//        user.insertUser(user);
    	
        
        System.out.println(user.findUserList());
    }    
}

