package day1224;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ex8Map {

	public static void main(String[] args) {

		// Map 타입은 key와 value의 쌍으로 데이터를 추가한다.
		// 이때 key값은 Set 타입이다. (즉, 중복허용X, 비순차적)
		Map<String, String> map = new HashMap<String, String>();
		
		// map에 데이터 추가
		map.put("name", "최은영");
		map.put("age", "22");
		map.put("blood", "B");
		map.put("name", "덮어쓰기 확인용"); // 중복이 안 되는 거지, 값이 안 들어가는 건 아님.
		
		System.out.println("map의 사이즈 : "+map.size());
		System.out.println("map에서 key값으로 value 값 꺼내기");
		System.out.println("이름 : "+map.get("name"));
		System.out.println("나이 : "+map.get("age"));
		System.out.println("혈액형 : "+map.get("blood"));
		System.out.println("핸드폰 : "+map.get("hp")); // 없을 경우 null 반환 
		System.out.println();
		System.out.println("key 값들을 자동으로 얻은 후 value 값들 얻기");
		
		Set<String> keySets = map.keySet();
		for(String key:keySets)
		{
			String v = map.get(key);
			System.out.println(key+"=>"+v);
		}
		
		
	}

}
