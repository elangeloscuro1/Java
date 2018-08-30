
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Decoder
{
	public static void decode(String[] args)
	{
		decryptFile(args[0], args[1]);
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
}
