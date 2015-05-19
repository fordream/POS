package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import controler.MenuControler;
import model.Drink;
import model.Food;
import model.Menu;
import model.PosData;

public class MenuAddPage extends SimpleJFrame implements ActionListener, KeyListener{

	private PosData data;
	
	private int menuType; // 0 : Food, 1: Drink
	final static int FOOD = 0;
	final static int DRINK = 1;
	
	private LineBorder lineBorder;
	
	private JLabel menuAddLabel;
	private JLabel menuAddLabel2;
	
	private JLabel nameLAbel;
	private JLabel priceLAbel;
	
	
	public MenuAddPage(PosData data, int menuType)
	{
		super("MenuAddPage", 400, 300);
		
		
		setData(data);
		setMenuType(menuType);
		
		
		this.setLayout(null);
		
		lineBorder = new LineBorder(Color.BLACK, 3);
		this.getRootPane().setBorder(lineBorder);
		
		menuAddLabel = new JLabel();
		menuAddLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 30));
		menuAddLabel.setForeground(Color.BLACK);
		menuAddLabel.setText("∏ﬁ¥∫ √ﬂ∞°");
		menuAddLabel.setVisible(true);
		this.add(menuAddLabel).setBounds(140, 50 , 150, 50);
		
		menuAddLabel2 = new JLabel();
		menuAddLabel2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		menuAddLabel2.setForeground(Color.BLACK);
		menuAddLabel2.setText("(¿Ã∏ß¿Ã ∞∞¿∏∏È ∞°∞› ºˆ¡§)");
		menuAddLabel2.setVisible(true);
		this.add(menuAddLabel2).setBounds(90, 100, 250, 50);
		
		
		
		// name label setup
		nameLAbel = new JLabel();
		nameLAbel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 16));
		nameLAbel.setForeground(Color.BLACK);
		nameLAbel.setText("¿Ã∏ß:");
		nameLAbel.setVisible(true);
		this.add(nameLAbel).setBounds(30, 150 , 50, 30);
		//
		
		
		// price label setup
		priceLAbel = new JLabel();
		priceLAbel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 16));
		priceLAbel.setForeground(Color.BLACK);
		priceLAbel.setText("∞°∞›:");
		priceLAbel.setVisible(true);
		this.add(priceLAbel).setBounds(30, 200 , 50, 30);
		//
		
	}
	public PosData getData() {
		return data;
	}

	
	public void setData(PosData data) {
		this.data = data;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public int getMenuType() {
		return menuType;
	}
	public void setMenuType(int menuType) {
		this.menuType = menuType;
	}

	
}
