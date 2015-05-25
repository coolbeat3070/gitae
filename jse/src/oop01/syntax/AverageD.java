package oop01.syntax;

public class AverageD {
	public static void main(String[] args) {
		
		AverageService averageService = new AverageService();
		
		String name = "헐크";
		int kor = 100;
		int eng = 90;
		
		averageService.setUser(name, kor, eng);
		
		System.out.println("===" + name + "의 성적표===");
		System.out.println("국어 : " + kor + "점");
		System.out.println("영어 : " + eng + "점");
		System.out.println("총점 : " + averageService.getTotal() + "점");
		System.out.println("평균 : " + averageService.getAverage() + "점");
		
	}

}
