package day1220;
// 추상 클래스는 객체 생성을 할 수 없다.
// 자식 클래스로 하여금 반드시 구현하게 하 목적으로 추상 메서드를 만든다.
//만약 자식클래서가 추상메서드를 오버라이드 안 했ㅇ르 경우, 그 콜렉션도 추상화시켜야 한다.

abstract class Parent2
{
	// 부모가 process에서 하는 일이 없을 경우
	// 그렇다고 안 만들면 자식클래스에서 오버라이드 불가능해짐.
	// 이럴 경우 미완성으로만 선언하는데, 그게 abstract 메서드.
	abstract public void process(); // 추상메서드는 일반 클래스에 멤버로 올 수 없음.
	
	// 추상클래스는 추상 메서드 뿐만 아니라 일반 메서드도 구현 가능하다.
	public void study() { // 부모만이 가진 메서드 
		System.out.println("자바 공부를 한다.");
	}
	
}

class Your1 extends Parent2
{
	@Override
	public void process() {
		System.out.println("벽지 공사를 합니다.");
	}
	
	// Your1이 가진 메서드 
	public void draw()
	{
		System.out.println("그림을 그린다.");
	}
}

class Your2 extends Parent2
{
	@Override
	public void process() {
		System.out.println("타일 공사를 합니다.");
	}
}


public class Ex6Abstract {
	
	public static void yourProcess(Parent2 p)
	{
		p.process();
		p.study(); // 부모가 가진 메서드는 호출 가능
		
//		p.draw(); 오류 발생 -> 다운캐스팅으로 호출 가능
		((Your1)p).draw(); // 하지만 지금 경우는 Your2가 들어올 수도 있음.
	}

	public static void main(String[] args) {

		yourProcess(new Your1());
		System.out.println("=".repeat(30));
		//yourProcess(new Your2());
		
		//yourProcess(new Parent2());//오류:추상클래스는 new 로 생성할수 없다
	}

}
