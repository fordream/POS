package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;

import GUIData.GUIdata;
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
	private JLabel posMainLabel;
	private JLabel passwordLabel;
	private JLabel logoLabel;
	private JLabel logoLabel2;
	
	private PasswordControler pcon;
	
	public LoginPage()
	{
		super("LoginPage", 400, 300);
		
		
		// login page setup
		this.getRootPane().setBorder(GUIdata.buttonBorder2);
		this.getContentPane().setBackground(GUIdata.loginFrameColor);
		//
		
		
		// posMainLabel label setup
		posMainLabel = new JLabel();
		posMainLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 16));
		posMainLabel.setForeground(new Color(60, 60, 60));
		posMainLabel.setText("Computer Science & Engineering POS");
		posMainLabel.setVisible(true);
		this.add(posMainLabel).setBounds(50, 10, 400, 50);
		//
		
		
		// CES logo setup
		logoLabel = new JLabel();
		logoLabel.setIcon(new ImageIcon("img/CSELogo_150_85.png"));
		this.add(logoLabel).setBounds(40, 50, 350, 85);
		//

		// CES logo setup
		logoLabel2 = new JLabel();
		logoLabel2.setIcon(new ImageIcon("img/revolution_logo.png"));
		this.add(logoLabel2).setBounds(45, 85, 350, 85);
		//

		// password label setup
		passwordLabel = new JLabel();
		passwordLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 16));
		passwordLabel.setForeground(Color.DARK_GRAY);
		passwordLabel.setText("password");
		passwordLabel.setVisible(true);
		this.add(passwordLabel).setBounds(75, 150, 250, 30);;
		//
		
		// password text field setup
		passwordTextField = new JPasswordField();
		passwordTextField.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 16));
		passwordTextField.setHorizontalAlignment(JPasswordField.CENTER);
		passwordTextField.setBorder(GUIdata.buttonBorder2);
		passwordTextField.grabFocus();
		passwordTextField.addKeyListener(this);
		this.add(passwordTextField).setBounds(75, 180, 250, 30);
		//
		
		
		
		// enter button setup
		enterButton = new JButton(" »Æ ¿Œ ");
		enterButton.setBackground(Color.WHITE);
		enterButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 14));
		enterButton.setBorder(null);
		enterButton.addActionListener(this);
		enterButton.setFocusPainted(false);
		enterButton.setForeground(Color.WHITE);
		enterButton.setBackground(GUIdata.buttonColor);
		this.add(enterButton).setBounds(75, 230, 124, 30);
		//
		
		
		// cancel button setup
		cancelButton = new JButton(" √Î º“ ");
		cancelButton.setBackground(Color.WHITE);
		cancelButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 14));
		cancelButton.setBorder(null);
		cancelButton.addActionListener(this);
		cancelButton.setFocusPainted(false);
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBackground(GUIdata.buttonColor);
		this.add(cancelButton).setBounds(201, 230, 124, 30);
		//
	}

	public void openPOSMainPage()
	{
		try
		{
			pcon = new PasswordControler();
			String password = "computer"; // need to be setted
			String macAddress = "1C-6F-65-8C-24-E1"; // need to be setted
			
			String inputPassword = "";
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
				JOptionPane.showMessageDialog(this, "Cannot run POS System!<br>Please check network connection!");
			}
			
			/* ========== ========== ========== */
			
			
			for(int i = 0; i < passwordTextField.getPassword().length; i++)
				inputPassword += passwordTextField.getPassword()[i];
			
			if( macAddress.equals(macAdd) )
		      {
		         if( pcon.checkPassword( password, inputPassword ) )
		         {
		            POSPage mainPage = new POSPage();
		            this.dispose();
		         }
		         else
		         {
		            JOptionPane.showMessageDialog(this, "∫Òπ–π¯»£∞° ∆≤∏≥¥œ¥Ÿ!");
		         }
		      }
		      else
		      {
		         JOptionPane.showMessageDialog(this, "µÓ∑œµ» ƒƒ«ª≈Õ∞° æ∆¥’¥œ¥Ÿ!");
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
