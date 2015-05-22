package oop01.syntax;

public class CardMain {

	public static void main(String[] args) {
		System.out.println("카드 높이 :"+CardVO.height);
		System.out.println("카드 너비 :"+CardVO.width);
		
		// 인스턴스 생성하셔서 아래 결과처럼 
		// 출력되도록 해주세요
		CardVO player =new CardVO("하트",3);
		CardVO com = new CardVO("스페이스", 5);
		
		System.out.println("플레이어는"+player.toString()+" 이고"); 
		System.out.println("컴퓨터는" +com.getKind()+com.getNumber()+"라서 "
				+ "컴퓨터가 이겼습니다.");
//		
//		System.out.println("플레이어는 하트 3 이고"); 
//		System.out.println("컴퓨터는" +"스페이스"+" 5"+"라서 "
//				+ "컴퓨터가 이겼습니다.");
//		// heart, spade
	}
}
