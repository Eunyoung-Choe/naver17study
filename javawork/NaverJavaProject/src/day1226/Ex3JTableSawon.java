package day1226;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex3JTableSawon extends JFrame{

	JTable table;
	List<Sawon> sawonList = new Vector<Sawon>();
	static final String SAWONFILE = "C:/naver1210/mysawon.txt";
	
	public Ex3JTableSawon() {
		super("사원파일읽기");
		this.setBounds(300, 100, 400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		this.initDesign(); // 컴포넌트들 추가 
        this.setVisible(true);
	}
	
	public void initDesign()
	{
		// 파일 정보 읽어오기
		this.sawonFileRead();
		
		// 테이블의 제목 부분
		String []title = {"사원명", "나이", "핸드폰", "주소"};
		
		// 테이블의 데이터 부분
		String [][]data = new String[sawonList.size()][4];
		
		int i = 0;
		for(Sawon s:sawonList)
		{
			data[i][0] = s.getSawonName();
			data[i][1] = String.valueOf(s.getAge());
			data[i][2] = s.getHp();
			data[i][3] = s.getAddress();
			
			i++;
		}
		
		// table 생성
		table = new JTable(data, title);
		
		// frame에 추가
		this.add("Center", new JScrollPane(table));
	}
	
	public void sawonFileRead()
	{
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(SAWONFILE);
			br = new BufferedReader(fr);
			
			while(true)
			{
				String sawonInfo = br.readLine();
				if(sawonInfo == null)
					break;
				String []s = sawonInfo.split("\\|");
				
				Sawon sawon = new Sawon();
				sawon.setSawonName(s[0]);
				sawon.setAge(Integer.parseInt(s[1]));
				sawon.setHp(s[2]);
				sawon.setAddress(s[3]);
				
				// List에 추가
				sawonList.add(sawon);
			}
			System.out.println("총 "+sawonList.size()+"명 읽음.");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				br.close();
				
			} catch (IOException | NullPointerException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {

		new Ex3JTableSawon();
	}

}
