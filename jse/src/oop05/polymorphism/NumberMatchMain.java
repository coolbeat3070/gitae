package oop05.polymorphism;

import java.util.Scanner;

public class NumberMatchMain {
	public static void main(String[] args) {
		int playVal;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1 또는 0 만 입력하세요.");
		playVal = scanner.nextInt();
		System.out.println("플레이어 값 :"+playVal);
		NumberMatchService service = new NumberMathcServiceImpl();
		int comVal = service.makeComVal();
		System.out.println("컴퓨터 값 :" + comVal);
		if(service.match(playVal, comVal)){
			System.out.println(service.display());
		}else{
			System.out.println("플레이어 패배");
		}
		
	}
}
