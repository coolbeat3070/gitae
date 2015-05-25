package oop05.polymorphism;

public interface NumberMatchService {
	/*
	 * 컴퓨터가 랜덤으로 생성하는 숫자
	 * 0 과 1만 발생시킴
	 * */
	public int makeComVal();
	/*
	 * 두개의 파라미터를 비교해서 일치하면 true
	 * 다르면 false 리턴
	 * */
	public boolean match(int playVal,int comVal);
	/*
	 * makeComVal() 의 리턴값이 true 면 플레이어 승리
	 * 다르면 컴퓨터승리라고 메시지 출력
	 * */
	public String display();
}
