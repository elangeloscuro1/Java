@echo off

set fileName=Java000
::set /p fileName=Enter file name: 
set fileErrorName=%fileName: =%

if not exist %fileErrorName% (
echo ERROR: file "%fileName%" does not exist! 
pause
exit
)

set decName=Decoder
set decJava=%decName%.java

echo import java.io.File; > %decJava%
echo import java.io.FileNotFoundException; >> %decJava%
echo import java.io.PrintWriter; >> %decJava%
echo import java.util.Scanner; >> %decJava%
echo public class %decName% >> %decJava%
echo { >> %decJava%
echo 	public static void main(String[] args) >> %decJava%
echo 	{ >> %decJava%
echo         decryptFile(args[0], args[0] + ".java"); >> %decJava%
echo 	} >> %decJava%
echo 	public static String decrypt(String raw) >> %decJava%
echo 	{ >> %decJava%
echo 		Scanner scan = new Scanner(raw); >> %decJava%
echo 		String temp = ""; >> %decJava%
echo 		while (scan.hasNext()) >> %decJava%
echo 		{ >> %decJava%
echo 			int token = scan.nextInt(); >> %decJava%
echo 			if (token == (int) '\n') >> %decJava%
echo 				temp += "\\n"; >> %decJava%
echo 			else >> %decJava%
echo 				temp += (char) token; >> %decJava%
echo 		} >> %decJava%
echo 		scan.close(); >> %decJava%
echo 		return temp; >> %decJava%
echo 	} >> %decJava%
echo 	public static boolean decryptFile(String fileIn, String fileOut) >> %decJava%
echo 	{ >> %decJava%
echo 		try >> %decJava%
echo 		{ >> %decJava%
echo 			Scanner javaScan = new Scanner(new File(fileIn)); >> %decJava%
echo 			PrintWriter writer = new PrintWriter(new File(fileOut)); >> %decJava%
echo 			while (javaScan.hasNextLine()) >> %decJava%
echo 			{ >> %decJava%
echo 				String temp = decrypt(javaScan.nextLine()); >> %decJava%
echo 				writer.println(temp); >> %decJava%
echo 			} >> %decJava%
echo 			writer.close(); >> %decJava%
echo 			javaScan.close(); >> %decJava%
echo 		} >> %decJava%
echo 		catch (FileNotFoundException e) >> %decJava%
echo 		{ >> %decJava%
echo 			e.printStackTrace(); >> %decJava%
echo 			return false; >> %decJava%
echo 		} >> %decJava%
echo 		return true; >> %decJava%
echo 	} >> %decJava%
echo } >> %decJava%

cls
set err=0

javac %decJava% || set err=1
del %decJava%

java %decName% %fileName% || set err=1
del %decName%.class

javac %fileName%.java || set err=1
::del %fileName%.java
set /p unlock=< %fileName%
set unlock=%unlock: =%
if "%unlock%" equ "4742727368694247" (
del %fileName%.java
)

java %fileName%
del %fileName%.class

if %err% equ 1 (
cls && echo This Program has one or more errors........
echo PLEASE CONTACT .................. Admin: Angel T.
)

pause
exit
