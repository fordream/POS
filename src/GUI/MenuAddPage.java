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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import controler.MenuControler;
import model.Menu;
import model.PosData;

public class MenuAddPage extends SimpleJFrame implements ActionListener, KeyListener{

	private PosData data;
	
	private LineBorder lineBorder;
	
	private JTextField menuTextFiedl;
	private JTextField priceTextFiedl;
	private JButton exitButton;
	private JButton enterButton;
	private JLabel nameLAbel;
	private JLabel priceLAbel;
	
	public MenuAddPage(PosData data)
	{
		super("MenuAddPage", 400, 300);
		
		setData(data);
		
		
		
		this.setLayout(null);
		
		
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
		
		
		// menuTextFiedl setup
		menuTextFiedl = new JTextField();
		lineBorder = new LineBorder(Color.BLACK, 3);
		menuTextFiedl.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 16));
		menuTextFiedl.setBorder(lineBorder);
		menuTextFiedl.addKeyListener(this);
		this.add(menuTextFiedl).setBounds(75, 150, 270, 30);
		//
		
		
		// priceTextFiedl setup
		priceTextFiedl = new JTextField();
		lineBorder = new LineBorder(Color.BLACK, 3);
		priceTextFiedl.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 16));
		priceTextFiedl.setBorder(lineBorder);
		priceTextFiedl.addKeyListener(this);
		this.add(priceTextFiedl).setBounds(75, 200, 270, 30);
		//
		
		
		// enter button setup
		enterButton = new JButton(" »Æ¿Œ ");
		lineBorder = new LineBorder(Color.BLACK, 3);
		enterButton.setBackground(Color.WHITE);
		enterButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 16));
		enterButton.setBorder(lineBorder);
		enterButton.addActionListener(this);
		this.add(enterButton).setBounds(90, 250, 80, 30);
		//
		
		
		// exit button setup
		exitButton = new JButton(" √Î º“ ");
		lineBorder = new LineBorder(Color.BLACK, 3);
		exitButton.setBackground(Color.WHITE);
		exitButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 16));
		exitButton.setBorder(lineBorder);
		exitButton.addActionListener(this);
		this.add(exitButton).setBounds(230, 250, 80, 30);
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
		if(e.getSource() == exitButton)
			this.dispose();
		if(e.getSource() == enterButton)
		{
			String newMenuName = menuTextFiedl.getText();
			int newMenuPrice = Integer.parseInt( priceTextFiedl.getText() );
			
			Menu newMenu = new Menu(newMenuName, newMenuPrice);
			
			MenuControler MCon = new MenuControler( getData() );
			MCon.addMenu( newMenu );
			setData( MCon.getData() );
			
			this.dispose();
		}
		
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

}
