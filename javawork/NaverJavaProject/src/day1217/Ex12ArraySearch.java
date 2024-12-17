package day1217;

import java.util.Scanner;

public class Ex12ArraySearch {

	public static void main(String[] args) {

		String []member = {"강호동", "김태희", "손미나", "이지혜", "카리나", "윈터", "닝닝", "지젤", "아이유", "김태리"};
		String searchName;
		Scanner sc = new Scanner(System.in);
		
		/*
		 * 검색할 성씨는? 이
		 * 		이지혜
		 * 		총 1명 검색
		 * 
		 * 검색할 성씨는? 강
		 * 		강호동
		 * 		강리나
		 * 
		 * 검색할 성씨는? 홍
		 * 	"홍"씨성을 가진 멤버는 없습니다.
		 * 
		 * -> 대소문자 상관없이 exit 입력시 종료
		 */
		
		while(true)
		{
			int count = 0;
			System.out.println("검색할 성씨는?");
			searchName = sc.nextLine(); //한 글자 입력하는 거 뭐였더라.
			
//			내가 쓴 조건..ㅋㅋ
//			if(searchName.equals("exit") && searchName.equals("EXIT"))
//			{
//				System.out.println("종료");
//				break;
//			}
			
			// 종료
			if(searchName.equalsIgnoreCase("exit")) //대소문자를 구분하지 않고 두 문자열의 내용을 비교
			{
				System.out.println("프로그램 종료");
				break;
			}
			
			// 특정 단어로 시작하는지 확인 -> startsWith
			for(int i=0; i<member.length; i++)
			{
				if(member[i].startsWith(searchName))
				{
					count++;
					System.out.println(i+":"+member[i]);
				}
				
			}
			// 출력
			if(count==0)
				System.out.println("\""+searchName+"\"씨 성을 가진 사람은 없습니다.");
			else
				System.out.println("총 "+count+"명 검색");
			
		}
	}

}
