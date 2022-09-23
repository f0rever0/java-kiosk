package java_gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LogInPage extends PagePanel {
	JTextField txtName ;
	JTextField txtPhone;
	public LogInPage(Frame f, Field field) { 
		this.field = field;
		
		Color b=new Color(27, 60, 53);  
		setBackground(b); 
		setSize(800, 600); 
		
		JLabel label = new JLabel("��");		
		
		Frame F = f; 
		JLabel label1 = new JLabel("Ű����ũ�� ����ϱ� ���ؼ��� �⺻���� ����� ������ �ʿ��մϴ�.");
		label1.setForeground(Color.white);
		JLabel label2 = new JLabel("�Ʒ��� ����� ������ �Է��ϼ���.");
		label2.setForeground(Color.white);
		
		Font f1 = new Font("���", Font.BOLD, 20);
		label1.setFont(f1);
		label2.setFont(f1);
		add(label1); 
		add(label2); 
		setLayout(null);
		
		JLabel name = new JLabel("�̸� : ");
		name.setForeground(Color.white);
		JLabel phone = new JLabel("��ȭ��ȣ(�� : 01012345678) : ");	
		phone.setForeground(Color.white);
		Font nameFont = new Font("���", Font.BOLD, 18);
		Font phoneFont = new Font("���", Font.BOLD, 18);
		txtName = new JTextField(10);
		txtPhone = new JTextField(10);
		label1.setBounds(100, 50, 800, 50);
		label2.setBounds(230, 80, 500, 50);
		name.setFont(nameFont);
		phone.setFont(phoneFont);
		name.setBounds(250, 180,100,30);
		txtName.setBounds(320, 185, 200, 20);
		phone.setBounds(200, 300, 300, 30);
		txtPhone.setBounds(470, 305, 150, 20);
		add(name);
		add(txtName);
		add(phone);
		add(txtPhone);

		JButton prevBtn = new JButton(new ImageIcon("./Button_Images/prevBtn.PNG")); 
		JButton save = new JButton(new ImageIcon("./Button_Images/saveBtn.PNG"));
		
		prevBtn.setBounds(150, 450, 200, 100);
		save.setBounds(450, 450, 200, 100);
		
		add(prevBtn);
		add(save);
		
		prevBtn.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				F.prevPanel(); 
				F.updatePage();
				} 
			}); 
		
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				field.setName(txtName.getText());
				field.setPhone(txtPhone.getText());
				if((txtPhone.getText().length()) != 11) {
					JOptionPane.showMessageDialog(null, 
							"��ȭ��ȣ ������ ���缭 �ۼ��� �ּ��� (�� : 01012345678)");
				}
				
				else if(field.findUser(txtPhone.getText()) != null) {
					JOptionPane.showMessageDialog(null, "�̹� �̿����� ���Դϴ�.");
				}
				
				else{
					F.nextPanel(); 
					F.updatePage();
				}
			}
		});
		
		setVisible(true); 
		} 
	
	public void updatePage(){
		txtName.setText("");
		txtPhone.setText("");
		}
	}
