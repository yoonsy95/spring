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
		
//		이름으로 찾을 때 사용
		ExamConsole console = (ExamConsole) context.getBean("console");
//		해당 인터페이스에 부합되는 아이들 찾아데려와 => 형식으로 찾음
//		ExamConsole console = context.getBean(ExamConsole.class);
		console.print();
		System.out.println();
		
//		exam list들을 exam이 set함
//		List<Exam> exams = (List<Exam>) context.getBean("exams");
//		exams.add(new NewlecExam(1,1,1,1));
		
//		for(Exam e: exams)
//			System.out.println(e);
	}

}
