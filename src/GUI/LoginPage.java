package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;

import controler.PasswordControler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.InetAddress;
import java.net.NetworkInterface;

public class LoginPage extends SimpleJFrame implements ActionListener, KeyListener{

	private JPasswordField passwordTextField;
	private JButton enterButton;
	private JButton cancelButton;
	private LineBorder lineBorder;
	private JLabel posMainLabel;
	private JLabel passwordLabel;
	private JLabel logoLabel;
	
	private PasswordControler pcon;
	
	public LoginPage()
	{
		super("LoginPage", 400, 300);
		
		
		// login page setup
		lineBorder = new LineBorder(Color.BLACK, 3);
		this.getRootPane().setBorder(lineBorder);
		//
		
		
		// posMainLabel label setup
		posMainLabel = new JLabel();
		posMainLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 16));
		posMainLabel.setForeground(Color.BLACK);
		posMainLabel.setText("Computer Science & Engineering POS");
		posMainLabel.setVisible(true);
		this.add(posMainLabel).setBounds(50, -12, 400, 50);
		//
		
		
		// CES logo setup
		logoLabel = new JLabel();
		logoLabel.setIcon(new ImageIcon("img/CSELogo_150_85.png"));
		this.add(logoLabel).setBounds(120, 50, 150, 85);
		//
		
		
		// password label setup
		passwordLabel = new JLabel();
		passwordLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 16));
		passwordLabel.setForeground(Color.BLACK);
		passwordLabel.setText("password");
		passwordLabel.setVisible(true);
		this.add(passwordLabel).setBounds(162, 130, 100, 50);;
		//
		
		
		// password text field setup
		passwordTextField = new JPasswordField();
		lineBorder = new LineBorder(Color.BLACK, 3);
		passwordTextField.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 16));
		passwordTextField.setBorder(lineBorder);
		passwordTextField.addKeyListener(this);
		this.add(passwordTextField).setBounds(75, 180, 250, 30);
		//
		
		
		// enter button setup
		enterButton = new JButton(" »Æ ¿Œ ");
		lineBorder = new LineBorder(Color.BLACK, 3);
		enterButton.setBackground(Color.WHITE);
		enterButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 14));
		enterButton.setBorder(lineBorder);
		enterButton.addActionListener(this);
		this.add(enterButton).setBounds(75, 230, 80, 30);
		//
		
		
		// cancel button setup
		cancelButton = new JButton(" √Î º“ ");
		lineBorder = new LineBorder(Color.BLACK, 3);
		cancelButton.setBackground(Color.WHITE);
		cancelButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 14));
		cancelButton.setBorder(lineBorder);
		cancelButton.addActionListener(this);
		this.add(cancelButton).setBounds(245, 230, 80, 30);
		//
	}

	public void openPOSMainPage()
	{
		try
		{
			pcon = new PasswordControler();
			String password = ""; // need to be setted
			String macAddress = "D0-50-99-4B-19-C3"; // need to be setted
			
			String macAdd = "";
			
			/* ========== Get mac address ========== */
			
			try
			{
				InetAddress addr = InetAddress.getLocalHost();
				NetworkInterface ni = NetworkInterface.getByInetAddress(addr);
				byte[] mac = ni.getHardwareAddress();
				
				for (int i = 0; i < mac.length; i++)
				{
					macAdd += String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "");
				}
				
				System.out.println(macAdd);
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(this, "Cannot run POS System!");
			}
			
			/* ========== ========== ========== */
			
			
			for(int i = 0; i < passwordTextField.getPassword().length; i++)
				password += passwordTextField.getPassword()[i];
			
			System.out.println(password);
			System.out.println(pcon.checkPassword( password ) );
			
			if( pcon.checkPassword( password ) && macAddress.equals(macAdd) )
			{
				POSPage mainPage = new POSPage();
				this.dispose();
			}
			else
			{
				
			}
		}
		catch(NullPointerException exception)
		{
			System.out.println("Error occured during check password!");
		}
		finally
		{
			
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == enterButton)
		{
			System.out.println("enter button clicked");
			openPOSMainPage();
		}
		else if(e.getSource() == cancelButton)
		{
			System.out.println("cancel button clicked");
			this.dispose();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == passwordTextField)
		{
			if(e.getKeyCode() == KeyEvent.VK_ENTER)
			{
				System.out.println("VK_ENTER pressed and check the password");
				openPOSMainPage();
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
}
