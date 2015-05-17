package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.sun.glass.ui.Menu;

import controler.MenuControler;
import controler.PosFileControler;
import model.Drink;
import model.Food;
import model.PosData;

public class MenuInnerPanel extends JPanel implements ActionListener, KeyListener, MouseListener, MouseWheelListener{

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
	
	private ArrayList<JButton> foodListButton;
	private ArrayList<JButton> drinkListButton;
	
	// for MenuAddPage
	private JTextField menuTextField;
	private JTextField priceTextField;
	private JButton enterButton;
	private JButton exitButton;
	private int menuType; // 0 : Food, 1: Drink
	final static int FOOD = 0;
	final static int DRINK = 1;
	//
	
	
	private TableCalculatePage tableCalculate;
	private MenuAddPage menuAddPage;
	
	private PosData data;
	private int currentTable;
	private int currentFood;
	private int currentDrink;
	private String currentFoodName;
	private String currentDrinkName;
	
	
	public MenuInnerPanel(PosData data)
	{
		
		// this setup
		setData(data);
		//setCurrentTable(-1);
		setCurrentFood(0);
		setCurrentDrink(0);
		
		foodListButton = new ArrayList<JButton>();
		drinkListButton = new ArrayList<JButton>();
		
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
		this.add(foodListPanel).setBounds(20, 20, 200, 303);
		{
			// addFoodButton setup
			addFoodButton = new JButton(" À½½Ä Ãß°¡");
			lineBorder = new LineBorder(Color.BLACK, 3);
			addFoodButton.setBackground(Color.WHITE);
			addFoodButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
			addFoodButton.setBorder(lineBorder);
			addFoodButton.addActionListener(this);
			foodListPanel.add(addFoodButton).setBounds(0, 0, 150, 30);
			//
			
			
			// delFoodButton setup setup
			delFoodButton = new JButton(" Á¦°Å ");
			lineBorder = new LineBorder(Color.BLACK, 3);
			delFoodButton.setBackground(Color.WHITE);
			delFoodButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
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
		this.add(drinkListPanel).setBounds(20, 347, 200, 303);
		{
			// addDrinkButton setup
			addDrinkButton = new JButton(" À½·á Ãß°¡");
			lineBorder = new LineBorder(Color.BLACK, 3);
			addDrinkButton.setBackground(Color.WHITE);
			addDrinkButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
			addDrinkButton.setBorder(lineBorder);
			addDrinkButton.addActionListener(this);
			drinkListPanel.add(addDrinkButton).setBounds(0, 0, 150, 30);
			//
			
			
			// delDrinkButton setup
			delDrinkButton = new JButton(" Á¦°Å ");
			lineBorder = new LineBorder(Color.BLACK, 3);
			delDrinkButton.setBackground(Color.WHITE);
			delDrinkButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
			delDrinkButton.setBorder(lineBorder);
			delDrinkButton.addActionListener(this);
			drinkListPanel.add(delDrinkButton).setBounds(147, 0, 53, 30);
			//
		}
		//
		
		for(int i = 0; i < getData().getMenuList().size(); i++)
		{
			if(getData().getMenuList().get(i) instanceof Food)
			{
				Food food = (Food)getData().getMenuList().get(i);
				
				JButton foodButton = new JButton(food.getName());
				
				lineBorder = new LineBorder(Color.BLACK, 3);
				foodButton.setBackground(Color.WHITE);
				foodButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
				//foodListButton[i].setBorder(lineBorder);
				foodButton.addActionListener(this);
				
				foodListButton.add(foodButton);
			}
			else
			{
				Drink drink = (Drink)getData().getMenuList().get(i);
				
				JButton drinkButton = new JButton(drink.getName());
				
				lineBorder = new LineBorder(Color.BLACK, 3);
				drinkButton.setBackground(Color.WHITE);
				drinkButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
				//foodListButton[i].setBorder(lineBorder);
				drinkButton.addActionListener(this);
				
				drinkListButton.add(drinkButton);
			}
		}
		
		
		
		// tableMenuListPanel setup
		tableMenuListPanel = new JPanel();
		lineBorder = new LineBorder(Color.BLACK, 3);
		tableMenuListPanel.setBorder(lineBorder);
		tableMenuListPanel.setBackground(Color.WHITE);
		this.add(tableMenuListPanel).setBounds(280, 20, 200, 300);
		//
		
		
		// addMenuToListButton setup
		addMenuToListButton = new JButton(" + ");
		lineBorder = new LineBorder(Color.BLACK, 3);
		addMenuToListButton.setBackground(Color.WHITE);
		addMenuToListButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		addMenuToListButton.setBorder(lineBorder);
		addMenuToListButton.addActionListener(this);
		this.add(addMenuToListButton).setBounds(230, 70, 40, 30);
		//
		
		
		// subMenuFromListButton setup
		subMenuFromListButton = new JButton(" - ");
		lineBorder = new LineBorder(Color.BLACK, 3);
		subMenuFromListButton.setBackground(Color.WHITE);
		subMenuFromListButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		subMenuFromListButton.setBorder(lineBorder);
		subMenuFromListButton.addActionListener(this);
		this.add(subMenuFromListButton).setBounds(230, 120, 40, 30);
		//
		
		
		// delMenuFromListButton setup
		delMenuFromListButton = new JButton("del");
		lineBorder = new LineBorder(Color.BLACK, 3);
		delMenuFromListButton.setBackground(Color.WHITE);
		delMenuFromListButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		delMenuFromListButton.setBorder(lineBorder);
		delMenuFromListButton.addActionListener(this);
		this.add(delMenuFromListButton).setBounds(230, 170, 40, 30);
		//
		
		
		// resetMenuFromListButton setup
		resetMenuFromListButton = new JButton("reset");
		lineBorder = new LineBorder(Color.BLACK, 3);
		resetMenuFromListButton.setBackground(Color.WHITE);
		resetMenuFromListButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		resetMenuFromListButton.setBorder(lineBorder);
		resetMenuFromListButton.addActionListener(this);
		this.add(resetMenuFromListButton).setBounds(230, 220, 40, 30);
		//
		
		
		// calcTableButton setup
		calcTableButton = new JButton(" ÀÚ¸® °è»ê ");
		lineBorder = new LineBorder(Color.BLACK, 3);
		calcTableButton.setBackground(Color.WHITE);
		calcTableButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		calcTableButton.setBorder(lineBorder);
		calcTableButton.addActionListener(this);
		this.add(calcTableButton).setBounds(280, 350, 200, 30);
		//
		
		
		// calcAllButton setup
		calcAllButton = new JButton(" Á¤ »ê ");
		lineBorder = new LineBorder(Color.BLACK, 3);
		calcAllButton.setBackground(Color.WHITE);
		calcAllButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		calcAllButton.setBorder(lineBorder);
		calcAllButton.addActionListener(this);
		this.add(calcAllButton).setBounds(280, 400, 200, 30);
		//
		
		showFoodList();
		showDrinkList();
	}
	
	
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
			tableCalculate = new TableCalculatePage( getData(), getCurrentTable() );
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
			
			// ÀúÀå 
			PosFileControler posFileControler = new PosFileControler(getData());
			posFileControler.writeToFile();
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
			
			// ÀúÀå 
			PosFileControler posFileControler = new PosFileControler(getData());
			posFileControler.writeToFile();
		}
		
		for(int i = 0; i < foodListButton.size(); i++)
		{
			if(e.getSource() == foodListButton.get(i) )
			{
				setCurrentFoodName(foodListButton.get(i).getText());
			}
		}
		for(int i = 0; i < drinkListButton.size(); i++)
		{
			if(e.getSource() == drinkListButton.get(i) )
			{
				setCurrentDrinkName(drinkListButton.get(i).getText());
			}
		}
	}

	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	public void addMenuconfirm()
	{
		System.out.println("Enter button clicked on the menu add page");
		
		String newMenuName = menuTextField.getText();
		
		int newMenuPrice = Integer.parseInt( priceTextField.getText() );
		
		if(getMenuType() == FOOD)
		{
			Food food = new Food(newMenuName, newMenuPrice);
			
			MenuControler MCon = new MenuControler( getData() );
			MCon.addMenu( food );
			setData( MCon.getData() );
			
			JButton foodButton = new JButton(food.getName());
			
			lineBorder = new LineBorder(Color.BLACK, 3);
			foodButton.setBackground(Color.WHITE);
			foodButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
			//foodListButton[i].setBorder(lineBorder);
			foodButton.addActionListener(this);
			
			foodListButton.add(foodButton);
			
			showFoodList();
		}
		else if(getMenuType() == DRINK)
		{
			Drink drink = new Drink(newMenuName, newMenuPrice);
			
			MenuControler MCon = new MenuControler( getData() );
			MCon.addMenu( drink );
			setData( MCon.getData() );
			
			
			JButton drinkButton = new JButton(drink.getName());
			
			lineBorder = new LineBorder(Color.BLACK, 3);
			drinkButton.setBackground(Color.WHITE);
			drinkButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
			//foodListButton[i].setBorder(lineBorder);
			drinkButton.addActionListener(this);
			
			drinkListButton.add(drinkButton);
			
			
			showDrinkList();
		}
		
		// ÀúÀå 
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
		menuTextField.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		menuTextField.setBorder(lineBorder);
		menuTextField.addKeyListener(this);
		menuAddPage.add(menuTextField).setBounds(75, 150, 270, 30);
		//
		// priceTextFiedl setup
		priceTextField = new JTextField();
		lineBorder = new LineBorder(Color.BLACK, 3);
		priceTextField.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		priceTextField.setBorder(lineBorder);
		priceTextField.addKeyListener(this);
		menuAddPage.add(priceTextField).setBounds(75, 200, 270, 30);
		//
		// enter button setup
		enterButton = new JButton(" È®ÀÎ ");
		lineBorder = new LineBorder(Color.BLACK, 3);
		enterButton.setBackground(Color.WHITE);
		enterButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		enterButton.setBorder(lineBorder);
		enterButton.addActionListener(this);
		menuAddPage.add(enterButton).setBounds(90, 250, 80, 30);
		//
		// exit button setup
		exitButton = new JButton(" Ãë ¼Ò ");
		lineBorder = new LineBorder(Color.BLACK, 3);
		exitButton.setBackground(Color.WHITE);
		exitButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
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
		menuTextField.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		menuTextField.setBorder(lineBorder);
		menuTextField.addKeyListener(this);
		menuAddPage.add(menuTextField).setBounds(75, 150, 270, 30);
		//
		// priceTextFiedl setup
		priceTextField = new JTextField();
		lineBorder = new LineBorder(Color.BLACK, 3);
		priceTextField.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		priceTextField.setBorder(lineBorder);
		priceTextField.addKeyListener(this);
		menuAddPage.add(priceTextField).setBounds(75, 200, 270, 30);
		//
		// enter button setup
		enterButton = new JButton(" È®ÀÎ ");
		lineBorder = new LineBorder(Color.BLACK, 3);
		enterButton.setBackground(Color.WHITE);
		enterButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		enterButton.setBorder(lineBorder);
		enterButton.addActionListener(this);
		menuAddPage.add(enterButton).setBounds(90, 250, 80, 30);
		//
		// exit button setup
		exitButton = new JButton(" Ãë ¼Ò ");
		lineBorder = new LineBorder(Color.BLACK, 3);
		exitButton.setBackground(Color.WHITE);
		exitButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		exitButton.setBorder(lineBorder);
		exitButton.addActionListener(this);
		menuAddPage.add(exitButton).setBounds(230, 250, 80, 30);
		//
		
		setMenuType(DRINK);
	}
	
	public void showFoodList()
	{	
		//foodListButton = new JButton[10];
		
		int j = getCurrentFood();
		
		Food food = null;
		
		foodListPanel.removeAll();
		
		// addFoodButton setup
		foodListPanel.add(addFoodButton).setBounds(0, 0, 150, 30);
		//
		
		
		// delFoodButton setup setup
		foodListPanel.add(delFoodButton).setBounds(147, 0, 53, 30);
		//
		
		for(int i = 0; i < foodListButton.size(); i++)
		{
			foodListPanel.add( foodListButton.get(i) ).setBounds(3, 30 + (i * 27), 194, 27);
		}
	}
	
	public void showDrinkList()
	{
		int j = getCurrentFood();
		
		Drink drink = null;
		
		drinkListPanel.removeAll();
		
		// addDrinkButton setup
		drinkListPanel.add(addDrinkButton).setBounds(0, 0, 150, 30);
		//
		
		// delDrinkButton setup
		drinkListPanel.add(delDrinkButton).setBounds(147, 0, 53, 30);
		//
		
		for(int i = 0; i < drinkListButton.size(); i++)
		{
			drinkListPanel.add( drinkListButton.get(i) ).setBounds(3, 30 + (i * 27), 194, 27);
		}
	}

	public PosData getData() {
		return data;
	}

	public void setData(PosData data) {
		this.data = data;
	}


	public int getCurrentTable() {
		return currentTable;
	}


	public void setCurrentTable(int currentTable) {
		this.currentTable = currentTable;
	}


	public int getCurrentFood() {
		return currentFood;
	}


	public void setCurrentFood(int currentFood) {
		this.currentFood = currentFood;
	}


	public int getCurrentDrink() {
		return currentDrink;
	}


	public void setCurrentDrink(int currentDrink) {
		this.currentDrink = currentDrink;
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
	
}
