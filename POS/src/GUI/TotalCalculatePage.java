package GUI;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import GUIData.GUIdata;
import model.Account;
import model.AccountData;
import model.Menu;
import model.Table;
import controler.AccountFileControler;

public class TotalCalculatePage extends SimpleJFrame implements ActionListener, MouseListener, MouseWheelListener {
	
	private LineBorder lineBorder;
	private JButton exitButton;
	
	private JLabel totalNameLabel;
	private JLabel escapeNameLabel;
	private JLabel todayNameLabel;
	
	private JLabel totalPriceLabel;
	private JLabel escapePriceLabel;
	private JLabel todayPriceLabel;

	private JPanel totalListPanel;
	private JPanel escapeListPanel;
	private JPanel todayListPanel;
	
	private ArrayList<MenuButton> totalListButton;
	private ArrayList<MenuButton> escapeListButton;
	private ArrayList<MenuButton> todayListButton;
	
	private ArrayList<Menu> menuList;
	private ArrayList<Menu> escapeList;
	
	private AccountData accountDataPack;
	
	private int totalPrice;
	private int escapePrice;
	private int todayPrice;
	
	private int totalListFrom = 0;
	private int escapeListFrom = 0;
	private int todayListFrom = 0;
	
	
	public TotalCalculatePage() {
		super("Total Calculate Page", 765, 450);
		AccountFileControler accountFileControler = new AccountFileControler();
		accountDataPack = accountFileControler.getAccountDataPack();
		
		// this setup
		lineBorder = new LineBorder(Color.BLACK, 3);
		this.getRootPane().setBorder(lineBorder);
		//
		
		// exit button setup
		exitButton = new JButton(" Á¾ ·á ");
		exitButton.setBackground(Color.WHITE);
		exitButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		exitButton.setBorder(lineBorder);
		exitButton.addActionListener(this);
		this.add(exitButton).setBounds(675, 5, 80, 30);
		//
		
		//// All Calculate
		// Name Label
		totalNameLabel = new JLabel();
		totalNameLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 26));
		totalNameLabel.setForeground(Color.BLACK);
		totalNameLabel.setText("ÃÑ Á¤»ê");
		totalNameLabel.setVisible(true);
		this.add(totalNameLabel).setBounds(30, 40, 200, 30);
		//
		
		// Total OrderList TextField
		totalListPanel = new JPanel();
		lineBorder = new LineBorder(Color.BLACK, 3);
		totalListPanel.setLayout(null);
		totalListPanel.setBackground(Color.WHITE);
		totalListPanel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		totalListPanel.setBorder(lineBorder);
		totalListPanel.enable(false);
		totalListPanel.addMouseListener(this);
		totalListPanel.addMouseWheelListener(this);
		this.add(totalListPanel).setBounds(30, 90, 200, 306);
		//
		
		//// Escape Calculate
		// Name Label
		escapeNameLabel = new JLabel();
		escapeNameLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 26));
		escapeNameLabel.setForeground(Color.BLACK);
		escapeNameLabel.setText("Å»ÁÖ Á¤»ê");
		escapeNameLabel.setVisible(true);
		this.add(escapeNameLabel).setBounds(280, 40, 200, 30);
		//	
		
				
		// Total OrderList TextField
		escapeListPanel = new JPanel();
		lineBorder = new LineBorder(Color.BLACK, 3);
		escapeListPanel.setBackground(Color.WHITE);
		escapeListPanel.setLayout(null);
		escapeListPanel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		escapeListPanel.setBorder(lineBorder);
		escapeListPanel.enable(false);
		escapeListPanel.addMouseListener(this);
		escapeListPanel.addMouseWheelListener(this);
		this.add(escapeListPanel).setBounds(280, 90, 200, 306);
		//
			
		
		//// Pure Calculate
		// Name Label
		todayNameLabel = new JLabel();
		todayNameLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 26));
		todayNameLabel.setForeground(Color.BLACK);
		todayNameLabel.setText("¿À´Ã Á¤»ê");
		todayNameLabel.setVisible(true);
		this.add(todayNameLabel).setBounds(530, 40, 200, 30);
		//
	
		// Total OrderList TextField
		todayListPanel = new JPanel();
		lineBorder = new LineBorder(Color.BLACK, 3);
		todayListPanel.setBackground(Color.WHITE);
		todayListPanel.setLayout(null);
		todayListPanel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		todayListPanel.setBorder(lineBorder);
		todayListPanel.enable(false);
		todayListPanel.addMouseListener(this);
		todayListPanel.addMouseWheelListener(this);
		this.add(todayListPanel).setBounds(530, 90, 200, 306);
		//
	
		makeButton();
		
		showTotalList();
		showEscapeList();
		showTodayList();
		
		// Total Calculate Label
		totalPriceLabel = new JLabel();
		totalPriceLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		totalPriceLabel.setForeground(Color.BLACK);
		totalPriceLabel.setText("Total :" + totalPrice + " ¿ø");
		totalPriceLabel.setVisible(true);
		this.add(totalPriceLabel).setBounds(30, 400, 200, 30);
		//
		////
		
		// Total Calculate Label
		todayPriceLabel = new JLabel();
		todayPriceLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		todayPriceLabel.setForeground(Color.BLACK);
		todayPriceLabel.setText("Total :" + todayPrice + " ¿ø");
		todayPriceLabel.setVisible(true);
		this.add(todayPriceLabel).setBounds(530, 400, 200, 30);
		//
		////
		
		// Total Calculate Label
		escapePriceLabel = new JLabel();
		escapePriceLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		escapePriceLabel.setForeground(Color.RED);
		escapePriceLabel.setText("Total :" + escapePrice + " ¿ø");
		escapePriceLabel.setVisible(true);
		this.add(escapePriceLabel).setBounds(280, 400, 200, 30);
		//
		////
	}
	
	
	
	public void makeButton()
	{
		totalPrice = 0;
		escapePrice = 0;
		todayPrice = 0;
		
		totalListButton = new ArrayList<MenuButton>();
		escapeListButton = new ArrayList<MenuButton>();
		todayListButton = new ArrayList<MenuButton>();
		
		ArrayList<Menu> totalMenuList = new ArrayList<Menu>();
		ArrayList<Menu> escapeMenuList = new ArrayList<Menu>();
		ArrayList<Menu> todayNetMenuList = new ArrayList<Menu>();
		
		ArrayList<Account> accountList = getAccountDataPack().getAccountDataList();
		
		/**
		 * make menu lists for total, escape, today net
		 */
		for(int i = 0; i < accountList.size(); i++)
		{
			ArrayList<Menu> currentMenuList = accountList.get(i).getNowTable().getOrderList();
			
			for(int j = 0; j < currentMenuList.size(); j++)
			{
				int k;
				
				// make total menu list
				for(k = 0; k < totalMenuList.size(); k++)
				{
					if(totalMenuList.get(k).getName().equals(currentMenuList.get(j).getName()))
					{
						totalMenuList.get(k).setCount(totalMenuList.get(k).getCount() + currentMenuList.get(j).getCount());
						k = -1;
						break;
					}
				}
				if(k > -1)
				{
					Menu menu = new Menu( currentMenuList.get(j).getName(), currentMenuList.get(j).getPrice() );
					totalMenuList.add( menu );
				}
				
				// make escape menu list
				if( accountList.get(i).isEscape() ) // if escape
				{
					for(k = 0; k < escapeMenuList.size(); k++)
					{
						if(escapeMenuList.get(k).getName().equals(currentMenuList.get(j).getName()))
						{
							escapeMenuList.get(k).setCount(escapeMenuList.get(k).getCount() + currentMenuList.get(j).getCount());
							k = -1;
							break;
						}
					}
					if(k > -1)
					{
						Menu menu = new Menu( currentMenuList.get(j).getName(), currentMenuList.get(j).getPrice() );
						escapeMenuList.add( menu );
					}
				}
				
				Date now = new Date();
				Date before12h = new Date();
				before12h.setHours(now.getHours() - 12);
				
				// make today net menu list
				if( accountList.get(i).getDate().after(before12h) ) // if 12h ago ~ now
				{
					if( !accountList.get(i).isEscape() ) // if not escape
					{
						for(k = 0; k < todayNetMenuList.size(); k++)
						{
							if(todayNetMenuList.get(k).getName().equals(currentMenuList.get(j).getName()))
							{
								todayNetMenuList.get(k).setCount(todayNetMenuList.get(k).getCount() + currentMenuList.get(j).getCount());
								k = -1;
								break;
							}
						}
						if(k > -1)
						{
							Menu menu = new Menu( currentMenuList.get(j).getName(), currentMenuList.get(j).getPrice() );
							todayNetMenuList.add( menu );
						}
					}
				}
				
			}
		}
		
		System.out.println(totalMenuList.size());
		System.out.println(escapeMenuList.size());
		System.out.println(todayNetMenuList.size());
		
		/**
		 * make button-for showing the list-lists for total, escape, today net
		 */
		// make total menu button
		for(int i = 0; i < totalMenuList.size(); i++)
		{
			totalPrice += totalMenuList.get(i).getTotalPrice();
			
			JLabel name = new JLabel("  " + totalMenuList.get(i).getName());
			JLabel count = new JLabel("  " + totalMenuList.get(i).getCount() + " °³" + "(" + ( totalMenuList.get(i).getCount() * totalMenuList.get(i).getPrice()) + "¿ø)");
//			count.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			name.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
			count.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
			name.setFocusable(false);
			name.setBackground(Color.WHITE);
			count.setFocusable(false);
			count.setBackground(Color.WHITE);
			name.setBorder(null);
			count.setBorder(null);

			MenuButton button = new MenuButton();
			button.setLayout(null);
			button.add(name).setBounds(1, 1, 200, 26);
			button.add(count).setBounds(1, 20, 200, 26);
			button.setMenuName( totalMenuList.get(i).getName() );
			button.setMenuPrice( totalMenuList.get(i).getTotalPrice() );
			button.setBorder(GUIdata.buttonBorder);
			button.setBackground(Color.WHITE);
			
			totalListButton.add(button);
		}
		
		// make escape menu button
		for(int i = 0; i < escapeMenuList.size(); i++)
		{
			escapePrice += escapeMenuList.get(i).getTotalPrice();
			
			JLabel name = new JLabel("  " + escapeMenuList.get(i).getName());
			JLabel count = new JLabel("  " + escapeMenuList.get(i).getCount() + " °³" + "(" + ( escapeMenuList.get(i).getCount() * escapeMenuList.get(i).getPrice()) + "¿ø)");
//			count.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			name.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
			count.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
			name.setFocusable(false);
			name.setBackground(Color.WHITE);
			count.setFocusable(false);
			count.setBackground(Color.WHITE);
			name.setBorder(null);
			count.setBorder(null);
			
			MenuButton button = new MenuButton();
			button.setLayout(null);
			button.add(name).setBounds(1, 1, 200, 26);
			button.add(count).setBounds(1, 20, 200, 26);
			button.setMenuName( escapeMenuList.get(i).getName() );
			button.setMenuPrice( escapeMenuList.get(i).getTotalPrice() );
			button.setMenuName( totalMenuList.get(i).getName() );
			button.setMenuPrice( totalMenuList.get(i).getTotalPrice() );
			button.setBorder(GUIdata.buttonBorder);
			button.setBackground(Color.WHITE);
			
			escapeListButton.add(button);
		}
		
		// make today net menu button
		for(int i = 0; i < todayNetMenuList.size(); i++)
		{
			todayPrice += todayNetMenuList.get(i).getTotalPrice();
			
			JLabel name = new JLabel("  " + todayNetMenuList.get(i).getName());
			JLabel count = new JLabel("  " + todayNetMenuList.get(i).getCount() + " °³" + "(" + ( todayNetMenuList.get(i).getCount() * todayNetMenuList.get(i).getPrice()) + "¿ø)");
//			count.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			name.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
			count.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
			name.setFocusable(false);
			name.setBackground(Color.WHITE);
			count.setFocusable(false);
			count.setBackground(Color.WHITE);
			name.setBorder(null);
			count.setBorder(null);
			
			MenuButton button = new MenuButton();
			button.setLayout(null);
			button.add(name).setBounds(1, 1, 200, 26);
			button.add(count).setBounds(1, 20, 200, 26);
			button.setMenuName( todayNetMenuList.get(i).getName() );
			button.setMenuPrice( todayNetMenuList.get(i).getTotalPrice() );
			button.setMenuName( totalMenuList.get(i).getName() );
			button.setMenuPrice( totalMenuList.get(i).getTotalPrice() );
			button.setBorder(GUIdata.buttonBorder);
			button.setBackground(Color.WHITE);
			
			todayListButton.add(button);
		}
	}
	
	
	/* ========== Event Listener ========== */

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == exitButton) {
			POSPage.setOnTotalCalculateFrame(false);
			this.dispose();
		}
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if (e.getWheelRotation() < 0) {
			if (e.getSource() == totalListPanel) {
				System.out
						.println("mouse wheel moved up in the food menu list");

				if (getTotalListFrom() > 0) {
					setTotalListFrom(getTotalListFrom() - 1);
				}

				showTotalList();
			} else if (e.getSource() == escapeListPanel) {
				System.out
						.println("mouse wheel moved up in the food menu list");

				if (getEscapeListFrom() > 0) {
					setEscapeListFrom(getEscapeListFrom() - 1);
				}

				showEscapeList();
			} else if (e.getSource() == todayListPanel) {
				System.out
						.println("mouse wheel moved up in the food menu list");

				if (getTodayListFrom() > 0) {
					setTodayListFrom(getTodayListFrom() - 1);
				}

				showTodayList();
			}
		} else if (e.getWheelRotation() > 0) {
			if (e.getSource() == totalListPanel) {
				System.out
						.println("mouse wheel moved down in the food menu list");

				if (getTotalListFrom() + 6 < totalListButton.size()) {
					setTotalListFrom(getTotalListFrom() + 1);
				}

				showTotalList();
			} else if (e.getSource() == escapeListPanel) {
				System.out
						.println("mouse wheel moved down in the food menu list");

				if (getEscapeListFrom() + 6 < escapeListButton.size()) {
					setEscapeListFrom(getEscapeListFrom() + 1);
				}

				showEscapeList();
			}

			else if (e.getSource() == todayListPanel) {
				System.out
						.println("mouse wheel moved down in the food menu list");

				if (getTodayListFrom() + 6 < todayListButton.size()) {
					setTodayListFrom(getTodayListFrom() + 1);
				}

				showTodayList();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == totalListPanel) {
			System.out.println("mouse entered the totalListPanel");
			totalListPanel.grabFocus();
		} else if (e.getSource() == escapeListPanel) {
			System.out.println("mouse entered the escapeListPanel");
			escapeListPanel.grabFocus();
		} else if (e.getSource() == todayListPanel) {
			System.out.println("mouse entered the todayListPanel");
			todayListPanel.grabFocus();
		}
	}

	
	/* ============== Repaint each panel =========== */
	
	public void showTotalList() 
	{
		int j = getTotalListFrom();

		totalListPanel.removeAll();

		int k = 0;

		for (int i = j; i < totalListButton.size(); i++) 
		{
			totalListPanel.add(totalListButton.get(i)).setBounds(3, (k * 50) + 3, 194, 50);
			k++;
			if (k > 5)
				break;
		}
	}

	public void showEscapeList() 
	{
		int j = getEscapeListFrom();

		escapeListPanel.removeAll();

		int k = 0;

		for (int i = j; i < escapeListButton.size(); i++) 
		{
			escapeListPanel.add(escapeListButton.get(i)).setBounds(3, (k * 50) + 3, 194, 50);
			k++;
			if (k > 5)
				break;
		}
	}

	public void showTodayList() 
	{
		int j = getTodayListFrom();

		todayListPanel.removeAll();

		int k = 0;

		for (int i = j; i < todayListButton.size(); i++) 
		{
			todayListPanel.add(todayListButton.get(i)).setBounds(3,	(k * 50) + 3, 194, 50);
			k++;
			if (k > 5)
				break;
		}
	}
	
	
	/* ========== Getters and Setters ========== */
	
	public AccountData getAccountDataPack() {
		return accountDataPack;
	}

	public void setAccountDataPack(AccountData accountDataPack) {
		this.accountDataPack = accountDataPack;
	}

	public int getTotalListFrom() {
		return totalListFrom;
	}

	public void setTotalListFrom(int totalListFrom) {
		this.totalListFrom = totalListFrom;
	}

	public int getEscapeListFrom() {
		return escapeListFrom;
	}


	public void setEscapeListFrom(int escapeListFrom) {
		this.escapeListFrom = escapeListFrom;
	}

	public int getTodayListFrom() {
		return todayListFrom;
	}

	public void setTodayListFrom(int todayListFrom) {
		this.todayListFrom = todayListFrom;
	}
	
}
