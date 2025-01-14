package day1220;

interface InterB
{
	int SPEED = 100; // final 상수
	public void speedWrite();
	public void speedUp(int speed);
	public void speedDown(int speed);
	
}

class Car implements InterB
{

	int curSpeed = SPEED; // 초기값 100이 대입 
	
	@Override
	public void speedWrite() {
		// TODO Auto-generated method stub
		System.out.println("현재 스피드는 "+ curSpeed);
	}

	@Override
	public void speedUp(int speed) {
		// TODO Auto-generated method stub
//		SPEED += speed; // 이건 상수라서 오류
		
	}

	@Override
	public void speedDown(int speed) {
		// TODO Auto-generated method stub
		System.out.println("스피드를 "+speed+" 내립니다.");
		curSpeed -= speed; // SPEED는 안 되고 이건 됨?
	}
	
}

public class Ex10Interface {

	public static void main(String[] args) {

		InterB inter = new Car();
		inter.speedWrite();
		
		inter.speedUp(30);
		inter.speedWrite();
		inter.speedDown(50);
		inter.speedWrite();
	}

}
