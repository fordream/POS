package controler;

import java.util.ArrayList;

import model.Menu;

public class MenuControler {

	
	public MenuControler() {
		
	}
	
	public void	addMenu(ArrayList<Menu> myMenuList,Menu newmMenu)
	{
		try
		{
		myMenuList.add(newmMenu);
		}
		catch(Exception exception)
		{
			System.out.println("do not addMenu()");
		}

	}
	public void	deleteMenu(ArrayList<Menu> myMenuList,int index)
	{
		try
		{
		myMenuList.remove(index);
		}
		catch(Exception exception)
		{
			System.out.println("do not deleteMenu()");
		}
	
	}

	public void	modifyMenu(ArrayList<Menu> myMenuList,int index,String modifyname,int modifyprice)
	{

		try
		{
			Menu temp = new Menu(modifyname,modifyprice);
			myMenuList.set(index,temp);
		}
		catch(Exception exception)
		{
			System.out.println("do not modifyMenu()");
		}

	}


}
