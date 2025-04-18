package day0106;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.Text;

public class Ex2ShopTable extends JFrame {
	// GUI 구성요소 테이블 모델 
   JTextField tfSang, tfSu, tfDan;
   JButton btnAdd, btnDel, btnUpdate, btnSearch;
   DefaultTableModel tableModel; //테이블 데이터와 구조를 관리하는 객체
   JTable table; //표 형식으로 데이터를 표시하기 위한 컴포넌트
   
   ShopModel shopModel = new ShopModel(); //shopModel=DB와 연결된 객체
   
   public Ex2ShopTable() {
      super("shop 관리"); //부모생성자 호출(JFrame)
      this.setBounds(300, 100, 400, 400); //시작위치와 프레임 크기 설정
      this.initDesign();
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x 클릭시 종료
      this.setVisible(true);
   }
   
   public void initDesign() {
      JPanel p1 = new JPanel();
      tfSang = new JTextField(6);
      tfSu = new JTextField(3);
      tfDan = new JTextField(6);
      
      p1.add(new JLabel("상품명"));
      p1.add(tfSang);
      
      p1.add(new JLabel("수량"));
      p1.add(tfSu);
      
      p1.add(new JLabel("단가"));
      p1.add(tfDan);

      
      //p1 panel frame 상단에 추가하가ㅣ
      this.add("North", p1);
      
      //frame 중간에 table 넣기
      String []title = {"인덱스", "상품명", "수량", "단가", " 총 금액", "입고일"};
      tableModel = new DefaultTableModel(title, 0); //제목과 데이터는 0개로 생성
      table = new JTable(tableModel);
      this.add("Center", new JScrollPane(table)); //제목과 스크롤이 보이도록 추가
      
      //생성된 테이블에 db데이터 출력하기
      this.rowSelect();
      
   
      //하단에는 버튼 3개
      btnAdd = new JButton("상품추가");
      btnDel = new JButton("상품삭제");
      btnUpdate = new JButton("상품수정");
      btnSearch = new JButton("상품검색");
      
      JPanel p2 = new JPanel();
      p2.add(btnAdd);
      p2.add(btnDel);
      p2.add(btnUpdate);
      p2.add(btnSearch);
      this.add("South", p2);
      
      //상품추가 버튼 이벤트
      btnAdd.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            //일단 입력한 데이터들을 읽어서 dto로 묶어준다
            String sangpum = tfSang.getText();
            if(sangpum.length()==0) {
               JOptionPane.showMessageDialog(Ex2ShopTable.this, "상품명을 입력해주세요");
               return; //메시지 띄운 후 메서드 종료
            }
            String text_su = tfSu.getText();
            int su = 0;
            if(text_su.length()==0) {
               JOptionPane.showMessageDialog(Ex2ShopTable.this,  "수량을 입력해주세요");
               return; //메시지 띄운 후 메서드 종료
            }else {
               su = Integer.parseInt(text_su);
            }
            
            String text_dan = tfDan.getText();
            int danga = 0;
            if(text_dan.length()==0) {
               JOptionPane.showMessageDialog(Ex2ShopTable.this,  "단가를 입력해주세요");
               return; //메시지 띄운 후 메서드 종료
            }else {
               danga = Integer.parseInt(text_dan);
            }
            
            //insert 메서드 호출
            shopModel.insertShop(new ShopDto(sangpum, su, danga));
            //전체 데이터 다시 출력
            rowSelect(); //DB에서 다시 가져와서 출력
            //입력한 데이터 초기화
            tfSang.setText("");
            tfSu.setText("");
            tfDan.setText("");
         }
      });
   
      btnDel.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            //table의 선택한 행번호 가져오기
            int row = table.getSelectedRow(); //선택을 안했을경우 -1
            System.out.println(row);
            
            if(row == -1) {
               JOptionPane.showMessageDialog(Ex2ShopTable.this, "삭제할 행을 먼저 선택해주세요.");
               return;
            }
            
            //선택한 행의 0번열(인덱스) 값 가져오기
//            int idx = Integer.parseInt(table.getValueAt(row, 0).toString());//방법1 Object를 toString으로 형변환하기
            int idx = Integer.parseInt((String)table.getValueAt(row, 0)); //방법2
            
            //삭제 메서드 호출
            shopModel.deleteShop(idx);
            //테이블 데이터 다시 출력
            rowSelect();
            
         }
      });
      
      btnUpdate.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            int row = table.getSelectedRow(); //선택을 안했을경우 -1
            System.out.println(row);
            
            if(row == -1) {
               JOptionPane.showMessageDialog(Ex2ShopTable.this, "수정할 행을 먼저 선택해주세요.");
               return;
            }
            
            //선택한 행의 0번열(인덱스) 값 가져오기
//            int idx = Integer.parseInt(table.getValueAt(row, 0).toString());//방법1 Object를 toString으로 형변환하기
            int idx = Integer.parseInt((String)table.getValueAt(row, 0)); //방법2
            
            String sangpum;
            int danga;
            
            sangpum = JOptionPane.showInputDialog("수정할 상품명을 입력하세요.");
            danga = Integer.parseInt(JOptionPane.showInputDialog("수정할 단가를 입력하세요"));
            
            //수정 메서드 호출
            shopModel.updateShop(idx, sangpum, danga);
            
            //테이블 다시 출력
            rowSelect();
         }
      });
   
      // 상품 검색 버튼 이벤트
      btnSearch.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String sangpum = tfSang.getText();
			
			if(sangpum.length()==0)
				rowSelect();
			else
				// 일단 기존 데이터 모두 삭제
				tableModel.setRowCount(0);
				// 검색 결과 가져오기
				List<Vector<String>> searchList = shopModel.getSearchData(sangpum);
				// 테이블에 출력
				for(Vector<String> data:searchList)
				{
					tableModel.addRow(data);
				}
		}
	});
   }
   
   //table에 데이터 출력하는 메소드
   public void rowSelect() {
      //기존 테이블의 데이터 모두 삭제
      tableModel.setRowCount(0);
      
      //db의 모든 데이터 가져오기
      List<Vector<String>> list = shopModel.getAllDatas(); //getAllDatas(): DB에서 모든 데이터를 가져오는 역할
      //결과값은 List<Vector<String>> 형태로 반환됨. Vector<String>: 하나의 행을 저장하는 객체 
      
      for(Vector<String> data:list) { // data: 한 번에 한 행
         tableModel.addRow(data); 
      }
   }
   
   
	/*====================================================*/
   public static void main(String[] args) {
      Ex2ShopTable ex2 = new Ex2ShopTable();
   }

}
