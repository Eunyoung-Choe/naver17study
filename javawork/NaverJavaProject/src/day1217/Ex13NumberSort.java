package day1217;

public class Ex13NumberSort {

	public static void main(String[] args) {

		int []data = {4,1,5,3,2};
		
		// Selection Sort
		for(int i=0; i<data.length-1; i++)
		{
			for(int j=i+1; j<data.length; j++)
			{
				//내림차순 정렬: data[i]<data[j]
				if(data[i]>data[j]) // 오름차순 정렬
				{
					int temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
		
		for(int i=0; i<data.length; i++)
		{
			System.out.println(i+ ":"+ data[i]);
		}
	}

}
