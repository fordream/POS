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
	private JButton[] table;
	private int tableNum;
	private PosData data;
	private MenuInnerPanel menuInnerPanel;
	

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
	
	
	public TableListPanel(PosData data, MenuInnerPanel menuInnerPanel)
	{
		setData(data);
		this.menuInnerPanel = menuInnerPanel;
		
		table = new JButton[24];
		setTableNum(getData().getTableList().size());
		
		lineBorder = new LineBorder(Color.BLACK, 3);
		this.setLayout(null);
		this.setBorder(lineBorder);
		this.setBackground(Color.WHITE);
		this.setBounds(10, 10, 780, 620);
		printTableList(getTableNum());
		
		
		for(int i = 0; i < getData().getTableList().size(); i++)
			System.out.println("table Number " + i + " : " + getData().getTableList().get(i).getTableNumber());
		
	}
	

	public void printTableList(int tableNum)
	{
		int j = 0;
		for(int i= 0;i+j*6<tableNum; i++ )
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
		table[i+j*6] = new JButton("<html>"+"<p align = center>" + (i + j * 6 + 1)+"</p>" +"<br>±Ý¾×: " + (double)getData().getTableList().get(i+j*6).getTotalPrice() /10000 + "</html>");
		table[i+j*6].setLayout(null);
		table[i+j*6].setBackground(Color.WHITE);
		table[i+j*6].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		table[i+j*6].setBorder(lineBorder);
		table[i+j*6].addActionListener(this);
		this.add(table[i+j*6]).setBounds(10 + i*128, 10+j*150, 120, 120);

	}

	public void addTableList()
	{
		if(tableNum >= 24)
		{
			System.out.println("table is full");
		}
		else
		{
			tableNum++;
			Table newtable = new Table(tableNum-1);
			TableControler Tcon = new TableControler(data);
			Tcon.addTable(newtable);
			
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
			System.out.println("table is empty");
		}
		else
		{
			tableNum--;
			Table newtable = new Table(tableNum);
			TableControler Tcon = new TableControler(data);
			Tcon.deleteTable(newtable);
			this.remove(table[tableNum]);
			this.repaint();
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0;i < tableNum;i++)
		{
			if(e.getSource()  == table[i])
			{
				table[Table.getSelectedTable()].setBorder(lineBorder);
				table[Table.getSelectedTable()].setBackground(Color.WHITE);
				Table.setSelectedTable(i);
				table[i].setBackground(new Color(200, 200, 200));
				System.out.println("table["+(i)+"]"+data.getTableList().get(i).getOrderList() + "select: " + Table.getSelectedTable());
				
				menuInnerPanel.showTableMenuList();
			}
		}
		
	}
	

}
