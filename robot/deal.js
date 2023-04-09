var robot = require("robotjs");   //控制鼠标键盘等操作
 
var screenSize = robot.getScreenSize();
robot.moveMouseSmooth(screenSize.width-140, screenSize.height-20);	//移动鼠标
robot.setMouseDelay(1000)	
robot.mouseClick();	 //鼠标点击
robot.moveMouseSmooth(screenSize.width-140, screenSize.height-560);
robot.setMouseDelay(2000)
robot.mouseClick()
robot.moveMouseSmooth(screenSize.width-140, screenSize.height-490);
robot.setMouseDelay(1000)
robot.mouseClick()


