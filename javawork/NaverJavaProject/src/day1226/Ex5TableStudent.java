package day1226;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex5TableStudent extends JFrame{
	static final String FILENAME="C:/naver1210/student.txt";
	List<Student> list=new ArrayList<Student>();
	JTable table;
	
	public Ex5TableStudent() {
		// TODO Auto-generated constructor stub
		super("학생성적관리");
		this.setBounds(300, 100, 400, 300);
		this.initDesign();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void studentFileRead()
	{
		//파일을 읽어서 list 변수에 담기
		FileReader fr=null;
		BufferedReader br=null;
		
		try {
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);
			
			while(true)
			{
				String s=br.readLine();
				if(s==null)
					break;
				Student stu=new Student();
				String []data=s.split("\\|");
				stu.setName(data[0]);
				stu.setKor(Integer.parseInt(data[1]));
				stu.setEng(Integer.parseInt(data[2]));
				
				//list 에 추가
				list.add(stu);				
			}
			System.out.println(list.size());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException|NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void initDesign()
	{
		this.studentFileRead();//파일을 읽어서 list 변수에 담는다
		//list 의 데이타를 읽어서 테이블에 출력후
		//프레임에 출력하시오
		//제목은 이름,국어,영어,총점,평균
		
		String []title= {"이름","국어","영어","총점","평균"};
		String [][]data=new String[list.size()][5];
		
		int i=0;
		for(Student s:list)
		{
			data[i][0]=s.getName();
			data[i][1]=String.valueOf(s.getKor());
			data[i][2]=String.valueOf(s.getEng());
			int sum=s.getKor()+s.getEng();
			double avg=sum/2.0;
			data[i][3]=String.valueOf(sum);
			data[i][4]=String.valueOf(avg);
			
			//행번호 증가
			i++;
		}
		
		table=new JTable(data, title);
		this.add("Center",new JScrollPane(table));
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex5TableStudent();
	}

}

