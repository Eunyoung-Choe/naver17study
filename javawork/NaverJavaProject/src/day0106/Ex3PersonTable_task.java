package day0106;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame; //윈도우 창 생성(기본 기능들 포함)
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Ex3PersonTable_task extends JFrame { // 클래스명
	JTextField tfName, tfAge, tfBlood, tfHP;
	JButton btnAdd, btnDel;
	DefaultTableModel tableModel;
	JTable table;
	
	PersonModel_task personModel = new PersonModel_task();
	
	
	public Ex3PersonTable_task() { // 생성자명
		super("사람 관리");
		this.setBounds(300, 100, 400, 400); //시작위치와 프레임 크기 설정
	    this.initDesign();
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x 클릭시 종료
	    this.setVisible(true);
	}
	
	
	// 제목 및 버튼 생성 (이름, 나이, 혈액형, 핸드폰)
	public void initDesign() {
		JPanel p1 = new JPanel();
		tfName = new JTextField(6);
		tfAge = new JTextField(3);
		tfBlood = new JTextField(3);
		tfHP = new JTextField(6);
		
		p1.add(new JLabel("이름"));
		p1.add(tfName);
		
		p1.add(new JLabel("나이"));
		p1.add(tfAge);
		
		p1.add(new JLabel("혈액형"));
		p1.add(tfBlood);
		
		p1.add(new JLabel("핸드폰"));
		p1.add(tfHP);
		
		this.add("South", p1); // p1 패널 위치 설정
		
		String []title = {"인덱스", "직원명", "나이", "혈액형", "핸드폰"};
		tableModel = new DefaultTableModel(title, 0); //제목과 데이터는 0개로 생성
	    table = new JTable(tableModel);
	    this.add("Center", new JScrollPane(table));
		
	    this.rowSelect();
	    
	    // 버튼
	    btnAdd = new JButton("상품추가");
	    btnDel = new JButton("상품삭제");
	    
	    JPanel p2 = new JPanel();
	    p2.add(btnAdd);
	    p2.add(btnDel);
	    this.add("North", p2);
	    
		
		// 직원 추가 버튼 이벤트
	    btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// 이름
				String name = tfName.getText();
				if(name.length()==0) {
					// 팝업 메시지 박스를 표시하는 함수
					JOptionPane.showMessageDialog(Ex3PersonTable_task.this, "이름을 입력하세요.");
					return;
				}
				// 나이
				String text_age = tfAge.getText();
				int age = 0;
				if(text_age.length()==0) {
					JOptionPane.showMessageDialog(Ex3PersonTable_task.this, "나이를 입력하세요.");
					return;
				} else
					age = Integer.parseInt(text_age);
				// 혈액형
				String blood = tfBlood.getText();
				if(blood.length()==0) {
					JOptionPane.showMessageDialog(Ex3PersonTable_task.this, "혈액형을 입력하세요.");
					return;
				}
				// 핸드폰
				String hp = tfHP.getText();
				if(hp.length()==0) {
					JOptionPane.showMessageDialog(Ex3PersonTable_task.this, "휴대폰 번호를 입력하세요.");
					return;
				}
			}
	    });
	    
	
		// 직원 삭제 버튼 이벤트
	
	
	}
	
	
	
	

	
	
	
	// 테이블에 데이터 출력하는 메서드
	public void rowSelect() {
		//기존 테이블의 행 개수를 0으로 모두 삭제(DB에서 새로운 데이터를 가져와 테이블을 다시 채울 때 사용)
	    TableModel.setRowCount(0);
	    
	    // DB의 모든 데이터 가져오기
	    List<Vector<String>> list = personModel.getAllDatas();
	    
	    for(Vector<String> data:list) {
	    	tableModel.addRow(data);
	    }
	    
	}
	
	
	/*====================================================*/
	public static void main(String[] args) {

	}

}
