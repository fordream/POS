package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import model.Account;
import controler.AccountFileControler;

public class TotalCalculatePage extends SimpleJFrame implements ActionListener {
	
	private LineBorder lineBorder;
	private JButton exitButton;
	
	private JLabel totalNameLabel;
	private JTextField totalTextField;
	private JLabel totalPriceLabel;
	
	private JLabel escapeNameLabel;
	private JButton chaseButton;
	private JTextField escapeTextField;
	private JLabel escapePriceLabel;
	private JLabel pureNameLabel;
	
	private JTextField pureTextField;
	private JLabel purePriceLabel;
	
	public TotalCalculatePage() {
		
		super("Total Calculate Page", 765, 450);
		
		// this setup
		lineBorder = new LineBorder(Color.BLACK, 3);
		//
		
		// exit button setup
		exitButton = new JButton(" Á¾ ·á ");
		exitButton.setBackground(Color.WHITE);
		exitButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		exitButton.setBorder(lineBorder);
		exitButton.addActionListener(this);
		this.add(exitButton).setBounds(675, 5, 80, 30);
		//
		
		//// All Calculate
		// Name Label
		totalNameLabel = new JLabel();
		totalNameLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 26));
		totalNameLabel.setForeground(Color.BLACK);
		totalNameLabel.setText("ÃÑ Á¤»ê");
		totalNameLabel.setVisible(true);
		this.add(totalNameLabel).setBounds(30, 40, 200, 30);
		//
		
		// Total OrderList TextField
		totalTextField = new JTextField();
		lineBorder = new LineBorder(Color.BLACK, 3);
		totalTextField.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		totalTextField.setBorder(lineBorder);
		totalTextField.enable(false);
		this.add(totalTextField).setBounds(30, 90, 200, 300);
		//
		
		// Total Calculate Label
		totalPriceLabel = new JLabel();
		totalPriceLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		totalPriceLabel.setForeground(Color.BLACK);
		totalPriceLabel.setText("Total :" + " ¿ø");
		totalPriceLabel.setVisible(true);
		this.add(totalPriceLabel).setBounds(30, 400, 200, 30);
		//
		////
		
		
		
		//// Escape Calculate
		// Name Label
		escapeNameLabel = new JLabel();
		escapeNameLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 26));
		escapeNameLabel.setForeground(Color.BLACK);
		escapeNameLabel.setText("Å»ÁÖ Á¤»ê");
		escapeNameLabel.setVisible(true);
		this.add(escapeNameLabel).setBounds(280, 40, 200, 30);
		//	
		
		// chase button
		chaseButton = new JButton("Chase");
		chaseButton.setBackground(Color.RED);
		chaseButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		chaseButton.setForeground(Color.WHITE);
		chaseButton.setBorder(lineBorder);
		chaseButton.addActionListener(this);
		this.add(chaseButton).setBounds(400, 40, 80, 32);
		//
				
		// Total OrderList TextField
		escapeTextField = new JTextField();
		lineBorder = new LineBorder(Color.BLACK, 3);
		escapeTextField.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		escapeTextField.setBorder(lineBorder);
		escapeTextField.enable(false);
		this.add(escapeTextField).setBounds(280, 90, 200, 300);
		//
	
		// Total Calculate Label
		escapePriceLabel = new JLabel();
		escapePriceLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		escapePriceLabel.setForeground(Color.RED);
		escapePriceLabel.setText("Total :" + " ¿ø");
		escapePriceLabel.setVisible(true);
		this.add(escapePriceLabel).setBounds(280, 400, 200, 30);
		//
		////
			
		
		
		//// Pure Calculate
		// Name Label
		pureNameLabel = new JLabel();
		pureNameLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 26));
		pureNameLabel.setForeground(Color.BLACK);
		pureNameLabel.setText("¼ø¼ö Á¤»ê");
		pureNameLabel.setVisible(true);
		this.add(pureNameLabel).setBounds(530, 40, 200, 30);
		//
	
		// Total OrderList TextField
		pureTextField = new JTextField();
		lineBorder = new LineBorder(Color.BLACK, 3);
		pureTextField.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		pureTextField.setBorder(lineBorder);
		pureTextField.enable(false);
		this.add(pureTextField).setBounds(530, 90, 200, 300);
		//
	
		// Total Calculate Label
		purePriceLabel = new JLabel();
		purePriceLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		purePriceLabel.setForeground(Color.BLACK);
		purePriceLabel.setText("Total :" + " ¿ø");
		purePriceLabel.setVisible(true);
		this.add(purePriceLabel).setBounds(530, 400, 200, 30);
		//
		////
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if( e.getSource() == exitButton ) {
			this.dispose();
		}
		
		if( e.getSource() == chaseButton) {
			ChasePage chase = new ChasePage();
		}
	}
}
