package GUI;

import java.awt.Color;
import java.awt.ComponentOrientation;
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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import GUIData.GUIdata;
import controler.MenuControler;
import controler.PosFileControler;
import controler.TableControler;
import model.Drink;
import model.Food;
import model.PosData;
import model.Table;
import model.Menu;

public class MenuInnerPanel extends JPanel implements ActionListener,
		KeyListener, MouseListener, MouseWheelListener, FocusListener {
	private JFrame checkPage;
	
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
	
	private JButton ok;
	private JButton cancel;

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
	private TotalCalculatePage totalCalculatePage;
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

	public MenuInnerPanel(PosData data) {

		// this setup
		setData(data);
		// setCurrentTable(-1);
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
		this.setBorder(GUIdata.buttonBorder2);
		this.setBackground(GUIdata.tableInnerPanelColor);
		this.setBounds(860, 80, 500, 680);
		//

		// foodListPanel setup
		foodListPanel = new JPanel();
		lineBorder = new LineBorder(Color.BLACK, 3);
		foodListPanel.setLayout(null);
		foodListPanel.setBorder(GUIdata.buttonBorder2);
		foodListPanel.setBackground(Color.WHITE);
		foodListPanel.setFocusable(true);
		foodListPanel.addMouseListener(this);
		foodListPanel.addFocusListener(this);
		foodListPanel.addMouseWheelListener(this);
		this.add(foodListPanel).setBounds(20, 20, 200, 303);
		{
			// addFoodButton setup
			addFoodButton = new JButton(" À½½Ä Ãß°¡");
			lineBorder = new LineBorder(Color.WHITE, 3);
			addFoodButton.setBackground(GUIdata.buttonColor);
			addFoodButton.setForeground(Color.WHITE);
			addFoodButton.setOpaque(true);
			addFoodButton.setFocusPainted(false);
			addFoodButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
			addFoodButton.setBorder(GUIdata.buttonBorder2);
			addFoodButton.addActionListener(this);
			foodListPanel.add(addFoodButton).setBounds(0, 0, 150, 30);
			//

			// delFoodButton setup setup
			delFoodButton = new JButton(" Á¦°Å ");
			lineBorder = new LineBorder(Color.WHITE, 3);
			delFoodButton.setBackground(GUIdata.removeButtonColor);
			delFoodButton.setForeground(Color.WHITE);
			delFoodButton.setOpaque(true);
			delFoodButton.setFocusPainted(false);
			delFoodButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
			delFoodButton.setBorder(GUIdata.buttonBorder2);
			delFoodButton.addActionListener(this);
			foodListPanel.add(delFoodButton).setBounds(150, 0, 50, 30);
			//
		}
		//

		// drinkListPanel setup
		drinkListPanel = new JPanel();
		lineBorder = new LineBorder(Color.BLACK, 3);
		drinkListPanel.setLayout(null);
		drinkListPanel.setBorder(GUIdata.buttonBorder2);
		drinkListPanel.setBackground(Color.WHITE);
		drinkListPanel.setFocusable(true);
		drinkListPanel.addMouseListener(this);
		drinkListPanel.addFocusListener(this);
		drinkListPanel.addMouseWheelListener(this);
		this.add(drinkListPanel).setBounds(20, 347, 200, 303);
		{
			// addDrinkButton setup
			addDrinkButton = new JButton(" À½·á Ãß°¡");
			lineBorder = new LineBorder(Color.WHITE, 3);
			addDrinkButton.setBackground(GUIdata.buttonColor);
			addDrinkButton.setForeground(Color.WHITE);
			addDrinkButton.setOpaque(true);
			addDrinkButton.setFocusPainted(false);
			addDrinkButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
			addDrinkButton.setBorder(GUIdata.buttonBorder2);
			addDrinkButton.addActionListener(this);
			drinkListPanel.add(addDrinkButton).setBounds(0, 0, 150, 30);
			//

			// delDrinkButton setup
			delDrinkButton = new JButton(" Á¦°Å ");
			lineBorder = new LineBorder(Color.WHITE, 3);
			delDrinkButton.setBackground(GUIdata.removeButtonColor);
			delDrinkButton.setForeground(Color.WHITE);
			delDrinkButton.setOpaque(true);
			delDrinkButton.setFocusPainted(false);
			delDrinkButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
			delDrinkButton.setBorder(GUIdata.buttonBorder2);
			delDrinkButton.addActionListener(this);
			drinkListPanel.add(delDrinkButton).setBounds(150, 0, 50, 30);
			//
		}
		//

		// tableMenuListPanel setup
		tableMenuListPanel = new JPanel();
		lineBorder = new LineBorder(Color.BLACK, 3);
		tableMenuListPanel.setLayout(null);
		tableMenuListPanel.setBorder(GUIdata.buttonBorder2);
		tableMenuListPanel.setBackground(Color.WHITE);
		tableMenuListPanel.setFocusable(true);
		tableMenuListPanel.addMouseListener(this);
		tableMenuListPanel.addFocusListener(this);
		tableMenuListPanel.addMouseWheelListener(this);
		this.add(tableMenuListPanel).setBounds(280, 20, 200, 306);
		//

		// addMenuToListButton setup
		addMenuToListButton = new JButton();
		lineBorder = new LineBorder(Color.BLACK, 3);
		addMenuToListButton.setContentAreaFilled(false);
		addMenuToListButton.setIcon(new ImageIcon("img/plus_button.png"));
		addMenuToListButton.setPressedIcon(new ImageIcon(
				"img/plus_button_pressed.png"));
		addMenuToListButton.setBackground(null);
		addMenuToListButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		addMenuToListButton.setBorder(null);
		addMenuToListButton.setFocusPainted(false);
		addMenuToListButton.addActionListener(this);
		this.add(addMenuToListButton).setBounds(235, 70, 30, 30);
		//

		// subMenuFromListButton setup
		subMenuFromListButton = new JButton();
		lineBorder = new LineBorder(Color.BLACK, 3);
		subMenuFromListButton.setContentAreaFilled(false);
		subMenuFromListButton.setIcon(new ImageIcon("img/minus_button.png"));
		subMenuFromListButton.setPressedIcon(new ImageIcon(
				"img/minus_button_pressed.png"));
		subMenuFromListButton.setBackground(null);
		subMenuFromListButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		subMenuFromListButton.setBorder(null);
		subMenuFromListButton.setFocusPainted(false);
		subMenuFromListButton.addActionListener(this);
		this.add(subMenuFromListButton).setBounds(235, 120, 30, 30);
		//

		// delMenuFromListButton setup
		delMenuFromListButton = new JButton("del");
		lineBorder = new LineBorder(Color.GRAY, 2);
		delMenuFromListButton.setBackground(Color.WHITE);
		delMenuFromListButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		delMenuFromListButton.setBorder(lineBorder);
		delMenuFromListButton.setFocusPainted(false);
		delMenuFromListButton.addActionListener(this);
		this.add(delMenuFromListButton).setBounds(230, 170, 40, 30);
		//

		// resetMenuFromListButton setup
		resetMenuFromListButton = new JButton("reset");
		lineBorder = new LineBorder(Color.GRAY, 2);
		resetMenuFromListButton.setBackground(Color.WHITE);
		resetMenuFromListButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		resetMenuFromListButton.setBorder(lineBorder);
		resetMenuFromListButton.setFocusPainted(false);
		resetMenuFromListButton.addActionListener(this);
		this.add(resetMenuFromListButton).setBounds(230, 220, 40, 30);
		//

		// calcTableButton setup
		calcTableButton = new JButton(" ÀÚ¸® °è»ê ");
		lineBorder = new LineBorder(Color.GRAY, 2);
		calcTableButton.setBackground(Color.WHITE);
		calcTableButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		calcTableButton.setBorder(lineBorder);
		calcTableButton.addActionListener(this);
		this.add(calcTableButton).setBounds(280, 350, 200, 30);
		//

		// calcAllButton setup
		calcAllButton = new JButton(" Á¤ »ê ");
		lineBorder = new LineBorder(Color.GRAY, 2);
		calcAllButton.setBackground(Color.WHITE);
		calcAllButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		calcAllButton.setBorder(lineBorder);
		calcAllButton.addActionListener(this);
		this.add(calcAllButton).setBounds(280, 400, 200, 30);
		//

		// showTableMenuList();
		showFoodList();
		showDrinkList();
	}

	// ÁÖ¹® ³»¿ª À» º¸¿©ÁÖ´Â ÇÔ¼ö

	private Menu Menu(String name, int price) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * ============================ action listeners
	 * =====================================
	 */
	

    public void showCheckPage()
    {
            checkPage = new SimpleJFrame("CheckPage", 400, 300);

            lineBorder = new LineBorder(Color.BLACK, 3);

            checkPage.getRootPane().setBorder(lineBorder);
            checkPage.setAlwaysOnTop(true);

            JLabel textLabel = new JLabel("Á¤¸» ÃÊ±âÈ­ ÇÏ½Ã°Ú½À´Ï±î?");
            textLabel.setBackground(Color.WHITE);
            textLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
            textLabel.setBorder(null);

            ok = new JButton(" »è Á¦ ");
            ok.setBackground(Color.WHITE);
            ok.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
            ok.setBorder(lineBorder);
            ok.addActionListener(this);

            cancel = new JButton(" Ãë ¼Ò ");
            cancel.setBackground(Color.WHITE);
            cancel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
            cancel.setBorder(lineBorder);
            cancel.addActionListener(this);


            checkPage.add(ok).setBounds(50, 200, 100, 50);
            checkPage.add(cancel).setBounds(250, 200, 100, 50);
            checkPage.add(textLabel).setBounds(90, 90, 300, 50);
    }


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == menuTextField) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER
					|| e.getKeyCode() == KeyEvent.VK_DOWN) {
				priceTextField.grabFocus();
			} else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				POSPage.setOnAddMenuFrame(false);
				menuAddPage.dispose();
			}
		} else if (e.getSource() == priceTextField) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				menuTextField.grabFocus();
			} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				POSPage.setOnAddMenuFrame(false);
				addMenuconfirm();
			} else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				POSPage.setOnAddMenuFrame(false);
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
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == ok)
		{
			System.out.println("Reset order" + " " + getCurrentOrderName());
			Table table = getData().getTableList().get(Table.getSelectedTable());

			tableControler.resetOrder(table);

			setData(tableControler.getData());
			showTableMenuList();
			repaint();
			getTableInnerPanel().getTableListPanel().repaintTable();
			POSPage.setOnResetFrame(false);
			checkPage.dispose();
		}
		
		if(e.getSource() == cancel)
		{
			POSPage.setOnResetFrame(false);
			checkPage.dispose();
		}
		
		if (e.getSource() == addFoodButton) {
			if (POSPage.isOnAddMenuFrame() == false) {
				POSPage.setOnAddMenuFrame(true);
				addFoodToMenu();
			}
		} else if (e.getSource() == addDrinkButton) {
			if(POSPage.isOnAddMenuFrame() == false)
			{
				POSPage.setOnAddMenuFrame(true);
				addDrinkToMenu();
			}
		} else if (e.getSource() == calcTableButton) {
			if(POSPage.isOnTableCalculateFrame() == false)
			{
				if (Table.getSelectedTable() > -1)
				{
					POSPage.setOnTableCalculateFrame(true);
					tableCalculate = new TableCalculatePage(getData(), this);
					tableCalculate.setAlwaysOnTop(true);
				}
			}
		} else if (e.getSource() == enterButton) {
			POSPage.setOnAddMenuFrame(false);
			addMenuconfirm();
		} else if (e.getSource() == exitButton) {
			System.out.println("Exit button clicked on the menu add page");
			POSPage.setOnAddMenuFrame(false);
			menuAddPage.dispose();
		}

		if (e.getSource() == delFoodButton) {
			MenuControler mcon = new MenuControler(getData());

			Food keyFood = new Food(getCurrentFoodName(), 0);

			mcon.deleteMenu(keyFood);

			setData(mcon.getData());

			for (int i = 0; i < foodListButton.size(); i++) {
				System.out.println("Number of Button of Menu : "
						+ foodListButton.size());
				System.out.println("current i is : " + i);
				System.out.println("foodListButton.get(i).getText()  : "
						+ foodListButton.get(i).getText());

				if (foodListButton.get(i).getText()
						.equals(getCurrentFoodName())) {
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

		if (e.getSource() == calcAllButton) {
			if(POSPage.isOnTotalCalculateFrame() == false)
			{
				POSPage.setOnTotalCalculateFrame(true);
				totalCalculatePage =new TotalCalculatePage();
				totalCalculatePage.setAlwaysOnTop(true);
			}
		}

		if (e.getSource() == delDrinkButton) {
			MenuControler mcon = new MenuControler(getData());

			Drink keyDrink = new Drink(getCurrentDrinkName(), 0);

			mcon.deleteMenu(keyDrink);

			setData(mcon.getData());

			for (int i = 0; i < drinkListButton.size(); i++) {
				System.out.println("Number of Button of Menu : "
						+ drinkListButton.size());
				System.out.println("current i is : " + i);
				System.out.println("drinkListButton.get(i).getText()  : "
						+ drinkListButton.get(i).getText());

				if (drinkListButton.get(i).getText()
						.equals(getCurrentDrinkName())) {
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

		for (int i = 0; i < foodListButton.size(); i++) {
			if (e.getSource() == foodListButton.get(i)) {
				setCurrentFoodName(foodListButton.get(i).getMenuName());
				setCurrentMenuType(0);
				showDrinkList();
				showFoodList();
				showTableMenuList();

			}
		}
		for (int i = 0; i < drinkListButton.size(); i++) {
			if (e.getSource() == drinkListButton.get(i)) {
				setCurrentDrinkName(drinkListButton.get(i).getMenuName());
				setCurrentMenuType(1);
				showDrinkList();
				showFoodList();
				showTableMenuList();
			}
		}

		// ¿À´õ¸®½ºÆ® º¸ÀÌ±â
		for (int i = 0; i < orderListButton.size(); i++) {
			if (e.getSource() == orderListButton.get(i)) {
				System.out.println(orderListButton.get(i).getMenuName());
				setCurrentOrderName(orderListButton.get(i).getMenuName());
				setCurrentMenuType(2);
				showDrinkList();
				showFoodList();
				showTableMenuList();
			}
		}

		// /// Âù¿µ º¯°æ ¿À´õ¸®½ºÆ® Ãß°¡ ±â´É
		/*
		 * addMenuToListButton; subMenuFromListButton; delMenuFromListButton;
		 * resetMenuFromListButton;
		 */

		if (e.getSource() == addMenuToListButton && POSPage.isOnTableCalculateFrame() == false) {

			System.out.println("" + Table.getSelectedTable() + " "
					+ getCurrentMenuType());
			if (getCurrentMenuType() == FOOD) {
				Table table = getData().getTableList().get(
						Table.getSelectedTable());
				Food food = new Food(getData().getMenuList()
						.get(menuControler.searchMenu(getCurrentFoodName()))
						.getName(), getData().getMenuList()
						.get(menuControler.searchMenu(getCurrentFoodName()))
						.getPrice()); // getData().getMenuList().get(menuControler.searchMenu(getCurrentFoodName()));

				tableControler.addOrder(table, food);
			} else if (getCurrentMenuType() == DRINK) {
				Table table = getData().getTableList().get(
						Table.getSelectedTable());
				Drink drink = new Drink(getData().getMenuList()
						.get(menuControler.searchMenu(getCurrentDrinkName()))
						.getName(), getData().getMenuList()
						.get(menuControler.searchMenu(getCurrentDrinkName()))
						.getPrice()); // getData().getMenuList().get(menuControler.searchMenu(getCurrentFoodName()));

				tableControler.addOrder(table, drink);
			}

			for (int i = 0; i < getData().getTableList().size(); i++) {
				System.out.println(i + " : ");
				for (int j = 0; j < getData().getTableList().get(i)
						.getOrderList().size(); j++) {
					System.out.println(getData().getTableList().get(i)
							.getOrderList().get(j).getName()
							+ "  "
							+ getData().getTableList().get(i).getOrderList()
									.get(j).getCount()
							+ "  "
							+ getData().getTableList().get(i).getTotalPrice());
				}
			}

			setData(tableControler.getData());
			showTableMenuList();
			getTableInnerPanel().getTableListPanel().repaintTable();

		}

		if (e.getSource() == subMenuFromListButton && POSPage.isOnTableCalculateFrame() == false) {
			if (getCurrentMenuType() == ORDER) {
				System.out.println("Subtract order" + " "
						+ getCurrentOrderName());

				Table table = getData().getTableList().get(
						Table.getSelectedTable());

				System.out.println("¸Þ´ºÀÌ¸§" + getCurrentOrderName());
				tableControler.subOrder(table, getCurrentOrderName());
			}

			setData(tableControler.getData());
			showTableMenuList();
			repaint();
			getTableInnerPanel().getTableListPanel().repaintTable();
		}

		if (e.getSource() == delMenuFromListButton && POSPage.isOnTableCalculateFrame() == false) {
			if (getCurrentMenuType() == ORDER) {
				System.out
						.println("Delete order" + " " + getCurrentOrderName());
				Table table = getData().getTableList().get(
						Table.getSelectedTable());

				System.out.println("¸Þ´ºÀÌ¸§" + getCurrentOrderName());
				tableControler.deleteOrder(table, getCurrentOrderName());

			}
			setData(tableControler.getData());
			showTableMenuList();
			repaint();
			getTableInnerPanel().getTableListPanel().repaintTable();
		}
		if (e.getSource() == resetMenuFromListButton && POSPage.isOnTableCalculateFrame() == false) {
			resetMenuFromList();
		}
	}

	public void resetMenuFromList() {
		if(POSPage.isOnResetFrame() == false)
		{
			POSPage.setOnResetFrame(true);
			showCheckPage();
		}
	}

	public void delMenuFromList() {

	}

	public void subMenuFromList() {

	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		if (e.getWheelRotation() < 0) {
			if (e.getSource() == foodListPanel) {
				System.out
						.println("mouse wheel moved up in the food menu list");

				if (getCurrentFoodIndex() > 0) {
					setCurrentFoodIndex(getCurrentFoodIndex() - 1);
				}

				showFoodList();
			} else if (e.getSource() == drinkListPanel) {
				System.out
						.println("mouse  wheel moved up in the drink menu list");

				if (getCurrentDrinkIndex() > 0) {
					setCurrentDrinkIndex(getCurrentDrinkIndex() - 1);
				}

				showDrinkList();

			} else if (e.getSource() == tableMenuListPanel) {
				System.out
						.println("mouse  wheel moved up in the table menu list");

				if (getCurrentTableMenuIndex() > 0) {
					setCurrentTableMenuIndex(getCurrentTableMenuIndex() - 1);
				}

				showTableMenuList();
			}
		} else if (e.getWheelRotation() > 0) {
			if (e.getSource() == foodListPanel) {
				System.out
						.println("mouse wheel moved down in the food menu list");

				if (getCurrentFoodIndex() + 5 < foodListButton.size()) {
					setCurrentFoodIndex(getCurrentFoodIndex() + 1);
				}

				showFoodList();
			} else if (e.getSource() == drinkListPanel) {
				System.out
						.println("mouse  wheel moved down in the drink menu list");

				if (getCurrentDrinkIndex() + 5 < drinkListButton.size()) {
					setCurrentDrinkIndex(getCurrentDrinkIndex() + 1);
				}

				showDrinkList();

			} else if (e.getSource() == tableMenuListPanel) {
				System.out
						.println("mouse  wheel moved down in the table menu list");

				if (getCurrentTableMenuIndex() + 6 < orderListButton.size()) {
					setCurrentTableMenuIndex(getCurrentTableMenuIndex() + 1);
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
		if (e.getSource() == foodListPanel) {
			// System.out.println("mouse entered the food menu list");
			foodListPanel.grabFocus();
		} else if (e.getSource() == drinkListPanel) {
			// System.out.println("mouse entered the drink menu list");
			drinkListPanel.grabFocus();
		} else if (e.getSource() == tableMenuListPanel) {
			// System.out.println("mouse entered the table menu list");
			tableMenuListPanel.grabFocus();
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == foodListPanel) {
			// System.out.println("mouse exited from the food menu list");
			// foodListPanel.
		} else if (e.getSource() == drinkListPanel) {
			// System.out.println("mouse exited from the drink menu list");
			// drinkListPanel
		} else if (e.getSource() == tableMenuListPanel) {
			// System.out.println("mouse exited from the table menu list");
			// tableMenuListPanel
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
		// System.out.println("get focus");
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	/*
	 * ==========================================================================
	 * =====================================
	 */

	public void addMenuconfirm() {
		System.out.println("Enter button clicked on the menu add page");

		String newMenuName = menuTextField.getText();

		int newMenuPrice = Integer.parseInt(priceTextField.getText());

		if (getMenuType() == FOOD) {
			Food food = new Food(newMenuName, newMenuPrice);

			MenuControler MCon = new MenuControler(getData());

			if (MCon.searchMenu(food.getName()) != -1) {
				if (getData().getMenuList()
						.get(MCon.searchMenu(food.getName())) instanceof Drink) {
					JOptionPane.showMessageDialog(this,
							"Á¾·ù°¡ ´Ù¸¥ °°Àº ÀÌ¸§ÀÇ ¸Þ´º°¡ Á¸ÀçÇÕ´Ï´Ù! ¼öÁ¤ÀÌ ºÒ°¡´ÉÇÕ´Ï´Ù!");
					return;
				}
			}

			MCon.addMenu(food);
			setData(MCon.getData());

			MenuButton foodButton = new MenuButton(food.getName() + "  "
					+ food.getPrice() + "¿ø");

			lineBorder = new LineBorder(Color.BLACK, 3);
			foodButton.setBackground(Color.WHITE);
			foodButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
			// foodListButton[i].setBorder(lineBorder);
			foodButton.addActionListener(this);
			foodButton.addMouseListener(this);
			foodButton.addFocusListener(this);

			foodListButton.add(foodButton);

			showFoodList();
		} else if (getMenuType() == DRINK) {
			Drink drink = new Drink(newMenuName, newMenuPrice);

			MenuControler MCon = new MenuControler(getData());

			if (MCon.searchMenu(drink.getName()) != -1) {
				if (getData().getMenuList().get(
						MCon.searchMenu(drink.getName())) instanceof Food) {
					JOptionPane.showMessageDialog(this,
							"Á¾·ù°¡ ´Ù¸¥ °°Àº ÀÌ¸§ÀÇ ¸Þ´º°¡ Á¸ÀçÇÕ´Ï´Ù! ¼öÁ¤ÀÌ ºÒ°¡´ÉÇÕ´Ï´Ù!");
					return;
				}
			}

			MCon.addMenu(drink);
			setData(MCon.getData());

			MenuButton drinkButton = new MenuButton(drink.getName() + "  "
					+ drink.getPrice() + "¿ø");

			lineBorder = new LineBorder(Color.BLACK, 3);
			drinkButton.setBackground(Color.WHITE);
			drinkButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
			// foodListButton[i].setBorder(lineBorder);
			drinkButton.addActionListener(this);
			drinkButton.addMouseListener(this);
			drinkButton.addFocusListener(this);

			drinkListButton.add(drinkButton);

			showDrinkList();
		}

		// ÀúÀå
		PosFileControler posFileControler = new PosFileControler(getData());
		posFileControler.writeToFile();

		menuAddPage.dispose();
	}

	public void addFoodToMenu() {
		menuAddPage = new MenuAddPage(getData(), MenuAddPage.FOOD);
		menuAddPage.setAlwaysOnTop(true);

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

	public void addDrinkToMenu() {
		menuAddPage = new MenuAddPage(getData(), MenuAddPage.DRINK);
		menuAddPage.setAlwaysOnTop(true);
		
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

	public void showTableMenuList() {
		int j = getCurrentTableMenuIndex();

		Menu menu = null;

		orderListButton.clear();

		tableMenuListPanel.removeAll();

		for (int i = 0; i < getData().getTableList()
				.get(Table.getSelectedTable()).getOrderList().size(); i++) {
			menu = getData().getTableList().get(Table.getSelectedTable())
					.getOrderList().get(i);

			JLabel name = new JLabel("  " + menu.getName());
			JLabel count = new JLabel("  " + menu.getCount() + " °³" + "("
					+ (menu.getCount() * menu.getPrice()) + "¿ø)");
			// count.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			name.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
			count.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
			name.setFocusable(false);
			name.setBackground(Color.WHITE);
			name.setBorder(null);
			count.setFocusable(false);
			count.setBackground(Color.WHITE);
			count.setBorder(null);

			MenuButton menuButton = new MenuButton();
			menuButton.setLayout(null);
			menuButton.add(name);
			menuButton.add(count);
			menuButton.add(name).setBounds(1, 1, 150, 26);
			menuButton.add(count).setBounds(1, 20, 150, 26);
			menuButton.setMenuName(menu.getName());
			menuButton.setBorder(GUIdata.buttonBorder);
			menuButton.setBackground(Color.WHITE);
			menuButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
			menuButton.setOpaque(true);

			menuButton.addActionListener(this);
			menuButton.addMouseListener(this);

			orderListButton.add(menuButton);
		}

		int k = 0;

		for (int i = j; i < orderListButton.size(); i++) {
			if (orderListButton.get(i).getMenuName()
					.equals(getCurrentOrderName())
					&& getCurrentMenuType() == ORDER)
				orderListButton.get(i).setBackground(new Color(200, 255, 200));

			tableMenuListPanel.add(orderListButton.get(i)).setBounds(3,
					(k * 50) + 3, 194, 50);
			k++;
			if (k > 5)
				break;
		}
		tableMenuListPanel.repaint();
	}

	public void showFoodList() {
		// foodListButton = new JButton[10];

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

		for (int i = 0; i < getData().getMenuList().size(); i++) {
			if (getData().getMenuList().get(i) instanceof Food) {
				food = (Food) getData().getMenuList().get(i);

				JLabel name = new JLabel("  " + food.getName());
				JLabel count = new JLabel("  " + food.getPrice() + " ¿ø");
				// count.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				name.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
				count.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
				name.setFocusable(false);
				name.setBackground(Color.WHITE);
				count.setFocusable(false);
				count.setBackground(Color.WHITE);
				name.setBorder(null);
				count.setBorder(null);

				MenuButton foodButton = new MenuButton();
				foodButton.setLayout(null);
				foodButton.add(name).setBounds(1, 1, 150, 26);
				foodButton.add(count).setBounds(1, 25, 150, 26);
				foodButton.setMenuName(food.getName());
				foodButton.setMenuPrice(food.getPrice());

				foodButton.setBorder(GUIdata.buttonBorder);
				System.out.println("Current Food Index : "
						+ getCurrentFoodName() + "  " + i);
				foodButton.setBackground(Color.WHITE);
				foodButton.setOpaque(true);
				foodButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
				// foodListButton[i].setBorder(lineBorder);
				foodButton.addActionListener(this);
				foodButton.addMouseListener(this);
				foodButton.addFocusListener(this);

				foodListButton.add(foodButton);
			}
		}

		int k = 0;

		for (int i = j; i < foodListButton.size(); i++) {
			if (foodListButton.get(i).getMenuName()
					.equals(getCurrentFoodName())
					&& getCurrentMenuType() == FOOD)
				foodListButton.get(i).setBackground(new Color(200, 255, 200));

			foodListPanel.add(foodListButton.get(i)).setBounds(3,
					30 + (k * 54), 194, 54);
			k++;
			if (k > 4)
				break;
		}

		foodListPanel.repaint();
	}

	public void showDrinkList() {
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

		for (int i = 0; i < getData().getMenuList().size(); i++) {
			if (getData().getMenuList().get(i) instanceof Drink) {
				drink = (Drink) getData().getMenuList().get(i);

				JLabel name = new JLabel("  " + drink.getName());
				JLabel count = new JLabel("  " + drink.getPrice() + " ¿ø");
				// count.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				name.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
				count.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
				name.setFocusable(false);
				name.setBackground(Color.WHITE);
				count.setFocusable(false);
				count.setBackground(Color.WHITE);
				name.setBorder(null);
				count.setBorder(null);

				MenuButton drinkButton = new MenuButton();
				drinkButton.setLayout(null);
				drinkButton.add(name).setBounds(1, 1, 150, 26);
				drinkButton.add(count).setBounds(1, 25, 150, 26);
				drinkButton.setMenuName(drink.getName());
				drinkButton.setMenuPrice(drink.getPrice());

				drinkButton.setBorder(GUIdata.buttonBorder);
				System.out.println("Current Drink Index : "
						+ getCurrentDrinkName() + "  " + i);
				drinkButton.setBackground(Color.WHITE);
				drinkButton.setOpaque(true);
				drinkButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
				// foodListButton[i].setBorder(lineBorder);
				drinkButton.addActionListener(this);
				drinkButton.addMouseListener(this);
				drinkButton.addFocusListener(this);

				drinkListButton.add(drinkButton);
			}
		}

		int k = 0;

		for (int i = j; i < drinkListButton.size(); i++) {
			if (drinkListButton.get(i).getMenuName()
					.equals(getCurrentDrinkName())
					&& getCurrentMenuType() == DRINK)
				drinkListButton.get(i).setBackground(new Color(200, 255, 200));

			drinkListPanel.add(drinkListButton.get(i)).setBounds(3,
					30 + (k * 54), 194, 54);
			k++;
			if (k > 4)
				break;
		}

		drinkListPanel.repaint();
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