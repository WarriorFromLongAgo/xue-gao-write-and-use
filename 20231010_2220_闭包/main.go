package main

import "fmt"

func add1() func() int {
	i := 10
	return func() int {
		return i + 1
	}
}

func add2() func(y int) int {
	i := 10
	return func(y int) int {
		i += y
		return i
	}
}

func add3() func() int {
	i := 10
	return func() int {
		i += 1
		return i
	}
}

// 全局变量

// 局部变量

// 闭包
// 1，而已让一个变量，常驻内存
// 2，可以让一个变量，不污染全局

func main() {
	func1 := add1()
	fmt.Println(func1())
	fmt.Println(func1())
	fmt.Println(func1())

	fmt.Println("=====================")

	func2 := add2()
	fmt.Println(func2(10))
	fmt.Println(func2(10))
	fmt.Println(func2(10))

	fmt.Println("=====================")

	func3 := add3()
	fmt.Println(func3())
	fmt.Println(func3())
	fmt.Println(func3())
}
