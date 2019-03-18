package utils;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Set;

import storage.DatabaseInterface;

public class Validator 
{
	public static boolean debug = false;
	static PrintStream p;

	public static void initialise()
	{
		try
		{
			FileOutputStream f = new FileOutputStream("log.txt");
			p = new PrintStream(f);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.toString());
		}
	}
	
	public static void validatorAssert(String message)
	{
		log("Validator assert", message);
	}
	
	public static void validate(DatabaseInterface db)
	{
		if(debug)
		{
			//Set<MVMap> 
			Set<String> mapnames = db.s.getMapNames();
			if(mapnames.size()>3)
			{
				validatorAssert("Too many map names");
			}
			
			
		}
	}
	
	public static void log(String type,String message)
	{
		if(debug)
		{
			System.out.println(type+"\t\t:"+message);
			p.append(type+"\t\t:"+message);
			p.flush();
		}
	}
}
