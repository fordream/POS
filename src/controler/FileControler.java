package controler;

<<<<<<< HEAD
public class FileControler {

=======
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Pdata;

public class FileControler {
	private Pdata data;
	private String saveFileName;
	
	
	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	public FileControler(Pdata data)
	{
		setData(data);
		saveFileName = new String("datafile.dat");
	}
	
	public Pdata getData() {
		return data;
	}

	public void setData(Pdata data) {
		this.data = data;
	}
	public void readFromFile()
	{
		try
		{
			FileInputStream fin = new FileInputStream(saveFileName);
			ObjectInputStream oin = new ObjectInputStream(fin);
			
			Pdata temp = (Pdata)oin.readObject();
			
			setData(temp);
			
			oin.close();
			fin.close();
		}
		catch(Exception exception)
		{
			System.out.println(this.getClass() + "cannot open the file!");
		}
		finally
		{
			for(int i = 0; i < getData().getStringList().size(); i++)
			{
				System.out.println("read string :" + getData().getStringList().get(i));
			}
		}
	}
	public void appendToFile()
	{
		try
		{
			FileOutputStream fout = new FileOutputStream(saveFileName);
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			
			oout.writeObject(getData());

			oout.close();
			fout.close();
		}
		catch(Exception exception)
		{
			System.out.println(this.getClass()+"cannot open the file!");
		}
		finally
		{
			for(int i = 0; i < getData().getStringList().size(); i++)
			{
				System.out.println("append string :" + getData().getStringList().get(i));
			}
		}
		
	}
	public void writeToFile()
	{
		try
		{
			FileOutputStream fout = new FileOutputStream(saveFileName);
			ObjectOutputStream oout = new ObjectOutputStream(fout);

			oout.writeObject(getData());

			oout.close();
			fout.close();
		}
		catch(Exception exception)
		{
			System.out.println(this.getClass()+"cannot open the file!");
		}
		finally
		{
			for(int i = 0; i < getData().getStringList().size(); i++)
			{
				System.out.println("written string :" + getData().getStringList().get(i));
			}
		}
	}
>>>>>>> e442888577e16d16a9de55297d50c60ddc761ed5
}
