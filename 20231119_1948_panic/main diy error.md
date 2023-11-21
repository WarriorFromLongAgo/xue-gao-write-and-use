package main

import (
	"errors"
	"fmt"
)

// 手动创建异常
// 自定义异常
func throw() error {
	return errors.New("CheckHostType ERROR:")
}

func main() {
	fmt.Println("Hello W3Cschool!")

	err := throw()

	if err != nil {
		// 打印异常信息 err.Error()

		fmt.Printf("Program stopping with error %v", err.Error())
		fmt.Println()
		fmt.Println(err.Error())
		fmt.Println()
		fmt.Printf("Program stopping with error %v", err)
		fmt.Println()
		// 自定义异常 2
		err = fmt.Errorf("产生了一个 %v 异常", "喝太多")
		fmt.Println()
		fmt.Println(err.Error())
		fmt.Println()

		return
	}

}
