package main

import "fmt"

func main() {

	var a = 10
	var p = &a
	fmt.Printf("a的值：%v, a的类型：%T, a的地址：%p", a, a, &a)
	fmt.Println()
	fmt.Printf("p的值：%v, p的类型：%T, p的地址：%p", p, p, p)
	fmt.Println()
	// a的值：10, a的类型：int, a的地址：0xc00001a088
	// p的值：0xc00001a088, p的类型：*int, p的地址：0xc00001a088
	// *int *int *int *int *int *int *int

	a = 100
	fmt.Printf("a的值：%v, a的类型：%T, a的地址：%p", a, a, &a)
	fmt.Println()
	fmt.Printf("p的值：%v, p的类型：%T, p的地址：%p", *p, p, p)
	fmt.Println()

	*p = 200
	fmt.Printf("a的值：%v, a的类型：%T, a的地址：%p", a, a, &a)
	fmt.Println()
	fmt.Printf("p的值：%v, p的类型：%T, p的地址：%p", *p, p, p)
	fmt.Println()

}
