package day1213;

import java.util.Scanner;

public class Ex12For {

	public static void main(String[] args) {

		/*
		 * 문제 1 
		 * 숫자 n 을 입력하면 1부터 n까지의 합계를 구하시오
		 * (for문 사용할것)
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 합계 계산: ");
		
		int n, sum = 0;
		n = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			sum += i;
		}
		
		System.out.print(sum+" ");
	}

}