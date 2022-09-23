package java_gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PaymentPage extends PagePanel { 
	static String n;
	private JLabel label;
	private JLabel selectMenu;
	private JLabel selectSeat;
	private JLabel totalPrice;
	private JLabel payment;
	
	public PaymentPage(Frame f, Field field) {

		this.field = field;
		Color b=new Color(27, 60, 53);  
		setBackground(b); 
		setSize(800, 600); 

		Frame F = f; 
		setLayout(null);
		
		Font f1 = new Font("고딕", Font.BOLD, 20);
		
		label = new JLabel(field.getName()+"님이 결제 금액과 좌석은 아래와 같습니다.");
		label.setForeground(Color.white);
		label.setFont(f1);
		totalPrice = new JLabel("총 결제 금액은 "+field.getPrice()+"입니다.");
		totalPrice.setForeground(Color.white);
		totalPrice.setFont(f1);
		selectSeat = new JLabel("선택한 좌석는 "+field.getSeat()+"번 좌석입니다.");
		selectSeat.setForeground(Color.white);
		selectSeat.setFont(f1);
		payment = new JLabel("결제수단을 선택한 후, 결제버튼을 눌러주세요.");
		payment.setForeground(Color.white);
		payment.setFont(f1);
		
		label.setBounds(190, 60, 500, 20);
		totalPrice.setBounds(270, 90, 500, 20);
		selectSeat.setBounds(270, 120, 500, 20);
		payment.setBounds(180, 150, 500, 20);
		add(label); 
		add(totalPrice);
		add(selectSeat);
		add(payment);
		
		JButton prevBtn = new JButton(new ImageIcon("./Button_Images/prevBtn.PNG")); 
		JButton paymentBtn = new JButton(new ImageIcon("./Button_Images/paymentBtn.PNG"));
		add(prevBtn); 
		add(paymentBtn);
		
		prevBtn.setBounds(150, 450, 200, 100);
		paymentBtn.setBounds(450, 450, 200, 100); 
		
		// Radio Button
		JRadioButton radio1 = new JRadioButton("신용카드");
		radio1.setIcon(new ImageIcon("./Button_Images/card.PNG"));
		radio1.setBorderPainted(true);
		JRadioButton radio2 = new JRadioButton("카카오페이");
		radio2.setIcon(new ImageIcon("./Button_Images/kakao.PNG"));
		radio2.setBorderPainted(true);
		JRadioButton radio3 = new JRadioButton("네이버페이");
		radio3.setIcon(new ImageIcon("./Button_Images/naver.PNG"));
		radio3.setBorderPainted(true);

		add(radio1);
		add(radio2);
		add(radio3);
		
		radio1.setBounds(100, 300, 170, 80);
		radio2.setBounds(300, 300, 170, 80);
		radio3.setBounds(500, 300, 180, 80);

		// Set Group
		ButtonGroup group = new ButtonGroup();
		group.add(radio1);
		group.add(radio2);
		group.add(radio3);
		
		
		prevBtn.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				F.prevPanel(); 
				} 
			}); 
		
		paymentBtn.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				F.nextPanel(); // 결제 누르면 바로 다음페이지로 넘어감
				if(radio1.isSelected()){
					JOptionPane.showMessageDialog(null,"신용카드로 결제되었습니다!");
				}else if(radio2.isSelected()){
					JOptionPane.showMessageDialog(null,"카카오페이로 결제되었습니다!");
				}else {
					JOptionPane.showMessageDialog(null,"네이버페이로 결제되었습니다!");
				}
			} 
		}); 
		
		setVisible(true); 
		} 
	
	public void updatePage(){
		label.setText(field.getName()+"님이 선택한 메뉴와 좌석은 아래와 같습니다.");
		totalPrice.setText("총 결제 금액은 "+field.getPrice()+"원 입니다.");
		selectSeat.setText("선택한 좌석는 "+field.getSeat()+"번 좌석입니다.");
	}
}