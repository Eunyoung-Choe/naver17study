package day1220;

import day1220_2.DbServerSystem;

class DataProcess extends DbServerSystem
{
	private String sql;
	
	public DataProcess() {
		sql = "select";
//		this.dbServerName = "MySQL"; //protected인 경우 직접 접근 가능(상속관계인 경우에만)
//		this.serverPort = 9000; // 오류 (default멤버 변수는 상속관계여도 접근 불가)
	}
	
	public DataProcess(String dbServerName, int serverPort, String sql)
	{
		super(dbServerName, serverPort);
		this.sql = sql;
	}
	
	public void process()
	{
		// 서브클래스애 오버라이드 메서드가 없는 경우 this로 호출해도 상속받은 메서드가 호출된다.
		// 이런 경우 this로 호출해도 되고 super로 호출해도 된다.
		// 하지만 오버라이드 메서드가 있는 경우 부모메서드 호출 시 반드시 super로 호출
		this.serverStart(); //super.serverStart()도 출력 동일함.
		System.out.println("SQL문 "+sql+"처리함");
		this.serverClose();
		System.out.println();
	}
}
public class Ex3Inheri {

	public static void main(String[] args) {

		DataProcess data1 = new DataProcess();
		data1.process();
		
		DataProcess data2 = new DataProcess("MariaDB", 3000, "insert");
		data2.process();
	}

}
