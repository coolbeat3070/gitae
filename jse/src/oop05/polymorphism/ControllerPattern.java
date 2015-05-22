package oop05.polymorphism;

import java.util.Scanner;

public class ControllerPattern {
	Scanner scanner = new Scanner(System.in);
	KaupInterface kaupService = new KaupServiceImpl();
	NumberMatchService matchService = new NumberMathcServiceImpl();
	RpsService rpsService = new RpsServiceImpl();
	
	public void selectGame(int selectNo){
		switch (selectNo) {
		case 1: 	break;
		case 2:     break;
		case 3:  
			System.out.println("키를 입력하세요.");
			int height = scanner.nextInt();
			System.out.println("몸무게를 입력하세요.");
			int weight = scanner.nextInt();
			kaupService.getKaupIndex(height,weight);   break;
		default: 
			System.out.println("1~3에서 다시 입력하세요.");
			break;
		}
	}
	
}
