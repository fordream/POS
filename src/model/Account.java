package model;

import java.io.Serializable;
import java.util.Date;

public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 121239531072292830L;
	/**
	 * 
	 */
	
	private Date date;
	private Table nowTable;
	
	public Account(Date date, Table nowTable) {
		super();
		this.date = date;
		this.nowTable = nowTable;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Table getNowTable() {
		return nowTable;
	}
	public void setNowTable(Table nowTable) {
		this.nowTable = nowTable;
	}

}
