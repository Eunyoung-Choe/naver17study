package day1220;

/*
 * interface는 음식점 메뉴판 역할.
 * 실체가 없이 메뉴 목록만 있기 때문이다.
 * 실제로 주문을 해야 음식이 만들어지는 것처럼 구현을 해야만 기능을 쓸 수 있다.
 * 
 * 인터페이스에는 추상메서드와 상수만이 올 수 있으므로 abstract나 final은 생략한다.
 */
interface InterA{
	public void process();
}

// InterA를 구현하는 클래스
class SubInter implements InterA
{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("Sub 클래스의 process");
	}
}



public class Ex9Interface {

	public static void process(InterA inter)
	{
		inter.process();
	}
	public static void main(String[] args) {

		InterA inter = new SubInter();
		inter.process();
		
		// 메서드 호출
		process(new SubInter());
	}

}
