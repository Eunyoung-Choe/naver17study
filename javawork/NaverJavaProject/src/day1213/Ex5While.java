package day1213;

public class Ex5While {

	public static void main(String[] args) {

		int a = 10;
		
		while(a<10) {
			System.out.println("while loop");
		}
		
		//do~while은 일단 한 번은 실행
		do {
			System.out.println("do~while loop");
		}while(a<10);
		
		a = 1;
		while(a<=10) {
			System.out.printf("%3d", a++);
		}
		
		System.out.println();
		a = 1;
		while(true) //true로 들어가니 반드시 break 필요
		{
			System.out.printf("%3d", a++);
			if (a==10)
				break; 
		}
		
		System.out.println();
		a = 0;
		while(a<10) {
			System.out.printf("%3d", ++a);
		}
		
		System.out.println();
		a = 1;
		do {
			System.out.printf("%3d", a++);
		}while(a<=10);
	}

}
