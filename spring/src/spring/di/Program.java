package spring.di;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.entity.Exam;
//import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
//import spring.di.ui.GridExamConsole;
//import spring.di.ui.InlineExamConsole;

public class Program {

	public static void main(String[] args) {

		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/di/setting.xml");
		
//		Exam exam=context.getBean(Exam.class);
//		System.out.println(exam.toString());
		
//		�̸����� ã�� �� ���
		ExamConsole console = (ExamConsole) context.getBean("console");
//		�ش� �������̽��� ���յǴ� ���̵� ã�Ƶ����� => �������� ã��
//		ExamConsole console = context.getBean(ExamConsole.class);
		console.print();
		System.out.println();
		
//		exam list���� exam�� set��
//		List<Exam> exams = (List<Exam>) context.getBean("exams");
//		exams.add(new NewlecExam(1,1,1,1));
		
//		for(Exam e: exams)
//			System.out.println(e);
	}

}
