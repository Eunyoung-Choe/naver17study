package day1217;

import java.util.Scanner;

public class Ex11ArraySearch {

	public static void main(String[] args) {

		String []member = {"강호동", "김태희", "손미나", "이지혜", "카리나", "윈터", "닝닝", "지젤", "아이유", "김태리"};
		String searchName;
		boolean find;
		Scanner sc = new Scanner(System.in);
		
		/*
		 * 이름을 입력하면 몇 번째에 있는지 출력
		 * 없으면 '해당 이름은 없습니다.' 출력
		 * 반복적으로 검색하다 종료하고 싶으면 "종료"
		 */
		
		while(true)
		{
			find = false;
			System.out.println("찾으려는 이름을 입력하세요.");
			searchName = sc.nextLine(); //문자형 입력받기
			
					
			if(searchName.equals("종료")) { //문자형끼리의 비교는 ==이 안 됨!
				System.out.println("프로그램 종료!");
				break;
			}
			
			for(int i=0; i<member.length; i++)
			{
				if (searchName.equals(member[i]))
				{
					find=true;
					System.out.println((i+1)+"번째에 있습니다.\n");
					
				}
			}
			if(!find)
				System.out.println("해당 이름은 없습니다.");

		}
	}
}
