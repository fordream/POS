package controler;

import java.util.ArrayList;

import model.Menu;
import model.Table;

public class TableControler {
	
	
	
	
	public TableControler() {

	}
	
	public void addTable(ArrayList<Table>myTableList,Table newTable)
	{
		try
		{
		myTableList.add(newTable);
		}
		catch(Exception exception)
		{
			System.out.println("do not TableControler::addTable()");
			
		}

	}
	public void deleteTable(ArrayList<Table> myTableList,int index)
	{
		try
		{
			myTableList.remove(index);
		}
		catch(Exception exception)
		{
			System.out.println("do not TableControler::deleteTable()");

		}

	}

	public void addOrder(Table myTable,Menu order)
	{
		try
		{
		MenuControler controler = new MenuControler();
		controler.addMenu(myTable.getOrderList(), order);
		}
		catch(Exception exception)
		{
			System.out.println("do not TableControler::addOrder()");

		}

	}


	public void subOrder(Table myTable,int index)
	{
		try
		{
			MenuControler controler = new MenuControler();
			controler.deleteMenu(myTable.getOrderList(), index);
		}
		catch(Exception exception)
		{
			System.out.println("do not TableControler::subOrder()");

		}
	}

	public void deleteOrder(Table myTable)
	{
		try
		{
			myTable.getOrderList().clear();
		}
		catch(Exception exception)
		{
			System.out.println("do not TableControler::deleteOrder()");

		}
	}
	public void resetOrder(Table myTable)
	{
		try
		{
			myTable.getOrderList().clear();
		}
		catch(Exception exception)
		{
			System.out.println("do not TableControler::resetOrder()");

		}
	}
	
	public int calculate(Table myTable)
	{
		try
		{
			int sum=0;
			for(int i=0;i<myTable.getOrderList().size();i++)
				sum += myTable.getOrderList().get(i).getPrice();
				
			return sum;
				
		}
		catch(Exception exception)
		{
			System.out.println("do not TableControler::myTableList()");

		}
		return 0;
	}
}
