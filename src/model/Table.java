package model;
import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.crypto.Data;


public class Table implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5770272354422577026L;
	private ArrayList<Menu> orderList;
	private int tableNumber;
	private int color;
	private int totalPrice;
	
	/**
	 * ����� ����� �������� true, Ƣ������ false
	 * <br> default�� false
	 */
	private boolean paid;
	
	
	public Table( int tableNumber) {
		super();
		this.orderList = new ArrayList<Menu>();
		this.tableNumber = tableNumber;
		setPaid(false);
	}
	
	public ArrayList<Menu> getOrderList() {
		return orderList;
	}
	public void setOrderList(ArrayList<Menu> orderList) {
		this.orderList = orderList;
	}
	public int getTableNumber() {
		return tableNumber;
	}
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}
	
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	

}
