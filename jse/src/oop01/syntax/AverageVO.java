package oop01.syntax;

class AverageVO {
	private String name;
	private int kor;
	private int eng;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	int tot(){
		int tot = this.eng + this.kor ;
		return tot ;
	}
	double avg(){
		double avg = tot() / 2d;
		return avg ;
	}
}
