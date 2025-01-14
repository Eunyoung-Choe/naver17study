package day0103;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// Java 코드로 MySQL 테이블에 데이터 추가하기 
public class Ex5MysqlInsertSelect {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/study502?serverTimezone=Asia/Seoul"; // 추후에 프로젝트 땐 localhost가 클라우드 주소로 들어갈 것
	String username = "root";
	String password = "0000";

	public Ex5MysqlInsertSelect() {
		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Mysql 드라이버 오류: "+e.getMessage());
		}
	}
	


	public void insertPerson(String name, String blood, int age, String hp)
	{
		Connection conn = null;
		Statement stmt = null;
		String sql = "insert into person (name, blood, age, hp, today) values ('" 
	             + name + "','" + blood.toUpperCase() + "'," + age + ",'" + hp + "',now())"; // age만 숫자라서 따옴표 없음.
		System.out.println(sql);
		
		conn = this.getConnection();
		
		try {
			stmt = conn.createStatement();
			
			// insert문 실행
			stmt.execute(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private Connection getConnection() {
	      Connection conn = null;
	      try {
	         conn = DriverManager.getConnection(url, username, password);
	         System.out.println("Mysql 접속 성공");
	      } catch (SQLException e) {
	         System.out.println("Mysql 접속 실패 : " +e.getMessage());
	      }
	      return conn;
	}



	public void writePerson()
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from person order by num";
		
		conn = this.getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("\t\t ** Person Table **");
			System.out.println();
			System.out.println("이름\t나이\t혈액형\t핸드폰\t\t날짜");
			System.out.println("=".repeat(50));
			
			while(rs.next())
			{
				String today = rs.getString("today").substring(0, 10);
				
				System.out.println(rs.getString("name")+"\t"+
									rs.getInt("age")+"\t"+
									rs.getString("blood")+"\t"+
									rs.getString("hp")+"\t"+today);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 이름 검색해서 출력하는 메서드
	public void searchName(String name)
	{
		int count = 0; // 찾은 인원 수를 얻을 변수
		/*
		 * 문제: name이 '영자'인 경우, 영자를 포함하는 모든 데이터 출력
		 * 
		 * Ex)
		 * 1번째
		 * 이름 : 김영자
		 * 혈액형 : B형
		 * 나이 : 23세
		 * 핸드폰 : 010-2222-3333
		 * -----------------------
		 * 2번째
		 * 이름 : 영자순
		 * ...
		 * 
		 * 만약 없을 경우, "영자"를 포함한 회원은 없습니다. 출력
		 */
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select * from person where name like concat('%','"+name+"','%')"; // 방법1
//		String sql = "select * from person where name like '%"+name+"%'"; // 방법2
		
		conn = this.getConnection();
		
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) 
			{
				count++;
				System.out.println(count+"번째");
				System.out.println("이름: "+rs.getString("name"));
//		        if (names.contains("영자")) {
		            System.out.println("혈액형: " + rs.getString("blood"));
		            System.out.println("나이: " + rs.getInt("age"));
		            System.out.println("핸드폰: " + rs.getString("hp"));
		            System.out.println("=".repeat(40));
//		        }// 못 찾았을 때의 처리를 모르겠다.
		        
		    }
			if(count==0) // while문을 다 돌고서도 count가 0이라면
		        	System.out.println("이름에 \""+name+"\"를 포함하고 있는 회원은 없습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	
	
	// 이름 찾아 삭제하는 메서드
	public void deletePerson(String name)
	{
		/*
		 * name이 이영자라면
		 * 이영자가 있을 경우
		 * 		1명의 데이터가 삭제되었습니다.
		 * 
		 * 이영자가 2명일 경우
		 * 		2명의 데이터가 삭제되었습니다.
		 * 
		 * 없을 경우
		 * 		"이영자"님은 존재하지 않습니다.
		 * 
		 * -> int executeUpdate(String sql)
		 * 		: 실행한 sql문의 개수를 반환함.
		 * 		(2명이 삭제된 경우 2 반환)
		 * 		해당 이름이 없어서 삭제를 못했다면 0 반환 
		 */
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "delete from person where name='"+name+"'";
		
		conn = this.getConnection();
		
		 try {
	         stmt = conn.createStatement();
	         int n=stmt.executeUpdate(sql);
	         if(n==0)
	            System.out.println("\""+name+"\" 님은 존재하지 않습니다");
	         else
	            System.out.println(n+"명의 데이터가 삭제되었습니다.");
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            stmt.close();
	            conn.close();
	         } catch (SQLException|NullPointerException e) {
	            e.printStackTrace();
	         }
	      }
	   }
	   
	
	
	/*=======================================================*/
	public static void main(String[] args) {
		Ex5MysqlInsertSelect ex5 = new Ex5MysqlInsertSelect();
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("1.데이터 추가  2.전체 출력  3.이름 검색  4.멤버 삭제  5.종료");
			System.out.println("select menu?");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu)
			{
			case 1:
			{	
				// 중괄호로 묶어주고 쓸 것(경우에 따라 오류남)
				System.out.println("데이터를 추가합니다.");
				System.out.println("이름을 입력하세요.");
				String name = sc.nextLine();
				System.out.println("혈액형을 입력하세요.");
				String blood = sc.nextLine();
				System.out.println("나이를 입력하세요.");
				int age = Integer.parseInt(sc.nextLine());
				System.out.println("핸드폰을 입력하세요.");
				String hp = sc.nextLine();
				
				ex5.insertPerson(name, blood, age, hp);
				break;
			}
			case 2:
			
				ex5.writePerson();
				break;
			case 3:
			{
				System.out.println("검색할 이름을 입력하세요.");
				String name = sc.nextLine();
				
				ex5.searchName(name);
				break;
			}
			case 4:
			{
				System.out.println("삭제할 회원의 이름을 입력하세요.");
				String name = sc.nextLine();
				
				ex5.deletePerson(name);
				break;
			}
			default:
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
			
			System.out.println("==================");
			}
		}
	}
	
	

}
