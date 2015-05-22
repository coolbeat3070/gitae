package cmm03.flow;

public class No02_IfElseDemo2 {
	public static void main(String[] args) {
		int kor = 90, eng = 85, sum = 0;
		double avg = 0.0;
		String msg = "메시지";
		sum = kor + eng;
		avg = sum/2;
		
		// 조건에 따라 if 처리
		/*
		 * 평균이 100점이면 "보너스 지급"
		 * 평균이 70 이상이면 "시험 합격"
		 * 평균이 70 미만이면 "재시험을 보세요."
		 * 
		 * */
		
		
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("총점 : " + sum);
		System.out.println(msg);
		
		if(avg == 100){
			System.out.println("보너스 지급");
		} else if(avg >= 70){
			System.out.println("시험 합격");
		} else
			System.out.println("재시험을 보세요.");
	}
}
