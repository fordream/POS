package controler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import model.Account;
import model.AccountData;




public class AccountFileControler  {

	private AccountData accountDataPack;
	
	public AccountFileControler(Account account) {
		readFromFile();
		
		accountDataPack.getAccountDataList().add(account);
		
		writeToFile();
	}
	
	public AccountFileControler() {
		readFromFile();
	}
	
	public void readFromFile()
	{
		try
		{
			FileInputStream fin = new FileInputStream("accountdatafile.dat");
			ObjectInputStream oin = new ObjectInputStream(fin);
			
			AccountData temp = (AccountData)oin.readObject();
			
			setAccountData(temp);
			
			oin.close();
			fin.close();
			
			for(int i = 0; i < getAccountDataPack().getAccountDataList().size(); i++)
			{
				System.out.println("Account" + i + ", Table" + getAccountDataPack().getAccountDataList().get(i).getNowTable().getTableNumber());
				for(int j = 0; j < getAccountDataPack().getAccountDataList().get(i).getNowTable().getOrderList().size(); j++)
				{
					System.out.println(getAccountDataPack().getAccountDataList().get(i).getNowTable().getOrderList().get(j).getName() + " " +
									getAccountDataPack().getAccountDataList().get(i).getNowTable().getOrderList().get(j).getCount() + "°³");
				}
			}
		}
		catch(Exception exception)
		{
			System.err.println("AccountFileControler::readFromFile() :cannot open the file!");
			accountDataPack = new AccountData();
			writeToFile();
		}
	}

	public void writeToFile()
	{
		try
		{
			FileOutputStream fout = new FileOutputStream("accountdatafile.dat");
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			
			oout.writeObject(getAccountDataPack());
			
			oout.close();
			fout.close();
			
			for(int i = 0; i < getAccountDataPack().getAccountDataList().size(); i++)
			{
				System.out.println("Account" + i + ", Table" + getAccountDataPack().getAccountDataList().get(i).getNowTable().getTableNumber());
				for(int j = 0; j < getAccountDataPack().getAccountDataList().get(i).getNowTable().getOrderList().size(); j++)
				{
					System.out.println(getAccountDataPack().getAccountDataList().get(i).getNowTable().getOrderList().get(j).getName() + " " +
									getAccountDataPack().getAccountDataList().get(i).getNowTable().getOrderList().get(j).getCount() + "°³");
				}
			}
		}
		catch(Exception exception)
		{
			System.out.println(" AccountFileControler::writeToFile() :cannot open the file!");
		}
	}
	
	public AccountData getAccountDataPack() {
		return accountDataPack;
	}
	
	public void setAccountData(AccountData accountData) {
		this.accountDataPack = accountData;
	}

	
}
