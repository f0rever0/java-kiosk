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
		Font f1 = new Font("���", Font.BOLD, 40);
		Font f2 = new Font("���", Font.BOLD, 30);
		
		countPrint = new JLabel("������");
		countPrint.setForeground(Color.white);
		countPrint.setFont(f1);
		namePrint = new JLabel(field.getName()+"���� �����Դϴ�");
		namePrint.setForeground(Color.white);
		namePrint.setFont(f2);
		seatPrint = new JLabel("�¼�"+field.getSeat());
		seatPrint.setForeground(Color.white);
		seatPrint.setFont(f2);
		countPrint.setBounds(300, 70, 500, 60);
		namePrint.setBounds(200, 160, 500, 40);
		seatPrint.setBounds(290, 210, 500, 40);
		add(countPrint); 
		add(namePrint);
		add(seatPrint);
		JButton nextBtn = new JButton(new ImageIcon("./Button_Images/endBtn.PNG")); // Ȩ���� ���ư���
		
		nextBtn.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				// Ȩ���� ���ư���
				new HomePage(F, field);
				setVisible(false);
				F.InitFrame(field);
				F.updatePage();

				// info(�������� ����Ʈ)�� Ű�� �̸�, �¼�, �޴� �ֱ�
				field.addUser(field.getPhone());
				
				// �� ����Ŭ�� ����Ǿ����� �����Է¶� ��� ����
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
		countPrint.setText("�ֹ���ȣ ["+field.getCount()+"]");
		namePrint.setText(field.getName()+" ������ �¼� �����Դϴ�.");
		seatPrint.setText("�̿� �¼� : " + String.valueOf(field.getSeat()));
		this.updateUI();
		}
	}
