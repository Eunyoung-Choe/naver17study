package day1226;

public class Student {
	private String name;
	private int kor;
	private int eng;
	private int sum;
	private double avg;
	
	public Student() {
		
	}

//	public Student(String name, int kor, int eng, int sum, double avg) {
//		super();
//		this.name = name;
//		this.kor = kor;
//		this.eng = eng;
//		this.sum = sum;
//		this.avg = avg;
//	}
	
	public Student(String name, int kor, int eng) {
	      super();
	      this.name = name;
	      this.kor = kor;
	      this.eng = eng;
	   }

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}
	
	
}
