package spring.di.hello;

//import spring.di.time.NowTime;

public class MorningHello implements Hello {
	
//	private int time;
	
	public MorningHello() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
//		System.out.printf("Current Hour: %d, Morning Hello\n", time);
		System.out.println("Morning Hello");
	}

//	@Override
//	public void setTime(NowTime time) {
//		// TODO Auto-generated method stub
//		
//	}
}
