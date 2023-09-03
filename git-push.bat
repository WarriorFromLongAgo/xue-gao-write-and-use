
@echo off
 
title GIT push bat
color 3
echo now file path：%cd%
echo;
 
echo git add .
git add .
echo;
 
set /p declation=commit message
git commit -m "%declation%"
echo;
 
echo git pull origin main
git pull origin main
echo;

echo git push origin main
git push origin main
echo;
 
echo success
echo;
 
pause