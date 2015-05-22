package oop05.polymorphism;

import java.util.Scanner;

public class ControllerMain {
	public static void main(String[] args) {
		ControllerPattern controller = new ControllerPattern();
	
		System.out.println("Game 종류 선택");
		System.out.println("다음 중에서 선택하세요.");
		System.out.println("[1] 1-0 맞추기");
		System.out.println("[2] 가위바위보 ");
		System.out.println("[3] 카우프지수");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		if(num>0 && num <4){
			controller.selectGame(num);
		}else{
			System.out.println("1부터 3에서 입력해 주세요");
		}
		
	}
}
