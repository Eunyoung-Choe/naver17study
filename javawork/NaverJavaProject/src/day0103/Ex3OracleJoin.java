package day0103;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 어딘가 오류 있음
public class Ex3OracleJoin {

	static final String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe"; // 오라클 port 
	String username = "angel";
	String password = "pw1234";
	
	public Ex3OracleJoin() {
		try {
			Class.forName(ORACLE_DRIVER);
			System.out.println("오라클 드라이버 성공!");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 실패: "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
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
	
	//========================================
	public void joinDataWrite()
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = """
				select
				    s.sangcode, sangname, sangprice, cntnum, to_char(cartday, 'yyyy-mm-dd') cartday
				from shop s, cart c
				where s.sangcode=c.sangcode
				"""; // 이 안에 ;이 있어서 계속 오류 났었음!! 크아아악
		
		conn = this.getConnecton();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
            System.out.println("상품코드\t상품명\t상품가격\t수량\t등록일");
            System.out.println("=".repeat(30));

            while(rs.next())
            {
            	String code = rs.getString("sangcode");
            	String sname = rs.getString("sangname");
            	int sprice = rs.getInt("sangprice");
            	int cntnum = rs.getInt("cntnum");
            	String cday = rs.getString("cartday");
            	
            	System.out.println(code+"\t"+sname+"\t"+sprice+"\t"+cntnum+"\t"+cday);
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
	

	
	/*==========================================================*/
	public static void main(String[] args) {

		Ex3OracleJoin ex3 = new Ex3OracleJoin();
		ex3.joinDataWrite();
	}

}
