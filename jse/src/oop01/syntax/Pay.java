package oop01.syntax;

public class Pay {
	
	String name;
	int salary;
	static final double TAX = 0.1; //참조변수를 통하여 접근
 	
	public static void main(String[] args) {
		
		Pay hulk = new Pay(); // 참조변수를 선언하는 방법 
		Pay iron = new Pay();
		Pay thor = new Pay();
		
		hulk.name = "헐크";
		hulk.salary = 300;
		iron.name = "아이언맨";
		iron.salary = 500;
		thor.name = "토르";
		thor.salary = 100;
		
		System.out.println("===" + hulk.name  + "의 5월달 실급여는" 
				+ (int)((1-TAX)*hulk.salary) + "만원 입니다.");	
		
		System.out.println("===" + iron.name  + "의 5월달 실급여는" 
				+ iron.salary + "만원 입니다.");
		
		System.out.println("===" + thor.name  + "의 5월달 실급여는" 
				+ thor.salary + "만원 입니다.");
	}
}
