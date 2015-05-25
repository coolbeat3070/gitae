package oop05.polymorphism;

import java.util.Scanner;

public class KaupMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("키를 입력하세요");
		double height = scanner.nextDouble();
		System.out.println("몸무게를 입력하세요");
		double weight = scanner.nextDouble();
		KaupInterface ki = new KaupServiceImpl();
		ki.getKaupIndex(height, weight);
		System.out.println(ki.getResultMsg());
	}
}
