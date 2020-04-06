package spring.di.ui;

import spring.di.entity.Exam;

public class GridExamConsole implements ExamConsole {

	private Exam exam;

	public GridExamConsole(Exam exam) {
//		super();  // ºÒÇÊ¿ä
		this.exam = exam;
	}
	
	public GridExamConsole() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void print() {
		System.out.println("______________________");
		System.out.println("|   total  |    avg   |");
		System.out.println("______________________");
		System.out.printf("|   %3d  |    %3.2f   |\n", exam.total(), exam.avg());
		System.out.println("______________________");
	}

	@Override
	public void setExam(Exam exam) {
		this.exam=exam;
	}

}
