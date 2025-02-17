package hywuboard.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.connect.MysqlConnect;
import memo.data.MemoDto;

public class HywuDao {
	MysqlConnect db=new MysqlConnect();
	
	public void insertMemo(MemoDto dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="insert into ajaxmemo (nickname,avata,message,writeday) values (?,?,?,now())";
		
		conn=db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getNickName());
			pstmt.setString(2, dto.getAvata());
			pstmt.setString(3, dto.getMessage());
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
}
