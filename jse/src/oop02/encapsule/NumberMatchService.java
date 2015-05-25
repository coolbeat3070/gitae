package oop02.encapsule;

public class NumberMatchService {
	NumberMatchVO vo = new NumberMatchVO();
	int player;
	public int game(int player){
		int result;
		vo.setCom();
		vo.setPlayer(player);
		if(vo.getPlayer()==vo.getCom()){
			
			System.out.println( vo.getPlayer() + "���� !!");
			result = 1;
		}else{
			System.out.println("Ʋ�Ƚ��ϴ�.");
			System.out.println("��ǻ�Ͱ� ������ ���� "+vo.getCom()+" �Դϴ�");
			result = 0;
		}
		return result;
		
	}
}
