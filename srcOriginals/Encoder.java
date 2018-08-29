
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Encoder
{
	public static void encode(String[] args)
	{
		encryptFile(args[0], args[1]);
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

}
