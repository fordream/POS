package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import controler.MenuControler;
import controler.PosFileControler;
import controler.TableControler;
import model.Drink;
import model.Food;
import model.PosData;
import model.Table;
import model.Menu;

public class MenuInnerPanel extends JPanel implements ActionListener, KeyListener, MouseListener, MouseWheelListener, FocusListener{

	private LineBorder lineBorder;
	
	private JPanel foodListPanel;
	private JPanel drinkListPanel;
	private JPanel tableMenuListPanel;
	
	private JButton addFoodButton;
	private JButton addDrinkButton;
	private JButton delFoodButton;
	private JButton delDrinkButton;
	
	private JButton addMenuToListButton;
	private JButton subMenuFromListButton;
	private JButton delMenuFromListButton;
	private JButton resetMenuFromListButton;
	private JButton calcTableButton;
	private JButton calcAllButton;
	
	private ArrayList<MenuButton> foodListButton;
	private ArrayList<MenuButton> drinkListButton;
	private ArrayList<MenuButton> orderListButton;
	
	// for MenuAddPage
	private JTextField menuTextField;
	private JTextField priceTextField;
	private JButton enterButton;
	private JButton exitButton;
	private int menuType; // 0 : Food, 1: Drink
	final static int FOOD = 0;
	final static int DRINK = 1;
	final static int ORDER = 2;
	
	
	private TableCalculatePage tableCalculate;
	private MenuAddPage menuAddPage;
	
	private TableControler tableControler;
	private MenuControler menuControler;
	
	private PosData data;
	private int currentTableMenuIndex;
	private int currentFoodIndex;
	private int currentDrinkIndex;
	private String currentFoodName;
	private String currentDrinkName;
	private String currentOrderName;
	private int currentMenuType;
	private TableInnerPanel tableInnerPanel;
	
	
	
	public MenuInnerPanel(PosData data)
	{
		
		// this setup
		setData(data);
		//setCurrentTable(-1);
		setCurrentFoodIndex(0);
		setCurrentDrinkIndex(0);
		setCurrentTableMenuIndex(0);
		setCurrentMenuType(-1);
		
		tableControler = new TableControler(getData());
		menuControler = new MenuControler(getData());
		
		foodListButton = new ArrayList<MenuButton>();
		drinkListButton = new ArrayList<MenuButton>();
		orderListButton = new ArrayList<MenuButton>();
		
		lineBorder = new LineBorder(Color.BLACK, 3);
		this.setLayout(null);
		this.setBorder(lineBorder);
		this.setBackground(Color.WHITE);
		this.setBounds(860, 80, 500, 680);
		//
		
		
		// foodListPanel setup
		foodListPanel = new JPanel();
		lineBorder = new LineBorder(Color.BLACK, 3);
		foodListPanel.setLayout(null);
		foodListPanel.setBorder(lineBorder);
		foodListPanel.setBackground(Color.WHITE);
		foodListPanel.setFocusable(true);
		foodListPanel.addMouseListener(this);
		foodListPanel.addFocusListener(this);
		foodListPanel.addMouseWheelListener(this);
		this.add(foodListPanel).setBounds(20, 20, 200, 303);
		{
			// addFoodButton setup
			addFoodButton = new JButton(" ���� �߰�");
			lineBorder = new LineBorder(Color.BLACK, 3);
			addFoodButton.setBackground(Color.WHITE);
			addFoodButton.setFont(new Font("���� ����", Font.BOLD, 16));
			addFoodButton.setBorder(lineBorder);
			addFoodButton.addActionListener(this);
			foodListPanel.add(addFoodButton).setBounds(0, 0, 150, 30);
			//
			
			
			// delFoodButton setup setup
			delFoodButton = new JButton(" ���� ");
			lineBorder = new LineBorder(Color.BLACK, 3);
			delFoodButton.setBackground(Color.WHITE);
			delFoodButton.setFont(new Font("���� ����", Font.BOLD, 16));
			delFoodButton.setBorder(lineBorder);
			delFoodButton.addActionListener(this);
			foodListPanel.add(delFoodButton).setBounds(147, 0, 53, 30);
			//
		}
		//
		
		
		// drinkListPanel setup
		drinkListPanel = new JPanel();
		lineBorder = new LineBorder(Color.BLACK, 3);
		drinkListPanel.setLayout(null);
		drinkListPanel.setBorder(lineBorder);
		drinkListPanel.setBackground(Color.WHITE);
		drinkListPanel.setFocusable(true);
		drinkListPanel.addMouseListener(this);
		drinkListPanel.addFocusListener(this);
		drinkListPanel.addMouseWheelListener(this);
		this.add(drinkListPanel).setBounds(20, 347, 200, 303);
		{
			// addDrinkButton setup
			addDrinkButton = new JButton(" ���� �߰�");
			lineBorder = new LineBorder(Color.BLACK, 3);
			addDrinkButton.setBackground(Color.WHITE);
			addDrinkButton.setFont(new Font("���� ����", Font.BOLD, 16));
			addDrinkButton.setBorder(lineBorder);
			addDrinkButton.addActionListener(this);
			drinkListPanel.add(addDrinkButton).setBounds(0, 0, 150, 30);
			//
			
			
			// delDrinkButton setup
			delDrinkButton = new JButton(" ���� ");
			lineBorder = new LineBorder(Color.BLACK, 3);
			delDrinkButton.setBackground(Color.WHITE);
			delDrinkButton.setFont(new Font("���� ����", Font.BOLD, 16));
			delDrinkButton.setBorder(lineBorder);
			delDrinkButton.addActionListener(this);
			drinkListPanel.add(delDrinkButton).setBounds(147, 0, 53, 30);
			//
		}
		//
		
		// tableMenuListPanel setup
		tableMenuListPanel = new JPanel();
		lineBorder = new LineBorder(Color.BLACK, 3);
		tableMenuListPanel.setBorder(lineBorder);
		tableMenuListPanel.setBackground(Color.WHITE);
		tableMenuListPanel.setFocusable(true);
		tableMenuListPanel.addMouseListener(this);
		tableMenuListPanel.addFocusListener(this);
		tableMenuListPanel.addMouseWheelListener(this);
		this.add(tableMenuListPanel).setBounds(280, 20, 200, 303);
		//
		
		
		
		// addMenuToListButton setup
		addMenuToListButton = new JButton(" + ");
		lineBorder = new LineBorder(Color.BLACK, 3);
		addMenuToListButton.setBackground(Color.WHITE);
		addMenuToListButton.setFont(new Font("���� ����", Font.BOLD, 18));
		addMenuToListButton.setBorder(lineBorder);
		addMenuToListButton.addActionListener(this);
		this.add(addMenuToListButton).setBounds(230, 70, 40, 30);
		//
		
		
		// subMenuFromListButton setup
		subMenuFromListButton = new JButton(" - ");
		lineBorder = new LineBorder(Color.BLACK, 3);
		subMenuFromListButton.setBackground(Color.WHITE);
		subMenuFromListButton.setFont(new Font("���� ����", Font.BOLD, 18));
		subMenuFromListButton.setBorder(lineBorder);
		subMenuFromListButton.addActionListener(this);
		this.add(subMenuFromListButton).setBounds(230, 120, 40, 30);
		//
		
		
		// delMenuFromListButton setup
		delMenuFromListButton = new JButton("del");
		lineBorder = new LineBorder(Color.BLACK, 3);
		delMenuFromListButton.setBackground(Color.WHITE);
		delMenuFromListButton.setFont(new Font("���� ����", Font.BOLD, 12));
		delMenuFromListButton.setBorder(lineBorder);
		delMenuFromListButton.addActionListener(this);
		this.add(delMenuFromListButton).setBounds(230, 170, 40, 30);
		//
		
		
		// resetMenuFromListButton setup
		resetMenuFromListButton = new JButton("reset");
		lineBorder = new LineBorder(Color.BLACK, 3);
		resetMenuFromListButton.setBackground(Color.WHITE);
		resetMenuFromListButton.setFont(new Font("���� ����", Font.BOLD, 12));
		resetMenuFromListButton.setBorder(lineBorder);
		resetMenuFromListButton.addActionListener(this);
		this.add(resetMenuFromListButton).setBounds(230, 220, 40, 30);
		//
		
		
		// calcTableButton setup
		calcTableButton = new JButton(" �ڸ� ��� ");
		lineBorder = new LineBorder(Color.BLACK, 3);
		calcTableButton.setBackground(Color.WHITE);
		calcTableButton.setFont(new Font("���� ����", Font.BOLD, 18));
		calcTableButton.setBorder(lineBorder);
		calcTableButton.addActionListener(this);
		this.add(calcTableButton).setBounds(280, 350, 200, 30);
		//
		
		
		// calcAllButton setup
		calcAllButton = new JButton(" �� �� ");
		lineBorder = new LineBorder(Color.BLACK, 3);
		calcAllButton.setBackground(Color.WHITE);
		calcAllButton.setFont(new Font("���� ����", Font.BOLD, 18));
		calcAllButton.setBorder(lineBorder);
		calcAllButton.addActionListener(this);
		this.add(calcAllButton).setBounds(280, 400, 200, 30);
		//
		
		
	
		
		
		showFoodList();
		showDrinkList();
	}
	
	// �ֹ� ���� �� �����ִ� �Լ� 

	
	
	private Menu Menu(String name, int price) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	
	/* ============================ action listeners =====================================*/
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == menuTextField)
		{
			if(e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_DOWN)
			{
				priceTextField.grabFocus();
			}
			else if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
			{
				menuAddPage.dispose();
			}
		}
		else if(e.getSource() == priceTextField)
		{
			if(e.getKeyCode() == KeyEvent.VK_UP)
			{
				menuTextField.grabFocus();
			}
			else if(e.getKeyCode() == KeyEvent.VK_ENTER)
			{
				addMenuconfirm();
			}
			else if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
			{
				menuAddPage.dispose();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		
		// TODO Auto-generated method stub
		if(e.getSource() == addFoodButton)
		{
			addFoodToMenu();
		}
		else if(e.getSource() == addDrinkButton)
		{
			addDrinkToMenu();
		}
		else if(e.getSource() == calcTableButton)
		{
			if(Table.getSelectedTable() > -1)
				tableCalculate = new TableCalculatePage( getData(), this );
		}
		else if(e.getSource() == enterButton)
		{
			addMenuconfirm();
		}
		else if(e.getSource() == exitButton)
		{
			System.out.println("Exit button clicked on the menu add page");
			
			menuAddPage.dispose();
		}
		
		if(e.getSource() == delFoodButton)
		{
			MenuControler mcon = new MenuControler(getData());
			
			Food keyFood = new Food(getCurrentFoodName(), 0);
			
			mcon.deleteMenu(keyFood);
			
			setData( mcon.getData() );
			
			for(int i = 0; i < foodListButton.size(); i++)
			{
				System.out.println("Number of Button of Menu : " + foodListButton.size());
				System.out.println("current i is : " + i);
				System.out.println("foodListButton.get(i).getText()  : " + foodListButton.get(i).getText());
				
				if( foodListButton.get(i).getText().equals(getCurrentFoodName()) )
				{
					foodListButton.remove(i);
					break;
				}
			}
			
			showFoodList();
			
			repaint();
			
			// ���� 
			PosFileControler posFileControler = new PosFileControler(getData());
			posFileControler.writeToFile();
		}
		
		if(e.getSource() == calcAllButton)
		{
			new TotalCalculatePage();
		}
		
		if(e.getSource() == delDrinkButton)
		{
			MenuControler mcon = new MenuControler(getData());
			
			Drink keyDrink = new Drink(getCurrentDrinkName(), 0);
			
			mcon.deleteMenu(keyDrink);
			
			setData( mcon.getData() );
			
			for(int i = 0; i < drinkListButton.size(); i++)
			{
				System.out.println("Number of Button of Menu : " + drinkListButton.size());
				System.out.println("current i is : " + i);
				System.out.println("drinkListButton.get(i).getText()  : " + drinkListButton.get(i).getText());
				
				if( drinkListButton.get(i).getText().equals(getCurrentDrinkName()) )
				{
					drinkListButton.remove(i);
					break;
				}
			}
			
			showDrinkList();
			
			repaint();
			
			// ���� 
			PosFileControler posFileControler = new PosFileControler(getData());
			posFileControler.writeToFile();
		}
		
		for(int i = 0; i < foodListButton.size(); i++)
		{
			if(e.getSource() == foodListButton.get(i) )
			{
				setCurrentFoodName(foodListButton.get(i).getMenuName());
				setCurrentMenuType(0);
			}
		}
		for(int i = 0; i < drinkListButton.size(); i++)
		{
			if(e.getSource() == drinkListButton.get(i) )
			{
				setCurrentDrinkName(drinkListButton.get(i).getMenuName());
				setCurrentMenuType(1);
			}
		}
		
		
		// ��������Ʈ ���̱�
		for(int i = 0; i < orderListButton.size(); i++)
		{
			if(e.getSource() == orderListButton.get(i) )
			{
				System.out.println(orderListButton.get(i).getMenuName());
				setCurrentOrderName(orderListButton.get(i).getMenuName());
				setCurrentMenuType(2);
			}
		}
		
		
		
		///// ���� ���� ��������Ʈ �߰� ��� 
		/*
		addMenuToListButton;
		subMenuFromListButton;
		delMenuFromListButton;
		resetMenuFromListButton;
		*/
		

		if(e.getSource()  == addMenuToListButton)
		{
			
			System.out.println("" + Table.getSelectedTable() + " " + getCurrentMenuType());
			if(getCurrentMenuType() == FOOD)
			{
				Table table = getData().getTableList().get(Table.getSelectedTable());
				Food food = new Food(getData().getMenuList().get(menuControler.searchMenu(getCurrentFoodName())).getName(), getData().getMenuList().get(menuControler.searchMenu(getCurrentFoodName())).getPrice()); // getData().getMenuList().get(menuControler.searchMenu(getCurrentFoodName()));
				
				tableControler.addOrder(table, food);
			}
			else if(getCurrentMenuType() == DRINK)
			{
				Table table = getData().getTableList().get(Table.getSelectedTable());
				Drink drink = new Drink(getData().getMenuList().get(menuControler.searchMenu(getCurrentDrinkName())).getName(), getData().getMenuList().get(menuControler.searchMenu(getCurrentDrinkName())).getPrice()); // getData().getMenuList().get(menuControler.searchMenu(getCurrentFoodName()));
				
				tableControler.addOrder(table, drink);
			}

			for(int i = 0; i < getData().getTableList().size(); i++)
			{
				System.out.println(i + " : " );
				for(int j = 0; j < getData().getTableList().get(i).getOrderList().size(); j++)
				{
					System.out.println(getData().getTableList().get(i).getOrderList().get(j).getName() + "  " + getData().getTableList().get(i).getOrderList().get(j).getCount()  + "  " + getData().getTableList().get(i).getTotalPrice());
				}
			}
			
			setData(tableControler.getData());
			showTableMenuList();
			getTableInnerPanel().getTableListPanel().removeAll();
			getTableInnerPanel().getTableListPanel().repaint();
			getTableInnerPanel().getTableListPanel().printTableList(getData().getTableList().size());
			getTableInnerPanel().getTableListPanel().repaintTableList(getTableInnerPanel().getTableListPanel().getTableNum());
		
			

		}

		if(e.getSource()  == subMenuFromListButton)
		{
			if(getCurrentMenuType() == ORDER)
			{
				System.out.println("Subtract order" + " " +getCurrentOrderName() );
				Table table = getData().getTableList().get(Table.getSelectedTable());
				Menu menu = new Menu(getData().getMenuList().get(menuControler.searchMenu(getCurrentOrderName())).getName(), 
						getData().getMenuList().get(menuControler.searchMenu(getCurrentOrderName())).getPrice()); // getData().getMenuList().get(menuControler.searchMenu(getCurrentFoodName()));
				
				tableControler.subOrder(table, menu);
			}
			
			setData(tableControler.getData());
			showTableMenuList();
			repaint();
			getTableInnerPanel().getTableListPanel().removeAll();
			getTableInnerPanel().getTableListPanel().repaint();
			getTableInnerPanel().getTableListPanel().printTableList(getData().getTableList().size());
			getTableInnerPanel().getTableListPanel().repaintTableList(getTableInnerPanel().getTableListPanel().getTableNum());
		}
		
		if(e.getSource()  == delMenuFromListButton)
		{
			if(getCurrentMenuType() == ORDER)
			{
				System.out.println("Delete order" + " " + getCurrentOrderName() );
				Table table = getData().getTableList().get(Table.getSelectedTable());
				/*
				Menu menu = new Food(getData().getTableList().get(table.getTableNumber()).getOrderList().get(menuControler.searchMenu(getCurrentOrderName())).getName(), 
						getData().getTableList().get(table.getTableNumber()).getOrderList().get(menuControler.searchMenu(getCurrentOrderName())).getPrice()); // getData().getMenuList().get(menuControler.searchMenu(getCurrentFoodName()));
*/
				
				Menu menu = new Food(getData().getMenuList().get(menuControler.searchMenu(getCurrentOrderName())).getName(), 
						getData().getMenuList().get(menuControler.searchMenu(getCurrentOrderName())).getPrice()); // getData().getMenuList().get(menuControler.searchMenu(getCurrentFoodName()));
				
				tableControler.deleteOrder(table, menu);

			}
			setData(tableControler.getData());
			showTableMenuList();
			repaint();
			getTableInnerPanel().getTableListPanel().removeAll();
			getTableInnerPanel().getTableListPanel().repaint();
			getTableInnerPanel().getTableListPanel().printTableList(getData().getTableList().size());
			getTableInnerPanel().getTableListPanel().repaintTableList(getTableInnerPanel().getTableListPanel().getTableNum());
		}
		if(e.getSource()  == resetMenuFromListButton)
		{
			 resetMenuFromList();
		}
	}
	
	public void resetMenuFromList()
	{
		System.out.println("Reset order" + " " + getCurrentOrderName() );
		Table table = getData().getTableList().get(Table.getSelectedTable());

		tableControler.resetOrder(table);

		setData(tableControler.getData());
		showTableMenuList();
		repaint();
		getTableInnerPanel().getTableListPanel().removeAll();
		getTableInnerPanel().getTableListPanel().repaint();
		getTableInnerPanel().getTableListPanel().printTableList(getData().getTableList().size());
		getTableInnerPanel().getTableListPanel().repaintTableList(getTableInnerPanel().getTableListPanel().getTableNum());
	}
	
	public void delMenuFromList()
	{
	
	}

	public void subMenuFromList()
	{
	
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		if(e.getWheelRotation() < 0)
		{
			if(e.getSource() == foodListPanel)
			{
				System.out.println("mouse wheel moved up in the food menu list");
				
				if(getCurrentFoodIndex() > 0)
				{
					setCurrentFoodIndex( getCurrentFoodIndex() - 1 );
				}
				
				showFoodList();
			}
			else if(e.getSource() == drinkListPanel)
			{
				System.out.println("mouse  wheel moved up in the drink menu list");
				
				if(getCurrentDrinkIndex() > 0)
				{
					setCurrentDrinkIndex( getCurrentDrinkIndex() - 1 );
				}
				
				showDrinkList();
				
			}
			else if(e.getSource() == tableMenuListPanel)
			{
				System.out.println("mouse  wheel moved up in the table menu list");
				
				if(getCurrentTableMenuIndex() > 0)
				{
					setCurrentTableMenuIndex( getCurrentTableMenuIndex() - 1 );
				}

				showTableMenuList();
			}
		}
		else if(e.getWheelRotation() > 0)
		{
			if(e.getSource() == foodListPanel)
			{
				System.out.println("mouse wheel moved down in the food menu list");
				
				if(getCurrentFoodIndex() + 10 < foodListButton.size())
				{
					setCurrentFoodIndex( getCurrentFoodIndex() + 1 );
				}
				
				showFoodList();
			}
			else if(e.getSource() == drinkListPanel)
			{
				System.out.println("mouse  wheel moved down in the drink menu list");
				
				if(getCurrentDrinkIndex() + 10 < drinkListButton.size())
				{
					setCurrentDrinkIndex( getCurrentDrinkIndex() + 1 );
				}
				
				showDrinkList();
				
			}
			else if(e.getSource() == tableMenuListPanel)
			{
				System.out.println("mouse  wheel moved down in the table menu list");

				if(getCurrentTableMenuIndex() + 11 < orderListButton.size())
				{
					setCurrentTableMenuIndex( getCurrentTableMenuIndex() + 1 );
				}

				showTableMenuList();
			}
		}
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == foodListPanel)
		{
			System.out.println("mouse entered the food menu list");
			foodListPanel.grabFocus();
		}
		else if(e.getSource() == drinkListPanel)
		{
			System.out.println("mouse entered the drink menu list");
			drinkListPanel.grabFocus();
		}
		else if(e.getSource() == tableMenuListPanel)
		{
			System.out.println("mouse entered the table menu list");
			tableMenuListPanel.grabFocus();
		}
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == foodListPanel)
		{
			System.out.println("mouse exited from the food menu list");
			//foodListPanel.
		}
		else if(e.getSource() == drinkListPanel)
		{
			System.out.println("mouse exited from the drink menu list");
			//drinkListPanel
		}
		else if(e.getSource() == tableMenuListPanel)
		{
			System.out.println("mouse exited from the table menu list");
			//tableMenuListPanel
		}
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		System.out.println("get focus");
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	/* =============================================================================================================== */
	
	
	
	
	
	
	
	public void addMenuconfirm()
	{
		System.out.println("Enter button clicked on the menu add page");
		
		String newMenuName = menuTextField.getText();
		
		int newMenuPrice = Integer.parseInt( priceTextField.getText() );
		
		if(getMenuType() == FOOD)
		{
			Food food = new Food(newMenuName, newMenuPrice);
			
			MenuControler MCon = new MenuControler( getData() );
			
			if( MCon.searchMenu(food.getName()) != -1)
			{
				if( getData().getMenuList().get( MCon.searchMenu(food.getName()) ) instanceof Drink )
				{
					JOptionPane.showMessageDialog(this, "������ �ٸ� ���� �̸��� �޴��� �����մϴ�! ������ �Ұ����մϴ�!");
					return;
				}
			}
			
			MCon.addMenu( food );
			setData( MCon.getData() );
			
			MenuButton foodButton = new MenuButton(food.getName() + "  " + food.getPrice() + "��");
			
			lineBorder = new LineBorder(Color.BLACK, 3);
			foodButton.setBackground(Color.WHITE);
			foodButton.setFont(new Font("���� ����", Font.BOLD, 16));
			//foodListButton[i].setBorder(lineBorder);
			foodButton.addActionListener(this);
			foodButton.addMouseListener(this);
			foodButton.addFocusListener(this);
			
			foodListButton.add(foodButton);
			
			showFoodList();
		}
		else if(getMenuType() == DRINK)
		{
			Drink drink = new Drink(newMenuName, newMenuPrice);
			
			MenuControler MCon = new MenuControler( getData() );
			
			if( MCon.searchMenu(drink.getName()) != -1)
			{
				if( getData().getMenuList().get( MCon.searchMenu(drink.getName()) ) instanceof Food )
				{
					JOptionPane.showMessageDialog(this, "������ �ٸ� ���� �̸��� �޴��� �����մϴ�! ������ �Ұ����մϴ�!");
					return;
				}
			}
			
			MCon.addMenu( drink );
			setData( MCon.getData() );
			
			MenuButton drinkButton = new MenuButton(drink.getName() + "  " + drink.getPrice() + "��");
			
			lineBorder = new LineBorder(Color.BLACK, 3);
			drinkButton.setBackground(Color.WHITE);
			drinkButton.setFont(new Font("���� ����", Font.BOLD, 16));
			//foodListButton[i].setBorder(lineBorder);
			drinkButton.addActionListener(this);
			drinkButton.addMouseListener(this);
			drinkButton.addFocusListener(this);
			
			drinkListButton.add(drinkButton);
			
			
			showDrinkList();
		}
		
		// ���� 
		PosFileControler posFileControler = new PosFileControler(getData());
		posFileControler.writeToFile();
		
		menuAddPage.dispose();
	}
	
	public void addFoodToMenu()
	{
		menuAddPage = new MenuAddPage(getData(), MenuAddPage.FOOD );
		
		// menuTextFiedl setup
		menuTextField = new JTextField();
		lineBorder = new LineBorder(Color.BLACK, 3);
		menuTextField.setFont(new Font("���� ����", Font.BOLD, 16));
		menuTextField.setBorder(lineBorder);
		menuTextField.addKeyListener(this);
		menuAddPage.add(menuTextField).setBounds(75, 150, 270, 30);
		//
		// priceTextFiedl setup
		priceTextField = new JTextField();
		lineBorder = new LineBorder(Color.BLACK, 3);
		priceTextField.setFont(new Font("���� ����", Font.BOLD, 16));
		priceTextField.setBorder(lineBorder);
		priceTextField.addKeyListener(this);
		menuAddPage.add(priceTextField).setBounds(75, 200, 270, 30);
		//
		// enter button setup
		enterButton = new JButton(" Ȯ�� ");
		lineBorder = new LineBorder(Color.BLACK, 3);
		enterButton.setBackground(Color.WHITE);
		enterButton.setFont(new Font("���� ����", Font.BOLD, 16));
		enterButton.setBorder(lineBorder);
		enterButton.addActionListener(this);
		menuAddPage.add(enterButton).setBounds(90, 250, 80, 30);
		//
		// exit button setup
		exitButton = new JButton(" �� �� ");
		lineBorder = new LineBorder(Color.BLACK, 3);
		exitButton.setBackground(Color.WHITE);
		exitButton.setFont(new Font("���� ����", Font.BOLD, 16));
		exitButton.setBorder(lineBorder);
		exitButton.addActionListener(this);
		menuAddPage.add(exitButton).setBounds(230, 250, 80, 30);
		//
		
		setMenuType(FOOD);
	}
	
	public void addDrinkToMenu()
	{
		menuAddPage = new MenuAddPage(getData(), MenuAddPage.DRINK );
		
		// menuTextFiedl setup
		menuTextField = new JTextField();
		lineBorder = new LineBorder(Color.BLACK, 3);
		menuTextField.setFont(new Font("���� ����", Font.BOLD, 16));
		menuTextField.setBorder(lineBorder);
		menuTextField.addKeyListener(this);
		menuAddPage.add(menuTextField).setBounds(75, 150, 270, 30);
		//
		// priceTextFiedl setup
		priceTextField = new JTextField();
		lineBorder = new LineBorder(Color.BLACK, 3);
		priceTextField.setFont(new Font("���� ����", Font.BOLD, 16));
		priceTextField.setBorder(lineBorder);
		priceTextField.addKeyListener(this);
		menuAddPage.add(priceTextField).setBounds(75, 200, 270, 30);
		//
		// enter button setup
		enterButton = new JButton(" Ȯ�� ");
		lineBorder = new LineBorder(Color.BLACK, 3);
		enterButton.setBackground(Color.WHITE);
		enterButton.setFont(new Font("���� ����", Font.BOLD, 16));
		enterButton.setBorder(lineBorder);
		enterButton.addActionListener(this);
		menuAddPage.add(enterButton).setBounds(90, 250, 80, 30);
		//
		// exit button setup
		exitButton = new JButton(" �� �� ");
		lineBorder = new LineBorder(Color.BLACK, 3);
		exitButton.setBackground(Color.WHITE);
		exitButton.setFont(new Font("���� ����", Font.BOLD, 16));
		exitButton.setBorder(lineBorder);
		exitButton.addActionListener(this);
		menuAddPage.add(exitButton).setBounds(230, 250, 80, 30);
		//
		
		setMenuType(DRINK);
	}
	

	public void showTableMenuList()
	{
		int j = getCurrentTableMenuIndex();
		
		Menu menu = null;
		
		orderListButton.clear();
		
		tableMenuListPanel.removeAll();
		
		for(int i = 0; i < getData().getTableList().get(Table.getSelectedTable()).getOrderList().size(); i++)
		{
			menu = getData().getTableList().get(Table.getSelectedTable()).getOrderList().get(i);
			MenuButton menuButton = new MenuButton(menu.getName() + "  " + menu.getCount() + "��");
			menuButton.setMenuName(menu.getName());
			lineBorder = new LineBorder(Color.BLACK, 3);
			menuButton.setBackground(Color.WHITE);
			menuButton.setFont(new Font("���� ����", Font.BOLD, 16));
			
			menuButton.addActionListener(this);
			menuButton.addMouseListener(this);
			menuButton.addFocusListener(this);
			
			orderListButton.add(menuButton);
		}
		
		int k = 0;
		
		for(int i = j; i < orderListButton.size(); i++)
		{
			tableMenuListPanel.add( orderListButton.get(i) ).setBounds(3, (k * 27)+3, 194, 27);
			k++;
			if(k > 10)
				break;
		}
	}
	
	
	public void showFoodList()
	{	
		//foodListButton = new JButton[10];
		
		int j = getCurrentFoodIndex();
		
		Food food = null;
		
		foodListButton.clear();
		
		foodListPanel.removeAll();
		
		// addFoodButton setup
		foodListPanel.add(addFoodButton).setBounds(0, 0, 150, 30);
		//
		
		
		// delFoodButton setup setup
		foodListPanel.add(delFoodButton).setBounds(147, 0, 53, 30);
		//
		
		for(int i = 0; i < getData().getMenuList().size(); i++)
		{
			if(getData().getMenuList().get(i) instanceof Food)
			{
				food = (Food)getData().getMenuList().get(i);
				MenuButton foodButton = new MenuButton(food.getName() + "  " + food.getPrice() + "��");
				foodButton.setMenuName(food.getName());
				foodButton.setMenuPrice(food.getPrice());
				
				lineBorder = new LineBorder(Color.BLACK, 3);
				foodButton.setBackground(Color.WHITE);
				foodButton.setFont(new Font("���� ����", Font.BOLD, 16));
				//foodListButton[i].setBorder(lineBorder);
				foodButton.addActionListener(this);
				foodButton.addMouseListener(this);
				foodButton.addFocusListener(this);
				
				foodListButton.add(foodButton);
			}
		}
		
		int k = 0;
		
		for(int i = j; i < foodListButton.size(); i++)
		{
			foodListPanel.add( foodListButton.get(i) ).setBounds(3, 30 + (k * 27), 194, 27);
			k++;
			if(k > 9)
				break;
		}
	}
	
	public void showDrinkList()
	{
		int j = getCurrentDrinkIndex();
		
		Drink drink = null;
		
		drinkListButton.clear();
		
		drinkListPanel.removeAll();
		
		// addDrinkButton setup
		drinkListPanel.add(addDrinkButton).setBounds(0, 0, 150, 30);
		//
		
		// delDrinkButton setup
		drinkListPanel.add(delDrinkButton).setBounds(147, 0, 53, 30);
		//
		

		for(int i = 0; i < getData().getMenuList().size(); i++)
		{
			if(getData().getMenuList().get(i) instanceof Drink)
			{
				drink = (Drink)getData().getMenuList().get(i);
				MenuButton drinkButton = new MenuButton(drink.getName() + "  " + drink.getPrice() + "��");
				drinkButton.setMenuName(drink.getName());
				drinkButton.setMenuPrice(drink.getPrice());
				
				lineBorder = new LineBorder(Color.BLACK, 3);
				drinkButton.setBackground(Color.WHITE);
				drinkButton.setFont(new Font("���� ����", Font.BOLD, 16));
				//foodListButton[i].setBorder(lineBorder);
				drinkButton.addActionListener(this);
				drinkButton.addMouseListener(this);
				drinkButton.addFocusListener(this);
				
				drinkListButton.add(drinkButton);
			}
		}
		
		int k = 0;
		
		for(int i = j; i < drinkListButton.size(); i++)
		{
			drinkListPanel.add( drinkListButton.get(i) ).setBounds(3, 30 + (k * 27), 194, 27);
			k++;
			if(k > 9)
				break;
		}
	}

	public PosData getData() {
		return data;
	}

	public void setData(PosData data) {
		this.data = data;
	}


	public int getCurrentFoodIndex() {
		return currentFoodIndex;
	}


	public void setCurrentFoodIndex(int currentFood) {
		this.currentFoodIndex = currentFood;
	}


	public int getCurrentDrinkIndex() {
		return currentDrinkIndex;
	}


	public void setCurrentDrinkIndex(int currentDrink) {
		this.currentDrinkIndex = currentDrink;
	}

	
	public int getMenuType() {
		return menuType;
	}
	public void setMenuType(int menuType) {
		this.menuType = menuType;
	}


	public String getCurrentFoodName() {
		return currentFoodName;
	}
	public void setCurrentFoodName(String currentFoodName) {
		this.currentFoodName = currentFoodName;
	}


	public String getCurrentDrinkName() {
		return currentDrinkName;
	}


	public void setCurrentDrinkName(String currentDrinkName) {
		this.currentDrinkName = currentDrinkName;
	}

	public String getCurrentOrderName() {
		return currentOrderName;
	}

	public void setCurrentOrderName(String currentOrderName) {
		this.currentOrderName = currentOrderName;
	}

	public int getCurrentMenuType() {
		return currentMenuType;
	}

	public void setCurrentMenuType(int currentMenuType) {
		this.currentMenuType = currentMenuType;
	}

	public TableInnerPanel getTableInnerPanel() {
		return tableInnerPanel;
	}

	public void setTableInnerPanel(TableInnerPanel tableInnerPanel) {
		this.tableInnerPanel = tableInnerPanel;
	}

	public int getCurrentTableMenuIndex() {
		return currentTableMenuIndex;
	}

	public void setCurrentTableMenuIndex(int currentTableMenuIndex) {
		this.currentTableMenuIndex = currentTableMenuIndex;
	}

	
	
}
