package day1220;

import java.util.List;
import java.util.Vector;

public class Ex7Abstract {

	public static void main(String[] args) {

		// 다형성 처리 예
		List<String> list = null;
		list = new Vector<String>(); // 문자만 저장하겠다.
		list.add("Red");
		list.add("Green"); // add라는 메서드는 오버라이드 메서드
		
		for(String s:list)
			System.out.println(s);
		
		// 현재 할당된 크기를 알아보는 capacity()이 메서드는
		// Vector만이 갖고 있다.
		int n = ((Vector<String>)list).capacity();
		System.out.println(n);
	}

}
