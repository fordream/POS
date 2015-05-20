package controler;

public class PasswordControler {

	
	public PasswordControler() 
	{

	}

	public boolean checkPassword(String password, String inputPassword)
	{
		try
		{
			if( inputPassword.equals(password) )
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
