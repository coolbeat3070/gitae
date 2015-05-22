package oop02.encapsule;

import java.util.Scanner;

public class NumberMatchController {
	public static void main(String[] args) {
		NumberMatchService service = new NumberMatchService();
		int player;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1~2������ ���� �Է��ϼ���.");
		player = scanner.nextInt();
		service.game(player);
		
	}
}
