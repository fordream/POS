package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
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
import model.Menu;
import model.PosData;
import model.Table;
import controler.AccountFileControler;

public class TableCalculatePage extends SimpleJFrame implements ActionListener, MouseListener, MouseWheelListener{

	private JLabel pageNameField;
	private JPanel orderListPanel;
	private LineBorder lineBorder;
	private JLabel totalLabel;
	private JButton calculateButton;
	private JButton escapeButton;
	private JButton cancelButton;
	private PosData data;
	
	private MenuInnerPanel menuInnerPanel;

	private int currentTableMenuIndex;
	
	private ArrayList<MenuButton> orderListButton;
	
	public PosData getData() {
		return data;
	}

	public void setData(PosData data) {
		this.data = data;
	}

	public TableCalculatePage(PosData data, MenuInnerPanel menuInnerPanel) {
		super("tableCalculate", 700, 500);
		
		setData(data);
		
		this.menuInnerPanel = menuInnerPanel;
		
		// show the total price in the table
		pageNameField = new JLabel();
		pageNameField.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 26));
		pageNameField.setForeground(Color.BLACK);
		pageNameField.setText("ÀÚ¸® °è»ê");
		pageNameField.setVisible(true);
		this.add(pageNameField).setBounds(50, 20, 200, 30);
				
				
		// show the orderlist in the table for the index
		orderListPanel = new JPanel();
		orderListPanel.setLayout(null);
		lineBorder = new LineBorder(Color.BLACK, 3);
		orderListPanel.setBackground(Color.WHITE);
		orderListPanel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		orderListPanel.setBorder(lineBorder);
		orderListPanel.addMouseListener(this);
		orderListPanel.addMouseWheelListener(this);
		this.add(orderListPanel).setBounds(50, 70, 280, 406);
		
		
		// show the total price in the table
		totalLabel = new JLabel();
		totalLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		totalLabel.setForeground(Color.RED);
		totalLabel.setText("Total : " + getData().getTableList().get(Table.getSelectedTable()).getTotalPrice() + " ¿ø");
		totalLabel.setVisible(true);
		this.add(totalLabel).setBounds(370, 120, 500, 50);
		
		
		// show buttons
		calculateButton = new JButton("°è  »ê");
		lineBorder = new LineBorder(Color.BLACK, 3);
		calculateButton.setBackground(Color.WHITE);
		calculateButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		calculateButton.setBorder(lineBorder);
		calculateButton.addActionListener(this);
		this.add(calculateButton).setBounds(370, 270, 270, 40);
		
		escapeButton = new JButton("Å»  ÁÖ");
		lineBorder = new LineBorder(Color.BLACK, 3);
		escapeButton.setBackground(Color.WHITE);
		escapeButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		escapeButton.setBorder(lineBorder);
		escapeButton.addActionListener(this);
		this.add(escapeButton).setBounds(370, 350, 270, 40);
		
		cancelButton = new JButton("Ãë  ¼Ò");
		lineBorder = new LineBorder(Color.BLACK, 3);
		cancelButton.setBackground(Color.WHITE);
		cancelButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		cancelButton.setBorder(lineBorder);
		cancelButton.addActionListener(this);
		this.add(cancelButton).setBounds(370, 430, 270, 40);
		
		orderListButton = new ArrayList<MenuButton>();
		
		showTableMenuList();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated orderListPanel stub
		if(e.getSource() == orderListPanel)
		{
			System.out.println("mouse entered the food menu list");
			orderListPanel.grabFocus();
		}
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == orderListPanel)
		{
			System.out.println("mouse exited from the food menu list");
			//foodListPanel.
		}
	}
	
	public void showTableMenuList()
	{
		int j = getCurrentTableMenuIndex();
		
		Menu menu = null;
		
		orderListButton.clear();
		
		orderListPanel.removeAll();
		
		for(int i = 0; i < getData().getTableList().get(Table.getSelectedTable()).getOrderList().size(); i++)
		{
			menu = getData().getTableList().get(Table.getSelectedTable()).getOrderList().get(i);
			
			JLabel name = new JLabel("  " + menu.getName());
			JLabel count = new JLabel("  " + menu.getCount() + " °³" + "(" + ( menu.getCount() * menu.getPrice()) + "¿ø)");
//			count.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			name.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
			count.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
			name.setFocusable(false);
			name.setBackground(Color.WHITE);
			count.setFocusable(false);
			count.setBackground(Color.WHITE);
			name.setBorder(null);
			count.setBorder(null);
			
			
			MenuButton menuButton = new MenuButton();
			menuButton.setLayout(null);
			menuButton.add(name);
			menuButton.add(count);
			menuButton.add(name).setBounds(1, 1, 150, 26);
			menuButton.add(count).setBounds(1, 15, 150, 26);
			menuButton.setMenuName(menu.getName());
			lineBorder = new LineBorder(Color.BLACK, 3);
			menuButton.setBorder(GUIdata.buttonBorder);
			menuButton.setBackground(Color.WHITE);
			menuButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
			
			menuButton.addActionListener(this);
			menuButton.addMouseListener(this);
			
			orderListButton.add(menuButton);
		}
		
		int k = 0;
		
		for(int i = j; i < orderListButton.size(); i++)
		{
			orderListPanel.add( orderListButton.get(i) ).setBounds(3, (k * 40)+3, 274, 40);
			k++;
			if(k > 9)
				break;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if ( e.getSource() == calculateButton)
		{
			// modify table boolean paid = true
			
			Account account = new Account(
					new Date(),
					data.getTableList().get(Table.getSelectedTable()), false);
			
			AccountFileControler accountFileControler = new AccountFileControler(account);
			
			System.out.println("dispose the table caluate frame");
			
			menuInnerPanel.resetMenuFromList();
			
			this.dispose();
		}
		
		
		if ( e.getSource() == escapeButton)
		{
			Account account = new Account(
					new Date(),
					data.getTableList().get(Table.getSelectedTable()), true);
			
			AccountFileControler accountFileControler = new AccountFileControler(account);
			
			System.out.println("dispose the table caluate frame");

			menuInnerPanel.resetMenuFromList();
			
			this.dispose();
		}
		
		
		if ( e.getSource() == cancelButton) {
			System.out.println("dispose the table caluate frame");
			
			this.dispose();
		}
		
			
	}
	

	public int getCurrentTableMenuIndex() {
		return currentTableMenuIndex;
	}

	public void setCurrentTableMenuIndex(int currentTableMenuIndex) {
		this.currentTableMenuIndex = currentTableMenuIndex;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {

		if(e.getWheelRotation() < 0)
		{
			if(e.getSource() == orderListPanel)
			{
				System.out.println("mouse wheel moved up in the food menu list");
				
				if(getCurrentTableMenuIndex() > 0)
				{
					setCurrentTableMenuIndex( getCurrentTableMenuIndex() - 1 );
				}
				
				showTableMenuList();
			}
		}
		else if(e.getWheelRotation() > 0)
		{
			if(e.getSource() == orderListPanel)
			{
				System.out.println("mouse wheel moved up in the food menu list");
				
				if(getCurrentTableMenuIndex() + 10 < getData().getTableList().get(Table.getSelectedTable()).getOrderList().size())
				{
					setCurrentTableMenuIndex( getCurrentTableMenuIndex() + 1 );
				}
				
				showTableMenuList();
			}
		}
	}
}
