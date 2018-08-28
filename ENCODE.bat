@echo off

::set fileName=JavaTest
set /p fileName=Enter file name: 
set fileErrorName=%fileName: =%.java

if not exist %fileErrorName% (
echo ERROR: .java file for "%fileName%" does not exist! 
pause
exit
)

javac %fileErrorName% || cls && echo "%fileErrorName%" could not compile! && pause && exit
del %fileName%.class

set encName=Encoder
set encJava=%encName%.java

echo import java.io.File; > %encJava%
echo import java.io.FileNotFoundException; >> %encJava%
echo import java.io.PrintWriter; >> %encJava%
echo import java.util.Scanner; >> %encJava%
echo public class %encName% >> %encJava%
echo { >> %encJava%
echo 	public static void main(String[] args) >> %encJava%
echo 	{ >> %encJava%
echo 		encryptFile(args[0], args[1]); >> %encJava%
echo 	} >> %encJava%
echo 	public static String encrypt(String raw) >> %encJava%
echo 	{ >> %encJava%
echo 		String temp = ""; >> %encJava%
echo 		for (int i = 0; i ^< raw.length(); i++) >> %encJava%
echo 		{ >> %encJava%
echo 			temp += (int) raw.charAt(i) + " "; >> %encJava%
echo 		} >> %encJava%
echo 		return temp; >> %encJava%
echo 	} >> %encJava%
echo 	public static boolean encryptFile(String fileIn, String fileOut) >> %encJava%
echo 	{ >> %encJava%
echo 		try >> %encJava%
echo 		{ >> %encJava%
echo 			Scanner scan = new Scanner(new File(fileIn)); >> %encJava%
echo 			PrintWriter writer = new PrintWriter(new File(fileOut)); >> %encJava%
echo 			while (scan.hasNextLine()) >> %encJava%
echo 			{ >> %encJava%
echo 				String temp = encrypt(scan.nextLine()); >> %encJava%
echo 				writer.println(temp); >> %encJava%
echo 			} >> %encJava%
echo 			writer.close(); >> %encJava%
echo 			scan.close(); >> %encJava%
echo 		} >> %encJava%
echo 		catch (FileNotFoundException e) >> %encJava%
echo 		{ >> %encJava%
echo 			e.printStackTrace(); >> %encJava%
echo 			return false; >> %encJava%
echo 		} >> %encJava%
echo 		return true; >> %encJava%
echo 	} >> %encJava%
echo } >> %encJava%


javac %encJava%
java %encName% %fileErrorName% %fileName%
del %encJava%
del %encName%.class
exit
