package day1220;

class SuperObj2
{
	private String schoolName;
	
	public SuperObj2() {
		schoolName = "한양여자대학교";
	}
	
	SuperObj2(String schoolName)
	{
		this.schoolName = schoolName;
	}
	
	public void write()
	{
		System.out.println("학교명:"+schoolName);
	}
}


class SubObj2 extends SuperObj2
{
	private String studentName;
	
	public SubObj2() {
		studentName = "최은영";
	}
	
	SubObj2(String schoolName, String studentName)
	{
		super(schoolName);
		this.studentName = studentName;
	}
	
	@Override // 부모 메서드 재정의 
	public void write() {

		super.write(); // 부모가 처리한 로직 실행 (호출하는 위치는 상관없음)
		System.out.println("학생 이름:"+studentName);
	}
}

class SubObj22 extends SuperObj2
{
	private String teacherName;
	
//	public SubObj22(String teacherName) {
//		teacherName = "선생님";
//	} 내가 잘못 쓴 답안 ㅎ
	
	public SubObj22() {
		teacherName = "이름없음";
	}
	
	SubObj22(String schoolName, String teacherName)
	{
		super(schoolName);
		this.teacherName = teacherName;
	}
	
	@Override
	public void write() {
		System.out.println("선생님 이름:"+teacherName);
		super.write();
	}
}
/*==============================================*/
public class Ex2Inheri {

	public static void main(String[] args) {

		SubObj2 s1 = new SubObj2();
		SubObj2 s2 = new SubObj2("강남고등학교", "노진구");
		
		s1.write();
		s2.write();
		
		SubObj22 s3 = new SubObj22();
		s3.write();
		
		SubObj22 s4 = new SubObj22("집가고싶다학교", "나");
		System.out.println();
		s4.write();
	}

}
