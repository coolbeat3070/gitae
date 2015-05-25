package oop01.syntax;

public class AverageC {
	public static void main(String[] args) {
		AverageVO hulk = new AverageVO();
		hulk.setName("헐크");
		hulk.setKor(100);
		hulk.setEng(95);
		
		System.out.println("==="+hulk.getName() +"의 평균을 구하시오===");
		System.out.println("국어 :"+hulk.getKor() + "점");
		System.out.println("영어 :"+hulk.getEng()+" 점");
		System.out.println("총점 :"+hulk.tot()+" 점");
		System.out.println("평균 : "+hulk.avg()+" 점"); 
		System.out.println();
	}
}
