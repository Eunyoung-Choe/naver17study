package day1213;

public class Ex6While {

	public static void main(String[] args) {
		
		int a = 65;
		while(a<=90) {
			System.out.print((char)a++);
		}
		
		
		
		System.out.println();
		char b = 'a';
		// do~while로 a~z까지 출력하기
		do {
			System.out.print(b++);
		}while(b<='z'); //아 조건에 문자 넣어도 되는군.
		
		
		
		// continue
		System.out.println();
		int n = 0;
		while(n<=10) {
			n++;
			if(n%2==0)
				continue;
			System.out.printf("%3d", n++);
		}
	}

}