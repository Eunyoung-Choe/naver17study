package day1213;

import java.util.Scanner;

public class Ex4Switch {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num;
		System.out.println("숫자 입력");
		num = sc.nextInt();
		switch(num%2)
		{
		case 0:
			System.out.println("짝수입니다.");
			break;
		case 1:
			System.out.println("홀수입니다");
		}
		
		// if문으로 구현해보기
		if(num%2==0)
			System.out.println("짝수입니다");
		else
			System.out.println("홀수입니다");
	}

}
