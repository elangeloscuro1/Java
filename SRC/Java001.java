import java.util.Scanner;

public class Java001
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter your full name");
		System.out.print("(for example: Speedy Gonzalez): ");
		String fullName = scan.nextLine();
		System.out.println("You entered \"" + fullName + "\"\n");
		
		System.out.print("Enter your age: ");
		int age = scan.nextInt();//scans on the same line and stays there waiting for a next call
		scan.nextLine();//finishes the previews call and get ready to get new input
		System.out.println("You entered \"" + age + "\"\n");
		
		System.out.print("Enter the title of your a book: ");
		String bookTitle = scan.nextLine();
		System.out.println("You entered \"" + bookTitle + "\"\n");
		
		System.out.print("Enter a decimal number: ");
		System.out.print("(for example: 1.5): ");
		double aDecimal = scan.nextDouble();//scans on the same line and stays there waiting for a next call
		scan.nextLine();//finishes the previews call and get ready to get new input
		System.out.println("You entered \"" + aDecimal + "\"\n");
		
		System.out.println("Enter four words (separated with spaces): ");
		String word1 = scan.next();//scans on the same line and stays there waiting for a next call
		String word2 = scan.next();//scans on the same line and stays there waiting for a next call
		String word3 = scan.next();//scans on the same line and stays there waiting for a next call
		String word4 = scan.next();//scans on the same line and stays there waiting for a next call
		scan.nextLine();//finishes the previews call and get ready to get new input
		
		System.out.println("You entered: ");
		System.out.println("\"" + word1 + "\"");
		System.out.println("\"" + word2 + "\"");
		System.out.println("\"" + word3 + "\"");
		System.out.println("\"" + word4 + "\"");
		
		System.out.println("\nEnd of the program!");
		
		scan.close();
	}
}
