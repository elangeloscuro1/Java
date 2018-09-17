/*HIDE*/
import java.util.Scanner;

public class Java003
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String firstString = "";
		String stringName = "";
		String nameRevered = "";
		int strLength = 0;
		int index=0;
		System.out.println("==== String ====");
		System.out.print("Enter a String: ");
		
		firstString = scan.nextLine();
		strLength = firstString.length();
		
		System.out.println("You entered: \"" + firstString + "\"");
		System.out.println(firstString + " has a length of " + strLength + " characters." );
		
		for (int i = 0; i < strLength; i++)
		{
			System.out.println("index [" + i + "] contains '" + firstString.charAt(i) + "'");
		}
		
		System.out.println("Enter an index from 0 to " + (strLength - 1) + ": ");
		index = scan.nextInt();
		System.out.println("The char at index " + index + " is '" + firstString.charAt(index) + "'");
		scan.nextLine();
		System.out.print("Now, please enter your name and I will reverse it for you: ");
		stringName = scan.next();
		
		for (int i = stringName.length() - 1; i >= 0; i--)
		{
			nameRevered += stringName.charAt(i);
		}
		System.out.println(stringName + " <==> " +  nameRevered);
		
		System.out.println("End of the program!");
		
		scan.close();
	}
}
