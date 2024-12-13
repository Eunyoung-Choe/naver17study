package day1213;

import java.util.Scanner;

public class Ex2Switch {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
//				char ch; //반복문 없어서 입력 한 번 밖에 안 되나?
//		
//		System.out.println("알파벳 한 글자 입력");
//		ch = sc.nextLine().charAt(0); // 입력한 문자열 중 첫 글자를 char 타입으로 반환
//		
//		switch(ch) 
//		{
//		case 'a': // 현재 case에는 break가 없어서 다음 명령 실행
//		case 'A':
//			System.out.println("Apple");
//			break;
//		case 'b':
//		case 'B':
//			System.out.println("Banana");
//			break;
//		case 'c':
//		case 'C':
//			System.out.println("Computer");
//			break;
//		default:
//			System.out.println("a,b,c가 아닌 알파벳");
//		}
		
		System.out.println("영단어를 입력해주세요");
		String msg = sc.nextLine();
		
		switch(msg) {
		case "red":
		case "RED":
			System.out.println("빨강색");
			break;
		case "green":
		case "GREEN":
			System.out.println("초록색");
			break;
		default:
			System.out.println("빨강, 초록 제외한 색상");
		}
	}
}
