package oop02.encapsule;
/*package oop01.encapsule;

import java.util.Scanner;

public class GameRpsController {
	public static void main(String[] args) {
		System.out.println("���������� ������ �����մϴ�.");
		boolean flag = true;
		while(flag){
			GameRpsService service = new GameRpsService();
			Scanner scanner = new Scanner(System.in);
			System.out.println("����:1 ����:2 ��:3 �� �Է��غ�����.");
			GameRPSValidation valid = new GameRPSValidation();
			try{
				int player = scanner.nextInt();
				int a = 1;
				int b = 3;
				if(player<1||player>3){
					System.out.println(valid.showRange(a,b));
					continue;
				} 
				String playerRPS = vo.setRpsValue(player);
				System.out.println("����� "+playerRPS+"�� �½��ϴ�.");
				int computer = (int)((Math.random()*3)+1);
				String computerRPS = vo.setRpsValue(computer);
				
				GameRpsService service = new GameRpsService();
				System.out.println("��ǻ�ʹ�" + computerRPS +"�̰�,"
						+ "���� "+service.playGame(player,computer)+"�Դϴ�.");
			}catch(Exception ex){
				ex.printStackTrace();
				continue;
			}
		}
		
	}
}
*/