package day1213;

import java.util.Scanner;

public class Ex13For {

	public static void main(String[] args) {

		/*
		 * 문제 2
		 * 5명의 나이 입력 후 40세 이상과 40세 미만이 각각 몇 명인지 출력하고
		 * 평균 나이도 같이 출력하시오 (for문 사용)
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int over = 0, loss = 0, sum=0;
		
		System.out.println("5명의 나이를 입력하세요.");
		

		for(int i=5;i>0;i--) {
			int n = sc.nextInt();
			
			if(n>=40)
				over++;
			else
				loss++;
			
			sum += n;
				
		}
		
		System.out.println("40세 이상: "+over+"명");
		System.out.println("40세 미만: "+loss+"명");
		System.out.println("평균 나이: "+(double)sum/(over+loss));
		
	}

}
