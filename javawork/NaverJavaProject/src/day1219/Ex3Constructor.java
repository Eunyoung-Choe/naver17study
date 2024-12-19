package day1219;

/*
 * <생성자>
 * 1. 객체 생성시 자동 호출(new)
 * 2. return 타입이 없다. (형식→ [접근지정자] 클래스명)
 * 3. 오버로딩(Overloading:파라미터만 다른 중복함수)이 가능함.
 * 4. 생성자에서는 주로 멤버 변수 초기화를 담당함.
 */

class Apple
{
	// 생성자 생성 
	Apple() // void Apple 이렇게 쓰면 일반 메서드로 인식하게 됨.
	{
		System.out.println("디폴트 생성자");
	}
	
	Apple(String name)
	{
		System.out.println(name+"을 인자로 받음.");
	}
	
	Apple(int age)
	{
		System.out.println(age+"를 인자로 받음.");
	}
	
	Apple(String name, int age)
	{
		System.out.println(name+"과"+age+"를 인자로 받음.");
	}
}

public class Ex3Constructor {

	public static void main(String[] args) {

		Apple a1 = new Apple(); // 생성자 자동 호출(new)
		Apple a2 = new Apple("최 씨");
		Apple a3 = new Apple(22);
		Apple a4 = new Apple("빨강", 23);
	}

}
