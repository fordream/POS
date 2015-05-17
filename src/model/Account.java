package model;

import java.util.Date;

public class Account {
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
