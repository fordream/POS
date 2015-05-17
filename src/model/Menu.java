package model;

import java.io.Serializable;

public class Menu implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9140534453939961687L;
	private String name;
	private int price;
	private int count;
	
	public Menu(String name, int price) {
		this.name = name;
		this.price = price;
		this.count = 1;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotalPrice()
	{
		return getCount() * getPrice();
	}
	
	public void addQuantity()
	{
		setCount(getCount() + 1);
	}
	
	public void subQuantity()
	{
		if(getCount() > 1)
			setCount(getCount() -1);
	}
}
