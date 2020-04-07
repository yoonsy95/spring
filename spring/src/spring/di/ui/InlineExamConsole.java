package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import spring.di.entity.Exam;

public class InlineExamConsole implements ExamConsole {
	
	private Exam exam;
	
	public InlineExamConsole() {
		// TODO Auto-generated constructor stub
	}

	public InlineExamConsole(Exam exam) {
//		super();  // 불필요
		this.exam = exam;
	}

	@Override
	public void print() {
		System.out.printf("total is %d, avg is %f\n", exam.total(), exam.avg());
	}
	
//	di 수행하는 xml 대신 수행
//	특별한 지시 없으면 class 들어와서 Autowired를 찾지 않음 => NullPointerException
	@Autowired
	@Qualifier("exam2")
	@Override
	public void setExam(Exam exam) {
		this.exam=exam;
	}

}
