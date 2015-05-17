package model;
import java.util.ArrayList;

import javax.xml.crypto.Data;


public class Table {
	
	private ArrayList<Menu> orderList;
	private int tableNumber;
	private Data time;
	private int color;
	private int totalPrice;
	
	
	
	public Table(ArrayList<Menu> orderList, int tableNumber, Data time,
			int color, int totalPrice) {
		super();
		this.orderList = orderList;
		this.tableNumber = tableNumber;
		this.time = time;
		this.color = color;
		this.totalPrice = totalPrice;
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
	public Data getTime() {
		return time;
	}
	public void setTime(Data time) {
		this.time = time;
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
	

}
