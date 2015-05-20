package controler;

import java.util.ArrayList;

import model.Food;
import model.Menu;
import model.PosData;

public class MenuControler {

	private PosData data;
	
	public MenuControler(PosData data) {
		setData(data);
	}
	
	/**
	 * add new menu if there's no duplicated menu exits on the menu list<br>
	 * otherwise, modify the menu(price)
	 * 
	 * @param newMenu
	 */
	public void	addMenu(Menu menu)
	{
		try
		{
			int index = searchMenu(menu);
			
			if( index == -1 )
				getData().getMenuList().add(menu);
			else
				modifyMenu( index, menu );
		}
		catch(Exception exception)
		{
			System.out.println("do not addMenu()");
		}
	}
	
	/**
	 * delete specific menu from the menu list by index(int)
	 * 
	 * @param index : int
	 */
	public void	deleteMenu(int index)
	{
		try
		{
			getData().getMenuList().remove(index);
		}
		catch(Exception exception)
		{
			System.out.println("do not deleteMenu()");
		}
	
	}
	
	/**
	 * delete specific menu from the menu list by key(Menu)
	 * 
	 * @param index : int
	 */
	public void	deleteMenu(Menu menu)
	{
		try
		{
			int index = searchMenu(menu);
			
			if(index != -1)
				getData().getMenuList().remove(index);
		}
		catch(Exception exception)
		{
			System.out.println("do not deleteMenu()");
		}
	
	}

	/**
	 * modify(reset) specific menu on the menu list by index
	 * 
	 * @param index
	 * @param menu
	 */
	public void	modifyMenu(int index, Menu menu)
	{
		try
		{
			getData().getMenuList().set(index, menu);
		}
		catch(Exception exception)
		{
			System.out.println("do not modifyMenu()");
		}

	}

	/**
	 * if there exists such menu then return the index of the menu<br>
	 * otherwise, return negative value(-1)
	 * 
	 * 2015.05.20 - add case
	 * if there is a menu that has same name but different type
	 * then return -2
	 * 
	 * @return index
	 */
	public int searchMenu(Menu keyMenu)
	{
		int index = -1;
		
		for(int i = 0; i < getData().getMenuList().size(); i++)
		{
			if( getData().getMenuList().get(i).getName().equals( keyMenu.getName() ))
			{
				if( !( (getData().getMenuList().get(i) instanceof Food) && (keyMenu instanceof Food) ) )
				{
					index = -2;
				}
				if( !( (getData().getMenuList().get(i) instanceof Food) && (keyMenu instanceof Food) ) )
				{
					index = -2;
				}
				index = i;
				break;
			}
		}
			
		return index;
	}
	
	/**
	 * if there exists such menu then return the index of the menu<br>
	 * otherwise, return negative value(-1)
	 * 
	 * @return index
	 */
	public int searchMenu(String nameOfMenu)
	{
		int index = -1;
		System.out.println("Start Search Menu");
		for(int i = 0; i < getData().getMenuList().size(); i++)
		{
			if( getData().getMenuList().get(i).getName().equals( nameOfMenu ))
			{
				System.out.println("" + getData().getMenuList().get(i).getName() +  " " + getData().getMenuList().get(i).getCount());
				index = i;
				break;
			}
		}
			
		return index;
	}

	public PosData getData() {
		return data;
	}

	public void setData(PosData data) {
		this.data = data;
	}
	
	
}
