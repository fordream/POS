package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class ChasePage extends SimpleJFrame implements ActionListener {
	
	private LineBorder lineBorder;
	private JButton exitButton;
	private JLabel nameLabel;
	private JTextField chaserTextField;
	
	public ChasePage() {
		super("Chase Page", 300, 400);
		
		// this setup
		lineBorder = new LineBorder(Color.BLACK, 3);
		//
		
		// exit button setup
		exitButton = new JButton(" Á¾ ·á ");
		exitButton.setBackground(Color.WHITE);
		exitButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		exitButton.setBorder(lineBorder);
		exitButton.addActionListener(this);
		this.add(exitButton).setBounds(230, 5, 60, 20);
		//
		
		// Name Label
		nameLabel = new JLabel();
		nameLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		nameLabel.setForeground(Color.RED);
		nameLabel.setText("Escaping List");
		nameLabel.setVisible(true);
		this.add(nameLabel).setBounds(10, 17, 200, 30);
		//
		
		// Total OrderList TextField
		chaserTextField = new JTextField();
		lineBorder = new LineBorder(Color.BLACK, 3);
		chaserTextField.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		chaserTextField.setBorder(lineBorder);
		chaserTextField.enable(false);
		this.add(chaserTextField).setBounds(10, 45, 275, 340);
		//
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if( e.getSource() == exitButton ) {
			this.dispose();
		}
		
	}
}
