package main

import (
	"fmt"
	"time"
)

type BaseModel_1 struct {
	Username string
	Time1    time.Time
	Time2    *time.Time
}

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

	modelArr := []*BaseModel_1{
		{Username: "111111", Time1: time.Now(), Time2: nil},
		{Username: "222222", Time1: time.Now(), Time2: nil},
	}
	fmt.Printf("Model Array: %+v\n", modelArr)

	fmt.Println("Model Array:")
	for _, model := range modelArr {
		fmt.Println(*model)
	}

	modelArr2 := []BaseModel_1{
		{Username: "111111", Time1: time.Now(), Time2: nil},
		{Username: "222222", Time1: time.Now(), Time2: nil},
	}
	fmt.Println("modelArr = ", modelArr2)
}
