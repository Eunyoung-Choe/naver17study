package day1218;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FormatExam {

	public static void main(String[] args) {

		Date date = new Date();
		System.out.println(date);
		
		// 내가 원하는 format 양식으로 출력해보자.
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm"); // M:월, m:분, H:24시간, h:12시간
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm EEE");
		SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		System.out.println(sdf1.format(date));
		System.out.println(sdf2.format(date));
		System.out.println(sdf3.format(date));
		System.out.println(sdf4.format(date));

		
		int num1 = 45678900;
		int num2 = 34567;
		
		NumberFormat nf1 = NumberFormat.getInstance(Locale.ENGLISH); // 원래 화폐 단위 있는데 글씨체 때문에 출력 안 보임.
		System.out.println("num1="+nf1.format(num1)); // 숫자에 ,삽입
		System.out.println("num2="+nf1.format(num2));
		
		NumberFormat nf2 = NumberFormat.getCurrencyInstance();
		System.out.println("num1="+nf2.format(num1)); 
		System.out.println("num2="+nf2.format(num2));
	}

}
