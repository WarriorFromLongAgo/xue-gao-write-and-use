package main

import (
	"fmt"
	"unsafe"
)

func main() {
	TestSizeOf()

}

func TestSizeOf() {
	a := 1
	aSizeof := unsafe.Sizeof(a)
	fmt.Print("a aSizeof = ", aSizeof)

}
