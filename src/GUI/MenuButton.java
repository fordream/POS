package GUI;

import javax.swing.JButton;

public class MenuButton extends JButton
{
	private String menuName;
	private int menuPrice ;
	private int count;
	
	public MenuButton()
	{
		super();
		count = 0;
	}
	
	public MenuButton(String buttonName)
	{
		super(buttonName);
		count = 0;
	}
	
	public MenuButton(String buttonName, int menuPrice)
	{
		super(buttonName);
		count = 0;
		setMenuPrice(menuPrice);
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

	public int getCount() {
		return count;
	}

	public void addCount() {
		count ++;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
}
