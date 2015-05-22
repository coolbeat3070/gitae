package cmm04.array;

import java.util.Scanner;

public class No03_ForLoopArrayDemo {
	public static void main(String[] args) {
		No03_ForLoopArrayVO vo = new No03_ForLoopArrayVO();
		Scanner scanner = new Scanner(System.in);
		System.out.println("다섯개의 숫자를 입력하세요. ");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		int d = scanner.nextInt();
		int e = scanner.nextInt();
		
		vo.testFor(a,b,c,d,e);
	}
}
