package main

import "fmt"

//unbuffer 同步状态
//写进入，必须要等待读出来

//func main() {
//	done := make(chan bool)
//	go func() {
//		fmt.Println(" unbuffer unbuffer unbuffer")
//		<-done
//	}()
//	done <- true
//}

// buffer 是异步的操作
//写进去，不用等待读出来

func main() {
	done := make(chan bool, 1)
	go func() {
		fmt.Println(" buffer buffer buffer")
		<-done
	}()
	done <- true
}
