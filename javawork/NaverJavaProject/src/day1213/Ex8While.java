package day1213;

import java.util.Scanner;

public class Ex8While {

	public static void main(String[] args) {

		/*
		 * 숫자 n을 입력하면 1부터 n까지의 합계 sum을 구해서 출력하시오.
		 * Ex) 100 입력 시 1부터 100까지의 합계는 5050입니다. (printf)
		 */
		
		/* 내가 작성한 것
		Scanner sc = new Scanner(System.in);
		int input=0, sum=0, start=1;
		input = sc.nextInt();
		
		while(true)
		{
			System.out.println("숫자를 입력하세요.");	
			
			if(start>input)
				break;
			
			sum += start;
			start++;
			
		}
		*/
		
		// 답안
		Scanner sc = new Scanner(System.in);
		int n, start=1, sum=0;
		System.out.println("숫자 n입력");
		n = sc.nextInt();
		while(start<=n){
			sum += start++; // 이렇게 이어 써도 되는군.
		}
		
		System.out.printf("1부터 %d까지의 합계는 %d입니다.", n, sum);
		
	}

}
