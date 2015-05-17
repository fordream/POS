package test;

import java.util.Date;

import controler.AccountFileControler;
import controler.PosFileControler;
import model.Account;
import model.Menu;
import model.PosData;
import model.Table;



public class TestMain {

	public static void main(String[] args)
	{
		
		Date a = new Date();
		Table table = new Table(0);
		Account account = new Account(a,table);
		table.getOrderList().add(new Menu("À½½Ä",300));
		
		AccountFileControler pfcon = new AccountFileControler(account);
		
		pfcon.readFromFile();
	   
		pfcon.writeToFile();
		
		
		
	}
}
