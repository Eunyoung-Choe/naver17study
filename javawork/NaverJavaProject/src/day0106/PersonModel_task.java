package day0106;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;

public class PersonModel_task {

   MysqlConnect connect = new MysqlConnect();

	
	// insert()
	public void insertShop(ShopDto dto) {
      Connection conn = connect.getConnection();
      PreparedStatement pstmt = null;
      String sql  ="insert into person(num,name,blood,age,today,hp) values (?,?,?,now())";
      
      try {
         pstmt = conn.prepareStatement(sql);
         
         //바인딩
         pstmt.setString();
         pstmt.setInt();
         pstmt.setInt();
         
         //실행
         pstmt.execute();
         
      }catch(SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {
         connect.dbClose(pstmt, conn);
      }
   }
	
	
	

        

}
