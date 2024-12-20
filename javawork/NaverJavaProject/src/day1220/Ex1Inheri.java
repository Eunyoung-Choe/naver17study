package day1220;

class SuperObj1
{
	SuperObj1()
	{
		System.out.println("super 생성자");
	}
	
	SuperObj1(String msg)
	{
		System.out.println("super 메세지 받는 생성자:"+msg);
	}
}


class SubObj1 extends SuperObj1
{
	SubObj1()
	{
		// 첫 줄에 super()가 생략되어있다 -> 직접 쓸 경우 무조건 첫 줄에!
		// 안 쓰여있으면 부모의 default 생성자라는 것.
		System.out.println("sub의 첫 생성자"); // 상속 클래스가 아니라면 이것만 출력
	}
	
	SubObj1(String msg)
	{
		super(msg); // 부모한테 보내는 용도 → 생략하면 부모의 디폴트 생성자가 호출됨. 
		System.out.println("sub의 두 번째 생성자");
	}
}
/*===============================================*/

public class Ex1Inheri {

	public static void main(String[] args) {

		SubObj1 sub1 = new SubObj1();
		SubObj1 sub2 = new SubObj1("Hello");
	}

}
