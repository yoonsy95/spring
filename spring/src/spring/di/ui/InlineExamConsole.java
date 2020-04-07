package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.di.entity.Exam;

// @Component()
// 이름으로 찾을 때 사용
@Component("console")
public class InlineExamConsole implements ExamConsole {

//	ioc container에 반드시 객체가 들어있어야 함
	@Autowired
//	@Autowired(required = false)
//	@Qualifier("exam2")	
	private Exam exam;

	public InlineExamConsole() {
		System.out.println("constructor");
	}

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
	
	@Override
	public void setExam(Exam exam) {
		System.out.println("setter");
		this.exam=exam;
	}

}
