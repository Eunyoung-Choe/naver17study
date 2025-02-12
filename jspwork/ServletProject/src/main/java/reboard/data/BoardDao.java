package reboard.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mybatis.db.ConnectionManager;

public class BoardDao {
	ConnectionManager connectionManager = ConnectionManager.getInstance();
	
	SqlSession session;
	String nameSpace = "reboard.data.BoardDao.";
	
	private SqlSession getSession()
	{
		session = connectionManager.openSession();
		return session;
	}
	
	public int getMaxNum()
	{
		session = getSession();
		int n = session.selectOne(nameSpace+"getMaxNum");
		session.close();
		return n;
	}
	
	public int getTotalCount()
	{
		session = getSession();
		int n = session.selectOne(nameSpace+"totalCount");
		session.close();
		return n;
	}
	
	public List<BoardDto> getPagingList(int start, int perpage)
	{
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start); // 바인딩 (강사님이 1~2개만 바인딩하는데 Dto 만들면 귀찮아진다고 Map 쓰심.)
		map.put("perpage",  perpage);
		
		session = getSession();
		List<BoardDto> list = session.selectList(nameSpace+"selectPagingList", map);
		session.close();
		return list;
	}
	
	public void updateRestep(int regroup, int restep)
	{
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("regroup", regroup);
		map.put("restep",  restep);
		session = getSession();
		session.update(nameSpace+"updateRestep", map);
		session.close();
	}
	
	public void insertBoard(BoardDto dto)
	{
		int num = dto.getNum();
		int regroup = dto.getRegroup();
		int restep = dto.getRestep();
		int relevel = dto.getRelevel();
		
		if(num==0) // 새 글이라는 의미(null일 때 0으로 변경 후 보낼 예정)
		{
			regroup = this.getMaxNum()+1;
			restep = 0;
			relevel = 0;
		} else // 답글일 경우
		{
			// 같은 그룹 중 전달 받은 restep 보다 큰 데이터는 모두 +1을 해준다.
			this.updateRestep(regroup, restep);
			// 그 후에 전달받은 레벨과 스텝을 1 증가한다.
			restep++;
			relevel++;
		}
		
		// 변경된 데이터들을 다시 Dto에 넣는다.
		dto.setRegroup(regroup);
		dto.setRestep(restep);
		dto.setRelevel(relevel);
		
		session = getSession();
		session.insert(nameSpace+"insertBoard", dto);
		session.close();
	}
	
	public void updateReadCount(int num)
	{
		session = getSession();
		session.update(nameSpace+"updateReadCount", num);
		session.close();
	}
	
	public BoardDto getData(int num)
	{
		session = getSession();
		BoardDto dto = session.selectOne(nameSpace+"selectOneByNum", num);
		session.close();
		return dto;
	}
}
