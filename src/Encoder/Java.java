/*HIDE*/
import java.util.Scanner;

public class Java001
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("This program prints a list of numbers starting from zero.");
		System.out.print("How many numbers would you like to print? ");
		int size = scan.nextInt();
		
		for (int i = 0; i <= size; i++)
		{
			System.out.println("    " + i);
		}
		scan.close();
	}
}
