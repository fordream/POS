package controler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.PosData;



public class PosFileControler   {
	PosData data;

	
	public PosFileControler(PosData data) {
		
		setData(data);
	}
	
	
	public void readFromFile()
	{
		try
		{
			FileInputStream fin = new FileInputStream("datafile.dat");
			ObjectInputStream oin = new ObjectInputStream(fin);
			
			PosData temp = (PosData)oin.readObject();
			
			setData(temp);
			

			oin.close();
			fin.close();
		}
		catch(Exception exception)
		{
			System.out.println("cannot open and read the file!");
		}
		finally
		{
			for(int i = 0; i < getData().getMenuList().size(); i++)
			{
				System.out.println("read string :" + getData().getMenuList().get(i));
			}
			for(int i = 0; i < getData().getTableList().size(); i++)
			{
				System.out.println("read string :" + getData().getTableList().get(i));
			}
		}
	}
	
	
	public void writeToFile()
	{
		try
		{
			FileOutputStream fout = new FileOutputStream("datafile.dat");
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			
			oout.writeObject(getData());

			oout.close();
			fout.close();
		}
		catch(Exception exception)
		{
			System.out.println("cannot open and write the file!");
		}
		finally
		{
			for(int i = 0; i < getData().getMenuList().size(); i++)
			{
				System.out.println("write string :" + getData().getMenuList().get(i));
			}
			for(int i = 0; i < getData().getTableList().size(); i++)
			{
				System.out.println("write string :" + getData().getTableList().get(i));
			}
		}
	}


	public PosData getData() {
		return data;
	}


	public void setData(PosData data) {
		this.data = data;
	}


}
