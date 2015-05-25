package oop01.syntax;

public class AverageB {
	String name;
	int kor;
	int eng;
	/*메소드를 여기에 정의하셔서 */
	/*메소드의 객체화롤 해주세요.*/
	int tot(){
		int tot = this.eng + this.kor ;
		return tot ;
	}
	double avg(){
		double avg = tot() / 2d;
		return avg ;
	}
	
	public static void main(String[] args) {
		
		AverageB hulk = new AverageB();
		
		hulk.name = "헐크";
		hulk.kor = 100 ; 
		hulk.eng = 75 ;
		
		System.out.println("==="+hulk.name+"의 평균을 구하시오===");
		System.out.println("국어 : "+hulk.kor+"점");
		System.out.println("영어 : "+hulk.eng+"점");
		System.out.println("총점 : "+hulk.tot()+"점");
		System.out.println("평균 : "+hulk.avg()+"점"); 
		System.out.println();

	}
}





