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

import GUIData.GUIdata;
import controler.PosFileControler;
import model.PosData;
import model.Table;

public class POSPage extends SimpleJFrame implements ActionListener, KeyListener, FocusListener{

	private LineBorder lineBorder;
	private JLabel posMainLabel;
	private JLabel logoLabel;
	private JLabel logoLabel2;
	private JButton exitButton;
	
	private JLabel developersLabel; // °³¹ßÀÚ ¸í´Ü Ãß°¡ : »ó´Ü À§ Á¾·á¹öÆ° ¿·
 
	private PosData data;
	
	private static boolean onAddMenuFrame;
	private static boolean onTableCalculateFrame;
	private static boolean onTotalCalculateFrame;
	private static boolean onResetFrame;
	
	private TableInnerPanel tableInnerPanel;
	private MenuInnerPanel menuInnerPanel;

	
	public static boolean isOnResetFrame() {
		return onResetFrame;
	}

	public static void setOnResetFrame(boolean onResetFrame) {
		POSPage.onResetFrame = onResetFrame;
	}

	public PosData getData() {
		return data;
	}

	public void setData(PosData data) {
		this.data = data;
	}

	public POSPage() 
	{
		super("POSMainPage", 1400, 800);
		data = new PosData();
		Table.setSelectedTable(-1);
		
		setOnAddMenuFrame(false);
		setOnTableCalculateFrame(false);
		setOnTotalCalculateFrame(false);
		setOnResetFrame(false);
		
		//// read File PosData
		PosFileControler posFileControler = new PosFileControler(getData());
		posFileControler.readFromFile();
		setData(posFileControler.getData());
		
		
		/* ========== Developers Label ========== */
		
		developersLabel = new JLabel();
		developersLabel.setText("<html>Developed by KNU ÄÄÇ»ÅÍÇÐºÎ REVOLUTION<br> ¹Úµ¿¿ø, À¯µ¿±Ô, "
				+ " °û´ëÈÆ, ÀÌÂù¿µ</html>");
		developersLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 11));
		this.add(developersLabel).setBounds(35, 728, 500, 100);
		
		/* ========== ========== ========== */
		
		
		/////
		// this setup
		lineBorder = new LineBorder(Color.darkGray, 1);
		this.getRootPane().setBorder(lineBorder);
		//
		
		
		// CSE lost setup
		logoLabel = new JLabel();
		logoLabel.setIcon(new ImageIcon("img/CSELogo_120_60.png"));
		this.add(logoLabel).setBounds(30, 0, 350, 60);
		//
		
		// CSE lost setup
		logoLabel2 = new JLabel();
		logoLabel2.setIcon(new ImageIcon("img/revolution_logo.png"));
		this.add(logoLabel2).setBounds(350, 2, 350, 60);
		//
		
		
		// posMainLabel label setup
		posMainLabel = new JLabel();
		posMainLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		posMainLabel.setForeground(Color.BLACK);
		posMainLabel.setText("Computer Science & Engineering POS");
		posMainLabel.setVisible(true);
		this.add(posMainLabel).setBounds(40, 30, 400, 50);
		//
		
		
		// exit button setup
		exitButton = new JButton();
		lineBorder = new LineBorder(Color.BLACK, 3);
		exitButton.setContentAreaFilled(false);
		exitButton.setIcon(new ImageIcon("img/exit_button.png"));
		exitButton.setPressedIcon(new ImageIcon("img/exit_button_press.png"));
		exitButton.setBackground(null);
		exitButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		exitButton.setBorder(null);
		exitButton.setFocusPainted(false);
		exitButton.addActionListener(this);
		this.add(exitButton).setBounds(1360, 0, 30, 30);
		//
		
		
		// table panel setup
		
		menuInnerPanel = new MenuInnerPanel(getData());
		this.add(menuInnerPanel);
		//
		tableInnerPanel = new TableInnerPanel(getData(), menuInnerPanel);
		this.add(tableInnerPanel);
		menuInnerPanel.setTableInnerPanel(tableInnerPanel);

		// menu panel setup
	
		
	
		//

	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource() == exitButton)
		{
			System.out.println("before dispose, please save all the data into the file!");
			
			
			PosFileControler posFileControler = new PosFileControler(getData());
			posFileControler.writeToFile();
			
			
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

	public static boolean isOnAddMenuFrame() {
		return onAddMenuFrame;
	}

	public static void setOnAddMenuFrame(boolean data) {
		onAddMenuFrame = data;
	}

	public static boolean isOnTableCalculateFrame() {
		return onTableCalculateFrame;
	}

	public static void setOnTableCalculateFrame(boolean data) {
		onTableCalculateFrame = data;
	}

	public static boolean isOnTotalCalculateFrame() {
		return onTotalCalculateFrame;
	}

	public static void setOnTotalCalculateFrame(boolean data) {
		onTotalCalculateFrame = data;
	}
}
