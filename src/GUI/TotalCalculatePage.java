package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import model.Account;
import model.AccountData;
import model.Menu;
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
	
	
	public TotalCalculatePage() {
		super("Total Calculate Page", 765, 450);
		AccountFileControler accountFileControler = new AccountFileControler();
		accountDataPack = accountFileControler.getAccountDataPack();
		
		totalPrice = 0;
		escapePrice = 0;
		todayPrice = 0;
		
		totalListButton = new ArrayList<MenuButton>();
		escapeListButton = new ArrayList<MenuButton>();
		todayListButton = new ArrayList<MenuButton>();
		
		menuList = new ArrayList<Menu>();
		
		

		for(int i = 0; i < accountDataPack.getAccountDataList().size(); i++)
		{
			for(int j = 0; j < accountDataPack.getAccountDataList().get(i).getNowTable().getOrderList().size(); j++)
			{
				int isExistIndex = -1;
				int isEscapeExistIndex = -1;
				
				for(int k = 0; k < menuList.size(); k++)
					if(menuList.get(k).getName().equals(accountDataPack.getAccountDataList().get(i).getNowTable().getOrderList().get(i)))
					{
						isExistIndex = k;
						break;
					}
				
				
				if(isExistIndex == -1) // Menu not exist
				{
					Menu menu = new Menu(accountDataPack.getAccountDataList().get(i).getNowTable().getOrderList().get(i).getName(),
							accountDataPack.getAccountDataList().get(i).getNowTable().getOrderList().get(i).getPrice());
					menu.setCount(menu.getCount() + 1);
					menuList.add(menu);
				}
				else // Menu exist
				{
					menuList.get(isExistIndex).setCount(menuList.get(isExistIndex).getCount() + 1);
				}
			}
		}
		
				
		for(int i = 0; i < accountDataPack.getAccountDataList().size(); i++)
		{
			for(int j = 0; j < accountDataPack.getAccountDataList().get(i).getNowTable().getOrderList().size(); j++)
			{
				int isExistIndex = -1;
				
				for(int k = 0; k < totalListButton.size(); k++)
					if(totalListButton.get(k).getName().equals(accountDataPack.getAccountDataList().get(i).getNowTable().getOrderList().get(i)))
					{
						isExistIndex = k;
						break;
					}
				
				if(isExistIndex == -1) // Menu not exist
				{
					MenuButton totalButton = new MenuButton(accountDataPack.getAccountDataList().get(i).getNowTable().getOrderList().get(i).getName(),
							accountDataPack.getAccountDataList().get(i).getNowTable().getOrderList().get(i).getPrice());
					totalButton.addCount();
					totalListButton.add(totalButton);
				}
				else
				{
					totalListButton.get(isExistIndex).addCount();
				}
			}
			
			
			totalPrice +=  accountDataPack.getAccountDataList().get(i).getNowTable().getTotalPrice();
			
			if(accountDataPack.getAccountDataList().get(i).isEscape())
				escapePrice +=  accountDataPack.getAccountDataList().get(i).getNowTable().getTotalPrice();
			if(accountDataPack.getAccountDataList().get(i).getDate().getDay() == new Date().getDay() &&
				!accountDataPack.getAccountDataList().get(i).isEscape())
				todayPrice +=  accountDataPack.getAccountDataList().get(i).getNowTable().getTotalPrice() ;
		}
		// this setup
		lineBorder = new LineBorder(Color.BLACK, 3);
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
		totalListPanel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		totalListPanel.setBorder(lineBorder);
		totalListPanel.enable(false);
		totalListPanel.addMouseListener(this);
		totalListPanel.addMouseWheelListener(this);
		this.add(totalListPanel).setBounds(30, 90, 200, 303);
		//
		
		// Total Calculate Label
		totalPriceLabel = new JLabel();
		totalPriceLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		totalPriceLabel.setForeground(Color.BLACK);
		totalPriceLabel.setText("Total :" + totalPrice + " ¿ø");
		totalPriceLabel.setVisible(true);
		this.add(totalPriceLabel).setBounds(30, 400, 200, 30);
		//
		////
		
		
		
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
		escapeListPanel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		escapeListPanel.setBorder(lineBorder);
		escapeListPanel.enable(false);
		escapeListPanel.addMouseListener(this);
		escapeListPanel.addMouseWheelListener(this);
		this.add(escapeListPanel).setBounds(280, 90, 200, 303);
		//
	
		// Total Calculate Label
		escapePriceLabel = new JLabel();
		escapePriceLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		escapePriceLabel.setForeground(Color.RED);
		escapePriceLabel.setText("Total :" + escapePrice + " ¿ø");
		escapePriceLabel.setVisible(true);
		this.add(escapePriceLabel).setBounds(280, 400, 200, 30);
		//
		////
			
		
		
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
		todayListPanel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		todayListPanel.setBorder(lineBorder);
		todayListPanel.enable(false);
		todayListPanel.addMouseListener(this);
		todayListPanel.addMouseWheelListener(this);
		this.add(todayListPanel).setBounds(530, 90, 200, 303);
		//
	
		// Total Calculate Label
		todayPriceLabel = new JLabel();
		todayPriceLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		todayPriceLabel.setForeground(Color.BLACK);
		todayPriceLabel.setText("Total :" + todayPrice + " ¿ø");
		todayPriceLabel.setVisible(true);
		this.add(todayPriceLabel).setBounds(530, 400, 200, 30);
		//
		////
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if( e.getSource() == exitButton ) {
			this.dispose();
		}
	}


	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		
	}
}
