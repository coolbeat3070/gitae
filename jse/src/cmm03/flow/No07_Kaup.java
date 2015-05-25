package cmm03.flow;

import java.util.Scanner;

public class No07_Kaup {
	double height;
	double weight;
	int idx;
	Scanner scanner = new Scanner(System.in);
	
	No07_Kaup() {
		
		this(0,0);
	}
	
	
	No07_Kaup(double i, double j) {
		setHeight(i);
		//this.height = i;
		setWeight(j);
		//this.weight = j;
		this.idx = (int) ((weight/(height*height))*10000);
	}
	

    public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		System.out.println("키를 입력하세요 : ");
		this.height = scanner.nextDouble();
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		System.out.println("몸무게를 입력하세요 : ");
		this.weight = scanner.nextDouble();
	}
	String getMsg(){
		String msg = "";
		if(idx>30){ msg = "비만";}
		else if(idx>24){ msg = "과체중";}
		else if(idx>20){ msg = "정상";}
		else if(idx>15){ msg = "저체중";}
		else if(idx>13){ msg = "마름";}
		else if(idx>10){ msg = "영양실조";}
		else { msg = "소모증";}
		return msg;
	}
	@Override
	public String toString() {
		return "카우프지수 [키=" + height + " cm , 몸무게=" + weight + " kg, 카우프지수="
				+ getMsg() + "]";
	}
	
	public static void main(String[] args) {
		//double i = 0 , j = 0;
		//No07_Kaup kaup = new No07_Kaup();
		//Scanner scanner = new Scanner(System.in);
		//System.out.println("키를 입력하세요");
		//double height = scanner.nextDouble();
		//System.out.println("몸무게를 입력하세요");
		//double weight = scanner.nextDouble();
		No07_Kaup kaup = new No07_Kaup();
		System.out.printf(kaup.toString());
		System.out.println("완료");
	}
	
	
	
	
	
	
}
