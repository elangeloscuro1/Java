/*HIDE*/
import java.util.Scanner;

public class Java002
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("This program repeats a sentence as many times you want.");
		System.out.print("Enter the number of times you want your sentence to be repeated: ");
		int size = scan.nextInt();
		scan.nextLine();//gets rid of \n since we have5 just used nextInt
		
		System.out.print("Enter the sentence to be repeated " + size + " time(s): ");
		String sentence = scan.nextLine();
		
		for (int i = 1; i <= size; i++)
		{
			System.out.println(i +  " \"" + sentence + "\"");
		}
		
		System.out.println("\nThe following asterisks represent each time your sentence is repeated");
		
		for (int i = 1; i <= size; i++)
		{
			System.out.print("*");
		}
		
		System.out.println("\n\nLet's do this again but now a bit different!");
		System.out.print("Enter the number of times followed by the sentence to be repeated: ");
		size = scan.nextInt();
		sentence = scan.nextLine();
		
		for (int i = 1; i <= size; i++)
		{
			System.out.println(i +  " \"" + sentence + "\"");
		}
		
		for (int i = 1; i <= size; i++)
		{
			System.out.print("*");
		}
		System.out.println("\n\nEnd of the proram!\nThank you for using this simple program!");
		
		
		
		
		
		scan.close();
	}
}
