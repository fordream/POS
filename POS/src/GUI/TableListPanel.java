package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import GUIData.GUIdata;
import controler.TableControler;
import model.PosData;
import model.Table;

public class TableListPanel extends JPanel implements ActionListener
{

	private LineBorder lineBorder;
	private ArrayList<JButton> tableButtons;
	private PosData data;
	private MenuInnerPanel menuInnerPanel;
	
	private int row;
	private int col;
	

	public PosData getData() {
		return data;
	}
	public void setData(PosData data) {
		this.data = data;
	}
	public int getTableNum() {
		return getData().getTableList().size();
	}
	
	
	public TableListPanel(PosData data, MenuInnerPanel menuInnerPanel)
	{
		setData(data);
		row = 6;
		col = 4;
		
		this.menuInnerPanel = menuInnerPanel;
		
		tableButtons = new ArrayList<JButton>();
		
		lineBorder = new LineBorder(Color.GRAY, 2);
		this.setLayout(null);
		this.setBorder(GUIdata.buttonBorder2);
		this.setBackground(Color.WHITE);
		this.setBounds(10, 50, 780, 620);
		
		repaintTable();
		
		
		for(int i = 0; i < getData().getTableList().size(); i++)
			System.out.println("table Number " + i + " : " + getData().getTableList().get(i).getTableNumber());
		
	}
	
	public void repaintTable()
	{
		this.removeAll();
		tableButtons.clear();
		
		printTableList();
		repaintTableList();
		this.repaint();
	}

	public void printTableList()
	{
		int i, j;
		for(i = 0, j = 0; i + j * row < getTableNum(); i++ )
		{
			if(i % row == 0 && i !=0)
			{
				j++;
				i = 0;
			}
			printTable(i,j);
		}
	}
	
	public void repaintTableList()
	{

		for(int i = 0; i < getTableNum(); i++)
		{
			if(i == Table.getSelectedTable())
				tableButtons.get(i).setBackground(new Color(200, 200, 200));
			else
				tableButtons.get(i).setBackground(Color.WHITE);
			
			if(getData().getTableList().get(i).getTotalPrice() > 0 && i != Table.getSelectedTable())
				tableButtons.get(i).setBackground(new Color(200, 255, 200));
			
		}
	}
	
	public void printTable(int i,int j)
	{	
		int index = i + j * row;
		tableButtons.add(new JButton("<html>"+"<p align = center>" + (index + 1) + "</p>" + "<br>±Ý¾×<br>"
						+ (int)getData().getTableList().get(index).getTotalPrice() + "¿ø" + "</html>"));
		tableButtons.get(index).setLayout(null);
		tableButtons.get(index).setBackground(Color.WHITE);
		tableButtons.get(index).setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		tableButtons.get(index).setBorder(lineBorder);
		tableButtons.get(index).setOpaque(true);
		tableButtons.get(index).addActionListener(this);
		tableButtons.get(index).setFocusPainted(false);
		this.add(tableButtons.get(index)).setBounds(10 + i*128, 10+j*150, 120, 120);

	}

	public void addTableList()
	{
		if(getTableNum() > (row * col - 1))
		{
			System.out.println("table is full");
		}
		else
		{
			Table newtable = new Table(getTableNum() - 1);
			TableControler Tcon = new TableControler(data);
			Tcon.addTable(newtable);
			

			repaintTable();
		}
		
	}
	
	public void delTable(int index)
	{
		if(getTableNum() <= 0)
		{
			System.out.println("table is empty");
		}
		else
		{
			TableControler Tcon = new TableControler(data);
			Tcon.deleteTable(index);

			if(Table.getSelectedTable() == getData().getTableList().size())
				Table.setSelectedTable(Table.getSelectedTable() - 1);
			menuInnerPanel.showTableMenuList();
			repaintTable();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0; i < getTableNum(); i++)
		{
			if(e.getSource() == tableButtons.get(i) && Table.getSelectedTable() >= 0 && POSPage.isOnTableCalculateFrame() == false)
			{
				Table.setSelectedTable(i);
				System.out.println("table["+(i)+"]"+data.getTableList().get(i).getOrderList() + "select: " + Table.getSelectedTable());
				System.out.println(""+menuInnerPanel+"");
				menuInnerPanel.setCurrentTableMenuIndex(0);
				menuInnerPanel.showTableMenuList();
				repaintTableList();
			}
			if(Table.getSelectedTable() < 0 && POSPage.isOnTableCalculateFrame() == false)
			{
				Table.setSelectedTable(i);
				System.out.println("table["+(i)+"]"+data.getTableList().get(i).getOrderList() + "select: " + Table.getSelectedTable());
				System.out.println(""+menuInnerPanel+"");
				menuInnerPanel.setCurrentTableMenuIndex(0);
				menuInnerPanel.showTableMenuList();
				repaintTableList();
			}
		}
		
	}
	

}
