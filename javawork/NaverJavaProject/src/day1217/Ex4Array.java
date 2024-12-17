package day1217;

public class Ex4Array {

	public static void main(String[] args) {

		String []str1;
		str1 = new String[4]; // 객체인 경우 null값으로 초기값 지정됨.
		str1[0] = "Hello";
		str1[3] = "Kitty";
		
		for(int i=0; i<str1.length; i++)
			System.out.println("str1["+ i +"]="+ str1[i]);
		
		//=================================
		System.out.println("=".repeat(30));
		
		String []str2;
		str2 = new String[] {"초록", "분홍", "빨강", "노랑"};
		for(String s:str2)
			System.out.println(s);
		
		System.out.println("=".repeat(30));
		
		String []str3 = {"김", "최", "홍", "강"};
		for(String s:str3)
			System.out.println(s);
	}

}
