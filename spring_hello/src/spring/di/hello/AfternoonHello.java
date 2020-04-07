package spring.di.hello;

//import spring.di.time.NowTime;

public class AfternoonHello implements Hello {
	
//	private NowTime time;
	
	public AfternoonHello() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("Afternoon Hello");
	}

//	@Override
//	public void setTime(NowTime time) {
//		// TODO Auto-generated method stub
//		this.time = time;
//	}

}
