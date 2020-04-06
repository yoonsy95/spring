package spring.di;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;
import spring.di.ui.InlineExamConsole;

public class Program {

	public static void main(String[] args) {
//		형식 같아야하는데 다름(참조형식 != 객체형식)
//		부모자식관계면 상관 없음
//		interface(Exam) = 데이터구현객체(NewlecExam)
		Exam exam = new NewlecExam();
		
//		exam 출력(ExamConsole)
//		interface(ExamConsole)
		
//		InlineExamConsole: 한 줄로 출력
//		일반적인 방식
//		ExamConsole console = new InlineExamConsole();
		ExamConsole console = new GridExamConsole();
		console.setExam(exam);
		
//		생성자로 결합
//		ExamConsole console = new InlineExamConsole(exam);  // DI
		
//		GridExamConsole: 그리드 형태로 출력
//		ExamConsole console = new GridExamConsole(exam);
		console.print();
		
//		InlineExamConsole -> GridExamConsole 수정시
//		소스 수정이 없으려면 설정파일로 빼내야 함
//		=> spring이 해줌 // 결합여부, 방식
//			di를 대신해주면서 소스코드를 밖으로 빼내주는 역할
	}

}
