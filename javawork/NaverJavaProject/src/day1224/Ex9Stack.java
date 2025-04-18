package day1224;

import java.util.Stack;

public class Ex9Stack {

	public static void main(String[] args) {

		// LIFO : Last In First Out
		// push : 데이터 추가, pop : 데이터 삭제 
		Stack<String> stack1 = new Stack<String>();
		
		stack1.push("사과");
		stack1.push("오렌지");
		stack1.push("사과");
		stack1.push("딸기");
		stack1.push("귤");
		stack1.push("키위");
		
		System.out.println("stack의 개수 : "+stack1.size());
		
		while(!stack1.isEmpty()) // Empty가 아닐 동안
		{
			System.out.println(stack1.pop());
		}
	}

}
