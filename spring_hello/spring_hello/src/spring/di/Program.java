package spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.hello.*;
import spring.di.time.*;

public class Program {

	public static void main(String[] args) {
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("spring/di/setting.xml");
		
		
		NowTime time = new NowTime();
		System.out.println("current hour: " + time.intTime() );		

		Hello hello = new MorningHello();
		hello.sayHello();
		
//		if(time.intTime()>=9 && time.intTime()<12) {
//			Hello hello = new MorningHello();
//			hello.sayHello();
//		} else if(time.intTime()>=12 && time.intTime()<17) {
//			Hello hello = new AfternoonHello();
//			hello.sayHello();
//		} else if(time.intTime()>=17 && time.intTime()<21) {
//			Hello hello = new EveningHello();
//			hello.sayHello();
//		} else {
//			System.out.println("Time to Sleep");
//		}
	}

}
