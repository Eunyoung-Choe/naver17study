package db.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlConnect {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/study502?serverTimezone=Asia/Seoul"; // 추후에 프로젝트 땐 localhost가 클라우드 주소로 들어갈 것
	String username = "root";
	String password = "0000";
	
	public MysqlConnect() {
		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("mysql driver 실패:"+e.getMessage());
		}
	}
	
	public Connection getConnection()
	{
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("mysql 연결 실패:"+e.getMessage());
		}
		return conn;
	} 
	
	public void dbClose(PreparedStatement pstmt, Connection conn)
	{	
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn)
	{	
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
