package day1218;

class Apple
{
	// 접근지정자는 생략 시 default가 되는데, 같은 패키지에서는 private을 제외하고 모두 직접 접근 가능
	static String message = "Hello"; //클래스 멤버 변수
	static final String EMP = "비트캠프"; //상수
	String name = "캔디"; // 인스턴스 멤버 변수(new로 생성해야 인스턴스 변수가 생성됨)
	
}

public class Ex7Object {

	public static void main(String[] args) {
		
		// 다른 클래스 static 변수는 클래스명.변수명 형태로 접근한다.
		System.out.println("메세지:"+Apple.message);
		System.out.println("EMP:"+Apple.EMP);
		
		Apple.message = "Happy Day";
		System.out.println(Apple.message);
		
//		Apple.EMP = "삼성전자"; // final, 즉 상수라 변경하면 오류 
		
		// 다른 클래스의 인스턴스 멤버 변수를 접근하려면 new로 생성된 인스턴스 변수가 있어야 한다.
		Apple a = new Apple();
		System.out.println("이름="+a.name); // 인스턴스 변수는 Apple.name처럼 클래스명으로 절대 가져올 수 없음.
		
		// 값 변경도 가능 
		a.name = "은영";
		System.out.println("a의 이름:"+a.name);
		
		Apple b = new Apple();
		b.name = "영자";
		System.out.println("b의 이름:"+b.name);
	}

}
