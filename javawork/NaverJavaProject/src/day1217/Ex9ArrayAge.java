package day1217;

public class Ex9ArrayAge {

	public static void main(String[] args) {

		int []datas = {12, 34, 54, 33, 41, 44, 27, 21};
		System.out.println("인원 수: "+datas.length);
		/*
		 * 위의 데이터를 분석하여 10대부터 40대까지의 각각의 인원 수를 구하시오.
		 * 배열 변수 []age를 이용하여 구하시오.
		 * 
		 * <출력 양식>
		 * 10대 : 1명
		 * 20대 : 3명
		 * ...
		 */
		
		int []age = new int[5];
		
		for(int i=0; i<datas.length; i++)
		{
			//연령별 인원 수 구하기
			//10대일 경우 0번지 증가, 20대일 경우 1번지 증가...
			age[datas[i]/10-1]++; //정수끼리의 계산이므로 무조건 정수 결과 나옴.
		}
		
		for(int i=0; i<age.length; i++)
		{
			System.out.println((i+1)*10+"대:"+age[i]+"명");
		}
	}

}
