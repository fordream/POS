package controler;

import java.util.ArrayList;

import model.Menu;
import model.PosData;
import model.Table;

public class TableControler {
	
	private PosData data;
	
	public TableControler(PosData data) {

		setData(data);
	}
	
	public void addTable(Table newTable)
	{
		try
		{
			getData().getTableList().add(newTable);
		}
		catch(Exception exception)
		{
			System.out.println("do not TableControler::addTable()");
			
		}

	}
	public void deleteTable(Table keyTable)
	{
		try
		{
			int index = this.searchTable(keyTable);
			
			getData().getTableList().remove(index);
		}
		catch(Exception exception)
		{
			System.out.println("do not TableControler::deleteTable()");

		}

	}

	public void addOrder(Table myTable, Menu order)
	{
		try
		{
			int tableIndex = Table.getSelectedTable();
			int menuIndex = searchOrderedMenu(tableIndex, order);
			
			System.out.println("Table Index: " + tableIndex + " " + "Menu Index: " + menuIndex);
			if( menuIndex == -1 )
			{
				getData().getTableList().get(tableIndex).getOrderList().add(order);
			}
			else
			{
				getData().getTableList().get(tableIndex).getOrderList().get(menuIndex).addQuantity();
			}
			
			getData().getTableList().get(tableIndex).setTotalPrice( calculate( getData().getTableList().get(tableIndex) ) );
		}
		catch(Exception exception)
		{
			System.out.println("do not TableControler::addOrder()");
		}

	}


	public void subOrder(Table myTable, Menu menu)
	{
		try
		{
			int tableIndex = Table.getSelectedTable();
			int menuIndex = searchOrderedMenu( tableIndex, menu );
			
			if( getData().getTableList().get(tableIndex).getOrderList().get(menuIndex).getCount() == 1 )
			{
				getData().getTableList().get(tableIndex).getOrderList().remove(menuIndex);
			}
			else
			{
				getData().getTableList().get(tableIndex).getOrderList().get(menuIndex).subQuantity();
			}
			
			getData().getTableList().get(tableIndex).setTotalPrice( calculate( getData().getTableList().get(tableIndex) ) );
		}
		catch(Exception exception)
		{
			System.out.println("do not TableControler::subOrder()");

		}
	}

	public void deleteOrder(Table myTable, Menu menu)
	{
		try
		{
			int tableIndex = searchTable(myTable);
			int menuIndex = searchOrderedMenu( tableIndex, menu );
			
			getData().getTableList().get(tableIndex).getOrderList().remove(menuIndex);
			getData().getTableList().get(tableIndex).setTotalPrice( calculate( getData().getTableList().get(tableIndex) ) );
		}
		catch(Exception exception)
		{
			System.out.println("do not TableControler::deleteOrder()");

		}
	}
	
	/**
	 * reset all ordered menu. It means all ordered menu is deleted and<br>
	 * total price of that table to be 0.
	 * 
	 * @param myTable
	 */
	public void resetOrder(Table myTable)
	{
		try
		{
			int index = searchTable(myTable);
			
			getData().getTableList().get(index).getOrderList().clear();
			getData().getTableList().get(index).setTotalPrice(0);
		}
		catch(Exception exception)
		{
			System.out.println("do not TableControler::resetOrder()");

		}
	}
	
	/**
	 * return sum of price of all menus ordered current table
	 * 
	 * @param myTable : Table
	 * @return sum : int
	 */
	public int calculate(Table myTable)
	{
		int sum = 0;
		
		try
		{
			for(int i = 0 ; i < myTable.getOrderList().size() ; i++)
				sum += myTable.getOrderList().get(i).getTotalPrice();
			
			return sum;
		}
		catch(Exception exception)
		{
			System.out.println("do not TableControler::myTableList()");

		}

		return 0;
	}
	
	/**
	 * return index of the specific table on the table list<br>
	 * if there's no such table then return negative value(-1)
	 * 
	 * @param keyTable : Table
	 * @return index : int
	 */
	public int searchTable(Table keyTable)
	{
		int index = -1;
		
		for(int i = 0; i < getData().getTableList().size(); i++)
		{
			if( keyTable.getTableNumber() == getData().getTableList().get(i).getTableNumber() )
			{
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	/**
	 * return index of the specific ordered menu on the ordered menu list<br>
	 * if there's no such table then return negative value(-1)
	 * 
	 * @param myTableIndex : int
	 * @param keyMenu : Menu
	 * @return index : int
	 */
	public int searchOrderedMenu(int myTableIndex, Menu keyMenu)
	{
		int index = -1;
		
		for(int i = 0; i < getData().getTableList().get(myTableIndex).getOrderList().size(); i++)
		{
			if( keyMenu.getName() == getData().getTableList().get(myTableIndex).getOrderList().get(i).getName() )
			{
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	public int getAllTableTotalPrice()
	{
		int sumOfTotal = 0;
		
		for(int i = 0; i < getData().getTableList().size(); i++)
			sumOfTotal += getData().getTableList().get(i).getTotalPrice();
		
		return sumOfTotal;
	}
	public PosData getData() {
		return data;
	}

	public void setData(PosData data) {
		this.data = data;
	}
}
