package day1217;

public class Ex15ArrayRandom {

	public static void main(String[] args) {

		int []numbers = new int[20];
		/*
		 * 배열에 1~50 사이의 난수 20개를 구하여 넣고
		 * 오름차순으로 정렬하여 출력 하시오.
		 */
		
		for(int i=0; i<numbers.length; i++)
		{
			// isSame이 true 아닐 때까지 반복
			while(true)
			{
				boolean isSame = false;
				
				// 1 더한 이유: Math.random() 범위가 0.0이상 1 미만이라 출력 범위를 0~50으로 만들기 위함임.
				numbers[i] = (int)(Math.random()*50)+1;
				
				
				// 이전에 발생한 값과 같을 경우 다시 구하기 (중복처리 로직)
				for(int j=0; j<i; j++)
				{
					
					// 중복이면 다시 while로 돌아가 난수 생성
					if(numbers[i]==numbers[j])
					{
						isSame = true;
						break;
					}
				}
				
				// 이 if문을 위 for문 내에 적었더니 무한루프 걸렸음.
				if(!isSame)
					break; // 중복 없으면 종료
					
			}			
		}
		
		// 정렬
		for(int i=0; i<numbers.length-1; i++)
		{
			for(int j=i+1; j<numbers.length; j++)
			{
				if(numbers[i]>numbers[j])
				{
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
		
		// 출력 (한 줄에 5개씩만)
		for(int i=0; i<numbers.length; i++)
		{
			System.out.print(i+":"+numbers[i]+"\t");
			if((i+1)%5==0)
				System.out.println();
		}
	}

}
