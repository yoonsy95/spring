package spring.di;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;
import spring.di.ui.InlineExamConsole;

public class Program {

	public static void main(String[] args) {
//		���� ���ƾ��ϴµ� �ٸ�(�������� != ��ü����)
//		�θ��ڽİ���� ��� ����
//		interface(Exam) = �����ͱ�����ü(NewlecExam)
		Exam exam = new NewlecExam();
		
//		exam ���(ExamConsole)
//		interface(ExamConsole)
		
//		InlineExamConsole: �� �ٷ� ���
//		�Ϲ����� ���
//		ExamConsole console = new InlineExamConsole();
		ExamConsole console = new GridExamConsole();
		console.setExam(exam);
		
//		�����ڷ� ����
//		ExamConsole console = new InlineExamConsole(exam);  // DI
		
//		GridExamConsole: �׸��� ���·� ���
//		ExamConsole console = new GridExamConsole(exam);
		console.print();
		
//		InlineExamConsole -> GridExamConsole ������
//		�ҽ� ������ �������� �������Ϸ� ������ ��
//		=> spring�� ���� // ���տ���, ���
//			di�� ������ָ鼭 �ҽ��ڵ带 ������ �����ִ� ����
	}

}
