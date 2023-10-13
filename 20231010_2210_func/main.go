package main

import "fmt"

type calc func(int, int) int

type myInt int

func add(x int, y int) int {
	return x + y
}

func sub(x int, y int) int {
	return x - y
}

func test(x int) int {
	return x
}

func deferTest() int {
	var resultInt int
	defer func() {
		resultInt++
	}()
	return resultInt
}

func deferTestV2() (resultInt int) {
	defer func() {
		resultInt++
	}()
	return resultInt
}

func main() {

	var cccc calc
	// cccc = test
	cccc = sub
	cccc = add
	fmt.Printf("cccc 的类型：%T", cccc)
	// cccc 的类型：main.calc

	fmt.Println()
	fmt.Println("=================================")

	var dddd = add
	fmt.Printf("dddd 的类型：%T", dddd)
	// dddd 的类型：func(int, int) int

	fmt.Println()
	fmt.Println("=================================")

	var int1 int = 1
	var int2 myInt = 2
	fmt.Printf("int1 的类型：%T", int1)
	// int1 的类型：int
	fmt.Println()
	fmt.Printf("int2 的类型：%T", int2)
	// int2 的类型：main.myInt
	fmt.Println()
	// 类型不同，会报错
	// fmt.Println(int1 + int2)
	fmt.Println(int1 + int(int2))
	// 3
	fmt.Println("=================================")

	func() (int, int) {
		fmt.Println("匿名函数")
		return 1, 2
	}()

	var func2 = func(a int, b int) int {
		return a + b
	}(11, 22)
	fmt.Println("匿名函数 func2 ", func2)

	var func1 = func() string {
		fmt.Println("匿名函数。。。。。")
		return "func1 func1 func1 "
	}
	func1Return := func1()
	fmt.Println("匿名函数。func1Return。。。。", func1Return)

	fmt.Println("=================================")

	defer func() {
		fmt.Println("defer 匿名自执行函数 1")
	}()

	fmt.Println("defer 开始")
	defer fmt.Println("1")
	defer fmt.Println("2")
	defer fmt.Println("3")
	fmt.Println("defer 结束")

	defer func() {
		fmt.Println("defer 匿名自执行函数 2")
	}()

	// 返回的是 0
	fmt.Println("defer deferTest ", deferTest())
	// 返回的是 1
	fmt.Println("defer deferTestV2 ", deferTestV2())

}
