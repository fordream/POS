package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controler.TableControler;
import model.PosData;
import model.Table;

public class TableListPanel extends JPanel implements ActionListener
{

	private LineBorder lineBorder;
	private JButton[] Table;
	private int tableNum;
	private PosData data;
	private MenuInnerPanel panel;
	
	public PosData getData() {
		return data;
	}
	public void setData(PosData data) {
		this.data = data;
	}
	public int getTableNum() {
		return tableNum;
	}
	public void setTableNum(int tableNum) {
		this.tableNum = tableNum;
	}
	
	public TableListPanel(PosData data,MenuInnerPanel panel)
	{
		setData(data);
		this.panel = panel;
		Table = new JButton[24];
		setTableNum(getData().getTableList().size());
		
		lineBorder = new LineBorder(Color.BLACK, 3);
		this.setLayout(null);
		this.setBorder(lineBorder);
		this.setBackground(Color.WHITE);
		this.setBounds(10, 10, 780, 620);
		printTableList(getTableNum());
		
		
		for(int i = 0; i < getData().getTableList().size(); i++)
			System.out.println("Table Number " + i + " : " + getData().getTableList().get(i).getTableNumber());
		
	}
	
	public void printTableList(int TableNum)
	{
		int j = 0;
		for(int i= 0;i+j*6<TableNum; i++ )
		{
			if(i%6 == 0&& i !=0)
			{
				j += 1;
				i= 0;
			}
			printTable(i,j);
		}
	}
	
	public void printTable(int i,int j)
	{	
		Table[i+j*6] = new JButton("<html>"+"<p align = center>" + (i + j * 6 + 1)+"</p>" +"<br>±Ý¾×: " + (double)getData().getTableList().get(i+j*6).getTotalPrice() /10000 + "</html>");
		Table[i+j*6].setLayout(null);
		Table[i+j*6].setBackground(Color.WHITE);
		Table[i+j*6].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		Table[i+j*6].setBorder(lineBorder);
		Table[i+j*6].addActionListener(this);
		this.add(Table[i+j*6]).setBounds(10 + i*128, 10+j*150, 120, 120);

	}

	public void addTableList()
	{
		if(tableNum >= 24)
		{
			System.out.println("Table is full");
		}
		else
		{
			tableNum++;
			Table newTable = new Table(tableNum-1);
			TableControler Tcon = new TableControler(data);
			Tcon.addTable(newTable);
			
			int i=0,j=0;
			for(i = tableNum;i >6;i -=6)
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
			Table newTable = new Table(tableNum);
			TableControler Tcon = new TableControler(data);
			Tcon.deleteTable(newTable);
			this.remove(Table[tableNum]);
			this.repaint();
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0;i<tableNum;i++)
		{
			if(e.getSource()  == Table[i])
			{
				System.out.println("Table["+(i)+"]"+data.getTableList().get(i).getOrderList());
				getData().setCurrentTable(i);
				panel.showOrderList();
				
			}
		}
		
	}
	

}
