package main

import "fmt"

func main() {
	errFun()
	fmt.Println("后续代码")
}

func errFun() {
	//异常处理
	defer func() {
		//捕获异常
		err := recover()
		if err != nil {//条件判断，是否存在异常
			//存在异常,抛出异常
			fmt.Println(err)
		}
	}()

	a := 1
	b := 0

	//此处会抛出异常panic: runtime error: integer divide by zero
	c := a / b
	fmt.Println(c)
}

===================================================================

package main

import (
	"errors"
	"fmt"
)

func main() {
	//调用读取配置文件方法，并接受返回值
	err := config("conf.txt")
	//判断错误不为空，抛出异常,终止程序执行
	if err != nil{
		panic(err)
	}

	fmt.Println("后续代码")
}

func config(conf string) error {
	//模拟读取配置文件，当传入的配置文件名不等于conf.ini时输出错误
	if conf != "conf.ini"{
		//自定义错误
		return errors.New("读取配置文件失败")
	}else {
		//没有错误，返回空
		return  nil
	}
}

