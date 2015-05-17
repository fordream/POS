package model;

import java.util.ArrayList;

public class AccountData {
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
