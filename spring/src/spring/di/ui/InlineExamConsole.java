package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import spring.di.entity.Exam;

public class InlineExamConsole implements ExamConsole {
//	@Autowired는 setter위가아닌 field위에 사용할 수도 있음
//	bean에서 참조하는 class가 같은 경우 해당 setter위가 아니면 여러 개 찾았다며 에러남
//	=> @Qualifier("")도 함께 써주어야 함


	
	
//	가장 자주 쓰이는 위치
//	setting.xml에 개게 없어도 실행되도록 하려면
//	@Autowired(required = false)
	@Qualifier("exam2")	
	private Exam exam;
	
//	@Autowired 포함 두 줄이 생성자 위에 있는 경우 기본생성자로 injection 수행됨
//	기본생성자 없이 바로 오버로드 생성자 들어오면 error 
//	=> overload도 없어야 함
//	=> constructor 거치지 않고 바로 setter로 넘어감
//	=> 기본생성자 자동 생성됨
	public InlineExamConsole() {
		System.out.println("constructor");
	}

//	@Autowired
//	@Qualifier("exam2")
//	@Qualifier("exam2")의 위치가 잘못되었다고 나옴
//	public InlineExamConsole(Exam exam1, Exam exam2) { }
//		와 같이 인터페이스가 두 개 이상 들어갈 수 있다고 판단
//		=> 파라미터에 각자 지정 가능함
//		public InlineExamConsole(@Qualifier("exam1")Exam exam1,
//								@Qualifier("exam2")Exam exam2) {
	public InlineExamConsole(@Qualifier("exam2")Exam exam) {
		System.out.println("overloaded constructor");
		this.exam = exam;
	}

	@Override
	public void print() {
		if(exam==null)
			System.out.printf("total is %d, avg is %f\n", 0, 0.0);
		else
			System.out.printf("total is %d, avg is %f\n", exam.total(), exam.avg());
	}
	
//	di 수행하는 xml 대신 수행
//	특별한 지시 없으면 class 들어와서 Autowired를 찾지 않음 => NullPointerException
//	@Autowired
//	@Qualifier("exam2")
	@Override
	public void setExam(Exam exam) {
		System.out.println("setter");
		this.exam=exam;
	}

}
