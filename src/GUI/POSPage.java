package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class POSPage extends SimpleJFrame implements ActionListener, KeyListener, FocusListener{

	private LineBorder lineBorder;
	private JPanel tablePanel;
	private JPanel menuPanel;
	private JLabel posMainLabel;
	private JLabel logoLabel;
	private JButton exitButton;
	private JButton addTableButton;
	private JButton deleteTableButton;
	
<<<<<<< HEAD
	TableInnerPanel tableInnerPanel;
=======
	private MenuInnerPanel menuInnerPanel;
>>>>>>> ac41592f74725a028feb3bfb49a0ab1523c5aafa
	
	public POSPage() 
	{
		super("POSMainPage", 1400, 800);
		
		
		// POS page setup
		lineBorder = new LineBorder(Color.BLACK, 3);
		this.getRootPane().setBorder(lineBorder);
		//
		
		// CES logo setup
		logoLabel = new JLabel();
		logoLabel.setIcon(new ImageIcon("img/CSELogo_120_60.png"));
		this.add(logoLabel).setBounds(30, 10, 120, 60);
		//
		
		// posMainLabel label setup
		posMainLabel = new JLabel();
		posMainLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		posMainLabel.setForeground(Color.BLACK);
		posMainLabel.setText("Computer Science & Engineering POS");
		posMainLabel.setVisible(true);
		this.add(posMainLabel).setBounds(150, 30, 400, 50);
		//
		
		// tablePanel setup
		/*tablePanel = new JPanel();
		lineBorder = new LineBorder(Color.BLACK, 3);
		tablePanel.setBorder(lineBorder);
		tablePanel.setBackground(Color.WHITE);
<<<<<<< HEAD
		this.add(tablePanel).setBounds(30, 80, 800, 650);*/
		tableInnerPanel = new TableInnerPanel();
		this.add(tableInnerPanel);
=======
		this.add(tablePanel).setBounds(30, 80, 800, 680);
>>>>>>> ac41592f74725a028feb3bfb49a0ab1523c5aafa
		//
		
		
		// menuPanel setup
		/*menuPanel = new JPanel();
		lineBorder = new LineBorder(Color.BLACK, 3);
		menuPanel.setBorder(lineBorder);
		menuPanel.setBackground(Color.WHITE);
<<<<<<< HEAD
		add(menuPanel).setBounds(860, 80, 500, 680);
=======
		add(menuPanel).setBounds(860, 80, 500, 680);*/
>>>>>>> ac41592f74725a028feb3bfb49a0ab1523c5aafa
		//
		
		
		// exitButton setup
		exitButton = new JButton(" Á¾ ·á ");
		lineBorder = new LineBorder(Color.BLACK, 3);
		exitButton.setBackground(Color.WHITE);
		exitButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		exitButton.setBorder(lineBorder);
		exitButton.addActionListener(this);
		this.add(exitButton).setBounds(1280, 30, 80, 30);
		//
		
		
		// menuInnerPanel setup
		menuInnerPanel = new MenuInnerPanel();
		this.add(menuInnerPanel);
		//
		
		
		//  setup
		
		//
		
		//  setup
		
		//
		
		
		//  setup
		
		//
		
		
		//  setup
		
		//
		
		
		//  setup
		
		//
		
		
		//  setup
		
		//
		
		
		//  setup
		
		//
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource() == exitButton)
		{
			System.out.println("before dispose, please save all the data into the file!");

			this.dispose();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

}
