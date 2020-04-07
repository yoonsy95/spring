package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import spring.di.entity.Exam;

public class InlineExamConsole implements ExamConsole {
//	@Autowired�� setter�����ƴ� field���� ����� ���� ����
//	bean���� �����ϴ� class�� ���� ��� �ش� setter���� �ƴϸ� ���� �� ã�Ҵٸ� ������
//	=> @Qualifier("")�� �Բ� ���־�� ��


	
	
//	���� ���� ���̴� ��ġ
//	setting.xml�� ���� ��� ����ǵ��� �Ϸ���
//	@Autowired(required = false)
	@Qualifier("exam2")	
	private Exam exam;
	
//	@Autowired ���� �� ���� ������ ���� �ִ� ��� �⺻�����ڷ� injection �����
//	�⺻������ ���� �ٷ� �����ε� ������ ������ error 
//	=> overload�� ����� ��
//	=> constructor ��ġ�� �ʰ� �ٷ� setter�� �Ѿ
//	=> �⺻������ �ڵ� ������
	public InlineExamConsole() {
		System.out.println("constructor");
	}

//	@Autowired
//	@Qualifier("exam2")
//	@Qualifier("exam2")�� ��ġ�� �߸��Ǿ��ٰ� ����
//	public InlineExamConsole(Exam exam1, Exam exam2) { }
//		�� ���� �������̽��� �� �� �̻� �� �� �ִٰ� �Ǵ�
//		=> �Ķ���Ϳ� ���� ���� ������
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
	
//	di �����ϴ� xml ��� ����
//	Ư���� ���� ������ class ���ͼ� Autowired�� ã�� ���� => NullPointerException
//	@Autowired
//	@Qualifier("exam2")
	@Override
	public void setExam(Exam exam) {
		System.out.println("setter");
		this.exam=exam;
	}

}
