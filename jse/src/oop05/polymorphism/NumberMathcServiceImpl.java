package oop05.polymorphism;

public class NumberMathcServiceImpl implements NumberMatchService{
	int comVal;
	@Override
	public int makeComVal() {
		this.comVal = (int) ((Math.random()*1));
		return comVal;
	}

	@Override
	public boolean match(int playVal, int comVal) {
		if(comVal == playVal){
			return true;
		}
		return false;
	}

	@Override
	public String display() {
		
		return "플레이어 승리";
	}

}
