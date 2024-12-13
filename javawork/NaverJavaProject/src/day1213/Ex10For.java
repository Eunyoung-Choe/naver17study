package day1213;

public class Ex10For {

	public static void main(String[] args) {

		for(int i=1;i<=5;i++) // 3번째 자리는 증감연산자나 대입연산자만 올 수 있음.
			System.out.print(i+" ");
		System.out.println();
		
		for(int i=1;i<=10;i+=2)
			System.out.print(i+" ");
		System.out.println();
		
		for(int i=10;i>=1;i--)
			System.out.print(i+" ");
		System.out.println();
		
		for(int i=10;i<=100;i+=10)
			System.out.print(i+" ");
		System.out.println();
		
		System.out.println("break=================");
		
		for(int i=1;i<=10;i++) {
			System.out.print(i+" ");
			if(i==5)
				break;
		}
		
		System.out.println();
		System.out.println("continue===============");
		
		
		for(int i=0;i<=10;i++) {
			if(i%2==1)
				continue;
			System.out.print(i+" ");
		}
	}

}
