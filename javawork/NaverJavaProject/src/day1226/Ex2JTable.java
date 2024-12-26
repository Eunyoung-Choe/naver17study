package day1226;

import java.util.Arrays;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex2JTable extends JFrame {
    JTable jtable;

    public Ex2JTable() {
        super("JTable공부");
        this.setBounds(300, 100, 300, 300); // 시작위치와 크기 지정
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭 시 종료
        this.initDesign();
        this.setVisible(true); // 프레임 보이게 하기
    }

    public void initDesign() {
        // 기본 레이아웃은 BorderLayout
        // -> 이 레이아웃은 동서남북센터로 위치를 정하는 레이아웃임.

//    	// 방법 1===================================================
//        String[] title = { "이름", "혈액형", "나이" };
//        String[][] data = {
//                { "최은영", "B", "22" },
//                { "이재희", "B", "24" },
//                { "노진구", "A", "10" }
//        };

    	
    	// 방법 2===================================================
    	Vector<String> title = new Vector<String>();
    	title.add("이름");
    	title.add("혈액형");
    	title.add("나이");
    	
    	Vector<String> data1 = new Vector<String>();
    	data1.add("최은영");
    	data1.add("B");
    	data1.add("22");
    	
    	Vector<Vector<String>> data = new Vector<Vector<String>>();
    	data.add(data1);

    	
        // jtable 생성
        jtable = new JTable(data, title);
        
        // North에 JLabel 추가하기
        this.add("North", new JLabel("데이터 출력 테이블", JLabel.CENTER));

        // frame의 center에 추가
        // this.add("Center", jtable); // 제목 안 나옴, 데이터가 많을 경우 스크롤 안 됨.
        this.add("Center", new JScrollPane(jtable)); // JScrollPane으로 생성해서 넣어야 위의 것들이 나타남.
    }

    public static void main(String[] args) {
        Ex2JTable ex2 = new Ex2JTable();
    }
}
