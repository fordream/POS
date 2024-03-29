package model;

import java.io.Serializable;
import java.util.Date;

public class Menu implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9140534453939961687L;
	private String name;
	private Date date;
	private boolean escape;
	private int price;
	private int count;
	
	public Menu(String name, int price) {
		this.name = name;
		this.price = price;
		this.count = 1;
	}
	
	public Menu(String name, int price, Date date) {
		this.name = name;
		this.price = price;
		this.count = 1;
		setDate(date);
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
		count++;
	}
	
	public void subQuantity()
	{
		if(getCount() > 1)
			setCount(getCount() -1);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isEscape() {
		return escape;
	}

	public void setEscape(boolean escape) {
		this.escape = escape;
	}
}
