package spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import spring.di.entity.Exam;
//import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
//import spring.di.ui.GridExamConsole;
//import spring.di.ui.InlineExamConsole;

public class Program {

	public static void main(String[] args) {
		
/*
 * 		��ǰ ���� => ������ �ٲ�� �κ� => ���� ���Ϸ� ������ ������ ���� �ٶ���
 * 		Exam exam = new NewlecExam();
 * 		ExamConsole console = new GridExamConsole();
 * 
 * 		��ǰ ���� => ������ �ٲ�� �ش� �κе� �����Ǿ�� ��
 * 		console.setExam(exam);
 */
		
//		�� ������ spring ���ü��� �ٲ� => setting.xml
//		context: IoC container ���� ����
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/di/setting.xml");
		
//		��ü �̸��������� ��û�� �� object������ �������Ƿ� casting ���־�� ��
//		ExamConsole console = (ExamConsole) context.getBean("console");

//		ExamConsole���� interface ������ ������ �� �ִ� ģ���� ã���� 
//		class ��� ��üȭ�� �̸� �־ ��
//		����ȯ �ʿ� ���� ����ϱ⿡ ��ȣ��
		ExamConsole console = context.getBean(ExamConsole.class);
		
//		print()
		console.print();
	}

}
