package day1219;
/*
 * <인자 전달 방식>
 * CallByValue : 값만 전달(기본형, String)
 * CallByReference : 주소가 전달 (모든 객체, 배열 타입)
 */

class Test{
	   String message;
	   int code;
	   
	}
//////////////////////////////////////////

public class Ex5CallBy {
	
	public static void changeInt(int n) // 주소가 다르게 새로 생성
	{
		n = 200;
	}
	
	public static void changeString(String s)
	{
		s = "apple";
	}
	
	public static void changeTest(Test t)
	{
		t.message = "Happy";
		t.code = 100;
	}
	
	
	// Array를 받자
	public static void changeArray(int []arr)
	{
		arr[1] = 20;
	}
	
	
	// return이 필요한 경우를 보자.
	public static int changeScore(int score)
	{
		if(score>=80)
			return score;
		else
			return 90;
	}
	
	///////////////////////////////////////////
	public static void main(String[] args) {

		int n = 100;
		changeInt(n); // static 메서드니까 바로 호출 가능
		System.out.println("n="+n);
		
		String s = "Berry";
		changeString(s);
		System.out.println(s); // 값만 전달
		
		Test t = new Test();
		System.out.println("message="+t.message+", code="+t.code);
		changeTest(t);
		System.out.println("message="+t.message+", code="+t.code);
		
		
		// 배열
		int []a = {5, 8 ,11};
		changeArray(a);
		for(int aa:a) // 이 형태 표기 어색하다
			System.out.println(aa+"  ");
		System.out.println();
		
		int score = 70;
		//값만 전달되는 경우는 메서드에서 변경된 값을 받으려면 무조건 return으로 받아와야 함.
		score = changeScore(score);
		System.out.println("score="+score);
	}

}
