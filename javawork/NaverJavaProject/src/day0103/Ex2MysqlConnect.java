package day0103;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex2MysqlConnect {

	static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/study502?serverTimezone=Asia/Seoul"; // study502 주소
	String username = "root";
	String password = "0000";
	
	public Ex2MysqlConnect() {
		try {
			Class.forName(MYSQL_DRIVER); // 실제 클래스 이름으로 반환해주는 역할
			System.out.println("Mysql 드라이버 성공!");
		} catch (ClassNotFoundException e) {
			System.out.println("Mysql 드라이버 실패: "+e.getMessage());
		} 		
	}
	
	public Connection getConnection()
	{
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Mysql 접속 성공");
		} catch (SQLException e) {
			System.out.println("Mysql 접속 실패: "+e.getMessage());
		}
		return conn;
	}
	
	
	public void personWriteData()
	{
		Connection conn = null; // DB연결
		Statement stmt = null; // SQL문을 DB로 보내기 위해 사용
		ResultSet rs = null; // SQL쿼리 실행 결과 처리
		
		// 작성 방법1 (따옴표 때문에 \가 붙음.)
//		String sql = "select name, age, blood, hp, date_format(today, \"%Y-%m-%d %H:%i\") today from person";
		
		// 작성 방법2 (jdk17기능, 멀티 라인 문자열을 쉽게 만들어주는 Text Blocks)
		String sql = """
				select name, age, blood, hp, date_format(today, "%Y-%m-%d %H:%i") today from person
				""";
		
		conn = this.getConnection();
		
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("이름 나이 혈액형 번호 날짜");
			System.out.println("=".repeat(50));
			
			while(rs.next())
			{
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String blood = rs.getString("blood");
				String hp = rs.getString("hp");
				String today = rs.getString("today");
				
				System.out.println(name+"\t"+age+"\t"+blood+"\t"+hp+"\t"+today);
			}
			
		} catch (SQLException e) {
			System.out.println("sql문 오류: "+e.getMessage());
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
				
			} catch (SQLException | NullPointerException e) { // NullPinterException 필요한 이유?
			
				e.printStackTrace();
			}
		}
	}
	
	/*=========================================================*/	
	public static void main(String[] args) {

		Ex2MysqlConnect ex2 = new Ex2MysqlConnect();
		ex2.personWriteData();
	}

}
