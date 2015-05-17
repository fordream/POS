package model;

import java.io.Serializable;
import java.util.ArrayList;

public class AccountData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 488808318105672178L;
	private ArrayList<Account> accountData;

	
	public AccountData() {
		super();
		this.accountData = new ArrayList<Account>();
	}
	
	
	public ArrayList<Account> getAccountData() {
		return accountData;
	}

	public void setAccountData(ArrayList<Account> accountData) {
		this.accountData = accountData;
	}

	
	

}
