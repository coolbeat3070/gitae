package oop01.syntax;

public class AverageService {

	private AverageDVO averageDVO = new AverageDVO();
	
	public void setUser(String name, int kor, int eng) {
		averageDVO.setName(name);
		averageDVO.setKor(kor);
		averageDVO.setEng(eng);
	}

	public int getTotal() {
		return averageDVO.getKor() + averageDVO.getEng();
	}

	public double getAverage() {
		return getTotal() / 2d;
	}
	
	
	
}
