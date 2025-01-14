package day1220;

import day1220_2.Apple;

class Orange extends Apple
{
	public void play()
	{
		this.job();
		this.study();
//		this.draw(); 오류 (패키지가 달라 상속관계여도 접근 불가)
		this.process(); // 현재 클래스의 오버라이드 메서드가 호출됨.
	}
	
	@Override
	// protected void process() { // 더 넓은 범위로 허용
	// default, private은 오류
	public void process() {
		super.process();
		System.out.println("Oracle, MySQL 공부를 더 깊게 합니다.");
	}
	
	
}
/*=================================================*/
public class Ex4Inheri {

	public static void main(String[] args) {

		Orange or = new Orange();
		or.play();
	}

}
