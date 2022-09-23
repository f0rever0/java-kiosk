package java_gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class HomePage extends PagePanel {
	private Image background=new ImageIcon("./Button_Images/background_home.PNG").getImage();
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}
	
	public HomePage(Frame f, Field field) { 

		this.field = field;
		Color b=new Color(27, 60, 53);  
		setBackground(b); 
		setSize(800, 600); 
		
		Frame F = f; 
		setLayout(null);
		
		JLabel label = new JLabel("스터디카페 키오스크입니다."); 
		JLabel welcomeLable = new JLabel("스터디카페를 이용하려면 시작버튼을 클릭하세요"); 
		
		add(label); 
		add(welcomeLable);
		label.setBounds(300, 50, 500, 20);
		welcomeLable.setBounds(250, 70, 500, 20);
		
		JButton nextBtn = new JButton(new ImageIcon("./Button_Images/startBtn.PNG"));
		nextBtn.setBorderPainted(false);
		
		JButton checkoutBtn = new JButton(new ImageIcon("./Button_Images/checkOutBtn.PNG")); 
		checkoutBtn.setBorderPainted(false);
		
		nextBtn.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				F.nextPanel(); 
				} 
			}); 
		
		checkoutBtn.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				F.gotoCheckout();
				} 
			}); 
		
		nextBtn.setBounds(450, 450, 200, 100); 
		checkoutBtn.setBounds(150, 450, 200, 100); 
		add(nextBtn); 
		add(checkoutBtn); 
		
		setVisible(true); 
	} 
	
	public void updatePage(){
		this.updateUI();
		}
	}

