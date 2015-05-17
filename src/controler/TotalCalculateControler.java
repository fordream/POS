package controler;

import java.util.ArrayList;

import model.Table;

public class TotalCalculateControler {

	public int calculate(ArrayList<Table> TableList)
	{
		try
		{
			int sum = 0 ;
			TableControler Tcontorler = new TableControler();
			for(int i=0; i< TableList.size();i++)
			{
				sum += Tcontorler.calculate(TableList.get(i));
			}
			return sum;
		}
		catch(Exception exception)
		{
			System.out.println("do not TotalCalculateControler::calculate()");
		}
		return 0;
	}
}
