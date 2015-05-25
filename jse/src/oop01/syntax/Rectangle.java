package oop01.syntax;

public class Rectangle {
	public int width = 0;
	public int height = 0;
	public Point origin;
	
	public Rectangle() {
		origin = new Point(0,0);
	}
	public Rectangle(Point p){
		origin = p;
	}
	public Rectangle(int w, int h){
		origin = new Point(0,0);
		width = w;
		height = h;
	}
	public Rectangle(Point p, int w, int h){
		origin = p;
		width = w;
		height = h;
	}
	// a method  for moving the rectangle
	public void move(int x, int y){
		// 원래위치 orgin 이라 할때
		// 파라미터 위치로 옮기는 기능을
		// 코드화 시켜주세요
		origin.x = x;
		origin.y = y;
	}
	// a method for computing the area of the rectangle
	public int getArea(){
		return width*height; // 0 대신 공식을 대입하세요.
	}

}
