package controler;

public class PasswordControler {

	
	public PasswordControler() 
	{

	}

	public boolean checkPassword(String password)
	{
		try
		{
			if( password.equals("") )
				return true;
			else
				return false;
		}
		catch(Exception exception)
		{
			System.out.println("do not checkPassword()");
			
		}
		return false;
	}
}
