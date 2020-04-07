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
//		super();  // ���ʿ�
		this.exam = exam;
	}

	@Override
	public void print() {
		System.out.printf("total is %d, avg is %f\n", exam.total(), exam.avg());
	}
	
//	di �����ϴ� xml ��� ����
//	Ư���� ���� ������ class ���ͼ� Autowired�� ã�� ���� => NullPointerException
	@Autowired
	@Qualifier("exam2")
	@Override
	public void setExam(Exam exam) {
		this.exam=exam;
	}

}
