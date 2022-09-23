package java_gui;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.List;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.JFrame;

import java_gui.Field;
import java_gui.HomePage;
import java_gui.LogInPage;
import java_gui.MenuPage;
import java_gui.PaymentPage;
import java_gui.ResultPage;
import java_gui.SeatCheckPage;

class userPerson{
	Field f = new Field();
	public String name = f.getName();
	public String phone = f.getPhone();
	public int seat = f.getSeat();
//	private String menu = 
}
class Field{
	public int[] seat = new int[11];
	public userPerson arrayUser[] = new userPerson[11];
	public String userName= "emptyName";
	public String userPhone = "emptyPhone";
	public int userSeat;
	public int Price = 0;
	public int count = 1;
	
	public void setName(String name) {
		userName = name;
	}
	
	public String getName() {
		return userName;
		
	}
	
	public void setPhone(String phone) {
		userPhone = phone;
	}
	
	public String getPhone() {
		return userPhone;
	}
	
	public void setSeat(int seat) {
		userSeat = seat;
	}
	
	public int getSeat() {
		return userSeat;
	}
	
	public void setPrice(int Price) {
		this.Price = Price;
	}
	
	public int getPrice() {
		return this.Price;
	}
	
	public int[] getseatlist() {
		return seat;
	}
	
	public void setseatlist(int[] seatlist) {
		if(seatlist.length == 11)
			seat = seatlist;
	}
	
	public void increaseCount() {
		this.count++;
	}
	
	public int getCount() {
		return this.count;
	}
	
	public void removeUser(userPerson user) {
		//만약 user가 없을때 예외처리
		for(int i = 0; i < 11; i++) {
			if(arrayUser[i] == user)
				arrayUser[i] = null;
		}
	}
	
	public void addUser(String phone) {
		userPerson newUser = new userPerson();
		newUser.name = userName;
		newUser.phone = userPhone;
		newUser.seat = userSeat;
		
		arrayUser[userSeat - 1] = newUser;
		
		for(int i =0; i<11; i++) {
			System.out.println(arrayUser[i]);
		}
	}
	
	public userPerson findUser(String phone) {
		for(int i = 0; i < 11; i++) {
			if(arrayUser[i] != null)
				if(arrayUser[i].phone.equals(phone))
					return arrayUser[i];
		}
		
		return null; 
	}
}

public class Frame extends JFrame{ 
	//각 페이지 레퍼런스들을 배열에 저장
	PagePanel arrayPanel[];
	int		pageCount = 0;
	private CardLayout cards = new CardLayout(); 
	public Frame() { 
		super("융프2팀_스터디카페");
		setSize(800, 600); 
		getContentPane().setLayout(cards); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setResizable(false); 
		
		Field field = new Field();
		
		//판넬 배열 할당
		arrayPanel = new PagePanel[7];
		
		HomePage home = new HomePage(this, field);
		getContentPane().add("HomePage", home);
		arrayPanel[pageCount] = home;
		++pageCount;

		LogInPage login = new LogInPage(this, field);
		getContentPane().add("LogInPage", login); 
		arrayPanel[pageCount] = login;
		++pageCount;

		MenuPage menu = new MenuPage(this, field);
		getContentPane().add("MenuPage", menu);  
		arrayPanel[pageCount] = menu;
		++pageCount;

		SeatCheckPage seatCheck = new SeatCheckPage(this, field);
		getContentPane().add("SeatCheckPage", seatCheck); 
		arrayPanel[pageCount] = seatCheck;
		++pageCount;

		PaymentPage payment = new PaymentPage(this, field);
		getContentPane().add("PaymentPage", payment); 
		arrayPanel[pageCount] = payment;
		++pageCount;

		ResultPage result = new ResultPage(this, field);
		getContentPane().add("ResultPage", result); 
		arrayPanel[pageCount] = result;
		++pageCount;
		
		CheckOutPage checkout = new CheckOutPage(this, field);
		getContentPane().add("CheckOutPage", checkout); 
		arrayPanel[pageCount] = checkout;
		++pageCount;
		
		setVisible(true); 
		} 

	public void nextPanel() { 
		cards.next(this.getContentPane()); 
		} 
	
	public void prevPanel() { 
		cards.previous(this.getContentPane());
		}  
	
	public void gotoCheckout() { // 퇴실페이지로 이동
		Container parent = this.getContentPane();
        synchronized (parent.getTreeLock()) {
            int ncomponents = parent.getComponentCount();
                Component comp = parent.getComponent(0);
                if (comp.isVisible()) {
                    comp.setVisible(false);
                    int currentCard = 6 % ncomponents;
                    comp = parent.getComponent(currentCard);
                    comp.setVisible(true);
                    parent.validate();
                    return;
                }
            showDefaultComponent(parent);
        	}
		}
	
    void showDefaultComponent(Container parent) {
        if (parent.getComponentCount() > 0) {
            int currentCard = 0;
            parent.getComponent(0).setVisible(true);
            parent.validate();
        }
    }
	
	public static void main(String[] args) {
		Frame frm = new Frame();
	}
	
	public void InitFrame(Field field) {
		for(int i = 0; i < pageCount;++i) {
			arrayPanel[i].Init();
		}
		
	}
	
	public void updatePage() {
		for(int i = 0; i < pageCount;++i) {
			arrayPanel[i].updatePage();
		}
	}
}