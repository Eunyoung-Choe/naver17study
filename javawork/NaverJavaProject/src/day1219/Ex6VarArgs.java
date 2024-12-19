package day1219;

public class Ex6VarArgs {

	public static void writeColor(String color1)
	{
		System.out.println("color1="+color1);
	}
	
	public static void writeColor(String color1, String color2)
	{
		System.out.println("color1="+color1+", color2="+color2);
	}
	
	public static void writeColor(String color1, String color2, String color3)
	{
		System.out.println("color1="+color1+", color2="+color2+", color3="+color3);
	}
	
	// 인자가 몇 개 들어오는지 모르겠지만 타입은 같을 때 
	public static void writeName(String...name) //...은 배열 타입으로 전달받음.
	{
		System.out.println("name의 length:"+name.length);
		if(name.length==0)
			System.out.println("멤버가 없습니다.");
		else
			System.out.println("<멤버 목록>");
		
		for(String n:name)
			System.out.println("\t"+n);
		System.out.println("=".repeat(20));
	}
	
	
	///////////////////////////////////////////
	public static void main(String[] args) {
		
		writeColor("red");
		writeColor("yellow", "green");
		writeColor("white", "orange", "black");
		
		System.out.println("Variable Arguments 기능으로 인자로 여러 문자열 보내기");
		writeName("도라에몽");
		writeName("노진구", "이슬이");
		writeName("비실이", "퉁퉁이", "영민이");
		writeName();
	}

}
