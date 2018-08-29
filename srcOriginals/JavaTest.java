
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class JavaTest
{
	

	public static void main(String[] arg)
	{
		String[] args = {"JavaTest.java", "JavaTest.bat"};
		//System.out.println(args[0] + " => " + args[1]);
		//Decoder.decode(args);
		//Encoder.encode(args);
		
	}
	
	
	
	
	
	
	
	

	public static String encrypt(String raw)
	{
		String temp = "";
		for (int i = 0; i < raw.length(); i++)
		{
			temp += (int) raw.charAt(i) + " ";
		}
		return temp;
	}

	public static String decrypt(String raw)
	{
		Scanner scan = new Scanner(raw);
		String temp = "";

		while (scan.hasNext())
		{
			int token = scan.nextInt();
			if (token == (int) '\n')
				temp += "\\n";
			else
				temp += (char) token;
		}
		scan.close();
		return temp;
	}

	public static boolean encryptFile(String fileIn, String fileOut)
	{
		try
		{
			Scanner scan = new Scanner(new File(fileIn));
			PrintWriter writer = new PrintWriter(new File(fileOut));
			while (scan.hasNextLine())
			{
				String temp = encrypt(scan.nextLine());
				writer.println(temp);
			}

			writer.close();
			scan.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}	
	
	public static boolean decryptFile(String fileIn, String fileOut)
	{
		try
		{
			Scanner javaScan = new Scanner(new File(fileIn));
			PrintWriter writer = new PrintWriter(new File(fileOut));
			while (javaScan.hasNextLine())
			{
				String temp = decrypt(javaScan.nextLine());
				writer.println(temp);
			}

			writer.close();
			javaScan.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

	public static boolean writeBatch(String fileIn, String fileOut)
	{
		try
		{
			PrintWriter writer = new PrintWriter(new File(fileOut));
			
			writer.println("@echo off");
			writer.println("java " + fileIn);
			writer.println("pause");
			writer.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	



	public static void mainTest(String[] args)
	{
		String javaName = "JavaTest";
		String encryptedJava = javaName + ".locked";
		String decryptedJava = javaName + ".java";
		String batchName = javaName + ".bat";
		
		//System.out.println(encryptFile(decryptedJava, encryptedJava));
		System.out.println(decryptFile(encryptedJava, decryptedJava));

		try
		{
			Process p = Runtime.getRuntime().exec("cmd /c javac " + decryptedJava + "\"");
			p.waitFor();
			//new File(decryptedJava).delete();
			System.out.println(writeBatch(javaName, batchName));
			Runtime.getRuntime().exec("cmd /c \"start " + batchName + "\"");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
