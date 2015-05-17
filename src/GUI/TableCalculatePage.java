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
import model.PosData;
import controler.AccountFileControler;

public class TableCalculatePage extends SimpleJFrame implements ActionListener{
	
	private JLabel pageNameField;
	private JTextField orderTextField;
	private LineBorder lineBorder;
	private JLabel totalLabel;
	private JButton calculateButton;
	private JButton escapeButton;
	private JButton cancelButton;
	private PosData data;
	private int index;
	
	public PosData getData() {
		return data;
	}

	public void setData(PosData data) {
		this.data = data;
	}

	public TableCalculatePage(PosData data, int index) {
		super("tableCalculate", 700, 500);
		this.index = index;
		
		setData(data);
		
		// show the total price in the table
		pageNameField = new JLabel();
		pageNameField.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 26));
		pageNameField.setForeground(Color.BLACK);
		pageNameField.setText("ÀÚ¸® °è»ê");
		pageNameField.setVisible(true);
		this.add(pageNameField).setBounds(50, 20, 200, 30);
				
				
		// show the orderlist in the table for the index
		orderTextField = new JTextField();
		lineBorder = new LineBorder(Color.BLACK, 3);
		orderTextField.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		orderTextField.setBorder(lineBorder);
		orderTextField.enable(false);
		this.add(orderTextField).setBounds(50, 70, 280, 400);
		
		
		// show the total price in the table
		totalLabel = new JLabel();
		totalLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		totalLabel.setForeground(Color.RED);
		totalLabel.setText("Total : " + " ¿ø");
		totalLabel.setVisible(true);
		this.add(totalLabel).setBounds(370, 120, 200, 50);
		
		
		// show buttons
		calculateButton = new JButton("°è  »ê");
		lineBorder = new LineBorder(Color.BLACK, 3);
		calculateButton.setBackground(Color.WHITE);
		calculateButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		calculateButton.setBorder(lineBorder);
		//calculateButton.addActionListener(this);
		this.add(calculateButton).setBounds(370, 270, 270, 40);
		
		escapeButton = new JButton("Å»  ÁÖ");
		lineBorder = new LineBorder(Color.BLACK, 3);
		escapeButton.setBackground(Color.WHITE);
		escapeButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		escapeButton.setBorder(lineBorder);
		//calculateButton.addActionListener(this);
		this.add(escapeButton).setBounds(370, 350, 270, 40);
		
		cancelButton = new JButton("Ãë  ¼Ò");
		lineBorder = new LineBorder(Color.BLACK, 3);
		cancelButton.setBackground(Color.WHITE);
		cancelButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		cancelButton.setBorder(lineBorder);
		cancelButton.addActionListener(this);
		this.add(cancelButton).setBounds(370, 430, 270, 40);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if ( e.getSource() == calculateButton)
		{
			// modify table boolean paid = true
			
			Account account = new Account(
					new Date(),
					data.getTableList().get(index));
			
			AccountFileControler accountFileControler = new AccountFileControler(account);
			accountFileControler.writeToFile();
			
			System.out.println("dispose the table caluate frame");
			
			this.dispose();
		}
		
		
		if ( e.getSource() == escapeButton)
		{
			
			Account account = new Account(
					new Date(),
					data.getTableList().get(index));
			
			AccountFileControler accountFileControler = new AccountFileControler(account);
			accountFileControler.writeToFile();
			
			System.out.println("dispose the table caluate frame");
		}
		
		
		if ( e.getSource() == cancelButton) {
			System.out.println("dispose the table caluate frame");
			this.dispose();
			
		}
		
			
	}
	
	
}
