@echo off
setlocal EnableDelayedExpansion

set fN=%1
set fX=
set fNX=
set fPTH=%cd%
set fFPTH=%fN: =^<%
set tVar= ^=^<
set errF=0
set errT=1
set errVal=0
set fExists=1
set fIsDir=1

if "%fFPTH%" equ "%tVar%" (
set errVal=!errT!
set /p fFPTH=Enter file/dir name:
set fN=!cd!\!fFPTH!
set fN="!fN!"
set fFPTH=!fN: ^=^<!
)

set fFPTH=%fN:^<^= %

for %%A in (%fFPTH%) do (
Set fN=%%~nA
set fX=%%~xA
set fNX=%%~nxA
)

if not exist "%fN%%fX%" ( set fExists=!errF! )

for %%i in ("%fN%%fX%") do if not exist %%~si\nul set fIsDir=!errF!



echo "==============================3"
echo fN---------- "%fN%"
echo fX---------- "%fX%"
echo fNX--------- "%fNX%"
echo fPTH-------- "%fPTH%"
echo fFPTH------- "%fFPTH%"
echo errF-------- "%errF%"
echo errT-------- "%errT%"
echo errVal------ "%errVal%"
echo fExists----- "%fExists%"
echo fIsDir------ "%fIsDir%"
echo "====================================================" %errVal%



set encName=Encoder
set encJava=%fFPTH%\%encName%.java

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

if %fIsDir% equ %errT% 
(
	cd %fFPTH%
	javac %encJava%
	
	
	for %%i in (*) do 
	(
		for %%A in (%%i) do 
		(
			if "%%~xA" equ ".java" 
			(
				echo %%~nA
				echo %%~xA
				echo %%~nxA
				java %encName% %%~nxA %%~nA
			) 
		) 
	) 
	 
) 
else 
(
	if "!fX!" equ ".java" 
	(
		javac %encJava%
		for %%A in (%fFPTH%) do 
		(
			echo --------------------------------
			echo %fFPTH%
			echo %encName% %%~nxA %%~nA
			echo %%~nxA
			echo %%~nA
			echo --------------------------------
		) 
	) 
)


del %encJava%
del %encName%.class
del %encName%


pause
exit

