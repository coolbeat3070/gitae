package oop05.polymorphism;

public class KaupServiceImpl implements KaupInterface{
	int idx;
	@Override
	public int getKaupIndex(double height, double weight) {
		this.idx = (int) ((weight/(height*height))*10000);
		System.out.println(getResultMsg());
		return idx;
	}

	@Override
	public String getResultMsg() {
		String msg = "";
		if(idx>30){ msg = "비만";}
		else if(idx>24){ msg = "과체중";}
		else if(idx>20){ msg = "정상";}
		else if(idx>15){ msg = "저체중";}
		else if(idx>13){ msg = "마름";}
		else if(idx>10){ msg = "영양실조";}
		else { msg = "소모증";}
		return  "카우프 지수는 "+this.idx +"이고, 결과는 "+ msg+"입니다";
	}

}
