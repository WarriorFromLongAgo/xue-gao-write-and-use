package main

import (
	"fmt"
	"unsafe"

	"github.com/shopspring/decimal"
)

func main() {
	var var1 int32 = 10
	var var2 int64 = 20
	fmt.Println(int64(var1) + var2)

	var intInt int = 10
	// 在64位里面就是64，占用8个字节
	fmt.Println(unsafe.Sizeof(intInt))

	// 3.14 * 10的二次方
	var f1 float32 = 3.14e2
	fmt.Println(f1)

	// 3.14 除以 10的二次方
	var f2 float32 = 3.14e-2
	fmt.Println(f2)

	// 精度丢失的问题
	var d1 float64 = 1129.6
	fmt.Println(d1 * 100)
	// 112959.99999999999

	var d2 float64 = 8.2
	var d3 float64 = 3.8
	fmt.Println(d2 - d3)
	// 4.3999999999999995

	var decimal2 decimal.Decimal = decimal.NewFromFloat(d2)
	var decimal3 decimal.Decimal = decimal.NewFromFloat(d3)
	fmt.Println(decimal2.Sub(decimal3))

}
