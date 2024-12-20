package day1219;


// Java파일에는 '하나의' public 클래스만 존재할 수 있음!
public class Book237 {

	public static void main(String[] args) {

		// Computer 객체 생성
		Computer myCom = new Computer();
		
		int result1 = myCom.sum(1, 2, 3);
		System.out.println("result1: "+result1);
		
		int result2 = myCom.sum(1,2,3,4,5);
		System.out.println("result2: "+result2);
		
		int[] values = {1,2,3,4,5};
		int result3 = myCom.sum(values);
		System.out.println("result3: "+result3);
		
		int result4 = myCom.sum(new int[] {1,2,3,4,5});
		System.out.println("result4: "+result4);
	}

}
