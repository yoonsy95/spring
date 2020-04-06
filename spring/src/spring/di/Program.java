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
 * 		부품 생성 => 수정시 바뀌는 부분 => 설정 파일로 밖으로 빼내는 것이 바람직
 * 		Exam exam = new NewlecExam();
 * 		ExamConsole console = new GridExamConsole();
 * 
 * 		부품 결합 => 생성이 바뀌면 해당 부분도 수정되어야 함
 * 		console.setExam(exam);
 */
		
//		위 내용을 spring 지시서로 바꿈 => setting.xml
//		context: IoC container 역할 수행
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/di/setting.xml");
		
//		객체 이름만가지고 요청할 시 object형으로 꺼내지므로 casting 해주어야 함
//		ExamConsole console = (ExamConsole) context.getBean("console");

//		ExamConsole에서 interface 형식의 참조될 수 있는 친구를 찾아줘 
//		class 대신 구체화된 이름 넣어도 됨
//		형변환 필요 없고 깔끔하기에 선호됨
		ExamConsole console = context.getBean(ExamConsole.class);
		
//		print()
		console.print();
	}

}
