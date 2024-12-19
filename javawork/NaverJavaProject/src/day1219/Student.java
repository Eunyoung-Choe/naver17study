package day1219;

import java.util.Calendar;

public class Student {
	
	private String stuName;
	private String stuAddress;
	private String stuBlood;
	private int stuBirthYear;
	private int stuScore;
	
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) { //Generate툴로 getter, setter 만들어주면 매개변수 이름 똑같이 들어가서
		this.stuName = stuName; // 여기에 this가 꼭 필요함.
	}
	public String getStuAddress() {
		return stuAddress;
	}
	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}

	
	// stuBlood에 대한 setter & getter
	public void setStuBlood(String stuBlood) {
		this.stuBlood = stuBlood;
	}
	public String getStuBlood() {
		return stuBlood;
	}
	
	
	// stuBirthYear에 대한 setter & getter
	public int getStuBirthYear() {
		return stuBirthYear;
	}
	public void setStuBirthYear(int stuBirthYear) {
		this.stuBirthYear = stuBirthYear;
	}
	
	
	// stuScore에 대한 setter & getter 
	public int getStuScore() {
		return stuScore;
	}
	public void setStuScore(int stuScore) {
		this.stuScore = stuScore;
	}
	
	
	// 한꺼번에 변경할 경우
	public void changeStudent(String stuName, String stuAddress, String stuBlood)
	{
		this.setStuName(stuName);
		this.setStuAddress(stuAddress);
		this.setStuBlood(stuBlood);
	}
	
	// stuScore에 대한 절대평가 (A~F) 반환하는 메서드
	public char getScoreGrade()
	{
		char grade = switch(stuScore)
				{
		case 10, 9 -> 'A';
		case 8 -> 'B';
		case 7 -> 'C';
		case 6 -> 'D';
		default -> 'F';
				};
		return grade;
	}
	
	//stuBirthYear로 나이 구해서 반환
	public int getAge()
	{
		//현재 연도
		//Calendar를 이용해서 현재 연도를 구하기
		Calendar cal = Calendar.getInstance();
		int curYear = cal.get(Calendar.YEAR);
		
		return curYear-stuBirthYear;
	}
}
