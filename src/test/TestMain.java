package test;

import java.util.Date;

<<<<<<< HEAD
import GUI.TableCalculatePage;
import GUI.TotalCalculatePage;
import model.PosData;
=======
import controler.AccountFileControler;
import controler.PosFileControler;
import model.Account;
import model.Menu;
import model.PosData;
import model.Table;
>>>>>>> 5e21cfc8ae9fb4e67c8cf43e34322665889ef52d



public class TestMain {

	public static void main(String[] args)
	{
<<<<<<< HEAD
		TotalCalculatePage t = new TotalCalculatePage();
=======
		
		Date a = new Date();
		Table table = new Table(0);
		Account account = new Account(a,table);
		table.getOrderList().add(new Menu("À½½Ä",300));
		
		AccountFileControler pfcon = new AccountFileControler(account);
		
		pfcon.readFromFile();
	   
		pfcon.writeToFile();
		
		
		
>>>>>>> 5e21cfc8ae9fb4e67c8cf43e34322665889ef52d
	}
}
