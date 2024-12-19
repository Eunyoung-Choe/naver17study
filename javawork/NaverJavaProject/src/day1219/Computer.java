package day1219;

public class Computer{
	
	int sum(int...values)
	{
		int sum = 0;
		
		// values는 배열 타입의 변수처럼 사용
		for(int i=0; i<values.length; i++)
			sum += values[i];
		
		return sum;
	}
}

