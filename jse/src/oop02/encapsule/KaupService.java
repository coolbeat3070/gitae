package oop02.encapsule;

import java.util.Scanner;

public class KaupService {

	public static void main(String[] args) {
		
		KaupVO vo = new KaupVO();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ű�� �Է��ϼ���");
		double height = scanner.nextDouble();
		System.out.println("�����Ը� �Է��ϼ���");
		double weight = scanner.nextDouble();
		vo.setHeight(height);
		vo.setWeight(weight);
		vo.setIdx(height, weight);
		System.out.println(vo.getMsg());
		vo.setMsg("");
		System.out.printf(vo.toString());
		System.out.println("�Ϸ�");
	}
}