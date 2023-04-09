const opn = require('opn');     //执行语句

opn('C:/Users/seagm/Desktop/小白入门手册.txt');	//自动打开程序（文件地址自己修改即可）
opn('C:/Users/seagm/Desktop/GitHub Desktop')
opn('C:/Users/seagm/Desktop/Visual Studio Code')
opn('', {app: 'chrome'});
setTimeout(()=>{opn('C:/Program Files (x86)/Tencent/WeChat/WeChat.exe')},2000)