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
		
		Font f1 = new Font("���", Font.BOLD, 20);
		
		label = new JLabel(field.getName()+"���� ���� �ݾװ� �¼��� �Ʒ��� �����ϴ�.");
		label.setForeground(Color.white);
		label.setFont(f1);
		totalPrice = new JLabel("�� ���� �ݾ��� "+field.getPrice()+"�Դϴ�.");
		totalPrice.setForeground(Color.white);
		totalPrice.setFont(f1);
		selectSeat = new JLabel("������ �¼��� "+field.getSeat()+"�� �¼��Դϴ�.");
		selectSeat.setForeground(Color.white);
		selectSeat.setFont(f1);
		payment = new JLabel("���������� ������ ��, ������ư�� �����ּ���.");
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
		JRadioButton radio1 = new JRadioButton("�ſ�ī��");
		radio1.setIcon(new ImageIcon("./Button_Images/card.PNG"));
		radio1.setBorderPainted(true);
		JRadioButton radio2 = new JRadioButton("īī������");
		radio2.setIcon(new ImageIcon("./Button_Images/kakao.PNG"));
		radio2.setBorderPainted(true);
		JRadioButton radio3 = new JRadioButton("���̹�����");
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
				F.nextPanel(); // ���� ������ �ٷ� ������������ �Ѿ
				if(radio1.isSelected()){
					JOptionPane.showMessageDialog(null,"�ſ�ī��� �����Ǿ����ϴ�!");
				}else if(radio2.isSelected()){
					JOptionPane.showMessageDialog(null,"īī�����̷� �����Ǿ����ϴ�!");
				}else {
					JOptionPane.showMessageDialog(null,"���̹����̷� �����Ǿ����ϴ�!");
				}
			} 
		}); 
		
		setVisible(true); 
		} 
	
	public void updatePage(){
		label.setText(field.getName()+"���� ������ �޴��� �¼��� �Ʒ��� �����ϴ�.");
		totalPrice.setText("�� ���� �ݾ��� "+field.getPrice()+"�� �Դϴ�.");
		selectSeat.setText("������ �¼��� "+field.getSeat()+"�� �¼��Դϴ�.");
	}
}