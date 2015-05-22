package oop01.syntax;

public class AverageA {
	String name;
	int kor;
	int eng;
	
	public static void main(String[] args) {
		
		AverageA hulk = new AverageA();
		AverageA iron = new AverageA();
		AverageA thor = new AverageA();
		
		hulk.name = "헐크";
		hulk.kor = 80;
		hulk.eng = 55;
		
		int tot = hulk.eng+hulk.kor;
		double avg = tot/2d;
		
		System.out.println("==="+hulk.name+"의 평균을 구하시오===");
		System.out.println("국어 : "+hulk.kor+"점");
		System.out.println("영어 : "+hulk.eng+"점");
		System.out.println("총점 : "+tot+"점");
		System.out.println("평균 : "+avg+"점"); 
		System.out.println();
		
		
	}
}
