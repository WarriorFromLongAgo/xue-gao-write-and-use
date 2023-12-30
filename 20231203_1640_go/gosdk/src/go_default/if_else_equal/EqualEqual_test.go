package if_else_equal

import (
	"fmt"
	"testing"
)

func Test_string_int(t *testing.T) {
	int1 := 10
	int2 := 10
	str1 := "11"
	str2 := "11"
	if int1 == int2 {
		fmt.Println("true")
	}
	if str1 == str2 {
		fmt.Println("true")
	}
}

func Test_slice_map(t *testing.T) {
	//s1 := []int64{1, 2}
	//s2 := []int64{1, 2}
	//if s1 == s2 {
	//}
	//if s1 == nil {
	//} //编辑器不会提示报错
}

// false
func Test_channel(t *testing.T) {
	ch1 := make(chan int, 1)
	ch2 := make(chan int, 1)
	if ch1 == ch2 {
		fmt.Println("true")
	}

	//ch1 := new(chan int, 1)
	//ch2 := new(chan int, 1)
	//if ch1 == ch2 {
	//	fmt.Println("true")
	//}
}

type simpleValue struct {
	Name   string
	Gender string
}

func Test_simple_struct(t *testing.T) {
	Gender := new(string) //下面赋值用的同一个变量，地址相同
	v1 := simpleValue{Name: "test", Gender: *Gender}
	v2 := simpleValue{Name: "test", Gender: *Gender}
	if v1 == v2 {
		fmt.Println("true")
		return
	}
}

type pointerValue struct {
	Name   string
	Gender *string
}

func Test_pointer_struct(t *testing.T) {
	Gender := new(string) //下面赋值用的同一个变量，地址相同
	v1 := pointerValue{Name: "test", Gender: Gender}
	v2 := pointerValue{Name: "test", Gender: Gender}
	if v1 == v2 {
		fmt.Println("true")
		return
	}
}

type StructA struct {
	Name string
}

type StructB struct {
	Name string
}

// 强制转换类型
func Test_two_struct(t *testing.T) {
	s1 := StructA{Name: "test1"}
	s2 := StructB{Name: "test1"}
	if s1 == StructA(s2) {
		fmt.Println("true")
		return
	}
}
