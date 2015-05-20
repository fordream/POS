package model;

import java.io.Serializable;
import java.util.ArrayList;

public class AccountData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 488808318105672178L;
	private ArrayList<Account> accountDataList;

	
	public AccountData() {
		super();
		this.accountDataList = new ArrayList<Account>();
	}
	
	
	public ArrayList<Account> getAccountDataList() {
		return accountDataList;
	}

	public void setAccountDataList(ArrayList<Account> accountData) {
		this.accountDataList = accountData;
	}

	
	

}
