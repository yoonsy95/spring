package spring.di.hello;

//import spring.di.time.NowTime;

public class EveningHello implements Hello {
	
//	private NowTime time;
	
	public EveningHello() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("Evening Hello");
	}

//	@Override
//	public void setTime(NowTime time) {
//		// TODO Auto-generated method stub
//		this.time = time;
//	}

}
