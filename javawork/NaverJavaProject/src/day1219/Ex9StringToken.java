package day1219;

import java.util.StringTokenizer;

public class Ex9StringToken {

	public static void main(String[] args) {

		String msg = "red|green|yellow|white|black";
//		String []arr = msg.split("|"); // 잘 안 됨.
//		for(String a:arr)
//		{
//			System.out.println(a);
//		}
		
		StringTokenizer st = new StringTokenizer(msg, "|");
		System.out.println("분리할 총 토큰 수"+st.countTokens());
		
		// countTokens는 토큰을 읽을 때마다 개수가 줄어든다.
		// 아래처럼 반복문을 돌리면 3번만 반복된다는 것.
//		for(int i=0; i<st.countTokens(); i++) 
//		{
//			System.out.println(st.nextToken());
//		}
		
		// 방법1
		int count = st.countTokens();
		for(int i=0; i<count; i++)
		{
			System.out.println(st.nextToken());
		}
		
		StringTokenizer st2 = new StringTokenizer(msg, "|");
		// 방법2
		while(st2.hasMoreTokens())
		{
			System.out.println(st2.nextToken());
		}
		System.out.println();
		String []arr2 = msg.split("|");
		System.out.println("총 "+arr2.length+"개");
		
		
		System.out.println("=====================");
		String []arr3 = msg.split("\\|"); // 정규표현식
		System.out.println("총 "+arr3.length+"개");
		
		// 아래 데이터를 .으로 분리하여 출력하시오.
		String msg2 = "카리나.윈터.닝닝.지젤";
		String []arr4 = msg2.split("\\.");
		
		for(String s:arr4)
			System.out.println(s);
		
	}

}
