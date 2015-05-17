package model;
import java.io.Serializable;
import java.util.ArrayList;


public class PosData implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 386210817840445076L;
	
	private ArrayList<Table> tableList; 
	private ArrayList<Menu> menuList;
	
	public PosData() {
		tableList = new ArrayList<Table>();
		menuList = new ArrayList<Menu>();
		
	}
	
	public ArrayList<Table> getTableList() {
		return tableList;
	}
	
	public void setTableList(ArrayList<Table> tableList) {
		this.tableList = tableList;
	}
	
	public ArrayList<Menu> getMenuList() {
		return menuList;
	}
	
	public void setMenuList(ArrayList<Menu> menuList) {
		this.menuList = menuList;
	}
}
