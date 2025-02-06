package shop.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;

public class ShopRepleDao {
	MysqlConnect db = new MysqlConnect();
	
	public void insertReple(ShopRepleDto dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="insert into shopreple values (null,?,?,?,now())";
		conn=db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1, dto.getNum());
			pstmt.setInt(2, dto.getStar());
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
	
	public void deleteReple(int idx)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "delete from shopreple where idx=?";
		
		conn=db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1, idx);
			pstmt.execute();
			
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public List<ShopRepleDto> getRepleByNum(int num)
	{
		List<ShopRepleDto> list = new Vector<ShopRepleDto>();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql = "select * from shopreple where num=? order by idx desc";
		
		conn=db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1, num);
			//실행
			rs = pstmt.executeQuery();
			while(rs.next()) 
			{
				ShopRepleDto dto = new ShopRepleDto();
				dto.setIdx(rs.getInt("idx"));
				dto.setNum(rs.getInt("num"));
				dto.setStar(rs.getInt("star"));
				dto.setMessage(rs.getString("message"));
				dto.setWriteday(rs.getTimestamp("writeday")); // 이거 자꾸 오류났던 이유가 Dto에서 TimeStamp 라이브러리를 sql말고 security로 넣었어서임.
				
				list.add(dto); // 이 줄 없으면 데이터 안 넘어감.
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
		return list;
	}
}
