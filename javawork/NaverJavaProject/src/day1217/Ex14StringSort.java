package day1217;

public class Ex14StringSort {

	public static void main(String[] args) {

		String []names = {"박남정", "공효진", "김미나", "이진", "손석구", "Adams"}; // 영어가 무조건 우선 순위.
		
		// 이름 오름차순 출력하기
		for(int i=0; i<names.length; i++)
		{
			for(int j=i+1; j<names.length; j++)
			{
				// names[i]가 names[j] 보다 클 경우 양수값, 작을 경우 음수값
				if(names[i].compareTo(names[j])>0)
				{
					String temp = names[i];
					names[i] = names[j];
					names[j] = temp;
				}
			}
		}
		
		for(int i=0; i<names.length; i++)
		{
			System.out.println(i+":"+names[i]);
		}
	}

}
