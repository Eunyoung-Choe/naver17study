package day1224;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
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
            System.out.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    public void sawonMemberList() {
        // 사원 이름을 번호와 함께 출력하기
        int n = 0;
        for (String name : sawonList) {
            System.out.println(++n + "\t" + name);
        }
    }

    public static void main(String[] args) {
        Ex12FileList ex12FileList = new Ex12FileList();
        ex12FileList.sawonMemberList(); // 사원 목록 출력
    }
}