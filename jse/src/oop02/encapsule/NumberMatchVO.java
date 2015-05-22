package oop02.encapsule;

public class NumberMatchVO {
	int player, com;
	
	public int getPlayer() {
		return player;
	}
	public void setPlayer(int player) {
		if(player <1 || player > 5){
			System.out.println(" 1���� 5������ ������ �Է��ؾ� �մϴ�.");
		}else{
			this.player = player;
		}
	}
	public int getCom() {
		return com;
	}
	
	public void setCom(){
		this.com = (int) ((Math.random()*2)+1);

	}
}
