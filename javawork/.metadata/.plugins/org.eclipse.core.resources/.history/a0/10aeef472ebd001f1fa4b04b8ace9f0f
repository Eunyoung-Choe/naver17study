package day1218;

class Orange
{
	public static final String MESSAGE = "Happy"; // 상수는 모두 대문자로 작성
	
	private String name;
	private int age;
	
	public void showData()
	{
		// 일반 멤버 메서드는 this라는 인스턴스 변수를 가지고 있다.
		// static 멤버 메서드에는 this가 없음.
		// 그래서 this.name 이런 식으로 접근 가능 (this는 경우에 따라 생략 가능)
		System.out.println("이름"+this.name+", 나이"+this.age); // this 생략 가능 
	}
	
	
	// 값을 변경하기 위한 setter method를 만들어 보자.
	public void setName(String name)
	{
		// 이 경우에선 파라미터도 name이기 때문에 혼동되지 않으려면 this 꼭 필요
		// 같은 구역에 멤버와 같은 이름의 변수가 있을 경우, 멤버 변수 앞에 반드시 this를 붙인다.
		this.name = name;
		
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
}

public class Ex8Object {

	public static void main(String[] args) {

		System.out.println(Orange.MESSAGE);
		
		Orange orange = new Orange();
//		System.out.println(orange.name); //오류: private 변수는 직접 접근 불가 
		
		orange.showData();
		System.out.println("값 변경");
		orange.setName("김태희");
		orange.setAge(35);
		
		orange.showData();
	}

}
