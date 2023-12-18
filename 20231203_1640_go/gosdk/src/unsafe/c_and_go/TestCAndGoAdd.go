package main

import (
	"20231203_1640_go_sdk/gosdk/src/unsafe/c_and_go/add"
	"fmt"
)

// https://chai2010.gitbooks.io/advanced-go-programming-book/content/ch2-cgo/readme.html
func main() {
	add.HelloWorld()

	add.HelloWorld()
	fmt.Println(add.Add(10, 5))
	fmt.Println(add.Mul(10, 5))
}

//这个错误通常表示在 64 位模式下编译器没有启用。要解决这个问题，你需要确保你的编译器支持 64 位模式，并且你正在使用 64 位编译器。
//
//以下是一些可能导致这个问题的原因和解决方法：
//
//安装 64 位版本的编译器： 确保你的编译器是 64 位版本。如果你使用的是 GCC，可以通过安装 64 位版本的 MinGW 来获得。
//
//检查编译器路径： 确保你的编译器路径正确设置。在一些情况下，系统可能会使用默认的 32 位编译器，而不是你安装的 64 位版本。
//
//检查操作系统： 确保你的操作系统是 64 位的。如果你的操作系统是 32 位的，你无法编译成 64 位模式。
//
//使用正确的编译器选项： 在编译时，确保使用了正确的编译器选项，以启用 64 位模式。
