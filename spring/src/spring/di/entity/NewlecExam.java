package spring.di.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.*;

//@Component
//@Component Annotation�� ����� �� ���� ����
//component: mvc ������� web app�� ����� �� ��� mvc�� �����ϰ� �ִ� �ڹ� �ڵ�,
//				������ �������� ���ϰ� �ִ� �ڵ�
//				component�� ���ҷ� ���� // ���� ���ȭ ���Ͽ� �Ʒ� ��� ������
//					- Controller [RequesetMapping, GetMapping, ...]
//					- Service
//					- Repository => DAO
//				�� 3������ ��� mvc �н��� �� �����
//				entity => not component
//				�ҽ��ڵ尡 ������ component ���� �Ұ�

//@Service
//@Controller

//@Service�� @Controller�� �����
//@Controller�� �� �� Ưȭ�Ǿ���

//���⿡ component ���� ���� �����Ƿ� ��뤤����
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
