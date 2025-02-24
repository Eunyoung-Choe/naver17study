package hywuboard.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;
import memo.data.MemoDto;


public class HywuDao {
	MysqlConnect db=new MysqlConnect();
	
	// 데이터 삽입 ============================================================
	public void insertMemo(HywuDto dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="insert into hywuboard (nickname,avata,message,writeday) values (?,?,?,now())";
		
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
	
	// 데이터 삭제 =========================================================
	public void deleteMemo(int idx)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="delete from hywuboard where idx=?";
		
		conn=db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1, idx);
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}

	// 데이터 수정 =========================================================
	public void updateMemo(HywuDto dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="update hywuboard set nickname=?,avata=?,message=? where idx=?";
		
		conn=db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getNickName());
			pstmt.setString(2, dto.getAvata());
			pstmt.setString(3, dto.getMessage());
			pstmt.setInt(4, dto.getIdx());
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	
	// 모든 데이터 호출 =====================================================
	public List<HywuDto> getAllMemos()
	{
		List<HywuDto> list=new Vector<HywuDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from hywuboard order by idx desc";
		
		conn=db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				HywuDto dto=new HywuDto();
				dto.setIdx(rs.getInt("idx"));
				dto.setAvata(rs.getString("avata"));
				dto.setNickName(rs.getString("nickname"));
				dto.setMessage(rs.getString("message"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}		
		
		return list;
	}
	
	// 데이터 검색 (특정 닉네임 포함) ============================================
	public List<HywuDto> getSearchMemos(String nickname)
	{
		List<HywuDto> list=new Vector<HywuDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from hywuboard  where nickname like ? order by idx desc";
		
		conn=db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, "%"+nickname+"%");
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				HywuDto dto=new HywuDto();
				dto.setIdx(rs.getInt("idx"));
				dto.setAvata(rs.getString("avata"));
				dto.setNickName(rs.getString("nickname"));
				dto.setMessage(rs.getString("message"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}		
		
		return list;
	}
	
	// 데이터 검색 (특정 id 포함) ============================================
	public HywuDto getOneMemo(int idx)
	{
		HywuDto dto=new HywuDto();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from hywuboard  where idx=?";
		
		conn=db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1,idx);
			rs=pstmt.executeQuery();
			if(rs.next())
			{				
				dto.setIdx(rs.getInt("idx"));
				dto.setAvata(rs.getString("avata"));
				dto.setNickName(rs.getString("nickname"));
				dto.setMessage(rs.getString("message"));
				dto.setWriteday(rs.getTimestamp("writeday"));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}		
		
		return dto;
	}
	
	
	// 페이징 추가 ===========================================================
	public List<HywuDto> getMemosByPage(int page, int pageSize) {
	    List<HywuDto> list = new ArrayList<>();
	    
	    int offset = (page - 1) * pageSize;  // 현재 페이지에 맞는 오프셋 계산

	    String sql = "SELECT * FROM hywuboard ORDER BY idx DESC LIMIT ? OFFSET ?";
	    
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    conn = db.getNaverCloudConnection();
	    try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, pageSize);  // 페이지 크기 설정
	        pstmt.setInt(2, offset);    // 오프셋 설정
	        
	        rs = pstmt.executeQuery();
	        while (rs.next()) {
	            HywuDto dto = new HywuDto();
	            dto.setIdx(rs.getInt("idx"));
	            dto.setAvata(rs.getString("avata"));
	            dto.setNickName(rs.getString("nickname"));
	            dto.setMessage(rs.getString("message"));
	            dto.setWriteday(rs.getTimestamp("writeday"));
	            list.add(dto);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        db.dbClose(rs, pstmt, conn);
	    }
	    
	    return list;
	}

	// 페이징 - 전체 게시글 개수 세는 메서드 
	public int getMemoCount() {
	    int count = 0;
	    String sql = "SELECT COUNT(*) FROM hywuboard";
	    
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    conn = db.getNaverCloudConnection();
	    try {
	        pstmt = conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	        if (rs.next()) {
	            count = rs.getInt(1);  // 첫 번째 컬럼에 전체 게시글 수가 저장됨
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        db.dbClose(rs, pstmt, conn);
	    }
	    return count;
	}

}
