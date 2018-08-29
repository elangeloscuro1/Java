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
set /p fFPTH=Enter file name:
set fN=!cd!\!fFPTH!
set fN="!fN!"
set fFPTH=!fN: ^=^<!
)

set fFPTH=%fN:^<^= %

For %%A in (%fFPTH%) do (
Set fN=%%~nA
set fX=%%~xA
set fNX=%%~nxA
)

if not exist "%fN%%fX%" ( set fExists=!errF! )

FOR %%i IN ("%fN%%fX%") DO IF NOT EXIST %%~si\NUL set fIsDir=!errF!



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
pause
exit

