
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Batch
{
	
	public static void write(String[] args)
	{
		try
		{
			Scanner scan = new Scanner(new File(args[0]));
			PrintWriter writer = new PrintWriter(new File(args[1]));
			
			writer.println("@echo off");
			writer.println("type nul > X" + args[0]);//X
			System.out.println("@echo off");
			System.out.println("type nul > X" + args[0]);//X
			
			while (scan.hasNextLine())
			{
				String temp = "echo: " + scan.nextLine() + " >> X" + args[0];//X
				writer.println(temp);
				System.out.println(temp);//
			}

			
			//writer.println("pause");
			
			writer.close();
			scan.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static String replaceSymbols(String line)
	{
		String newLine = "'\" \"'\"   ";
		int sQt = 0;
		int dQt = 0;
		
		for (int i = 0; i < line.length(); i++)
		{
			char c = line.charAt(i);
			if (c == '\'' && (i + 2) < line.length())
			{
				if (line.charAt(i + 1) == '"')
				{
					
				}
			}
			
			
		}
		
		return newLine;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static String x1(String line)
	{
		String newLine = "";
		int sQuote = 0;
		int dQquote = 0;
		
		for (int i = 0; i < line.length(); i++)
		{
			char c = line.charAt(i);
			if (c == '\'' && (i+2) < line.length())
			{
				newLine += "^'";
				if (line.charAt(i + 1) == '"' )
				{
					
				}
			}
			
			
		}
		
		return newLine;
	}
	
	
	
	
	
	
	
	
	
	
	
}
