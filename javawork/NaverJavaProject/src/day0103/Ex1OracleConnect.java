package day0103;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex1OracleConnect {
		static final String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
		// DB에 접근하려면 URL과 id, password 필요함.
		String url = "jdbc:oracle:thin:@localhost:1521/xe"; // 오라클 port 
		String username = "angel";
		String password = "pw1234";
		
		public Ex1OracleConnect() {
			try {
				Class.forName(ORACLE_DRIVER);
				System.out.println("오라클 드라이버 성공!");
			} catch (ClassNotFoundException e) {
				System.out.println("오라클 드라이버 실패: "+ e.getMessage());
				e.printStackTrace();
			}
		}
		
		// DB 연결 성공 후 Connection을 반환하는 메서드
		public Connection getConnecton() {
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(url, username, password);
				System.out.println("오라클 접속 성공");
			} catch (SQLException e) {
				System.out.println("오라클 접속 실패: "+e.getMessage());
			}
			
			return conn;
		}

	public void shopWriteData()
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from shop"; // 데이터베이스에서 가져올 데이터를 정의하는 쿼리문
		
		conn = this.getConnecton();
		
		try {
			stmt = conn.createStatement();
            rs = stmt.executeQuery(sql); // select SQL문은 ResultSet이 반환되는 executeQuery만 가능
            
            // 여러 개인 경우 while문으로 rs.next()가 true인 동안만 반복
            System.out.println("상품코드\t상품명\t상품단가");
            System.out.println("=".repeat(25));
            while(rs.next())
            {
            	// 컬럼명으로 가져와도 되고 인덱스로 가져와도 됨. (인덱스는 1부터)
            	// < 컬럼명 >
//            	String code = rs.getString("sangcode"); // getString(ColumnLabel)
//            	String sname = rs.getString("sangname");
//            	int sprice = rs.getInt("sangprice");
            	
            	// < 인덱스 >
            	String code = rs.getString(1);
            	String sname = rs.getString(2);
            	int sprice = rs.getInt(3);
            	
            	System.out.println(code+"\t"+sname+"\t"+sprice);
            }
            
		} catch (SQLException e) {
			System.out.println("sql문 오류: "+e.getMessage());
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
				
			} catch (SQLException | NullPointerException e) { // NullPinterException 필요한 이유?
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	/*=========================================================*/
	public static void main(String[] args) {

		Ex1OracleConnect ex1 = new Ex1OracleConnect();
		ex1.shopWriteData();
	}

}
