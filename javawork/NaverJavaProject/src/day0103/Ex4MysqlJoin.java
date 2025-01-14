package day0103;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex4MysqlJoin {
   static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
   String url = "jdbc:mysql://localhost:3306/study502?serverTimezone=Asia/Seoul"; // 추후에 프로젝트 땐 localhost가 클라우드 주소로 들어갈 것
   String username = "root";
   String password = "0000"; // 비번 잘못 입력해서 오류났음ㅎ
   
   public Ex4MysqlJoin() {
      try {
         Class.forName(MYSQL_DRIVER);
         System.out.println("Mysql 드라이버 성공!");
      } catch (ClassNotFoundException e) {
         System.out.println("Mysql 드라이버 실패 : "+e.getMessage());
      }
   }
   
   public Connection getConnection() {
      Connection conn = null;
      try {
         conn = DriverManager.getConnection(url, username, password);
         System.out.println("Mysql 접속 성공");
      } catch (SQLException e) {
         System.out.println("Mysql 접속 실패 : " +e.getMessage());
      }
      return conn;
   }

   public void joinPersonTable() {
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;
      
      String sql = """
            select name, blood, age, hp, kor, eng, sum
            from person p inner join stu s on p.num=s.num
            """;
      
      //db 연결
      conn = this.getConnection();
      try {
         stmt=conn.createStatement();
         rs = stmt.executeQuery(sql);
         
         System.out.println("이름\t혈액형\t나이\t핸드폰\t국어\t영어\t총점");
         System.out.println("=".repeat(60));
         
         while(rs.next())
         {
        	 String name = rs.getString("name");
        	 String blood = rs.getString("blood");
        	 int age = rs.getInt("age");
        	 String hp = rs.getString("hp");
        	 int kor = rs.getInt("kor");
        	 int eng = rs.getInt("eng");
        	 int sum = rs.getInt("sum");
        	 
        	 System.out.println(name+"\t"+blood+"\t"+age+"\t"+hp+"\t"+kor+"\t"+eng+"\t"+sum);
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         try {
            rs.close();
            stmt.close();
            conn.close();
         } catch (SQLException|NullPointerException e) {
            e.printStackTrace();
         }
      }
      
   }
   
   
	public void personBloodGroup()
	{
		// 혈액형 별 인원 수와 나이평균 구하기
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
	      
		String sql = """
				select blood, count(*) count, round(avg(age),1) avgage from person
				group by blood order by count;
				""";
		
		conn = this.getConnection();
		
		try {
			stmt=conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				String blood = rs.getString("blood");
				int count = rs.getInt("count");
				int avgage = rs.getInt("avgage");
				
				System.out.println(blood+"\t"+count+"\t"+avgage);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	         try {
	             rs.close();
	             stmt.close();
	             conn.close();
	          } catch (SQLException|NullPointerException e) {
	             e.printStackTrace();
	          }
	       }
	}
	
   
   public static void main(String[] args) {

	   Ex4MysqlJoin ex4 = new Ex4MysqlJoin();
	   ex4.joinPersonTable();
   }

}
