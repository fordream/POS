package model;
import java.util.*;
import java.io.*;

public class Pdata implements Serializable{

	
	ArrayList<String> stringList;
	
	public Pdata()
	{
		stringList = new ArrayList<String>();
	}

	public ArrayList<String> getStringList() 
	{
		return stringList;
	}

	public void setStringList(ArrayList<String> stringList) 
	{
		this.stringList = stringList;
	}
	
	
}
