// package main

// import "fmt"

// func main() {
// 	fmt.Println("c")
// 	defer func() {
// 		fmt.Println("d")
// 		// recover 函数只有在 defer 代码块中才会有效果
// 		// recover 可以放在最外层函数，做统一异常处理。
// 		if err := recover(); err != nil {
// 			fmt.Println(err)
// 		}
// 		fmt.Println("e")
// 	}()

// 	f()
// 	fmt.Println("f")
// }

// func f() {
// 	fmt.Println("a")
// 	// 出现 panic 以后程序会终止运行
// 	panic("异常信息")
// 	fmt.Println("b")
// 	fmt.Println("f")
// }
