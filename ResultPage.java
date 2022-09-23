package java_gui;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResultPage extends PagePanel { 
	JLabel countPrint;
	JLabel namePrint;
	JLabel seatPrint;
	
	
	public ResultPage(Frame f, Field field) {
		this.field = field;
		Color b=new Color(27, 60, 53);  
		setBackground(b); 
		setSize(800, 600); 
		setLayout(null);
		
		Frame F = f; 
		Font f1 = new Font("고딕", Font.BOLD, 40);
		Font f2 = new Font("고딕", Font.BOLD, 30);
		
		countPrint = new JLabel("영수증");
		countPrint.setForeground(Color.white);
		countPrint.setFont(f1);
		namePrint = new JLabel(field.getName()+"님의 정보입니다");
		namePrint.setForeground(Color.white);
		namePrint.setFont(f2);
		seatPrint = new JLabel("좌석"+field.getSeat());
		seatPrint.setForeground(Color.white);
		seatPrint.setFont(f2);
		countPrint.setBounds(300, 70, 500, 60);
		namePrint.setBounds(200, 160, 500, 40);
		seatPrint.setBounds(290, 210, 500, 40);
		add(countPrint); 
		add(namePrint);
		add(seatPrint);
		JButton nextBtn = new JButton(new ImageIcon("./Button_Images/endBtn.PNG")); // 홈으로 돌아가기
		
		nextBtn.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				// 홈으로 돌아가기
				new HomePage(F, field);
				setVisible(false);
				F.InitFrame(field);
				F.updatePage();

				// info(유저정보 리스트)에 키와 이름, 좌석, 메뉴 넣기
				field.addUser(field.getPhone());
				
				// 한 사이클이 종료되었으니 정보입력란 모두 리셋
				field.setName("");
				field.setPhone("");
				field.setSeat(0);
				field.increaseCount();
				} 
			}); 
		nextBtn.setBounds(300, 450, 200, 100); 

		add(nextBtn); 
		setVisible(true); 
		} 
	
	public void updatePage(){
		countPrint.setText("주문번호 ["+field.getCount()+"]");
		namePrint.setText(field.getName()+" 고객님의 좌석 정보입니다.");
		seatPrint.setText("이용 좌석 : " + String.valueOf(field.getSeat()));
		this.updateUI();
		}
	}
