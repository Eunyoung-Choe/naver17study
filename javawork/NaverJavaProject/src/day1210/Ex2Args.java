package day1210;

public class Ex2Args {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("첫 번째 값:"+args[0]);
		System.out.println("두 번째 값:"+args[1]);

		System.out.println(args[0]+args[1]);
		
		// 문자열을 숫자 형태로 변환해보자.
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		
		System.out.println("두 수의 합은 "+ (num1+num2) +"입니다."); // 우선 순위 ()
		
	}

}
