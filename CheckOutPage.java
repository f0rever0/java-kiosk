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
		Font f1 = new Font("���", Font.BOLD, 20);
		JLabel label = new JLabel("����� ���Ѵٸ� ����� ��ȭ��ȣ�� �Է��ϼ���.");
		label.setFont(f1);
		label.setForeground(Color.white);
		label.setBounds(200, 100, 500, 20);
		add(label); 
		
		JLabel phone = new JLabel("��ȭ��ȣ(�� : 01012345678) : ");	
		phone.setForeground(Color.white);
		Font phoneFont = new Font("���", Font.BOLD, 18);
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
				// ��ȭ��ȣ�� ���� ���� ã��
				userPerson resultArray = field.findUser(txtPhone.getText());
				if(resultArray == null) {
					Modal ="����ڰ� �����ϴ�!";
				}else
					Modal = resultArray.name+"�� ���� ����Ͻðڽ��ϱ�?"
							+"���� �¼���"+resultArray.seat+"�Դϴ�";
				F.updatePage();
				
				int result = JOptionPane.showConfirmDialog(null,Modal,
						"��Ǿȳ�", JOptionPane.YES_NO_OPTION);
				
				if(result == JOptionPane.YES_OPTION) {
					// ����� ������ ����
					field.removeUser(resultArray);
					int[] copyseat = field.getseatlist();
					copyseat[resultArray.seat-1] = 0;
					field.setseatlist(copyseat);
				}
				else if(result ==  JOptionPane.NO_OPTION)
					// ����� ������ ������
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