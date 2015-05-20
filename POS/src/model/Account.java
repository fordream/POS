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
	private boolean escape;
	
	public Account(Date date, Table nowTable, boolean escape) {
		super();
		this.date = date;
		this.nowTable = nowTable;
		this.escape = escape;
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
	
	public boolean isEscape() {
		return escape;
	}
	
	public void setEscape(boolean escape) {
		this.escape = escape;
	}

}
