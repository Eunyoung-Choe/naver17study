package day1220_2;

public class Apple
{
	public void job()
	{
		System.out.println("아침 식사를 준비합니다.");
	}
	
	protected void study() // protected는 '상속 관계'일 경우에만 접근 가능
	{
		System.out.println("자바 공부를 합니다.");
	}
	
	void draw()
	{
		System.out.println("그림 공부를 합니다.");
	}
	
	protected void process() {
		System.out.println("DB 공부를 합니다.");
	}
	

}
