package oop01.syntax;

public class Pay {
	
	String name;
	int salary;
	static final double TAX = 0.1; //���������� ���Ͽ� ����
 	
	public static void main(String[] args) {
		
		Pay hulk = new Pay(); // ���������� �����ϴ� ��� 
		Pay iron = new Pay();
		Pay thor = new Pay();
		
		hulk.name = "��ũ";
		hulk.salary = 300;
		iron.name = "���̾��";
		iron.salary = 500;
		thor.name = "�丣";
		thor.salary = 100;
		
		System.out.println("===" + hulk.name  + "�� 5���� �Ǳ޿���" 
				+ (int)((1-TAX)*hulk.salary) + "���� �Դϴ�.");	
		
		System.out.println("===" + iron.name  + "�� 5���� �Ǳ޿���" 
				+ iron.salary + "���� �Դϴ�.");
		
		System.out.println("===" + thor.name  + "�� 5���� �Ǳ޿���" 
				+ thor.salary + "���� �Դϴ�.");
	}
}
