package controler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import model.Account;
import model.AccountData;




public class AccountFileControler  {

	private AccountData accountData;
	
	public AccountFileControler(Account account) {
		AccountData temp;
		readFromFile();
		temp = getAccountData();
		temp.getAccountData().add(account);
		setAccountData(temp);
	}
	
	
	public void readFromFile()
	{
		try
		{
<<<<<<< HEAD
			FileInputStream fin = new FileInputStream("accountfile.dat");
=======
			FileInputStream fin = new FileInputStream("accountdatafile.dat");
>>>>>>> 5e21cfc8ae9fb4e67c8cf43e34322665889ef52d
			ObjectInputStream oin = new ObjectInputStream(fin);
			
			AccountData temp = (AccountData)oin.readObject();
			
			setAccountData(temp);
			
			oin.close();
			fin.close();
		}
		catch(Exception exception)
		{
			System.out.println("AccountFileControler::readFromFile() :cannot open the file!");
		}
		finally
		{
			for(int i = 0; i < getAccountData().getAccountData().size(); i++)
			{
				System.out.println("read string :" + getAccountData().getAccountData().get(i));
			}
			
		}
	}

	public void writeToFile()
	{
		try
		{
<<<<<<< HEAD
			FileOutputStream fout = new FileOutputStream("accountfile.dat");
=======
			FileOutputStream fout = new FileOutputStream("accountdatafile.dat");
>>>>>>> 5e21cfc8ae9fb4e67c8cf43e34322665889ef52d
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			
			oout.writeObject(getAccountData());
			
			oout.close();
			fout.close();
		}
		catch(Exception exception)
		{
			System.out.println(" AccountFileControler::writeToFile() :cannot open the file!");
		}
		finally
		{
			for(int i = 0; i < getAccountData().getAccountData().size(); i++)
			{
				System.out.println("read string :" + getAccountData().getAccountData().get(i));
			}
		}
	}
	
	
	
	public AccountData getAccountData() {
		return accountData;
	}
	public void setAccountData(AccountData accountData) {
		this.accountData = accountData;
	}

	
}
