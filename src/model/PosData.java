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
	private Mypassword password;
	
	
	public PosData(ArrayList<Table> tableList, ArrayList<Menu> menuList,
			Mypassword password) {
		super();
		this.tableList = tableList;
		this.menuList = menuList;
		this.password = password;
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
	
	public Mypassword getPassword() {
		return password;
	}
	
	public void setPassword(Mypassword password) {
		this.password = password;
	}
	
	

}
