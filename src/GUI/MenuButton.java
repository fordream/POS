package GUI;

import javax.swing.JButton;

public class MenuButton extends JButton
{
	private String menuName;
	private int menuPrice ;
	
	public MenuButton()
	{
		super();
	}
	
	public MenuButton(String buttonName)
	{
		super(buttonName);
	}
	
	public void setMenuName(String name)
	{
		menuName = name;
	}
	
	public void setMenuPrice(int price)
	{
		menuPrice = price;
	}
	
	public String getMenuName()
	{
		return menuName;
	}
	
	public int getMenuPrice()
	{
		return menuPrice;
	}
}
