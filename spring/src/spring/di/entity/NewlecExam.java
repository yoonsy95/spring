package spring.di.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.*;

//@Component
//@Component Annotation은 개념상 잘 맞지 않음
//component: mvc 방식으로 web app을 만들게 될 경우 mvc를 구성하고 있는 자바 코드,
//				업무형 로직들을 지니고 있는 코드
//				component를 역할로 나눔 // 역할 명시화 위하여 아래 사용 권장함
//					- Controller [RequesetMapping, GetMapping, ...]
//					- Service
//					- Repository => DAO
//				위 3가지는 모두 mvc 학습할 때 사용함
//				entity => not component
//				소스코드가 없으면 component 생성 불가

//@Service
//@Controller

//@Service와 @Controller는 비슷함
//@Controller가 좀 더 특화되었음

//여기에 component 생성 맞지 않으므로 사용ㄴㄴ함
public class NewlecExam implements Exam {
	@Value("10")
	private int kor;
	@Value("10")
	private int eng;
	@Value("40")
	private int math;
	@Value("40")
	private int com;
	
	public NewlecExam() {
		// TODO Auto-generated constructor stub
	}

	public NewlecExam(int kor, int eng, int math, int com) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.com = com;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getCom() {
		return com;
	}

	public void setCom(int com) {
		this.com = com;
	}

	@Override
	public int total() {
		// TODO Auto-generated method stub
		return kor+eng+math+com;
	}

	@Override
	public float avg() {
		// TODO Auto-generated method stub
		return total() / 4.0f;
	}

	@Override
	public String toString() {
		return "NewlecExam [kor=" + kor + ", eng=" + eng + ", math=" + math + ", com=" + com + "]";
	}
	
}
