import java.util.Scanner;

public class Java001_BT
{		
	public static void main(String[] args)
	{	
		Scanner keyboard = new Scanner(System.in);
			
		System.out.println("Enter your name");
		
		System.out.println("(For example: Speedy Gonzalez:)");
		String name = keyboard.nextLine();
		
		System.out.println("Your name is " + "\"" + name + "\"");
		
		System.out.println("\nEnter your age:");
		int age = keyboard.nextInt();
		
		System.out.println("You are " + "\"" + age + "\"");
		
		keyboard.nextLine();//gets rid of \n
	
		System.out.println("\nEnter a book title:");
		String aTextB = keyboard.nextLine();
		
		System.out.println("The book title = " + "\"" + aTextB + "\"");
			
		System.out.println("\nEnter a decimal: (For example: 1.5)");
		double aD = keyboard.nextDouble();
		
		System.out.println("You entered " + "\"" + aD + "\"");
		
		System.out.println("\nEnter a four words (seperate with spaces):");
		String aWord = keyboard.next();
		
		String aMord = keyboard.next();

		String aTord = keyboard.next();
		
		String aFord = keyboard.next();
		
		System.out.println("You entered " + "\"" + aWord + " " + aMord + " " + aTord + " " + aFord + "\"");
		
		keyboard.close();
	}

}