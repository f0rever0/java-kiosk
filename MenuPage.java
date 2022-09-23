package java_gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class MenuPage extends PagePanel { 
	public MenuButtonList 	MenuBtnList;
	public SelectMenuList 	SelectList;
	public JLabel			PriceLabel;
	public int				SelectTotalPrice = 0;

	public MenuPage(Frame f, Field field) { 

		this.field = field;
		Color b=new Color(27, 60, 53);  
		setBackground(b); 
		setSize(800, 600); 
		setLayout(null);
		
		Frame F = f; 
		JLabel label = new JLabel("메뉴페이지");
		label.setBounds(12, 10, 61, 15);
		add(label);
		JButton prevBtn = new JButton(new ImageIcon("./Button_Images/prevBtn.PNG")); 
		JButton nextBtn = new JButton(new ImageIcon("./Button_Images/nextBtn.PNG")); 
		nextBtn.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				if(SelectTotalPrice != 0) {
					F.updatePage();
					F.nextPanel(); 
				}else {
					JOptionPane.showMessageDialog(null, 
							"메뉴를 한가지 이상 선택해주세요!");
				}
				} 
			}); 
		nextBtn.setBounds(450, 450, 200, 100); 
		
		prevBtn.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				F.prevPanel(); 
				} 
			}); 
		prevBtn.setBounds(150, 450, 200, 100);
		add(prevBtn); 
		add(nextBtn); 
		
		MenuBtnList = new MenuButtonList();
		MenuBtnList.setLocation(150, 10);
		add(MenuBtnList);

		
		SelectList = new SelectMenuList();
		add(SelectList);
		SelectList.menuPage = this;
		
		JScrollPane Scroll = new JScrollPane(SelectList,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		Scroll.setSize(500, 90);
		Scroll.setLocation(100, 350);
		Scroll.setVisible(true);
		add(Scroll);
		
		PriceLabel = new JLabel(String.valueOf(SelectTotalPrice) + " 원");
		PriceLabel.setForeground(Color.white);
		PriceLabel.setSize(300, 150);
		PriceLabel.setBackground(Color.BLUE);
		PriceLabel.setLocation(630, 350);
		PriceLabel.setHorizontalTextPosition(JLabel.LEFT);
		PriceLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		add(PriceLabel);

		setVisible(true); 
		} 
	
	public void Init() {
		SelectList.InitSelectList();
		updatePrice();
	}
	
	public void updatePage(){
		this.field.setPrice(SelectTotalPrice);
		System.out.println(this.field.getPrice());
		}
	
	public void updatePrice() {
		SelectTotalPrice = SelectList.getTotalPrice();
		PriceLabel.setText(String.valueOf(SelectTotalPrice) + " 원");
	}
	
	}

class MenuButtonList extends JPanel{
	
	private ArrayList<MenuButton> arrayMenuBtn;
	
	public MenuButtonList(){
		
		setBackground(Color.LIGHT_GRAY);
		GridLayout layout = new GridLayout(2,3, 10, 10);
		
		setLayout(layout);
		
		//메뉴 버튼 생성
		createMenuBtn();
		
		setSize(500, 300);
		setVisible(true);
		
		}
	
	public ArrayList<MenuButton> GetMenuArray() {return arrayMenuBtn;}

	private void createMenuBtn() {
		
		arrayMenuBtn = new ArrayList<MenuButton>();
		
		int index = 0;
		String MenuName = "아메리카노";	
		ImageIcon MenuImage = new ImageIcon("./Button_Images/Americano.png");
		MenuImage = ImageScaling(MenuImage);
		MenuButton MenuBtn = new MenuButton(MenuName, 4100, MenuImage);
		MenuBtn.Index = index;//밖에서 배열에 접근하기 위한 인덱스 정보 담아둠
		++index;
		arrayMenuBtn.add(MenuBtn);
		add(MenuBtn);
		
		MenuName = "카페 라떼";	
		MenuImage = new ImageIcon("./Button_Images/Latte.png");	
		MenuImage = ImageScaling(MenuImage);
		MenuBtn = new MenuButton(MenuName, 4600, MenuImage);
		MenuBtn.Index = index;
		++index;
		arrayMenuBtn.add(MenuBtn);
		add(MenuBtn);
		
		MenuName = "카라멜 마키아또";	
		MenuImage = new ImageIcon("./Button_Images/Caramel_Macchiato.png");	
		MenuImage = ImageScaling(MenuImage);
		MenuBtn = new MenuButton(MenuName, 5600, MenuImage);
		MenuBtn.Index = index;
		++index;
		arrayMenuBtn.add(MenuBtn);
		add(MenuBtn);
		
		MenuName = "자바 칩 프라푸치노";	
		MenuImage = new ImageIcon("./Button_Images/Java_Chip_Frappuccino.png");	
		MenuImage = ImageScaling(MenuImage);
		MenuBtn = new MenuButton(MenuName, 6100, MenuImage);
		MenuBtn.Index = index;
		++index;
		arrayMenuBtn.add(MenuBtn);
		add(MenuBtn);
		
		MenuName = "말차 크림 프라푸치노";	
		MenuImage = new ImageIcon("./Button_Images/Malcha_Cream_Frappuccino.png");	
		MenuImage = ImageScaling(MenuImage);
		MenuBtn = new MenuButton(MenuName, 6300, MenuImage);
		MenuBtn.Index = index;
		++index;
		arrayMenuBtn.add(MenuBtn);
		add(MenuBtn);
		
		MenuName = "얼 그레이";	
		MenuImage = new ImageIcon("./Button_Images/Earl_Grey.png");	
		MenuImage = ImageScaling(MenuImage);
		MenuBtn = new MenuButton(MenuName, 4100, MenuImage);
		MenuBtn.Index = index;
		++index;
		arrayMenuBtn.add(MenuBtn);
		add(MenuBtn);
		
		MenuName = "티라미슈 케이크";	
		MenuImage = new ImageIcon("./Button_Images/Cake.png");	
		MenuImage = ImageScaling(MenuImage);
		MenuBtn = new MenuButton(MenuName, 5900, MenuImage);
		MenuBtn.Index = index;
		++index;
		arrayMenuBtn.add(MenuBtn);
		add(MenuBtn);
		
		MenuName = "생크림 카스테라";	
		MenuImage = new ImageIcon("./Button_Images/Castera.png");	
		MenuImage = ImageScaling(MenuImage);
		MenuBtn = new MenuButton(MenuName, 4100, MenuImage);
		MenuBtn.Index = index;
		++index;
		arrayMenuBtn.add(MenuBtn);
		add(MenuBtn);
	}
	
	public static ImageIcon ImageScaling(ImageIcon Icon) {

		Image image = Icon.getImage();
		Image ChangeImage = image.getScaledInstance(165,150, image.SCALE_SMOOTH);
		ImageIcon ChangeIcon = new ImageIcon(ChangeImage);
		
		return ChangeIcon;
	}
}

class MenuButton extends JButton{
	
	public String		MenuName;
	public int			Price;
	public int 			Index;
	boolean				isSelected;
	
	public MenuButton(String name, int price, ImageIcon Image) {
		super(Image);

		MenuName = name;
		Price = price;
		isSelected = false;

		addActionListener(new SelectMenuListener());
		
		setVisible(true);
	}
	
	class SelectMenuListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) 
		{
			MenuButton Select = (MenuButton)e.getSource();
			
			if(!isSelected)
			{
				isSelected = true;
				MenuPage List = (MenuPage)(Select.getParent().getParent());
				List.SelectList.AddSelectMenu(Select.MenuName, Select.Price, Select.Index);
				
			}
		}
	}
}


class SelectMenuList extends JPanel{
	LinkedList<SelectMenu> SelectList;
	MenuPage				menuPage;
	
	SelectMenuList(){
		setLayout(new GridLayout(0, 1));
		SelectList = new LinkedList<SelectMenu>();
		setSize(100, 30);
		setVisible(true);
	}
	
	public void AddSelectMenu(String menuName, int price, int index) {
		
		SelectMenu Menu = new SelectMenu(menuName, price);
		
		SelectList.add(Menu);
		Menu.Index = index;
		Menu.parentPanel = this;
		Menu.setSize(220,30);
		Menu.setVisible(true);
		add(Menu);
		this.updateUI();
	}
	
	public int getTotalPrice() {
		
		int TotalPrice = 0;
		
		for(Iterator<SelectMenu> iter = SelectList.iterator() ;iter.hasNext();) {
			 
			 SelectMenu Select = iter.next();
			 TotalPrice += Select.getPrice();
		 }
		
		return TotalPrice;
	}
	
	public void RemoveSelectMenu(String menuName) {
		  
		 for(Iterator<SelectMenu> iter = SelectList.iterator() ;iter.hasNext();) {
			 
			 SelectMenu Select = iter.next();
			 
			 if(Select.menuName.equals(menuName)) {
				SelectMenuList List = (SelectMenuList)Select.getParent();
				MenuPage Page = List.menuPage;
				ArrayList<MenuButton> MenuArray = Page.MenuBtnList.GetMenuArray();
				MenuButton Btn = MenuArray.get(Select.Index); 
				Btn.isSelected = false;
			
				 SelectList.remove(Select);
				 remove(Select);
				 this.updateUI();
				 return;
			 }
		 }
	}
	
	public void InitSelectList() {
		for(Iterator<SelectMenu> iter = SelectList.iterator() ;iter.hasNext();) {
			 
			SelectMenu Select = iter.next();
			SelectMenuList List = (SelectMenuList)Select.getParent();
			MenuPage Page = List.menuPage;
			ArrayList<MenuButton> MenuArray = Page.MenuBtnList.GetMenuArray();
			MenuButton Btn = MenuArray.get(Select.Index); 
			Btn.isSelected = false;
		 }

		this.removeAll();
		SelectList.clear();
	}
}

class SelectMenu extends JPanel{
	SelectMenuList parentPanel;
	
	String	menuName;
	int 	selectCount = 0;
	int 	price;
	int 	Index;
	int		TotalPrice;
	
	JButton removeBtn;
	JLabel	menuNameLabel;
	JLabel	menuCountLabel;
	JLabel	menuPriceLabel;
	JButton plusBtn;
	JButton minusBtn;
	
	public SelectMenu(String menuName, int price) {
		
		this.menuName = menuName;
		this.price = price;
		
		setLayout(new FlowLayout());
		
		removeBtn = new JButton("X");
		removeBtn.addActionListener(new RemoveListener());
		menuNameLabel = new JLabel(menuName);
		minusBtn = new JButton("-");
		minusBtn.addActionListener(new MinusListener());
		menuCountLabel= new JLabel(String.valueOf(selectCount));
		plusBtn = new JButton("+");
		plusBtn.addActionListener(new PlusListener());
		TotalPrice = price * selectCount;
		menuPriceLabel = new JLabel(String.valueOf(TotalPrice) + "원");

		add(removeBtn);
		add(menuNameLabel);
		add(minusBtn);
		add(menuCountLabel);
		add(plusBtn);
		add(menuPriceLabel);
	}
	
	public void setParent(SelectMenuList parent) {
		parentPanel = parent;
	}
	
	public int getPrice() {
		TotalPrice = price * selectCount;
		return TotalPrice;
	}
	
	public void countPlus() {
		if(selectCount<9){
			
			++selectCount;
			
			TotalPrice = price * selectCount;
			menuCountLabel.setText(String.valueOf(selectCount));
			menuPriceLabel.setText(String.valueOf(TotalPrice) + "원");
		}
	}

	public void countMinus() {
		
		if(selectCount>0) {
			--selectCount;
		
			menuCountLabel.setText(String.valueOf(selectCount));
			menuPriceLabel.setText(String.valueOf(price * selectCount) + "원");
		}
	}
	
	class RemoveListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) 
		{
			JButton Select = (JButton)e.getSource();
			SelectMenu Menu = (SelectMenu)Select.getParent();
			SelectMenuList List = (SelectMenuList)Menu.getParent();
			Menu.parentPanel.RemoveSelectMenu(Menu.menuName);
			MenuPage page = List.menuPage;
			List.menuPage.updatePrice();
			
		}
	}
	
	class PlusListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) 
		{
			JButton Select = (JButton)e.getSource();
			SelectMenu Menu = (SelectMenu)Select.getParent();
			Menu.countPlus();
			SelectMenuList List = (SelectMenuList)Menu.getParent();
			List.menuPage.updatePrice();
		}
	}
	
	class MinusListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) 
		{
			JButton Select = (JButton)e.getSource();
			SelectMenu Menu = (SelectMenu)Select.getParent();
			Menu.countMinus();
			SelectMenuList List = (SelectMenuList)Menu.getParent();
			List.menuPage.updatePrice();
		}
	}
}


















