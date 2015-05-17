package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import model.PosData;

public class MenuAddPage extends SimpleJFrame implements ActionListener, KeyListener{

	private PosData data;
	
	private LineBorder lineBorder;
	
	private JTextField menuTextFiedl;
	private JTextField priceTextFiedl;
	
	public MenuAddPage(PosData data)
	{
		super("MenuAddPage", 400, 300);
		
		setData(data);
		
		this.setLayout(null);
		
		// menuTextFiedl setup
		menuTextFiedl = new JTextField();
		lineBorder = new LineBorder(Color.BLACK, 3);
		menuTextFiedl.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		menuTextFiedl.setBorder(lineBorder);
		menuTextFiedl.addKeyListener(this);
		this.add(menuTextFiedl).setBounds(75, 100, 200, 30);
		//
		
		
		// priceTextFiedl setup
		priceTextFiedl = new JTextField();
		lineBorder = new LineBorder(Color.BLACK, 3);
		priceTextFiedl.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		priceTextFiedl.setBorder(lineBorder);
		priceTextFiedl.addKeyListener(this);
		this.add(priceTextFiedl).setBounds(75, 200, 200, 30);
		//
	}

	
	public PosData getData() {
		return data;
	}

	
	public void setData(PosData data) {
		this.data = data;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
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
