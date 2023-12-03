package main

import (
	"fmt"
)

func main() {
	var aa = 1
	fmt.Println("aa = ", aa)

	var aa2 = "aa2aa2"
	fmt.Println("aa2 = ", aa2)

	var var1 int
	fmt.Println("var1 = ", var1)

	var var2 string
	fmt.Println("var2 = ", var2)

	var var3 bool
	fmt.Println("var3 = ", var3)

	var var4 float32
	fmt.Println("var4 = ", var4)

	var var5, var6 float32
	fmt.Println("var5 = ", var5)
	fmt.Println("var6 = ", var6)

	var (
		var7 float32
		var8 float32
	)
	fmt.Println("var7 = ", var7)
	fmt.Println("var8 = ", var8)

	bb := 122
	fmt.Println("bb = ", bb)

	cc, dd := "cc", "dd"
	fmt.Println("cc = ", cc)
	fmt.Println("dd = ", dd)

	var username, age = getUserInfo()
	fmt.Println("username = ", username)
	fmt.Println("age = ", age)

	var username2, _ = getUserInfo()
	fmt.Println("username2 = ", username2)
}

func getUserInfo() (string, uint) {
	return "xuegao", 18
}
