package oop02.encapsule;

import java.util.Scanner;

public class PayController {
	public static void main(String[] args) {
		/*
		 ��� ... 
		 income = salary - salary*TAX;
		 static final double TAX = 0.1;
		 PayVO : getter, setter
		 PayService : ������
		 PayController : ����� �� �����մϴ�.
		 ������ �����ϼ���.
		 �̸��� �޿��� �Է¹޾Ƽ�
		 ���� �� �� �ҵ��� ���ϴ� �����Դϴ�.
		 
		 * */
		Scanner scanner = new Scanner(System.in);
		System.out.println(" �̸��� �Է��ϼ���. ");
		String name = scanner.nextLine();
		System.out.println(" ������ �Է��ϼ���. ");
		int salary = scanner.nextInt();
		PayService service = new PayService();
		
		System.out.println("===== �޿����� =====");
		System.out.println("���� : " + name );
		System.out.println("���� : " + salary);
		System.out.println("���� : " + service.showTax());
		System.out.println("�Ǽ��ɾ� : " + service.calculateIncome(name,salary));
	}
}
