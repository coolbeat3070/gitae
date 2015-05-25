package oop01.syntax;

public class AverageEVO {
	public AverageEVO() {}// 디폴트생성자 직접 작성
	
	public AverageEVO(String name, int kor, int eng) {

		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.tot();
		this.avg();
	}
	public AverageEVO(String name, int kor, int eng, int math) {

		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.tot();
		this.avg();
	}

	
	int tot(){
		int total = this.kor + this.eng;
		return total;
	}
	
	double avg(){
		double avgerage = this.tot()/2d;
		return avgerage;
	}
	private String name;
	private int kor;
	private int eng;
	private int math;
	// getter setter 를 사용하지 마시고
	// 생성자로 처리해주세요
	// 단, avg() tot()은 작성해주세요
	@Override
	public String toString() {
		return " [name=" + name + ", kor=" + kor + ", eng=" + eng+
				"tot = "+tot()+"avg ="+avg()
				+ "]";
	}
	
}
