package day1219;

import java.util.Scanner;

public class Ex2ObjectArray {
	
	public static void dataInput(Student s)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("학생 이름?");
		String name = sc.nextLine();
		
		System.out.println("학생 주소?");
		String addr = sc.nextLine();
		
		System.out.println("학생 혈액형?");
		String blood = sc.nextLine();
		
		
		s.changeStudent(name, addr, blood);
		System.out.println();
	}

	public static void showTitle()
	{
		System.out.println("이름\t혈액형\t주소");
		System.out.println("=".repeat(35));
	}
	
	public static void writeStudent(Student s)
	{
		System.out.println(s.getStuName()+"\t"+s.getStuBlood().toUpperCase()+"형\t"+s.getStuAddress());
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int inwon;
		Student []stuArray;
		
		System.out.println("입력할 인원 수는?");
		inwon = Integer.parseInt(sc.nextLine());
		
		// 메모리 할당
		stuArray = new Student[inwon];
		
		// 데이터 입력
		for(int i=0; i<stuArray.length; i++)
		{
			stuArray[i] = new Student(); //생성
			dataInput(stuArray[i]); // 객체 타입은 주소가 전달됨.(주소를 통해 데이터가 들어옴)
		}
		
		showTitle(); // 제목 출력
		
		for(int i=0; i<stuArray.length; i++)
			writeStudent(stuArray[i]); //내용 출력
		
		// 주소로 데이터 공유? 객체 참조?
	}

}
