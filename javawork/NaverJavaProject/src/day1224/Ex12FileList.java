package day1224;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Ex12FileList {
    
    static final String FILENAME = "C:/naver1210/sawon.txt";
    List<String> sawonList = new Vector<String>(); 

    
    public Ex12FileList() {
        // 파일에서 이름을 읽어 sawonList에 추가하기
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                sawonList.add(line); // 각 줄을 읽어 리스트에 추가
                
            }
        } catch (IOException e) {
            System.out.println("파일 오류: " + e.getMessage());
        }
    }

    
    public void sawonMemberList() {
        // 사원 이름을 번호와 함께 출력하기
    	 System.out.println("총 " + sawonList.size() +"명의 사원이 있습니다.");

        int n = 0;
        for (String name : sawonList) {
            System.out.println(++n + "\t" + name);
        }
    }
    
    // 해당 이름이 몇 번 인덱스에 있는지 리턴 (없으면 -1)
    public int getSearchName(String name)
    {
    	int idx = -1;
    	for(int i=0; i<sawonList.size(); i++)
    	{
    		String listName = sawonList.get(i);
    		if(listName.equals(name)) {
    			idx = i;
    			break;
    		}
    	}
    	return idx;
    }
    
    // 이름 입력 시 삭제하는 메서드
    public void deleteSawon(String name)
    {
    	int idx = getSearchName(name);
    	if(idx == -1)
    		System.out.println(name+"님은 사원 명단에 없습니다.");
    	else
    	{
    		sawonList.remove(idx);
    		System.out.println(name+"님을 사원 명단에서 삭제했습니다.");
    	}
    }
    
    // 이름 조회
    public void searchName(String name)
    {
    	int idx = this.getSearchName(name);
    	if(idx==-1)
    		System.out.println(name+"님은 사원 명단에 없습니다.");
    	else
    		System.out.println(name+"님은 "+(idx+1)+"번째에 있습니다.");
    }
    
    // List의 이름들을 다시 파일에 저장하기
    public void sawonFileSave()
    {
    	FileWriter fw = null;
    	try {
			fw = new FileWriter(FILENAME);
			for(String name:sawonList)
			{
				fw.write(name+"\n");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	
    }
    
    // 사원명 추가
    public void addSawon(String name)
    {
    	int idx = this.getSearchName(name); // 이미 존재할 경우 추가 못 함
    	if(idx!=-1)
    		System.out.println(name+"님은 이미 존재합니다.");
    	else
    	{
    		sawonList.add(name);
    		System.out.println("추가되었습니다.");
    	}
    }
    
    /*======================================================*/
    public static void main(String[] args) {
        Ex12FileList ex12FileList = new Ex12FileList();
        
        Scanner sc = new Scanner(System.in);
        int menu = 0;
        
        while(true)
        {
        	System.out.println("1.사원추가  2.사원삭제  3.사원검색  4.전체 목록  5.저장 후 종료");
        	System.out.println("=".repeat(40));
        	
        	try {
        		menu = Integer.parseInt(sc.nextLine());
        	} catch(NumberFormatException e) {
        		menu = 4; // 문자 잘못 입력 시 전체 목록 출력 
        	}
        	
        	switch(menu)
        	{
        	case 1 -> {
        		System.out.println("추가 할 사원명 입력");
        		String name = sc.nextLine();
        		ex12FileList.addSawon(name);
        	}
        	case 2 -> {
        		System.out.println("삭제 할 사원명 입력");
        		String name = sc.nextLine();
        		ex12FileList.deleteSawon(name);
        	}
        	case 3 -> {
        		System.out.println("검색 할 사원명 입력");
        		String name = sc.nextLine();
        		ex12FileList.searchName(name);
        	}
        	case 4 -> ex12FileList.sawonMemberList();
        	
        	default -> {
        		System.out.println("저장 후 종료합니다.");
        		ex12FileList.sawonFileSave();
        		System.exit(0);
        	}
        	}
        }
    }
}
