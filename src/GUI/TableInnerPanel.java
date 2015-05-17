package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class TableInnerPanel extends JPanel implements ActionListener{
	
	private TableListPanel tableListPanel;
	
	
	private JButton addButton;
	private JButton delButton;
	
	private LineBorder lineBorder;
	
	public TableInnerPanel() {
		
		lineBorder = new LineBorder(Color.BLACK, 3);
		this.setLayout(null);
		this.setBorder(lineBorder);
		this.setBackground(Color.WHITE);
		this.setBounds(30, 80, 800, 680);
		
		tableListPanel = new TableListPanel();
		this.add(tableListPanel);
		
		
		
		addButton = new JButton("���̺� �߰� ");
		lineBorder = new LineBorder(Color.BLACK, 3);
		addButton.setBackground(Color.WHITE);
		addButton.setFont(new Font("���� ����", Font.BOLD, 14));
		addButton.setBorder(lineBorder);
		addButton.addActionListener(this);
		this.add(addButton).setBounds(500, 640, 100, 30);
		//
		
		
		// cancel button setup
		delButton = new JButton("���̺� ����");
		lineBorder = new LineBorder(Color.BLACK, 3);
		delButton.setBackground(Color.WHITE);
		delButton.setFont(new Font("���� ����", Font.BOLD, 14));
		delButton.setBorder(lineBorder);
		delButton.addActionListener(this);
		this.add(delButton).setBounds(630, 640, 100, 30);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == addButton)
		{
			System.out.println("addTable button clicked");
			tableListPanel.addTableList();
			
		}
		else if(e.getSource() == delButton)
		{
			System.out.println("delTable button clicked");
			tableListPanel.delTableList();
		}
		// TODO Auto-generated method stub
		
	}
	
	
}