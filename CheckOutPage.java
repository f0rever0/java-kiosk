package java_gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CheckOutPage extends PagePanel{
	String Modal;
	JTextField txtPhone;
	public CheckOutPage(Frame f, Field field) {
		Frame F = f; 
		this.field = field;
		Color b=new Color(27, 60, 53);  
		setBackground(b); 
		setSize(800, 600); 
		setLayout(null);
		Font f1 = new Font("고딕", Font.BOLD, 20);
		JLabel label = new JLabel("퇴실을 원한다면 등록한 전화번호를 입력하세요.");
		label.setFont(f1);
		label.setForeground(Color.white);
		label.setBounds(200, 100, 500, 20);
		add(label); 
		
		JLabel phone = new JLabel("전화번호(예 : 01012345678) : ");	
		phone.setForeground(Color.white);
		Font phoneFont = new Font("고딕", Font.BOLD, 18);
		txtPhone = new JTextField(10);
		phone.setFont(phoneFont);
		phone.setBounds(200, 250, 300, 30);
		txtPhone.setBounds(470, 255, 150, 20);
		add(phone);
		add(txtPhone);
		
		JButton save = new JButton(new ImageIcon("./Button_Images/checkOutBtn.PNG"));
		save.setBounds(150, 450, 200, 100);
		add(save);
		
		JButton prevBtn = new JButton(new ImageIcon("./Button_Images/cancelBtn.PNG"));
		prevBtn.setBounds(400, 450, 200, 100);
		add(prevBtn);
		
		prevBtn.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				new HomePage(F, field);
				setVisible(false);
				} 
			});
		
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 전화번호로 유저 정보 찾기
				userPerson resultArray = field.findUser(txtPhone.getText());
				if(resultArray == null) {
					Modal ="사용자가 없습니다!";
				}else
					Modal = resultArray.name+"님 정말 퇴실하시겠습니까?"
							+"현재 좌석는"+resultArray.seat+"입니다";
				F.updatePage();
				
				int result = JOptionPane.showConfirmDialog(null,Modal,
						"퇴실안내", JOptionPane.YES_NO_OPTION);
				
				if(result == JOptionPane.YES_OPTION) {
					// 사용자 정보를 지움
					field.removeUser(resultArray);
					int[] copyseat = field.getseatlist();
					copyseat[resultArray.seat-1] = 0;
					field.setseatlist(copyseat);
				}
				else if(result ==  JOptionPane.NO_OPTION)
					// 사용자 정보를 유지함
				new HomePage(F, field);
				setVisible(false);
				F.updatePage();
				F.InitFrame(field);
			}
		});
		setVisible(true);
	}
	public void updatePage(){
		txtPhone.setText("");
	}	
}