package controler;

public class PasswordControler {




	public PasswordControler() 
	{

	}

	public boolean checkPassword(String Mypassword,String _inputPassword)
	{
		try
		{
			if(Mypassword.compareTo(_inputPassword) == 0)
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
