package test;

import java.util.Date;


public class TestMain {

	public static void main(String[] args)
	{
		Date now = new Date();
		Date before12h = new Date();
		Date before1sec = new Date();
		Date after1sec = new Date();
		
		before12h.setHours(now.getHours() - 12);
		before1sec.setSeconds(now.getSeconds() - 1);
		after1sec.setHours(now.getSeconds() + 1);
		
		System.out.println("<Now Time>");
		System.out.println("Year : " + now.getYear());
		System.out.println("Month : " + now.getMonth());
		System.out.println("Day : " + now.getDay());
		System.out.println("Hour : " + now.getHours());
		
		System.out.println("\n");
		
		System.out.println("<12hrs ago>");
		System.out.println("Year : " + before12h.getYear());
		System.out.println("Month : " + before12h.getMonth());
		System.out.println("Day : " + before12h.getDay());
		System.out.println("Hour : " + before12h.getHours());
		
		System.out.println("\n");
		System.out.println(now.compareTo(now));
		System.out.println(now.compareTo(before12h));
		System.out.println(now.compareTo(before1sec));
		System.out.println(now.compareTo(after1sec));
		
		if( now.after(before12h) )
		{
			System.out.println("지금은 12시간 전보다 크다");
		}
	}
}
