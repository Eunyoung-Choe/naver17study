package day1224;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex6Set {

	public static void main(String[] args) {

		Set<String> set1 = new HashSet<String>();
		Set<String> set2 = new TreeSet<String>();
		
		set1.add("최은영");
		set1.add("노진구");
		set1.add("도라에몽");
		set1.add("퉁퉁이");
		
		set2.add("카리나");
		set2.add("윈터");
		set2.add("닝닝");
		set2.add("지젤");
		
		System.out.println("set1의 개수 : "+set1.size());
		System.out.println("set2의 개수 : "+set2.size());
		
		System.out.println("HashSet으로 출력");
		for(String s:set1)
			System.out.println(s+"  ");
		System.out.println();
		
		System.out.println("TreeSet으로 출력");
		for(String s:set2)
			System.out.println(s+"  ");
		System.out.println();
		
		Iterator<String> iter = set2.iterator();
		// 데이터를 출력하는 다른 방법 
		while(iter.hasNext())
			System.out.println(iter.next());
		System.out.println();
	}

}
