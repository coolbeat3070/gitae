package oop05.polymorphism;

public class RpsServiceImpl implements RpsService{

	@Override
	public int displayComVal() {
		
		return (int) ((Math.random()*3)+1);
	}

	@Override
	public String showWinner(int playerVal, int comVal) {
		String msg = "";
		switch(playerVal-comVal){
		case 0: msg = "비겼습니다."; break;
		case 1:case -2:
				msg = "플레이어가 이겼습니다."; break;
		default: msg = "플레이어가 졌습니다."; break;
		}
		return msg;
	}

	@Override
	public String showRpsVal(int playerVal) {
		String msg = "";
		switch(playerVal){
		case 1: msg = "가위"; break;
		case 2: msg = "바위"; break;
		case 3: msg = "보자기"; break;
		}
		return msg;
	}

}
