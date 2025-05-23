package day1224;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Ex10ListVector {

	public static void main(String[] args) {

		List<String> list1 = new Vector<String>(); // 기본 10개 할당
		List<String> list2 = new Vector<String>(5); // 기본 5개 할당
		
		// capacity() 메서드는 오버라이드 메서드가 X
		System.out.println("list1의 데이터 개수: " + list1.size() +
			    " 할당개수: " + ((Vector<String>) list1).capacity());

			System.out.println("list2의 데이터 개수: " + list2.size() +
			    " 할당개수: " + ((Vector<String>) list2).capacity());
		
		
		list2.add("일");
		list2.add("이");
		list2.add("삼");
		list2.add("사");
		list2.add("오");
		list2.add("육");
		list2.add("칠");
		
		System.out.println("list2의 데이터 개수"+list2.size()+", 할당 개수:"
				+((Vector<String>)list2).capacity()); // capacity() 메서드는 오버라이드 메서드 X
		
		System.out.println("출력 방법 1");
		for(String s:list2)
			System.out.println(s+"  ");
		System.out.println();
		
		System.out.println("출력 방법 2");
		for(int i=0; i<list2.size(); i++)
			System.out.println(i+1+":"+list2.get(i)+"  ");
		System.out.println();
		
		System.out.println("출력 방법 3");
		Iterator<String> iter = list2.iterator();
		
		while(iter.hasNext())
			System.out.println(iter.next()+"  ");
		System.out.println();
		
		System.out.println("출력 방법 4");
		Object []ob = list2.toArray();
		for(Object s:ob)
			System.out.println(s+"  ");
	}

	
}
