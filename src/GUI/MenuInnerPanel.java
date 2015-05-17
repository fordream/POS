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

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

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
	
	private JButton[] foodListButton;
	private JButton[] drinkListButton;
	
	
	private TableCalculatePage tableCalculate;
	
	
	private PosData data;
	private int currentTable;
	
	
	public MenuInnerPanel(PosData data)
	{
		
		// this setup
		setData(data);
		setCurrentTable(-1);
		
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
		this.add(foodListPanel).setBounds(20, 20, 200, 300);
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
		this.add(drinkListPanel).setBounds(20, 317, 200, 300);
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
	}
	
	
	public void showFoodList()
	{
		
	}
	
	public void showDrinkList()
	{
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		if(e.getSource() == addFoodButton)
		{
			MenuAddPage menuAddPage = new MenuAddPage( getData() );
			
		}
		else if(e.getSource() == addDrinkButton)
		{
			MenuAddPage menuAddPage = new MenuAddPage( getData() );
		}
		else if(e.getSource() == calcTableButton)
		{
			tableCalculate = new TableCalculatePage( getData(), getCurrentTable() );
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
	
}
