package day1213;

import java.util.Scanner;

public class Ex9While {

	public static void main(String[] args) {

		/*
		 * 한 글자씩 입력하다 x,X를 입력하면 빠져나와서 입력한 데이터들을 분석한 결과를 출력하시오.
		 * (대문자:3, 소문자:4, 숫자:3)
		 */
		
		Scanner sc = new Scanner(System.in);
		char ch;
		int upper=0, lower=0, number=0; //대문자, 소문자, 숫자 카운트
		
		while(true)
		{
			System.out.println("문자입력 (종료:x):");
			ch = sc.nextLine().charAt(0);
			//종료 코드
			if(ch=='x' || ch=='X')
				break;
			
			
//			if(ch>='a' && ch<='z')
//				lower++;
//			else if(ch>='A' && ch<='Z')
//				upper++;
//			else if(ch>='0' && ch<='9')
//				number++;
			
			// 위를 아스키코드로 바꾸면
			if(ch>=97 && ch<=122)
				lower++;
			else if(ch>=65 && ch<=90)
				upper++;
			else if(ch>=48 && ch<=57)
				number++;
		}
		
		System.out.println("대문자: "+upper);
		System.out.println("소문자: "+lower);
		System.out.println("숫자: "+number);
		
		
	}

}
