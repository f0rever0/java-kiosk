package java_gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;


public class SeatCheckPage extends PagePanel {  
	public int seatnum;
	public int[] seat = new int[11];
	ImageIcon checked;
	
	public JRadioButton btnlist[];
	public JButton btnlistcheck[];
	
	public SeatCheckPage(Frame f, Field field) {
		
		this.field = field;
		field.setseatlist(seat);
		
		btnlist = new JRadioButton[11];
		btnlistcheck = new JButton[11];
		
		for (int i=0; i<seat.length; i++) { 
			seat[i] = 0;
		}
		
		Color b=new Color(27, 60, 53);  
		setBackground(b); 
		setSize(800, 600); 
		
		setLayout(null);
		
		Frame F = f; 
		
		JButton prevBtn = new JButton(new ImageIcon("./Button_Images/prevBtn.PNG")); 
		JButton nextBtn = new JButton(new ImageIcon("./Button_Images/nextBtn.PNG")); 
		nextBtn.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				if(seatnum != 0) {
					F.nextPanel(); 
					F.updatePage();
					
					if(seatnum == 0)
						return;
					
					seat[seatnum-1] = 1;
					for (int i=0; i<seat.length; i++) { 
						System.out.print(seat[i]);
						}
					System.out.println();
					} else {
					JOptionPane.showMessageDialog(null, 
							"좌석을 선택해주세요!");
				}
				}

			}); 
		
		prevBtn.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				F.prevPanel(); 
				F.updatePage();
				} 
			}); 
		
		add(prevBtn); 
		add(nextBtn); 
		
		prevBtn.setBounds(150, 450, 200, 100);
		nextBtn.setBounds(450, 450, 200, 100); 
		
		ImageIcon ima1 = new ImageIcon("./Button_Images/1.jpg");
		ImageIcon s_ima1 = new ImageIcon("./Button_Images/1c.jpg");
		JRadioButton no1 = new JRadioButton(ima1);
		no1.setBorderPainted(true);
		no1.setSelectedIcon(s_ima1);
		no1.setBounds(30, 20, 120, 85);
		
		ImageIcon ima2 = new ImageIcon("./Button_Images/2.jpg");
		ImageIcon s_ima2 = new ImageIcon("./Button_Images/2c.jpg");
		JRadioButton no2 = new JRadioButton(ima2);
		no2.setBorderPainted(true);
		no2.setSelectedIcon(s_ima2);
		no2.setBounds(170, 20, 120, 85);
		
		ImageIcon ima3 = new ImageIcon("./Button_Images/3.jpg");
		ImageIcon s_ima3 = new ImageIcon("./Button_Images/3c.jpg");
		JRadioButton no3 = new JRadioButton(ima3);
		no3.setBorderPainted(true);
		no3.setSelectedIcon(s_ima3);
		no3.setBounds(310, 20, 120, 85);
		
		ImageIcon ima4 = new ImageIcon("./Button_Images/4.jpg");
		ImageIcon s_ima4 = new ImageIcon("./Button_Images/4c.jpg");
		JRadioButton no4 = new JRadioButton(ima4);
		no4.setBorderPainted(true);
		no4.setSelectedIcon(s_ima4);
		no4.setBounds(450, 20, 120, 85);
		
		ImageIcon ima5 = new ImageIcon("./Button_Images/5.jpg");
		ImageIcon s_ima5 = new ImageIcon("./Button_Images/5c.jpg");
		JRadioButton no5 = new JRadioButton(ima5);
		no5.setBorderPainted(true);
		no5.setSelectedIcon(s_ima5);
		no5.setBounds(590, 20, 120, 85);
		
		ImageIcon ima6 = new ImageIcon("./Button_Images/6.jpg");
		ImageIcon s_ima6 = new ImageIcon("./Button_Images/6c.jpg");
		JRadioButton no6 = new JRadioButton(ima6);
		no6.setBorderPainted(true);
		no6.setSelectedIcon(s_ima6);
		no6.setBounds(30, 150, 120, 85);
		
		ImageIcon ima7 = new ImageIcon("./Button_Images/7.jpg");
		ImageIcon s_ima7 = new ImageIcon("./Button_Images/7c.jpg");
		JRadioButton no7 = new JRadioButton(ima7);
		no7.setBorderPainted(true);
		no7.setSelectedIcon(s_ima7);
		no7.setBounds(30, 250, 120, 85);
		
		ImageIcon ima8 = new ImageIcon("./Button_Images/8.jpg");
		ImageIcon s_ima8 = new ImageIcon("./Button_Images/8c.jpg");
		JRadioButton no8 = new JRadioButton(ima8);
		no8.setBorderPainted(true);
		no8.setSelectedIcon(s_ima8);
		no8.setBounds(30, 350, 120, 85);
		
		ImageIcon ima9 = new ImageIcon("./Button_Images/9.jpg");
		ImageIcon s_ima9 = new ImageIcon("./Button_Images/9c.jpg");
		JRadioButton no9 = new JRadioButton(ima9);
		no9.setBorderPainted(true);
		no9.setSelectedIcon(s_ima9);
		no9.setBounds(330, 150, 120, 85);
		
		ImageIcon ima10 = new ImageIcon("./Button_Images/10.jpg");
		ImageIcon s_ima10 = new ImageIcon("./Button_Images/10c.jpg");
		JRadioButton no10 = new JRadioButton(ima10);
		no10.setBorderPainted(true);
		no10.setSelectedIcon(s_ima10);
		no10.setBounds(330, 250, 120, 85);
		
		ImageIcon ima11 = new ImageIcon("./Button_Images/11.jpg");
		ImageIcon s_ima11 = new ImageIcon("./Button_Images/11c.jpg");
		JRadioButton no11 = new JRadioButton(ima11);
		no11.setBorderPainted(true);
		no11.setSelectedIcon(s_ima11);
		no11.setBounds(330, 350, 120, 85);
		
		btnlist[0] = no1;
		btnlist[1] = no2;
		btnlist[2] = no3;
		btnlist[3] = no4;
		btnlist[4] = no5;
		btnlist[5] = no6;
		btnlist[6] = no7;
		btnlist[7] = no8;
		btnlist[8] = no9;
		btnlist[9] = no10;
		btnlist[10] = no11;
		
		checked = new ImageIcon("./Button_Images/선택됨.jpg");
		JButton checked1 = new JButton(checked);
		checked1.setBounds(30, 20, 120, 85);
		JButton checked2 = new JButton(checked);
		checked2.setBounds(170, 20, 120, 85);
		JButton checked3 = new JButton(checked);
		checked3.setBounds(310, 20, 120, 85);
		JButton checked4 = new JButton(checked);
		checked4.setBounds(450, 20, 120, 85);
		JButton checked5 = new JButton(checked);
		checked5.setBounds(590, 20, 120, 85);
		JButton checked6 = new JButton(checked);
		checked6.setBounds(30, 150, 120, 85);
		JButton checked7 = new JButton(checked);
		checked7.setBounds(30, 250, 120, 85);
		JButton checked8 = new JButton(checked);
		checked8.setBounds(30, 350, 120, 85);
		JButton checked9 = new JButton(checked);
		checked9.setBounds(330, 150, 120, 85);
		JButton checked10 = new JButton(checked);
		checked10.setBounds(330, 250, 120, 85);
		JButton checked11 = new JButton(checked);
		checked11.setBounds(330, 350, 120, 85);
		
		btnlistcheck[0] = checked1;
		btnlistcheck[1] = checked2;
		btnlistcheck[2] = checked3;
		btnlistcheck[3] = checked4;
		btnlistcheck[4] = checked5;
		btnlistcheck[5] = checked6;
		btnlistcheck[6] = checked7;
		btnlistcheck[7] = checked8;
		btnlistcheck[8] = checked9;
		btnlistcheck[9] = checked10;
		btnlistcheck[10] = checked11;
		
		ButtonGroup g = new ButtonGroup();
		
		g.add(no1);
		g.add(no2);
		g.add(no3);
		g.add(no4);
		g.add(no5);
		g.add(no6);
		g.add(no7);
		g.add(no8);
		g.add(no9);
		g.add(no10);	
		g.add(no11);
		
		int[] copyseat = field.getseatlist();
		
		add(no1);
		add(no2);
		add(no3);
		add(no4);
		add(no5);
		add(no6);
		add(no7);
		add(no8);
		add(no9);
		add(no10);
		add(no11);
		
		no1.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				seatnum = 1;
				System.out.println(seatnum);
				} 
			});
		no2.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				seatnum = 2;
				System.out.println(seatnum);
				} 
			});
		no3.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				seatnum = 3;
				System.out.println(seatnum);
				} 
			});
		no4.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				seatnum = 4;
				System.out.println(seatnum);
				} 
			});
		no5.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				seatnum = 5;
				System.out.println(seatnum);
				} 
			});
		no6.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				seatnum = 6;
				System.out.println(seatnum);
				} 
			});
		no7.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				seatnum = 7;
				System.out.println(seatnum);
				} 
			});
		no8.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				seatnum = 8;
				System.out.println(seatnum);
				} 
			});
		no9.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				seatnum = 9;
				System.out.println(seatnum);
				} 
			});
		no10.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				seatnum = 10;
				System.out.println(seatnum);
				} 
			});
		
		no11.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				seatnum = 11;
				System.out.println(seatnum);
				} 
			});
		
		setVisible(true);
		
		} 
	
	public void updatePage(){
		field.setSeat(seatnum);
		this.updateUI();
	}
	
	public void Init() {
		
		int[] copyseat = field.getseatlist();
		
		for(int i = 0; i < copyseat.length;++i) {
			
			if (copyseat[i]==0) { 
				remove(btnlistcheck[i]);
				add(btnlist[i]);
			}
			
			else {
				remove(btnlist[i]);
				add(btnlistcheck[i]);
			}
		}
	}
}