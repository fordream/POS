package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class TableListPanel extends JPanel implements ActionListener
{

	private LineBorder lineBorder;
	private JButton[] Table;
	private int tableNum;
	
	public int getTableNum() {
		return tableNum;
	}
	public void setTableNum(int tableNum) {
		this.tableNum = tableNum;
	}
	
	TableListPanel()
	{
		Table = new JButton[50];  
		setTableNum(32);
		
		lineBorder = new LineBorder(Color.BLACK, 3);
		this.setLayout(null);
		this.setBorder(lineBorder);
		this.setBackground(Color.WHITE);
		this.setBounds(10, 10, 780, 620);
		printTableList(getTableNum());
		
	}
	public void printTableList(int TableNum)
	{
		int j = 0;
		for(int i= 0;i+j*8<TableNum; i++ )
		{
			if(i%8 == 0&& i !=0)
			{
				j += 1;
				i= 0;
			}
			printTable(i,j);
		}
	}
	public void printTable(int i,int j)
	{
			Table[i+j*8] = new JButton(""+(i+j*8+1));
			Table[i+j*8].setBackground(Color.WHITE);
			Table[i+j*8].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
			Table[i+j*8].setBorder(lineBorder);
			Table[i+j*8].addActionListener(this);
			this.add(Table[i+j*8]).setBounds(10 + i*97, 10+j*150, 80, 120);

	}

	public void addTableList()
	{
		if(tableNum>=32)
		{
			System.out.println("Table is full");
		}
		else
		{
			
			tableNum++;
			
			int i=0,j=0;
			for(i = tableNum;i >8;i -=8)
			{
				j ++;
			}
			i--;
			
			printTable(i,j);
			this.repaint();
		}
	}
	
	public void delTableList()
	{
		if(tableNum<=0)
		{
			System.out.println("Table is empty");
		}
		else
		{
			tableNum--;
			this.remove(Table[tableNum]);
			this.repaint();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
