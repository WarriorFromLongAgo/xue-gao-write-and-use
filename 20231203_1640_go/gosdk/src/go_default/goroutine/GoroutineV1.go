package main

import "time"

func main() {

	go func() {
		println("111111111")
	}()

	go func() {
		println("2222222")
	}()

	time.Sleep(time.Second * 3)

	//2222222
	//111111111

	//111111111
	//2222222

	//都有可能执行出来
}
