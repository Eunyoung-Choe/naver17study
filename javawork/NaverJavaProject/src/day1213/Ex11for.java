package day1213;

public class Ex11for {

	public static void main(String[] args) {

		System.out.println("알파벳 반복해서 출력하기");
		for(int i=65;i<=90;i++) 
			System.out.print((char)i);
		System.out.println();
		
		for(char ch='A';ch<='Z';ch++)
			System.out.print(ch);
		System.out.println();
		
		//Z부터 A까지 거꾸로 출력하기
		for(char ch='Z';ch>='A';ch--)
			System.out.print(ch+" ");
	}

}