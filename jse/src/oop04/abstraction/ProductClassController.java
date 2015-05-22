package oop04.abstraction;

public class ProductClassController {
	public static void main(String[] args) {
		ComputerInfoClass ci = new ComputerInfoClass();
		ci.setInfo("삼성", "센스", "a-1234","듀얼코어",
				"2GB","500GB");
		
		TvInfoClass ti = new TvInfoClass();
		ti.setInfo("LG", "x캔버스", "lg-1234", 
				"42인치", "LCD");
		
		ProductInterface pii[] =
				new ProductInterface[2];
		pii[0] = ci;
		pii[1] = ti;
		
		for(int i=0;i<pii.length;i++){
			pii[i].displayInfo();
			System.out.println();
		}
		
	}
}
