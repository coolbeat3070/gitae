package cmm04.array;

public class No03_ForLoopArrayVO {
	
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getE() {
		return e;
	}

	public void setE(int e) {
		int a;
		this.e = e;
	}
	private int a,b,c,d,e;
	void testFor(int a, int b, int c, int d, int e){
		
		setA(a);
		setB(b);
		setC(c);
		setD(d);
		setE(e);
		
		int[] arr = {getA(),getB(),getC(),getD(),getE()};
		int sum=0;
		
		/*
		 *  입력받은 다섯개의 숫자의 합을 구하세요
		 * 
		 * */
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
			
		System.out.println(" 1부터 5까지의 합은 :" +sum);
	}
}
