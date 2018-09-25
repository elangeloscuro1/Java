
import java.util.Scanner;

public class JavaTest
{		
	public static void main(String[] args)
	{	
		Scanner keyboard = new Scanner(System.in);
				
			System.out.println("This program repeats a sentence as many times as you want.");
				
			System.out.println("Enter the number of times you want your sentence to be repeated:");
			int aInt = keyboard.nextInt();
				
			keyboard.nextLine();
				
			System.out.println("Enter the sentence to be repeated " + aInt + " time(s):");
			String aS = keyboard.nextLine();
					
			int times = aInt + 1;
				
			for(int x = 1; x < times; x = x + 1) 
			{
				System.out.print(x + "\"" + aS + "\"");
		        System.out.print("\n");
			}
				
			System.out.println("The following asterisks represent each time your sentence is repeated");
				
			for(int x = 1; x < times; x = x + 1) 
			{
					System.out.print("*");
			}
				
			System.out.println("\nLet's do this again, but now a bit different!");
				
			System.out.println("Enter the number of times your sentence will be repeated and also enter you sentence:");
			int aNum = keyboard.nextInt();
				
			String aSe = keyboard.nextLine();
				
			int timess = aNum + 1;
				
			for(int x = 1; x < timess; x = x + 1) 
			{
				System.out.print(x + "\"" + aSe + "\"");
		        System.out.print("\n");
			}
				
			int timmes = aNum + 1;
				
			for(int x = 1; x < timmes; x = x + 1) 
			{
					System.out.print("*");
			}
				
			System.out.println("\nThank you for using my simple program!");
		
		keyboard.close();
	}

}