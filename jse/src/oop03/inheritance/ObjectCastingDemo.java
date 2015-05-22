package oop03.inheritance;

public class ObjectCastingDemo {
	public static void main(String[] args) {
		// 일반적인 객체생성
		ParentC p = new ParentC();
		ChildC c = new ChildC();
		
		// 부모 타입 = new 자식타입
		ParentC p2 = new ChildC();
		
		// 오버라이딩시 자식클래스 메소드 우선 출력
		p2.over(1);
		// 오버라이딩 하지 않으면 부모클래스 우선 호출
		p2.noOver(1);
		// 부모클래스 타입을 자식클래스로 강제 형변환
		ChildC c2 = (ChildC) p2;
		c2.over(1);
		c2.noOver("AAA");
	}
}
class ParentC{
	void over(int i){
		System.out.println("Aclass-over() :" + (i*10));
	}
	void noOver(int i){
		System.out.println("Aclass-noOver() :" + i);
	}
}
class ChildC extends ParentC{
	public ChildC() {
		super.over(3);
	}
	
	void over(int i){
		System.out.println("Bclass-over() :" + (i*10000));
	}
	void noOver(String s){
		System.out.println("Bclass-noOver() :" + s);
	}
	void onlyB(){
		System.out.println("onlyB()");
	}
}








